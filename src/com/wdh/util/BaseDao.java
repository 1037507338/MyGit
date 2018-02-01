package com.wdh.util;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class BaseDao {
	/**
	 * 获得连接
	 * @return
	 */
	public static Connection getConnection() {
		Connection conn=null;
		try {
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/homework","root","54188wang");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
	/**
	 * 关闭连接
	 * @param a
	 */
	public static void close(AutoCloseable a) {
		if(a!=null) {
			try {
				a.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	/**
	 * 登录
	 * @param c 需要登录操作的vo类
	 * @param sql 登录查询的sql语句
	 * @param username 用户名
	 * @param password 密码
	 * @return 查询得到的vo对象
	 */
	public <T> Object login(Class<T> c,String sql,String username,String password) {
		Field[] f=c.getDeclaredFields();
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		T t=null;
		try {
			conn=getConnection();
			ps=conn.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);
			rs=ps.executeQuery();
			if(rs.next()) {
				t=c.newInstance();
				for(int i=0;i<f.length;i++) {
					f[i].setAccessible(true);
					f[i].set(t, rs.getObject(f[i].getName()));
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return t;
	}
	/**
	 * 复杂的插入
	 * @param o 需要插入的vo对象
	 */
	public static void insert(Object o) {
		Class<?> c=o.getClass();
		Field[] f=c.getDeclaredFields();
		StringBuffer sql=new StringBuffer("insert into "+c.getSimpleName()+"(");
		StringBuffer sql2=new StringBuffer(" values(");
		for(int i=0;i<f.length;i++) {
			if(f[i].getName().equals("password")) {
				sql.append(f[i].getName()+",");
				sql2.append("md5(?),");
			}else if(i!=f.length-1) {
				sql.append(f[i].getName()+",");
				sql2.append("?,");
			}else {
				sql.append(f[i].getName()+")");
				sql2.append("?)");
			}
		}
		sql.append(sql2);
		Connection conn=null;
		PreparedStatement ps=null;
		try {
			conn=getConnection();
			ps=conn.prepareStatement(sql.toString());
			for(int i=0;i<f.length;i++) {
				f[i].setAccessible(true);
				ps.setObject(i+1, f[i].get(o));
			}
			ps.execute();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(conn);
			close(ps);
		}
	}
	/**
	 * 执行简单的增删改操作
	 * @param sql 需要执行的sql语句
	 * @param o 需要替代java占位符的数据
	 */
	public void launchsql(String sql,Object...o) {
		Connection conn=getConnection();
		PreparedStatement ps=null;
		try {
			ps=conn.prepareStatement(sql);
			for(int i=0;i<o.length;i++) {
				ps.setObject(i+1, o[i]);
			}
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(ps);
			close(conn);
		}
	}
	/**
	 * 查询操作，可根据id查询，可分页查询，可全部查询
	 * @param sql 需要执行的sql语句
	 * @param c 需要查询的vo类
	 * @param o 查询时需要替代java占位符的数据
	 * @return 一个存有多个vo对象的list数组
	 */
	public static <T> List<T> select(String sql,Class<T> c,Object...o) {
		Field[] f=c.getDeclaredFields();
		List<T> list=new ArrayList<T>();
		Connection conn=getConnection();
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			ps=conn.prepareStatement(sql);
			for(int i=0;i<o.length;i++) {
				ps.setObject(i+1, o[i]);
			}
			rs=ps.executeQuery();
			while(rs.next()) {
				T t=c.newInstance();
				for(int i=0;i<f.length;i++) {
					f[i].setAccessible(true);
					f[i].set(t, rs.getObject(f[i].getName()));
				}
				list.add(t);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(ps);
			close(conn);
		}
		return list;
	}
	
	/**
	 * 按文章类型和页码查询对应list
	 * @param articletype 文章类型
	 * @param pagenum 页数
	 * @return 该页的list
	 */
	public static <T> List<T> getpage(String sql,Class<T> c,int pagenum){
		List<T> list=new ArrayList<T>();
		list=select(sql, c, (pagenum-1)*5, 5);
		return list;
	}
	
	/**
	 * 文章的总页数
	 * @param <T>
	 * @param articletype 文章类型
	 * @return 总页数
	 */
	public static <T> int pagesum(Class<T> c) {
		int i=1;
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			conn=getConnection();
			ps=conn.prepareStatement("select count(*) from "+c.getSimpleName());
			rs=ps.executeQuery();
			rs.next();
			i=rs.getInt(1)/5+1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rs);
			close(ps);
			close(conn);
		}
		return i;
	}

}

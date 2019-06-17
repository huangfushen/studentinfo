package com.artisan.dao;

import java.sql.Connection;
import java.sql.SQLException;

import com.artisan.util.DbUtil;

/**
 * 
 * @author llq
 *创建对数据库连接对象，整个项目与数据库打交道都用这一个对象.
 */
public class BaseDao {
	//创建连接
	public Connection con = new DbUtil().getCon();
	
	//关闭连接
	public void closeDao(){
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

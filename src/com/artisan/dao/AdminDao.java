package com.artisan.dao;

import com.artisan.model.Admin;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminDao extends BaseDao {
	/**
	 * 管理员登录
	 */
	public Admin login(Admin admin){
		String sql = "select * from s_admin where name=? and password=?";
		Admin adminRst = null;
		try {
			//使用PreparedStatement可防止sql注入
			PreparedStatement prst = con.prepareStatement(sql);//把sql语句传给数据库操作对象
			//获取admin的用户名给sql第一个问号
			prst.setString(1, admin.getName());
			prst.setString(2, admin.getPassword());
			//执行
			ResultSet executeQuery = prst.executeQuery();
			//参考放回结果是否有值，并创建对象将值赋给结果对象
			if(executeQuery.next()){
				adminRst = new Admin();
				adminRst.setId(executeQuery.getInt("id"));
				adminRst.setName(executeQuery.getString("name"));
				adminRst.setPassword(executeQuery.getString("password"));
				adminRst.setCreateDate(executeQuery.getString("createDate"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return adminRst;
	}
	/*
	 * 修改管理员密码
	 */
	public String editPassword(Admin admin,String newPassword){
		String sql = "select * from s_admin where id=? and password=?";
		PreparedStatement prst = null;
		int id = 0;
		try {
			prst = con.prepareStatement(sql);
			prst.setInt(1, admin.getId());
			prst.setString(2, admin.getPassword());
			ResultSet executeQuery = prst.executeQuery();
			if(!executeQuery.next()){
				String retString = "旧密码错误";
				return retString;
			}
			id = executeQuery.getInt("id");
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}//把sql语句传给数据库操作对象
		String retString = "修改失败";
		String sqlString = "update s_admin set password = ? where id = ?";
		try {
			prst = con.prepareStatement(sqlString);
			prst.setString(1, newPassword);
			prst.setInt(2, id);
			int rst = prst.executeUpdate();
			if(rst > 0){
				retString = "密码修改成功！";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//把sql语句传给数据库操作对象
		return retString;
	}
}

package com.artisan.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URI;

import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.artisan.model.UserType;

public class MainFrm extends JFrame {

	private JPanel contentPane;
	private JDesktopPane desktopPane;
	public static UserType userType;
	public static Object userObject;
	private JMenuItem addStudentMenuItem ;
	private JMenu manageClassMenu ;
	private JMenu manageTeacherMenu;
	private JMenuItem addTeacherMenuItem;
	/**
	 * Create the frame.
	 */
	public MainFrm(UserType userType,Object userObject) {
		this.userType = userType;
		this.userObject = userObject;
		setTitle("学生信息系统主界面");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 936, 774);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		//系统设置
		JMenu menu = new JMenu("系统设置");
		menu.setIcon(new ImageIcon(MainFrm.class.getResource("/images/xtsz.png")));
		menuBar.add(menu);
		/**
		 * 修改密码
		 * 添加点击事件，点击执行editPassword
		 */
		JMenuItem menuItem = new JMenuItem("修改密码");
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				editPassword(ae);
			}
		});
		menuItem.setIcon(new ImageIcon(MainFrm.class.getResource("/images/xgmm.png")));
		menu.add(menuItem);
		/**
		 * 退出系统
		 * 添加点击事件，点击出现消息框，如果点击确定则退出
		 */
		JMenuItem menuItem_1 = new JMenuItem("退出系统");
		menuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(JOptionPane.showConfirmDialog(MainFrm.this, "确定退出么？") == JOptionPane.OK_OPTION){
					System.exit(0);
				}
			}
		});
		menuItem_1.setIcon(new ImageIcon(MainFrm.class.getResource("/images/tc.png")));
		menu.add(menuItem_1);
		
		//学生管理
		JMenu menu_1 = new JMenu("学生管理");
		menu_1.setIcon(new ImageIcon(MainFrm.class.getResource("/images/xsgl.png")));
		menuBar.add(menu_1);
		/**
		 * 添加学生
		 * 添加点击事件，点击执行跳出添加学生信息窗口
		 */
		addStudentMenuItem = new JMenuItem("添加学生");
		addStudentMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			//添加学生窗口
				AddStudentFrm addStudentFrm = new AddStudentFrm();
				addStudentFrm.setVisible(true);
				//将窗口设置为子窗口
				desktopPane.add(addStudentFrm);
			}
		});
		addStudentMenuItem.setIcon(new ImageIcon(MainFrm.class.getResource("/images/tj.png")));
		menu_1.add(addStudentMenuItem);
		/**
		 * 学生列表
		 * 添加点击事件，点击跳出学生列表窗口
		 */
		JMenuItem menuItem_3 = new JMenuItem("学生列表");
		menuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//学生列表窗口
				ManageStudentFrm studentManageFrm = new ManageStudentFrm();
				studentManageFrm.setVisible(true);
				desktopPane.add(studentManageFrm);
			}
		});
		menuItem_3.setIcon(new ImageIcon(MainFrm.class.getResource("/images/xsgl.png")));
		menu_1.add(menuItem_3);
		
		//班级管理
		manageClassMenu = new JMenu("班级管理");
		manageClassMenu.setIcon(new ImageIcon(MainFrm.class.getResource("/images/bjgl.png")));
		menuBar.add(manageClassMenu);
		/**
		 * 添加班级
		 * 添加点击事件，点击执行addStudentClass方法
		 */
		JMenuItem menuItem_4 = new JMenuItem("添加班级");
		menuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				addStudentClass(ae);
			}
		});
		menuItem_4.setIcon(new ImageIcon(MainFrm.class.getResource("/images/tj.png")));
		manageClassMenu.add(menuItem_4);
		/**
		 * 班级列表
		 * 添加点击事件，点击跳出班级列表窗口
		 */
		JMenuItem menuItem_5 = new JMenuItem("班级列表");
		menuItem_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ManageClassFrm classManageFrm = new ManageClassFrm();
				classManageFrm.setVisible(true);
				desktopPane.add(classManageFrm);
			}
		});
		menuItem_5.setIcon(new ImageIcon(MainFrm.class.getResource("/images/bjlb.png")));
		manageClassMenu.add(menuItem_5);
		//教师管理
		manageTeacherMenu = new JMenu("教师管理");
		manageTeacherMenu.setIcon(new ImageIcon(MainFrm.class.getResource("/images/ls.png")));
		menuBar.add(manageTeacherMenu);
		/**
		 * 添加教师
		 * 添加点击事件，点击跳出添加教师窗口
		 */
		addTeacherMenuItem = new JMenuItem("添加教师");
		addTeacherMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddTeacherFrm addTeacherFrm = new AddTeacherFrm();
				addTeacherFrm.setVisible(true);
				desktopPane.add(addTeacherFrm);
			}
		});
		addTeacherMenuItem.setIcon(new ImageIcon(MainFrm.class.getResource("/images/tj.png")));
		manageTeacherMenu.add(addTeacherMenuItem);
		/**
		 *教师列表
		 * 添加点击事件，点击跳出教师列表窗口
		 */
		JMenuItem menuItem_8 = new JMenuItem("教师列表");
		menuItem_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ManageTeacherFrm manageTeacherFrm = new ManageTeacherFrm();
				manageTeacherFrm.setVisible(true);
				desktopPane.add(manageTeacherFrm);
			}
		});
		menuItem_8.setIcon(new ImageIcon(MainFrm.class.getResource("/images/yhlb.png")));
		manageTeacherMenu.add(menuItem_8);
		//帮助子窗口
		JMenu menu_3 = new JMenu("帮助");
		menu_3.setIcon(new ImageIcon(MainFrm.class.getResource("/images/bz.png")));
		menuBar.add(menu_3);
		/**
		 * 关于我们
		 * 添加点击事件，点击执行aboutUs方法
		 */
		JMenuItem menuItem_6 = new JMenuItem("关于我们");
		menuItem_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				aboutUs(ae);
			}
		});
		menuItem_6.setIcon(new ImageIcon(MainFrm.class.getResource("/images/gywm.png")));
		menu_3.add(menuItem_6);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		desktopPane = new JDesktopPane();
		desktopPane.setBackground(new Color(0, 128, 128));
		contentPane.add(desktopPane, BorderLayout.CENTER);
		setLocationRelativeTo(null);
		//权限
		setAuthority();
	}
	//添加班级方法
	protected void addStudentClass(ActionEvent ae) {
		// TODO Auto-generated method stub
		AddStudentClassFrm sca = new AddStudentClassFrm();
		sca.setVisible(true);
		desktopPane.add(sca);
	}
	//修改密码方法
	protected void editPassword(ActionEvent ae) {
		// TODO Auto-generated method stub
		EditPasswordFrm editPasswordFrm = new EditPasswordFrm();
		editPasswordFrm.setVisible(true);
		desktopPane.add(editPasswordFrm);
	}
	//关于我们方法
	protected void aboutUs(ActionEvent ae) {
		// TODO Auto-generated method stub
		String info = "信计一班40号";
		String[] buttons = {"确定"};
		int ret = JOptionPane.showOptionDialog(this, info, "关于我们", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.DEFAULT_OPTION, new ImageIcon(LoginFrm.class.getResource("/images/logo.png")), buttons, null);
		
	}
	//权限控制 管理员拥有所有权限
	private void setAuthority(){
		if("学生".equals(userType.getName())){
			addStudentMenuItem.setEnabled(false);
			manageClassMenu.setEnabled(false);
			manageTeacherMenu.setEnabled(false);
		}
		if("教师".equals(userType.getName())){
			addTeacherMenuItem.setEnabled(false);
		}
	}
}

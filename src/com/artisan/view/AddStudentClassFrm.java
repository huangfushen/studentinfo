package com.artisan.view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.JOptionPane;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextArea;
import javax.swing.JButton;

import com.artisan.dao.ClassDao;
import com.artisan.model.StudentClass;
import com.artisan.util.StringUtil;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddStudentClassFrm extends JInternalFrame {
	private JTextField classNameTextField;
	private JTextArea classInfotextArea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddStudentClassFrm frame = new AddStudentClassFrm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AddStudentClassFrm() {
		setClosable(true);
		setIconifiable(true);
		setTitle("添加班级信息");
		setBounds(100, 100, 450, 300);
		
		JLabel label = new JLabel("班级名称");
		label.setIcon(new ImageIcon(AddStudentClassFrm.class.getResource("/images/bjmc.png")));
		label.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		
		classNameTextField = new JTextField();
		classNameTextField.setColumns(10);
		
		JLabel label_1 = new JLabel("班级信息");
		label_1.setIcon(new ImageIcon(AddStudentClassFrm.class.getResource("/images/kclb.png")));
		label_1.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		
		classInfotextArea = new JTextArea();
		
		JButton submitButton = new JButton("提交");
		submitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				//提交操作 ，执行submitClass方法
				submitClass(ae);
			}
		});
		submitButton.setIcon(new ImageIcon(AddStudentClassFrm.class.getResource("/images/queding.png")));
		submitButton.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		
		JButton restButton = new JButton("重置");
		restButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetValue(e);
			}
		});
		restButton.setIcon(new ImageIcon(AddStudentClassFrm.class.getResource("/images/cz.png")));
		restButton.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		//窗体布局
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(submitButton)
							.addGap(72)
							.addComponent(restButton))
						.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
							.addGap(73)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(label_1)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(classInfotextArea))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(label)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(classNameTextField, GroupLayout.PREFERRED_SIZE, 173, GroupLayout.PREFERRED_SIZE)))))
					.addContainerGap(88, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(32)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(classNameTextField, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
					.addGap(39)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_1)
						.addComponent(classInfotextArea, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(restButton)
						.addComponent(submitButton))
					.addGap(18))
		);
		getContentPane().setLayout(groupLayout);

	}

	protected void submitClass(ActionEvent ae) {
		// TODO Auto-generated method stub
		//获取输入框信息
		String className = classNameTextField.getText().toString();
		String classInfo = classInfotextArea.getText().toString();
		if(StringUtil.isEmpty(className)){
			JOptionPane.showMessageDialog(this, "班级名称不能为空！");
			return;
		}
		//创建班级对象
		StudentClass scl = new StudentClass();
		scl.setName(className);
		scl.setInfo(classInfo);
		ClassDao classDao = new ClassDao();
		//向数据库中添加班级数据
		if(classDao.addClass(scl)){
			JOptionPane.showMessageDialog(this, "班级添加成功！");
		}else{
			JOptionPane.showMessageDialog(this, "班级添加失败！");
		}
		classDao.closeDao();
		resetValue(ae);
	}
	//重置操作
	protected void resetValue(ActionEvent e) {
		// TODO Auto-generated method stub
		classNameTextField.setText("");
		classInfotextArea.setText("");
	}
}

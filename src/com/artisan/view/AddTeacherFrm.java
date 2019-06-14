package com.artisan.view;

import java.awt.EventQueue;

import javax.swing.ButtonGroup;
import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JRadioButton;
import javax.swing.JButton;

import com.artisan.dao.TeacherDao;
import com.artisan.model.Teacher;
import com.artisan.util.StringUtil;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class AddTeacherFrm extends JInternalFrame {
	private JTextField teacherNameTextField;
	private JTextField teacherTitleTextField;
	private JTextField teacherAgeTextField;
	private JRadioButton teacherSexManRadioButton;
	private JRadioButton teacherSexFemalRadioButton;
	private JPasswordField teacherPasswordField;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddTeacherFrm frame = new AddTeacherFrm();
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
	public AddTeacherFrm() {
		setClosable(true);
		setIconifiable(true);
		setTitle("添加教师");
		setBounds(100, 100, 450, 371);
		
		JLabel label = new JLabel("教师名称:");
		label.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		label.setIcon(new ImageIcon(AddTeacherFrm.class.getResource("/images/ls.png")));
		
		teacherNameTextField = new JTextField();
		teacherNameTextField.setColumns(10);
		
		JLabel label_1 = new JLabel("教师性别:");
		label_1.setIcon(new ImageIcon(AddTeacherFrm.class.getResource("/images/xb.png")));
		label_1.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		
		ButtonGroup buttonGroup = new ButtonGroup();
		teacherSexManRadioButton = new JRadioButton("男");
		teacherSexManRadioButton.setSelected(true);
		teacherSexManRadioButton.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		
		teacherSexFemalRadioButton = new JRadioButton("女");
		teacherSexFemalRadioButton.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		buttonGroup.add(teacherSexManRadioButton);
		buttonGroup.add(teacherSexFemalRadioButton);
		
		JLabel label_2 = new JLabel("教师职称:");
		label_2.setIcon(new ImageIcon(AddTeacherFrm.class.getResource("/images/zcpd.png")));
		label_2.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		
		teacherTitleTextField = new JTextField();
		teacherTitleTextField.setColumns(10);
		
		JLabel label_3 = new JLabel("教师年龄:");
		label_3.setIcon(new ImageIcon(AddTeacherFrm.class.getResource("/images/nl.png")));
		label_3.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		
		teacherAgeTextField = new JTextField();
		teacherAgeTextField.setColumns(10);
		
		JButton submitButton = new JButton("登录密码");
		submitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				addTeacherAct(ae);
			}
		});
		submitButton.setIcon(new ImageIcon(AddTeacherFrm.class.getResource("/images/mm.png")));
		submitButton.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		
		JButton resetButton = new JButton("确定添加");
		resetButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				resetValue(ae);
			}
		});
		resetButton.setIcon(new ImageIcon(AddTeacherFrm.class.getResource("/images/tj.png")));
		resetButton.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		
		JLabel label_4 = new JLabel("重置表单");
		label_4.setIcon(new ImageIcon(AddTeacherFrm.class.getResource("/images/cz.png")));
		label_4.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		
		teacherPasswordField = new JPasswordField();
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(104)
					.addComponent(submitButton)
					.addGap(40)
					.addComponent(resetButton)
					.addContainerGap(68, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(87)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(label_1)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(teacherSexManRadioButton)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(teacherSexFemalRadioButton))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(label)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(teacherNameTextField, GroupLayout.PREFERRED_SIZE, 152, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(label_2)
								.addComponent(label_3)
								.addComponent(label_4))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(teacherPasswordField, GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE)
								.addComponent(teacherAgeTextField, GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE)
								.addComponent(teacherTitleTextField, 152, 152, Short.MAX_VALUE))))
					.addGap(95))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(26)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(teacherNameTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_1)
						.addComponent(teacherSexManRadioButton)
						.addComponent(teacherSexFemalRadioButton))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_2)
						.addComponent(teacherTitleTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(27)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_3)
						.addComponent(teacherAgeTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(30)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_4)
						.addComponent(teacherPasswordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(submitButton)
						.addComponent(resetButton))
					.addGap(32))
		);
		getContentPane().setLayout(groupLayout);

	}

	protected void resetValue(ActionEvent ae) {
		// TODO Auto-generated method stub
		teacherNameTextField.setText("");
		teacherTitleTextField.setText("");
		teacherAgeTextField.setText("");
		teacherSexManRadioButton.setSelected(true);
		teacherPasswordField.setText("");
	}

	protected void addTeacherAct(ActionEvent ae) {
		// TODO Auto-generated method stub
		String teacherName = teacherNameTextField.getText().toString();
		String teacherSex = teacherSexManRadioButton.isSelected() ? teacherSexManRadioButton.getText().toString() : teacherSexFemalRadioButton.getText().toString();
		String teacherTitle = teacherTitleTextField.getText().toString();
		String teacherPassword = teacherPasswordField.getText().toString();
		int teacherAge = 0;
		try {
			teacherAge = Integer.parseInt(teacherAgeTextField.getText().toString());
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(this, "年龄只允许输入数字！");
			return;
		}
		if(StringUtil.isEmpty(teacherName)){
			JOptionPane.showMessageDialog(this, "教师姓名必须填写！");
			return;
		}
		if(StringUtil.isEmpty(teacherTitle)){
			JOptionPane.showMessageDialog(this, "教师职称必须填写！");
			return;
		}
		if(teacherAge == 0 || teacherAge < 0){
			JOptionPane.showMessageDialog(this, "教师年龄必须大于0！");
			return;
		}
		if(StringUtil.isEmpty(teacherPassword)){
			JOptionPane.showMessageDialog(this, "教师登录密码必须填写！");
			return;
		}
		Teacher teacher = new Teacher();
		teacher.setName(teacherName);
		teacher.setSex(teacherSex);
		teacher.setTitle(teacherTitle);
		teacher.setAge(teacherAge);
		teacher.setPassword(teacherPassword);
		TeacherDao teacherDao = new TeacherDao();
		if(teacherDao.addTeacher(teacher)){
			JOptionPane.showMessageDialog(this, "教师添加成功！");
		}else{
			JOptionPane.showMessageDialog(this, "教师添加失败！");
		}
		resetValue(ae);
	}
}

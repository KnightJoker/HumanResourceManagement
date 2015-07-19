package com.dlnu;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

public class Modifypassword extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JComboBox user;
	private JPasswordField textField_1;
	private JPasswordField textField_2;
	private JPasswordField textField_3;
	private Cursor cursor = new Cursor(Cursor.HAND_CURSOR);

	public Modifypassword() {
		setBackground(Color.WHITE);
		setLayout(null);
		{
			JLabel labelpass = new JLabel("请 修 改 密 码");
			labelpass.setFont(new Font("黑体", Font.PLAIN, 15));
			labelpass.setForeground(Color.GRAY);
			labelpass.setBounds(300, 85, 138, 20);
			add(labelpass);
		}
		{
			JLabel label = new JLabel("用  户  名：");
			label.setBounds(300, 135, 82, 15);
			add(label);
		}
		{
			JLabel label = new JLabel("旧  密  码：");
			label.setBounds(300, 185, 82, 15);
			add(label);
		}
		{
			JLabel label = new JLabel("新  密  码：");
			label.setBounds(300, 235, 82, 15);
			add(label);
		}
		{
			JLabel label = new JLabel("确认密码：");
			label.setBounds(300, 285, 82, 15);
			add(label);
		}
		{
			user = new JComboBox();
			DBConnection.joinDB();
			String sql = "select * from t_user";
			try {
				if (DBConnection.query(sql)) {
					while (DBConnection.rs.next()) {
						String name = DBConnection.rs.getString("User_Name");
						user.addItem(name);
					}
				}
			} catch (Exception e) {
			}
			user.setBounds(355, 130, 165, 27);
			add(user);
		}
		{
			textField_1 = new JPasswordField();
			textField_1.setColumns(10);
			textField_1.setBounds(355, 180, 165, 27);
			add(textField_1);
		}
		{
			textField_2 = new JPasswordField();
			textField_2.setColumns(10);
			textField_2.setBounds(355, 230, 165, 27);
			add(textField_2);
		}
		{
			textField_3 = new JPasswordField();
			textField_3.setColumns(10);
			textField_3.setBounds(355, 280, 165, 27);
			add(textField_3);
		}
		{
			JButton button = new JButton("确定");
			button.setBounds(300, 330, 93, 27);
			button.setCursor(cursor);
			add(button);
			button.addActionListener(new ActionListener() {
				@SuppressWarnings("deprecation")
				public void actionPerformed(ActionEvent e) {
					String name = "" + user.getSelectedItem();
					String sql = "select * from t_user where User_Name='" + ""
							+ user.getSelectedItem() + "'";
					try {
						if (DBConnection.query(sql)) {
							DBConnection.rs.next();
							String ps1 = textField_1.getText();
							String password = DBConnection.rs
									.getString("User_Pass");
							if (ps1.equals(password)) {
								if (textField_2.getText().equals(
										textField_3.getText())) {
									String supdate = "update t_user set User_Pass='"
											+ textField_3.getText()
											+ "' where User_Name='"
											+ name
											+ "'";
									DBConnection.executeSQL(supdate);
									new JOptionPane();
									JOptionPane.showMessageDialog(null,
											"密码修改成功！");
								} else {
									new JOptionPane();
									JOptionPane.showMessageDialog(null,
											"两次密码不同！");
									textField_2.requestFocus();
								}
							} else {
								new JOptionPane();
								JOptionPane.showMessageDialog(null, "旧密码不正确！");
								textField_1.requestFocus();
							}
						}
					} catch (Exception ex) {
						ex.printStackTrace();
					}
				}
			});
		}
		{
			JButton button1 = new JButton("取消");
			button1.setBounds(425, 330, 93, 27);
			button1.setCursor(cursor);
			add(button1);
			button1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					textField_1.setText("");
					textField_2.setText("");
					textField_3.setText("");
					textField_1.requestFocus();
				}
			});
		}
	}
}
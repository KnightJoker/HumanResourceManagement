package com.dlnu;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ModifyDepartment extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private Cursor cursor = new Cursor(Cursor.HAND_CURSOR);
	
	public ModifyDepartment() {
		setBackground(Color.WHITE);
		setLayout(null);
		{
			JLabel labelpass = new JLabel("修 改 部 门");
			labelpass.setFont(new Font("黑体", Font.PLAIN, 15));
			labelpass.setForeground(Color.GRAY);
			labelpass.setBounds(333, 82, 158, 20);
			add(labelpass);
		}
		{
			JLabel label = new JLabel("部门编号：");
			label.setBounds(107, 130, 84, 15);
			add(label);
		}
		{
			JLabel label = new JLabel("部门名称：");
			label.setBounds(390, 130, 68, 15);
			add(label);
		}
		{
			JLabel label = new JLabel("从属部门：");
			label.setBounds(107, 180, 84, 15);
			add(label);
		}
		{
			JLabel lbli = new JLabel("部门职能：");
			lbli.setBounds(390, 180, 68, 15);
			add(lbli);
		}
		{
			textField = new JTextField();
			textField.setBounds(171, 127, 112, 21);
			add(textField);
			textField.setColumns(10);
		}
		{
			textField_1 = new JTextField();
			textField_1.setBounds(454, 127, 112, 21);
			add(textField_1);
			textField_1.setColumns(10);
		}
		{
			textField_2 = new JTextField();
			textField_2.setBounds(171, 177, 112, 21);
			add(textField_2);
			textField_2.setColumns(10);
		}
		{
			textField_3 = new JTextField();
			textField_3.setBounds(454, 177, 112, 21);
			add(textField_3);
			textField_3.setColumns(10);
		}
		{
			JButton button = new JButton("修改");
			button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String sqlupdate = "update t_department set Dept_Name='"
							+ textField_1.getText() + "'," + "Belong_Name='"
							+ textField_2.getText() + "',Dept_Job='"
							+ textField_3.getText() + "'where Dept_ID='"
							+ textField.getText() + "'";
					try {
						if (DBConnection.executeSQL(sqlupdate)) {
							new JOptionPane();
							JOptionPane.showMessageDialog(null, "数据修改成功！");
							DBConnection.joinDB();
							String sql = "select * from t_department";
							DBConnection.query(sql);
						} else {
							new JOptionPane();
							JOptionPane.showMessageDialog(null, "数据修改失败！");
						}
					} catch (Exception ex) {
						ex.getStackTrace();
					}
				}
			});
			button.setBounds(107, 230, 101, 25);
			button.setCursor(cursor);
			add(button);
		}
		{
			JButton button = new JButton("取消");
			button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					textField_1.requestFocus();
					DBConnection.joinDB();
					String sql = "select * from t_department";
					try {
						if (DBConnection.query(sql)) {
							DBConnection.rs.next();
							textField.setText(DBConnection.rs.getString("Dept_ID"));
							textField_1.setText(DBConnection.rs
									.getString("Dept_Name"));
							textField_2.setText(DBConnection.rs
									.getString("Belong_Name"));
							textField_3.setText(DBConnection.rs
									.getString("Dept_Job"));
							textField.setEditable(false);
						}
					} catch (Exception ex) {
						ex.getStackTrace();
					}
				}
			});
			button.setBounds(258, 230, 101, 25);
			button.setCursor(cursor);
			add(button);
		}
		{
			JButton button = new JButton("<<");
			button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						if (DBConnection.rs.previous()) {
							textField.setText(DBConnection.rs.getString("Dept_ID"));
							textField_1.setText(DBConnection.rs
									.getString("Dept_Name"));
							textField_2.setText(DBConnection.rs
									.getString("Belong_Name"));
							textField_3.setText(DBConnection.rs
									.getString("Dept_Job"));
						}
					} catch (Exception ex) {
						ex.getStackTrace();
					}
				}
			});
			button.setBounds(450, 230, 50, 25);
			button.setCursor(cursor);
			add(button);
		}
		{
			JButton button = new JButton(">>");
			button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						if (DBConnection.rs.next()) {
							textField.setText(DBConnection.rs.getString("Dept_ID"));
							textField_1.setText(DBConnection.rs
									.getString("Dept_Name"));
							textField_2.setText(DBConnection.rs
									.getString("Belong_Name"));
							textField_3.setText(DBConnection.rs
									.getString("Dept_Job"));
						}
					} catch (Exception ex) {
						ex.getStackTrace();
					}
				}
			});
			button.setBounds(520, 230, 50, 25);
			button.setCursor(cursor);
			add(button);
		}

		DBConnection.joinDB();
		String sql = "select * from t_department";
		try {
			if (DBConnection.query(sql)) {
				DBConnection.rs.next();
				textField.setText(DBConnection.rs.getString("Dept_ID"));
				textField_1.setText(DBConnection.rs.getString("Dept_Name"));
				textField_2.setText(DBConnection.rs.getString("Belong_Name"));
				textField_3.setText(DBConnection.rs.getString("Dept_Job"));
				textField.setEditable(false);
			}
		} catch (Exception ex) {
			ex.getStackTrace();
		}
	}
}


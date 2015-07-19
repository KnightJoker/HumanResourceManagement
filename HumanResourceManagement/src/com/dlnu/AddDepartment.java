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

public class AddDepartment extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private Cursor cursor = new Cursor(Cursor.HAND_CURSOR);

	public AddDepartment() {
		setBackground(Color.WHITE);
		setLayout(null);
		{
			JLabel labelpass = new JLabel("添 加 部 门");
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
			JButton button = new JButton("确认");
			button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (textField.getText().equals("")
							|| textField_1.getText().equals("")
							|| textField_2.getText().equals("")
							|| textField_3.getText().equals("")) {
						new JOptionPane();
						JOptionPane.showMessageDialog(null, "所有数据均不能为空！");
					} else {
						String sqlInsert = "insert into t_department values('"
							+ textField.getText() + "'," + "'"
							+ textField_1.getText() + "','"
							+ textField_2.getText() + "'," + "'"
							+ textField_3.getText() + "')";
						try {
							if (DBConnection.executeSQL(sqlInsert)) {
								new JOptionPane();
								JOptionPane.showMessageDialog(null, "数据添加成功！");
								DBConnection.joinDB();
								String sql = "select * from t_department";
								DBConnection.query(sql);
							}
						} catch (Exception ex) {
							ex.getStackTrace();
						}
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
					textField.setText("");
					textField_1.setText("");
					textField_2.setText("");
					textField_3.setText("");
					textField.requestFocus();
				}
			});
			button.setBounds(465, 230, 101, 25);
			button.setCursor(cursor);
			add(button);
		}
	}
}

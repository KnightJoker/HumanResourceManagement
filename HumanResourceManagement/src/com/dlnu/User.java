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
import javax.swing.JTextField;

public class User extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JComboBox user;
	private JTextField textField_1;
	private JPasswordField textField_2;
	private JPasswordField textField_3;
	private JPasswordField textField_4;
	private Cursor cursor = new Cursor(Cursor.HAND_CURSOR);

	public User() {
		setBackground(Color.WHITE);
		setLayout(null);
		{
			JLabel labelpass = new JLabel("�� �� �� �� ��");
			labelpass.setFont(new Font("����", Font.PLAIN, 15));
			labelpass.setForeground(Color.GRAY);
			labelpass.setBounds(100, 105, 138, 20);
			add(labelpass);
		}
		{
			JLabel label = new JLabel("���û�����");
			label.setBounds(100, 145, 82, 15);
			add(label);
		}
		{
			JLabel label = new JLabel("�������룺");
			label.setBounds(100, 185, 82, 15);
			add(label);
		}
		{
			JLabel label = new JLabel("ȷ�����룺");
			label.setBounds(100, 225, 82, 15);
			add(label);
		}
		{
			textField_1 = new JTextField();
			textField_1.setColumns(10);
			textField_1.setBounds(155, 140, 165, 27);
			add(textField_1);
		}
		{
			textField_2 = new JPasswordField();
			textField_2.setColumns(10);
			textField_2.setBounds(155, 180, 165, 27);
			add(textField_2);
		}
		{
			textField_3 = new JPasswordField();
			textField_3.setColumns(10);
			textField_3.setBounds(155, 220, 165, 27);
			add(textField_3);
		}
		{
			JButton button1 = new JButton("���");
			button1.setBounds(100, 270, 93, 27);
			button1.setCursor(cursor);
			add(button1);
			button1.addActionListener(new ActionListener() {
				@SuppressWarnings( { "static-access", "deprecation" })
				public void actionPerformed(ActionEvent e) {
					if (textField_1.getText().equals("")) {
						new JOptionPane().showMessageDialog(null, "�û�������Ϊ��!");
						textField_1.requestFocus();
					} else if (textField_2.getText().equals("")) {
						new JOptionPane().showMessageDialog(null, "���벻��Ϊ��!");
						textField_2.requestFocus();
					} else if (textField_3.getText().equals("")) {
						new JOptionPane().showMessageDialog(null, "ȷ�����벻��Ϊ��!");
						textField_3.requestFocus();
					} else if (!textField_2.getText().equals(
							textField_3.getText())) {
						new JOptionPane().showMessageDialog(null, "�����������벻ͬ��");
						textField_3.requestFocus();
					} else {
						String sql = "insert t_user values('"
								+ textField_1.getText() + "','"
								+ textField_2.getText() + "')";
						try {
							if (DBConnection.executeSQL(sql)) {
								new JOptionPane().showMessageDialog(null,
										"��ӳɹ���");
								user.addItem(textField_1.getText());
							} else {
								new JOptionPane().showMessageDialog(null,
										"���ʧ�ܣ�");
							}
						} catch (Exception ex) {
							ex.getStackTrace();
						}
					}

				}
			});
		}
		{
			JButton button2 = new JButton("���");
			button2.setBounds(225, 270, 93, 27);
			button2.setCursor(cursor);
			add(button2);
			button2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					textField_1.setText("");
					textField_2.setText("");
					textField_3.setText("");
					textField_1.requestFocus();
				}
			});
		}

		{
			JLabel labelpass = new JLabel("�� ɾ �� �� ��");
			labelpass.setFont(new Font("����", Font.PLAIN, 15));
			labelpass.setForeground(Color.GRAY);
			labelpass.setBounds(420, 105, 138, 20);
			add(labelpass);
		}
		{
			JLabel label = new JLabel("�û�����");
			label.setBounds(420, 165, 82, 15);
			add(label);
		}
		{
			JLabel label = new JLabel("��   �룺");
			label.setBounds(420, 215, 82, 15);
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
			user.setBounds(475, 160, 165, 27);
			add(user);
		}
		{
			textField_4 = new JPasswordField();
			textField_4.setColumns(10);
			textField_4.setBounds(475, 210, 165, 27);
			add(textField_4);
		}
		{
			JButton button3 = new JButton("ɾ��");
			button3.setBounds(420, 270, 93, 27);
			button3.setCursor(cursor);
			add(button3);
			button3.addActionListener(new ActionListener() {
				@SuppressWarnings( { "deprecation", "static-access" })
				public void actionPerformed(ActionEvent e) {
					String name = "" + user.getSelectedItem();
					String sql = "select * from t_user where User_Name='"
							+ name + "'";
					try {
						if (DBConnection.query(sql)) {
							DBConnection.rs.next();
							String pas = textField_4.getText();
							String password = DBConnection.rs
									.getString("User_Pass");
							if (pas.equals(password)) {
								String sdelete = "delete from t_user where User_Name='"
										+ name + "'";
								if (DBConnection.executeSQL(sdelete)) {
									new JOptionPane().showMessageDialog(null,
											"ɾ���ɹ���");
									textField_4.setText("");
									user.removeAllItems();
									String sql1 = "select * from t_user";
									if (DBConnection.query(sql1)) {
										while (DBConnection.rs.next()) {
											String name1 = DBConnection.rs
													.getString("User_Name");
											user.addItem(name1);
										}
									}
								}
							} else {
								new JOptionPane().showMessageDialog(null,
										"���벻��ȷ��");
								textField_4.requestFocus();
							}
						}
					} catch (Exception ex) {
						ex.printStackTrace();
					}
				}
			});
		}
		{
			JButton button4 = new JButton("���");
			button4.setBounds(545, 270, 93, 27);
			button4.setCursor(cursor);
			add(button4);
			button4.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					textField_4.setText("");
					textField_4.requestFocus();
				}
			});
		}
	}
}

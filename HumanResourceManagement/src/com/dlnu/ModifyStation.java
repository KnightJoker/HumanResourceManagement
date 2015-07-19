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

public class ModifyStation extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private Cursor cursor = new Cursor(Cursor.HAND_CURSOR);

	public ModifyStation() {
		setBackground(Color.WHITE);
		setLayout(null);
		{
			JLabel labelpass = new JLabel("�� �� �� λ");
			labelpass.setFont(new Font("����", Font.PLAIN, 15));
			labelpass.setForeground(Color.GRAY);
			labelpass.setBounds(300, 60, 138, 20);
			add(labelpass);
		}
		{
			JLabel label = new JLabel("ְλ��ţ�");
			label.setBounds(140, 120, 70, 17);
			add(label);
		}
		{
			JLabel label = new JLabel("ְλ���ƣ�");
			label.setBounds(390, 120, 70, 17);
			add(label);
		}
		{
			JLabel label = new JLabel("��Ƹ����");
			label.setBounds(140, 170, 70, 17);
			add(label);
		}
		{
			JLabel lbli = new JLabel("��Ч������");
			lbli.setBounds(390, 170, 70, 17);
			add(lbli);
		}
		{
			JLabel label = new JLabel("ְλ���");
			label.setBounds(140, 220, 70, 17);
			add(label);
		}
		{
			JLabel label = new JLabel("�����ص㣺");
			label.setBounds(390, 220, 70, 17);
			add(label);
		}
		{
			JLabel label = new JLabel("��λ������");
			label.setBounds(140, 270, 70, 17);
			add(label);
		}
		{
			JLabel label = new JLabel("��ְ������");
			label.setBounds(390, 270, 70, 17);
			add(label);
		}
		{
			textField = new JTextField();
			textField.setBounds(201, 117, 116, 23);
			add(textField);
			textField.setColumns(10);
		}
		{
			textField_1 = new JTextField();
			textField_1.setBounds(201, 170, 116, 23);
			add(textField_1);
			textField_1.setColumns(10);
		}
		{
			textField_2 = new JTextField();
			textField_2.setBounds(201, 217, 116, 23);
			add(textField_2);
			textField_2.setColumns(10);
		}
		{
			textField_3 = new JTextField();
			textField_3.setBounds(201, 267, 116, 23);
			add(textField_3);
			textField_3.setColumns(10);
		}
		{
			textField_4 = new JTextField();
			textField_4.setBounds(448, 117, 226, 23);
			add(textField_4);
			textField_4.setColumns(10);
		}
		{
			textField_5 = new JTextField();
			textField_5.setBounds(448, 170, 226, 23);
			add(textField_5);
			textField_5.setColumns(10);
		}
		{
			textField_6 = new JTextField();
			textField_6.setBounds(448, 217, 226, 23);
			add(textField_6);
			textField_6.setColumns(10);
		}
		{
			textField_7 = new JTextField();
			textField_7.setBounds(448, 267, 226, 23);
			add(textField_7);
			textField_7.setColumns(10);
		}
		{
			JButton button = new JButton("�޸�");
			button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String sqlupdate = "update t_station set St_Number='"
							+ textField_1.getText() + "'," + "St_Date='"
							+ textField_5.getText() + "',St_Describe='"
							+ textField_3.getText() + "'," + "St_Condition='"
							+ textField_7.getText() + "' where St_ID='"
							+ textField.getText() + "'";
					try {
						if (DBConnection.executeSQL(sqlupdate)) {
							new JOptionPane();
							JOptionPane.showMessageDialog(null, "�����޸ĳɹ���");
							DBConnection.joinDB();
							String sql = "select * from t_station";
							DBConnection.query(sql);
						} else {
							new JOptionPane();
							JOptionPane.showMessageDialog(null, "�����޸�ʧ�ܣ�");
						}
					} catch (Exception ex) {
						ex.getStackTrace();
					}
				}
			});
			button.setBounds(215, 325, 101, 25);
			button.setCursor(cursor);
			add(button);
		}
		{
			JButton button = new JButton("ȡ��");
			button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					textField_1.requestFocus();
					DBConnection.joinDB();
					String sql = "select * from t_station";
					try {
						if (DBConnection.query(sql)) {
							DBConnection.rs.next();
							textField.setText(DBConnection.rs.getString("St_ID"));
							textField_4.setText(DBConnection.rs
									.getString("St_Name"));
							textField_2.setText(DBConnection.rs
									.getString("St_Tier"));
							textField_6.setText(DBConnection.rs
									.getString("St_Place"));
							textField_5.setText(DBConnection.rs
									.getString("St_Date"));
							textField_1.setText(DBConnection.rs
									.getString("St_Number"));
							textField_3.setText(DBConnection.rs
									.getString("St_Describe"));
							textField_7.setText(DBConnection.rs
									.getString("St_Condition"));
							textField.setEditable(false);
							textField_4.setEditable(false);
							textField_2.setEditable(false);
							textField_6.setEditable(false);
						}
					} catch (Exception ex) {
						ex.getStackTrace();
					}
				}
			});
			button.setBounds(400, 325, 101, 25);
			button.setCursor(cursor);
			add(button);
		}
		{
			JButton button = new JButton("<<");
			button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						if (DBConnection.rs.previous()) {
							textField.setText(DBConnection.rs.getString("St_ID"));
							textField_4.setText(DBConnection.rs
									.getString("St_Name"));
							textField_2.setText(DBConnection.rs
									.getString("St_Tier"));
							textField_6.setText(DBConnection.rs
									.getString("St_Place"));
							textField_5.setText(DBConnection.rs
									.getString("St_Date"));
							textField_1.setText(DBConnection.rs
									.getString("St_Number"));
							textField_3.setText(DBConnection.rs
									.getString("St_Describe"));
							textField_7.setText(DBConnection.rs
									.getString("St_Condition"));
						}
					} catch (Exception ex) {
						ex.getStackTrace();
					}
				}
			});
			button.setBounds(570, 325, 50, 25);
			button.setCursor(cursor);
			add(button);
		}
		{
			JButton button = new JButton(">>");
			button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						if (DBConnection.rs.next()) {
							textField.setText(DBConnection.rs.getString("St_ID"));
							textField_4.setText(DBConnection.rs
									.getString("St_Name"));
							textField_2.setText(DBConnection.rs
									.getString("St_Tier"));
							textField_6.setText(DBConnection.rs
									.getString("St_Place"));
							textField_5.setText(DBConnection.rs
									.getString("St_Date"));
							textField_1.setText(DBConnection.rs
									.getString("St_Number"));
							textField_3.setText(DBConnection.rs
									.getString("St_Describe"));
							textField_7.setText(DBConnection.rs
									.getString("St_Condition"));
						}
					} catch (Exception ex) {
						ex.getStackTrace();
					}
				}
			});
			button.setBounds(620, 325, 50, 25);
			button.setCursor(cursor);
			add(button);
		}

		DBConnection.joinDB();
		String sql = "select * from t_station";
		try {
			if (DBConnection.query(sql)) {
				DBConnection.rs.next();
				textField.setText(DBConnection.rs.getString("St_ID"));
				textField_4.setText(DBConnection.rs.getString("St_Name"));
				textField_2.setText(DBConnection.rs.getString("St_Tier"));
				textField_6.setText(DBConnection.rs.getString("St_Place"));
				textField_5.setText(DBConnection.rs.getString("St_Date"));
				textField_1.setText(DBConnection.rs.getString("St_Number"));
				textField_3.setText(DBConnection.rs.getString("St_Describe"));
				textField_7.setText(DBConnection.rs.getString("St_Condition"));
				textField.setEditable(false);
				textField_4.setEditable(false);
				textField_2.setEditable(false);
				textField_6.setEditable(false);
			}
		} catch (Exception ex) {
			ex.getStackTrace();
		}
	}
}

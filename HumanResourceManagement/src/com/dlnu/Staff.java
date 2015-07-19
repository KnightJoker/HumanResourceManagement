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
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class Staff extends JPanel {
	private static final long serialVersionUID = 1L;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private Cursor cursor = new Cursor(Cursor.HAND_CURSOR);

	JButton button1 = new JButton("保存");
	JButton button2 = new JButton("添加");
	JButton button3 = new JButton("修改");

	JTextField textField = new JTextField();
	JTextField textField_1 = new JTextField();
	JComboBox comboBox1 = new JComboBox();
	JComboBox comboBox2 = new JComboBox();
	JComboBox comboBox3 = new JComboBox();
	JComboBox comboBox4 = new JComboBox();

	public Staff() {
		setBackground(Color.WHITE);
		setLayout(null);
		button1.setEnabled(true);
		textField.setEditable(true);
		{
			JLabel label = new JLabel("员 工 管 理");
			label.setFont(new Font("黑体", Font.PLAIN, 15));
			label.setForeground(Color.GRAY);
			label.setBounds(333, 0, 158, 20);
			add(label);
		}
		{
			JLabel label = new JLabel("编        号：");
			label.setBounds(107, 60, 84, 15);
			add(label);
		}
		{
			JLabel label = new JLabel("姓        名：");
			label.setBounds(390, 60, 68, 15);
			add(label);
		}
		{
			JLabel label = new JLabel("性        别：");
			label.setBounds(107, 105, 84, 15);
			add(label);
		}
		{
			JLabel label = new JLabel("生        日：");
			label.setBounds(390, 150, 68, 15);
			add(label);
		}
		{
			JLabel label = new JLabel("身  份  证：");
			label.setBounds(107, 150, 84, 15);
			add(label);
		}
		{
			JLabel label = new JLabel("婚        姻：");
			label.setBounds(390, 105, 68, 15);
			add(label);
		}
		{
			JLabel label = new JLabel("政        治：");
			label.setBounds(107, 195, 84, 15);
			add(label);
		}
		{
			JLabel label = new JLabel("学        历：");
			label.setBounds(390, 195, 84, 15);
			add(label);
		}
		{
			JLabel label = new JLabel("专        业：");
			label.setBounds(107, 240, 84, 15);
			add(label);
		}
		{
			JLabel label = new JLabel("毕业院校：");
			label.setBounds(390, 240, 84, 15);
			add(label);
		}
		{
			JLabel label = new JLabel("部          门：");
			label.setBounds(107, 285, 84, 15);
			add(label);
		}
		{
			JLabel label = new JLabel("职位名称：");
			label.setBounds(390, 285, 84, 15);
			add(label);
		}
		{
			JLabel label = new JLabel("入职时间：");
			label.setBounds(107, 330, 84, 15);
			add(label);
		}
		{
			JLabel label = new JLabel("状        况：");
			label.setBounds(390, 330, 84, 15);
			add(label);
		}
		{
			JLabel label = new JLabel("备        注：");
			label.setBounds(107, 375, 84, 15);
			add(label);
		}
		{
			textField.setBounds(171, 57, 112, 21);
			add(textField);
			textField.setColumns(10);
		}
		{
			textField_1.setBounds(448, 57, 112, 21);
			add(textField_1);
			textField_1.setColumns(10);
		}
		{
			comboBox1.setModel(new DefaultComboBoxModel(
					new String[] { "男", "女" }));
			comboBox1.setBounds(171, 102, 112, 21);
			add(comboBox1);
		}
		{
			comboBox2.setModel(new DefaultComboBoxModel(new String[] { "未婚",
					"已婚" }));
			comboBox2.setBounds(448, 102, 112, 21);
			add(comboBox2);
		}
		{
			textField_2 = new JTextField();
			textField_2.setBounds(171, 147, 112, 21);
			add(textField_2);
			textField_2.setColumns(10);
		}
		{
			textField_3 = new JTextField();
			textField_3.setBounds(448, 147, 112, 21);
			add(textField_3);
			textField_3.setColumns(10);
		}
		{
			comboBox3.setModel(new DefaultComboBoxModel(new String[] { "中共党员",
					"共青团员", "民主党", "无党派" }));
			comboBox3.setBounds(171, 192, 112, 21);
			add(comboBox3);
		}
		{
			comboBox4.setModel(new DefaultComboBoxModel(new String[] { "博士",
					"硕士", "本科", "专科", "高中", "初中" }));
			comboBox4.setBounds(448, 192, 112, 21);
			add(comboBox4);
		}
		{
			textField_4 = new JTextField();
			textField_4.setBounds(171, 237, 112, 21);
			add(textField_4);
			textField_4.setColumns(10);
		}
		{
			textField_5 = new JTextField();
			textField_5.setBounds(448, 237, 112, 21);
			add(textField_5);
			textField_5.setColumns(10);
		}
		{
			textField_6 = new JTextField();
			textField_6.setBounds(171, 282, 112, 21);
			add(textField_6);
			textField_6.setColumns(10);
		}
		{
			textField_7 = new JTextField();
			textField_7.setBounds(448, 282, 112, 21);
			add(textField_7);
			textField_7.setColumns(10);
		}
		{
			textField_8 = new JTextField();
			textField_8.setBounds(171, 327, 112, 21);
			add(textField_8);
			textField_8.setColumns(10);
		}
		{
			textField_9 = new JTextField();
			textField_9.setBounds(448, 327, 112, 21);
			add(textField_9);
			textField_9.setColumns(10);
		}
		{
			textField_10 = new JTextField();
			textField_10.setBounds(171, 372, 389, 21);
			add(textField_10);
			textField_10.setColumns(10);
		}
		{
			button1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (textField_1.getText().equals("")
							|| textField_2.getText().equals("")
							|| textField_3.getText().equals("")
							|| textField_4.getText().equals("")
							|| textField_5.getText().equals("")
							|| textField_6.getText().equals("")
							|| textField_7.getText().equals("")
							|| textField_8.getText().equals("")
							|| textField_9.getText().equals("")
							|| textField_10.getText().equals("")) {
						new JOptionPane();
						JOptionPane.showMessageDialog(null, "所有数据均不能为空！");
					} else {
						String sqlInsert = "insert into t_employee values('"
								+ textField.getText()+ "'," + "'"
								+ textField_1.getText() + "'," + "'"
								+ comboBox1.getSelectedItem() + "','"
								+ comboBox2.getSelectedItem() + "','"
								+ textField_2.getText() + "','"
								+ textField_3.getText() + "','"
								+ comboBox3.getSelectedItem() + "','"
								+ comboBox4.getSelectedItem() + "','"
								+ textField_4.getText() + "','"
								+ textField_5.getText() + "','"
								+ textField_6.getText() + "','"
								+ textField_7.getText() + "','"
								+ textField_8.getText() + "','"
								+ textField_9.getText() + "','"
								+ textField_10.getText() + "')";
						try {
							if (DBConnection.executeSQL(sqlInsert)) {
								new JOptionPane();
								JOptionPane.showMessageDialog(null, "数据保存成功！");
								textField_1.setEditable(false);								
								button1.setEnabled(false);
								button2.setEnabled(true);
								button3.setEnabled(true);

								DBConnection.joinDB();
								String sql = "select * from t_employee";
								DBConnection.query(sql);
							}
						} catch (Exception ex) {
							System.out.println("e");
							ex.getStackTrace();
						}
					}
				}
			});
			button1.setBounds(107, 422, 68, 23);
			button1.setCursor(cursor);
			add(button1);
		}
		{
			button2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					button1.setEnabled(true);
					button2.setEnabled(false);
					button3.setEnabled(false);

					textField_1.setEditable(true);
					textField.setEditable(true);
					textField.setText("");					
					textField_1.setText("");
					textField_2.setText("");
					textField_3.setText("");
					textField_4.setText("");
					textField_5.setText("");
					textField_6.setText("");
					textField_7.setText("");
					textField_8.setText("");
					textField_9.setText("");
					textField_10.setText("");
					comboBox1.setSelectedItem("女");
					comboBox2.setSelectedItem("未婚");
					comboBox3.setSelectedItem("中共党员");
					comboBox4.setSelectedItem("专科");
				}
			});
			button2.setBounds(195, 422, 68, 23);
			button2.setCursor(cursor);
			add(button2);
		}
		{
			button3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String sqlupdate = "update t_employee set Emp_Sex='"
							+ comboBox1.getSelectedItem() + "'," + "Emp_Marry='"
							+ comboBox2.getSelectedItem() + "',Emp_Card='"
							+ textField_2.getText()+ "',Emp_Birthday='"
							+ textField_3.getText() + "',Emp_Politics='"
							+ comboBox3.getSelectedItem() + "',Emp_Education='"
							+ comboBox4.getSelectedItem() + "',Emp_Speciality='"
							+ textField_4.getText() + "',Emp_Graduation='"
							+ textField_5.getText() + "',Emp_Department='"
							+ textField_6.getText() + "',Emp_Position='"
							+ textField_7.getText() + "',Emp_In='"
							+ textField_8.getText() + "',Emp_Status='"
							+ textField_9.getText() + "',Emp_Remark='"
							+ textField_10.getText() + "'where Emp_ID='"
							+ textField.getText() + "'";
					System.out.println(sqlupdate);
					try {
						if (DBConnection.executeSQL(sqlupdate)) {
							new JOptionPane();
							JOptionPane.showMessageDialog(null, "数据修改成功！");
							DBConnection.joinDB();
							String sql = "select * from t_employee";
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
			button3.setBounds(283, 422, 68, 23);
			button3.setCursor(cursor);
			add(button3);
		}
		{
			JButton button4 = new JButton("删除");
			button4.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						String sql = "delete from t_employee where Emp_ID ='"
								+ textField.getText() + "'";
						new JOptionPane();
						int s = JOptionPane.showConfirmDialog(null,
								"确认删除选中数据？", "确认", JOptionPane.YES_NO_OPTION);
						if (s == JOptionPane.YES_OPTION) {
							if (DBConnection.executeSQL(sql)) {
								new JOptionPane();
								JOptionPane.showMessageDialog(null, "数据删除成功！");
								DBConnection.joinDB();
							}
							String sqll = "select * from t_employee";
							DBConnection.query(sqll);
							DBConnection.rs.last();
							textField.setText(DBConnection.rs.getString("Emp_ID"));
							textField_1.setText(DBConnection.rs.getString("Emp_Name"));
							comboBox1.setSelectedItem(DBConnection.rs.getString("Emp_Sex"));
							comboBox2.setSelectedItem(DBConnection.rs.getString("Emp_Marry"));
							textField_2.setText(DBConnection.rs.getString("Emp_Card"));
							textField_3.setText(DBConnection.rs.getString("Emp_Birthday"));
							comboBox3.setSelectedItem(DBConnection.rs.getString("Emp_Politics"));
							comboBox4.setSelectedItem(DBConnection.rs.getString("Emp_Education"));
							textField_4.setText(DBConnection.rs.getString("Emp_Speciality"));
							textField_5.setText(DBConnection.rs.getString("Emp_Graduation"));
							textField_6.setText(DBConnection.rs.getString("Emp_Department"));
							textField_7.setText(DBConnection.rs.getString("Emp_Position"));
							textField_8.setText(DBConnection.rs.getString("Emp_In"));
							textField_9.setText(DBConnection.rs.getString("Emp_Status"));
							textField_10.setText(DBConnection.rs.getString("Emp_Remark"));
						}
					} catch (Exception ex) {
						ex.getStackTrace();
					}
				}
			});
			button4.setBounds(371, 422, 68, 23);
			button4.setCursor(cursor);
			add(button4);
		}

		
		DBConnection.joinDB();
		String sql = "select * from t_employee";
		try {
			if (DBConnection.query(sql)) {
				DBConnection.rs.next();
				textField.setText(DBConnection.rs.getString("Emp_ID"));
				textField_1.setText(DBConnection.rs.getString("Emp_Name"));
				comboBox1.setSelectedItem(DBConnection.rs.getString("Emp_Sex"));
				comboBox2.setSelectedItem(DBConnection.rs.getString("Emp_Marry"));
				textField_2.setText(DBConnection.rs.getString("Emp_Card"));
				textField_3.setText(DBConnection.rs.getString("Emp_Birthday"));
				comboBox3.setSelectedItem(DBConnection.rs.getString("Emp_Politics"));
				comboBox4.setSelectedItem(DBConnection.rs.getString("Emp_Education"));
				textField_4.setText(DBConnection.rs.getString("Emp_Speciality"));
				textField_5.setText(DBConnection.rs.getString("Emp_Graduation"));
				textField_6.setText(DBConnection.rs.getString("Emp_Department"));
				textField_7.setText(DBConnection.rs.getString("Emp_Position"));
				textField_8.setText(DBConnection.rs.getString("Emp_In"));
				textField_9.setText(DBConnection.rs.getString("Emp_Status"));
				textField_10.setText(DBConnection.rs.getString("Emp_Remark"));
			}
		} catch (Exception ex) {
			ex.getStackTrace();
		}
	}
}

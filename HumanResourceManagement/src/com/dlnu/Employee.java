package com.dlnu;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.Vector;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Employee extends JPanel {
	private static final long serialVersionUID = 1L;
	JTable table_1;
	DefaultTableModel dtm;
	String head[] = { "编号", "姓名", "性别", "婚否", "身份证号", "出生日期", "政治面貌", "学历",
			"专业", "毕业院校", "部门", "工作", "进入时间", "业绩", "评价" };

	@SuppressWarnings("unchecked")
	public Employee() {
		setLayout(null);
		setBackground(Color.WHITE);
		dtm = new DefaultTableModel();
		table_1 = new JTable(dtm);
		//table_1.setFillsViewportHeight(true);
		table_1.setBackground(Color.WHITE);
		table_1.setPreferredScrollableViewportSize(new Dimension(550, 400));
		JScrollPane scrollPane = new JScrollPane(table_1);
		scrollPane.setBounds(50, 50, 660, 300);
		add(scrollPane);
		{
			JLabel label = new JLabel("员 工 信 息");
			label.setFont(new Font("黑体", Font.PLAIN, 15));
			label.setForeground(Color.GRAY);
			label.setBounds(333, 14, 158, 20);
			add(label);
		}
		dtm.setColumnCount(15);
		dtm.setColumnIdentifiers(head);
		DBConnection.joinDB();
		String csf = "select * from t_employee";
		if (DBConnection.query(csf)) {
			try {
				while (DBConnection.rs.next()) {
					String id = DBConnection.rs.getString("Emp_ID");
					String name = DBConnection.rs.getString("Emp_Name");
					String sex = DBConnection.rs.getString("Emp_Sex");
					String marry = DBConnection.rs.getString("Emp_Marry");
					String card = DBConnection.rs.getString("Emp_Card");
					String birthday = DBConnection.rs.getString("Emp_Birthday");
					String politics = DBConnection.rs.getString("Emp_Politics");
					String education = DBConnection.rs.getString("Emp_Education");
					String speciality = DBConnection.rs.getString("Emp_Speciality");
					String graduation = DBConnection.rs.getString("Emp_Graduation");
					String department = DBConnection.rs.getString("Emp_Department");
					String position = DBConnection.rs.getString("Emp_Position");
					String in = DBConnection.rs.getString("Emp_In");
					String status = DBConnection.rs.getString("Emp_Status");
					String remark = DBConnection.rs.getString("Emp_Remark");
					Vector v = new Vector();
					v.add(id);
					v.add(name);
					v.add(sex);
					v.add(marry);					
					v.add(card);
					v.add(birthday);
					v.add(politics);
					v.add(education);
					v.add(speciality);
					v.add(graduation);
					v.add(department);
					v.add(position);
					v.add(in);
					v.add(status);
					v.add(remark);
					dtm.addRow(v);
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}
}

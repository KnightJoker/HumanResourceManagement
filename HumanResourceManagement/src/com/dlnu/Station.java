package com.dlnu;

import java.util.Vector;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

public class Station extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JTable table_1;
	DefaultTableModel dtm;
	String head[] = { "职位编号", "职位名称", "职位类别", "工作地点", "有效日期", "需求人数", "职位描述",
			"入职条件" };

	@SuppressWarnings("unchecked")
	public Station() {
		setLayout(null);
		setBackground(Color.WHITE);
		dtm = new DefaultTableModel();
		table_1 = new JTable(dtm);
		//table_1.setFillsViewportHeight(true);
		table_1.setBackground(Color.WHITE);
		table_1.setPreferredScrollableViewportSize(new Dimension(550, 400));
		JScrollPane scrollPane = new JScrollPane(table_1);
		scrollPane.setBounds(100, 50, 600, 300);
		add(scrollPane);
		{
			JLabel label = new JLabel("最 新 岗 位 信 息");
			label.setFont(new Font("黑体", Font.PLAIN, 15));
			label.setForeground(Color.GRAY);
			label.setBounds(333, 14, 158, 20);
			add(label);
		}
		dtm.setColumnCount(8);
		dtm.setColumnIdentifiers(head);
		DBConnection.joinDB();
		String csf = "select * from t_station";
		if (DBConnection.query(csf)) {
			try {
				while (DBConnection.rs.next()) {
					String id = DBConnection.rs.getString("St_ID");
					String name = DBConnection.rs.getString("St_Name");
					String tier = DBConnection.rs.getString("St_Tier");
					String place = DBConnection.rs.getString("St_Place");
					String date = DBConnection.rs.getString("St_Date");
					String number = DBConnection.rs.getString("St_Number");
					String describe = DBConnection.rs.getString("St_Describe");
					String condition = DBConnection.rs.getString("St_Condition");
					Vector v = new Vector();
					v.add(id);
					v.add(name);
					v.add(tier);
					v.add(place);
					v.add(date);
					v.add(number);
					v.add(describe);
					v.add(condition);
					dtm.addRow(v);
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}
}
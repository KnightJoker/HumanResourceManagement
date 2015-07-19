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

public class Wage extends JPanel {
	private static final long serialVersionUID = 1L;
	JTable table_1;
	DefaultTableModel dtm;
	String head[] = { "工资编号", "员工编号", "姓名", "福利", "奖金", "基本工资", "实发工资" };

	@SuppressWarnings("unchecked")
	public Wage() {
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
			JLabel label = new JLabel("员 工 薪 资");
			label.setFont(new Font("黑体", Font.PLAIN, 15));
			label.setForeground(Color.GRAY);
			label.setBounds(333, 14, 158, 20);
			add(label);
		}
		dtm.setColumnCount(7);
		dtm.setColumnIdentifiers(head);
		DBConnection.joinDB();
		String csf = "select * from t_wage";
		if (DBConnection.query(csf)) {
			try {
				while (DBConnection.rs.next()) {
					String id = DBConnection.rs.getString("Wage_ID");
					String id1 = DBConnection.rs.getString("Emp_ID");
					String name = DBConnection.rs.getString("Emp_Name");
					String welfare = DBConnection.rs.getString("Wage_Welfare");
					String bonus = DBConnection.rs.getString("Wage_Bonus");
					String basic = DBConnection.rs.getString("Wage_Basic");
					String pay = DBConnection.rs.getString("Wage_Pay");
					Vector v = new Vector();
					v.add(id);
					v.add(id1);
					v.add(name);
					v.add(welfare);
					v.add(bonus);
					v.add(basic);
					v.add(pay);
					dtm.addRow(v);
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}
}

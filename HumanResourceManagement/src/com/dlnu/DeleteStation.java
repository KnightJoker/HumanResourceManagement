package com.dlnu;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JButton;

public class DeleteStation extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JTable table_1;
	DefaultTableModel dtm;
	private Cursor cursor = new Cursor(Cursor.HAND_CURSOR);
	String head[] = { "职位编号", "职位名称", "职位类别", "工作地点", "有效日期", "需求人数", "职位描述",
			"入职条件" };

	@SuppressWarnings("unchecked")
	public DeleteStation() {
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
			JLabel label = new JLabel("删 除 岗 位");
			label.setFont(new Font("黑体", Font.PLAIN, 15));
			label.setForeground(Color.GRAY);
			label.setBounds(333, 14, 138, 20);
			add(label);
		}
		{
			JButton button = new JButton("确认删除");
			button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (table_1.getSelectedRow() != -1) {
						String id = table_1.getValueAt(
								table_1.getSelectedRow(), 0).toString();
						String sqldelete = "delete from t_station where St_ID='"
								+ id + "'";
						try {
							new JOptionPane();
							int s = JOptionPane.showConfirmDialog(null,
									"确认删除选中数据？", "确认",
									JOptionPane.YES_NO_OPTION);
							if (s == JOptionPane.YES_OPTION) {
								if (DBConnection.executeSQL(sqldelete)) {
									new JOptionPane();
									JOptionPane.showMessageDialog(null,
											"数据删除成功！");
									DBConnection.joinDB();
								}
							}

						} catch (Exception ex) {
							ex.getStackTrace();
						}
					} else {
						JOptionPane.showMessageDialog(null, "数据删除失败！");
					}
				}
			});
			button.setBounds(333, 370, 101, 25);
			button.setCursor(cursor);
			add(button);
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
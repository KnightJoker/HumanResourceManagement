package com.dlnu;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.Vector;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTree;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.tree.DefaultMutableTreeNode;

public class Department extends JPanel {
	private static final long serialVersionUID = 1L;
//	private DefaultMutableTreeNode mainroot = new DefaultMutableTreeNode("公司部门");
//	private DefaultMutableTreeNode newnode;
//	private DefaultMutableTreeNode root;
	private String rootstr = "";
	JTable table_1;
	DefaultTableModel dtm;
	String head[] = { "部门编号", "部门名称", "从属部门", "部门职能" };

	@SuppressWarnings("unchecked")
	public Department() {
		setLayout(null);
		setBackground(Color.WHITE);
		dtm = new DefaultTableModel();
		table_1 = new JTable(dtm);
		//table_1.setFillsViewportHeight(true);
		table_1.setBackground(Color.WHITE);
		table_1.setPreferredScrollableViewportSize(new Dimension(350, 300));
		JScrollPane scrollPane = new JScrollPane(table_1);
		scrollPane.setBounds(250, 50, 400, 300);
		add(scrollPane);
		{
			JLabel label = new JLabel("部 门 信 息");
			label.setFont(new Font("黑体", Font.PLAIN, 15));
			label.setForeground(Color.GRAY);
			label.setBounds(333, 14, 158, 20);
			add(label);
		}
//		{
//			JTree tree = new JTree(mainroot);
//			tree.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null,
//					null, null));
//			tree.setBounds(100, 50, 150, 300);
//			add(tree);
//		}
		dtm.setColumnCount(7);
		dtm.setColumnIdentifiers(head);
		DBConnection.joinDB();
		String csf = "select * from t_department";
		if (DBConnection.query(csf)) {
			try {
				while (DBConnection.rs.next()) {
					String id = DBConnection.rs.getString("Dept_ID");
					String name = DBConnection.rs.getString("Dept_Name");
					String name1 = DBConnection.rs.getString("Belong_Name");
					String job = DBConnection.rs.getString("Dept_Job");
					Vector v = new Vector();
					v.add(id);
					v.add(name);
					v.add(name1);
					v.add(job);
					dtm.addRow(v);
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}

//		String dp = "select * from t_department order by Dept_Name";
//		if (Database.query(dp)) {
//			try {
//				while (Database.rs.next()) {
//					if (!rootstr.equals(Database.rs.getString("Dept_Name"))) {
//						root = new DefaultMutableTreeNode(Database.rs
//								.getString("Dept_Name"), true);
//						mainroot.add(root);
//						rootstr = Database.rs.getString("Dept_Name");
//					}
//					if (Database.rs.getString("Belong_Name") != null) {
//						newnode = new DefaultMutableTreeNode(Database.rs
//								.getString("Belong_Name"));						
//						root.add(newnode);
//					}
//				}
//			} catch (Exception ex) {
//				ex.getStackTrace();
//			}
//		}

	}
}

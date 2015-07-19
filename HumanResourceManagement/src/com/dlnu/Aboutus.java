package com.dlnu;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JTextArea;
import java.awt.Font;

public class Aboutus extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Aboutus() {
		setBackground(Color.WHITE);
		setLayout(null);
		{
			JLabel label = new JLabel("关于我们");
			label.setForeground(Color.GRAY);
			label.setFont(new Font("宋体", Font.PLAIN, 16));
			label.setBackground(Color.WHITE);
			label.setBounds(191, 48, 85, 17);
			add(label);
		}
		{
			JTextArea txtrhrms = new JTextArea();
			txtrhrms.setForeground(Color.GRAY);
			txtrhrms
					.setText("    人力资源管理系统（HRMS），包括人事日常事务 、薪酬 、招聘、 培训、 "
							+ "考核以及人力资源的管理也指组织或社会团体运用系统学理论方法，"
							+ "对企业的人力资源管理方方面面进行分析、规划、实施、调整，提高企"
							+ "业人力资源管理水平，使人力资源更有效的服务于组织或团体目标。"
							+ "								"
							+ "  		运行环境：Windows			  "
							+ " 	开发工具：JAVA                 		  "
							+ " 	数据库类型：Oracle    			  "
							+ " 	开发人员：	 "
							+ "  				 陈旭礼，徐再贤     "
							+ "  			戴来特，黄思成，杨茹越，王晓滨    ");
			txtrhrms.setFont(new Font("宋体", Font.PLAIN, 16));
			txtrhrms.setBackground(Color.WHITE);
			txtrhrms.setLineWrap(true);
			txtrhrms.setBounds(137, 76, 420, 359);
			txtrhrms.setEditable(false);
			add(txtrhrms);
		}
	}
}

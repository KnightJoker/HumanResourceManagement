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
			JLabel label = new JLabel("��������");
			label.setForeground(Color.GRAY);
			label.setFont(new Font("����", Font.PLAIN, 16));
			label.setBackground(Color.WHITE);
			label.setBounds(191, 48, 85, 17);
			add(label);
		}
		{
			JTextArea txtrhrms = new JTextArea();
			txtrhrms.setForeground(Color.GRAY);
			txtrhrms
					.setText("    ������Դ����ϵͳ��HRMS�������������ճ����� ��н�� ����Ƹ�� ��ѵ�� "
							+ "�����Լ�������Դ�Ĺ���Ҳָ��֯�������������ϵͳѧ���۷�����"
							+ "����ҵ��������Դ������������з������滮��ʵʩ�������������"
							+ "ҵ������Դ����ˮƽ��ʹ������Դ����Ч�ķ�������֯������Ŀ�ꡣ"
							+ "								"
							+ "  		���л�����Windows			  "
							+ " 	�������ߣ�JAVA                 		  "
							+ " 	���ݿ����ͣ�Oracle    			  "
							+ " 	������Ա��	 "
							+ "  				 ������������     "
							+ "  			�����أ���˼�ɣ�����Խ��������    ");
			txtrhrms.setFont(new Font("����", Font.PLAIN, 16));
			txtrhrms.setBackground(Color.WHITE);
			txtrhrms.setLineWrap(true);
			txtrhrms.setBounds(137, 76, 420, 359);
			txtrhrms.setEditable(false);
			add(txtrhrms);
		}
	}
}

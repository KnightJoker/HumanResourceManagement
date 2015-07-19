package com.dlnu;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.UIManager;

public class Main extends JFrame {
	
	//jPanel右边   放图标监听器里内容   leftJpane放图标的
	private JPanel contentPane = null;
	private JPanel jPanel = null;
	private JPanel rightJPane = null;
	private JSplitPane splitPane = null;
	private JPanel leftJPane = null;
	private JLabel label = null;
	private Cursor cursor = new Cursor(Cursor.HAND_CURSOR);

	public Main() {
		super();
		setResizable(false);
		initialize();
	}

	private void initialize() {
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		int w = toolkit.getScreenSize().width;
		int h = toolkit.getScreenSize().height;

		this.setIconImage(SwingResourceManager.getImage(Login.class,
				"/img/hrms.gif"));
		this.setBounds(w / 2 - 512, h / 2 - 339, 1024, 678);
		this.setContentPane(getJContentPane());
		this.setTitle("人力资源管理系统");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		try {
			UIManager.setLookAndFeel("com.birosoft.liquid.LiquidLookAndFeel");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	JSplitPane getJSplitPane() {
		if (splitPane == null) {
			splitPane = new JSplitPane();
			splitPane.setBounds(230, 150, 778, 490);
			splitPane.setDividerSize(0);
			splitPane.setBorder(null);
			rightJPane = new JPanel();
			splitPane.setRightComponent(rightJPane);
			rightJPane.setLayout(null);
			rightJPane.setBorder(null);
			rightJPane.setMinimumSize(new Dimension(600, 400));
			rightJPane.add(getLabel());
			splitPane.setLeftComponent(leftJPane);
			leftJPane = new JPanel();
			leftJPane.setSize(230, 640);
			getJContentPane().add(leftJPane);
			leftJPane.setLocation(0, 0);
			leftJPane.setBorder(null);
			leftJPane.setBackground(Color.WHITE);
			leftJPane.setLayout(null);
			{
				JButton button1 = new JButton("");
				button1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						jPanel.removeAll();

						JLabel label1 = new JLabel();
						label1.setIcon(new ImageIcon(Main.class
								.getResource("/img/main.jpg")));
						splitPane.setRightComponent(label);

						JLabel label = new JLabel();
						label.setIcon(new ImageIcon(Main.class
								.getResource("/img/子菜单.jpg")));
						label.setBounds(50, 50, 149, 70);
						jPanel.add(label);

						JButton button1 = new JButton("");
						button1.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								JPanel p = new Modifypassword();
								splitPane.setRightComponent(p);
							}
						});
						button1.setIcon(new ImageIcon(Main.class
								.getResource("/img/修改密码.jpg")));
						button1.setBounds(240, 40, 70, 80);
						button1.setCursor(cursor);
						button1.setBorder(null);
						jPanel.add(button1);

						JButton button2 = new JButton("");
						button2.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								JPanel p = new User();
								splitPane.setRightComponent(p);
							}
						});
						button2.setIcon(new ImageIcon(Main.class
								.getResource("/img/用户管理.jpg")));
						button2.setBounds(380, 40, 70, 80);
						button2.setCursor(cursor);
						button2.setBorder(null);
						jPanel.add(button2);

						JButton button3 = new JButton("");
						button3.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								new Login().setVisible(true);
								dispose();
							}
						});
						button3.setIcon(new ImageIcon(Main.class
								.getResource("/img/重新登录.jpg")));
						button3.setBounds(520, 40, 70, 80);
						button3.setCursor(cursor);
						button3.setBorder(null);
						jPanel.add(button3);
						jPanel.repaint();
					}
				});
				button1.setIcon(new ImageIcon(Main.class
						.getResource("/img/系统设置.jpg")));
				button1.setBounds(30, 40, 70, 70);
				button1.setCursor(cursor);
				button1.setBorder(null);
				leftJPane.add(button1);
			}
			{
				JButton button2 = new JButton("");
				button2.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						jPanel.removeAll();

						JPanel p = new Station();
						splitPane.setRightComponent(p);
						splitPane.repaint();

						JLabel label = new JLabel();
						label.setIcon(new ImageIcon(Main.class
								.getResource("/img/子菜单.jpg")));
						label.setBounds(50, 50, 149, 70);
						jPanel.add(label);

						JButton button4 = new JButton("");
						button4.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								JPanel p = new ReleaseStation();
								splitPane.setRightComponent(p);
							}
						});
						button4.setIcon(new ImageIcon(Main.class
								.getResource("/img/发布岗位.jpg")));
						button4.setBounds(240, 40, 70, 80);
						button4.setCursor(cursor);
						button4.setBorder(null);
						jPanel.add(button4);

						JButton button5 = new JButton("");
						button5.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								JPanel p = new ModifyStation();
								splitPane.setRightComponent(p);
							}
						});
						button5.setIcon(new ImageIcon(Main.class
								.getResource("/img/修改岗位.jpg")));
						button5.setBounds(380, 40, 70, 80);
						button5.setCursor(cursor);
						button5.setBorder(null);
						jPanel.add(button5);

						JButton button6 = new JButton("");
						button6.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								JPanel p = new DeleteStation();
								splitPane.setRightComponent(p);
							}

						});
						button6.setIcon(new ImageIcon(Main.class
								.getResource("/img/删除岗位.jpg")));
						button6.setBounds(520, 40, 70, 80);
						button6.setCursor(cursor);
						button6.setBorder(null);
						jPanel.add(button6);
						jPanel.repaint();
					}
				});
				button2.setIcon(new ImageIcon(Main.class
						.getResource("/img/岗位管理.jpg")));
				button2.setBounds(30, 160, 70, 80);
				button2.setCursor(cursor);
				button2.setBorder(null);
				leftJPane.add(button2);
			}
			{
				JButton button3 = new JButton("");
				button3.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						jPanel.removeAll();

						JPanel p = new Wage();
						splitPane.setRightComponent(p);
						splitPane.repaint();

						JLabel label = new JLabel();
						label.setIcon(new ImageIcon(Main.class
								.getResource("/img/子菜单.jpg")));
						label.setBounds(50, 50, 149, 70);
						jPanel.add(label);

						JButton button1 = new JButton("");
						button1.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								JPanel p = new RegisteWage();
								splitPane.setRightComponent(p);
							}
						});
						button1.setIcon(new ImageIcon(Main.class
								.getResource("/img/薪资登记.jpg")));
						button1.setBounds(240, 40, 70, 80);
						button1.setCursor(cursor);
						button1.setBorder(null);
						jPanel.add(button1);

						JButton button2 = new JButton("");
						button2.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								JPanel p = new ModifyWage();
								splitPane.setRightComponent(p);
							}
						});
						button2.setIcon(new ImageIcon(Main.class
								.getResource("/img/薪资修改.jpg")));
						button2.setBounds(380, 40, 70, 80);
						button2.setCursor(cursor);
						button2.setBorder(null);
						jPanel.add(button2);

						JButton button3 = new JButton("");
						button3.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								JPanel p = new DeleteWage();
								splitPane.setRightComponent(p);
							}

						});
						button3.setIcon(new ImageIcon(Main.class
								.getResource("/img/薪资删除.jpg")));
						button3.setBounds(520, 40, 70, 80);
						button3.setCursor(cursor);
						button3.setBorder(null);
						jPanel.add(button3);
						jPanel.repaint();
					}
				});
				button3.setIcon(new ImageIcon(Main.class
						.getResource("/img/薪资管理.jpg")));
				button3.setBounds(30, 290, 70, 70);
				button3.setCursor(cursor);
				button3.setBorder(null);
				leftJPane.add(button3);
			}
			{
				JButton button4 = new JButton("");
				button4.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						jPanel.removeAll();
						
						JPanel p = new Employee ();
						splitPane.setRightComponent(p);
						splitPane.repaint();
						
						JLabel label = new JLabel();
						label.setIcon(new ImageIcon(Main.class
								.getResource("/img/子菜单.jpg")));
						label.setBounds(50, 50, 149, 70);
						jPanel.add(label);
						
						JButton button1 = new JButton("");
						button1.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								JPanel p = new Staff();
								splitPane.setRightComponent(p);
							}
						});
						button1.setIcon(new ImageIcon(Main.class
								.getResource("/img/员工管理.jpg")));
						button1.setBounds(350, 40, 70, 80);
						button1.setCursor(cursor);
						button1.setBorder(null);
						jPanel.add(button1);
						jPanel.repaint();

					}
				});
				button4.setIcon(new ImageIcon(Main.class
						.getResource("/img/人事管理.jpg")));
				button4.setBounds(30, 410, 70, 80);
				button4.setCursor(cursor);
				button4.setBorder(null);
				leftJPane.add(button4);
			}
			{
				JButton button5 = new JButton("");
				button5.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						jPanel.removeAll();

						JPanel p = new Department();
						splitPane.setRightComponent(p);
						splitPane.repaint();
						
						JLabel label = new JLabel();
						label.setIcon(new ImageIcon(Main.class
								.getResource("/img/子菜单.jpg")));
						label.setBounds(50, 50, 149, 70);
						jPanel.add(label);
						
						JButton button4 = new JButton("");
						button4.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								JPanel p = new AddDepartment();
								splitPane.setRightComponent(p);
							}
						});
						button4.setIcon(new ImageIcon(Main.class
								.getResource("/img/部门添加.jpg")));
						button4.setBounds(240, 40, 70, 80);
						button4.setCursor(cursor);
						button4.setBorder(null);
						jPanel.add(button4);

						JButton button5 = new JButton("");
						button5.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								JPanel p = new ModifyDepartment();
								splitPane.setRightComponent(p);
							}
						});
						button5.setIcon(new ImageIcon(Main.class
								.getResource("/img/部门修改.jpg")));
						button5.setBounds(380, 40, 70, 80);
						button5.setCursor(cursor);
						button5.setBorder(null);
						jPanel.add(button5);

						JButton button6 = new JButton("");
						button6.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								JPanel p = new DeleteDepartment();
								splitPane.setRightComponent(p);
							}
						});
						button6.setIcon(new ImageIcon(Main.class
								.getResource("/img/部门删除.jpg")));
						button6.setBounds(520, 40, 70, 80);
						button6.setCursor(cursor);
						button6.setBorder(null);
						jPanel.add(button6);
						jPanel.repaint();
					}
				});
				button5.setIcon(new ImageIcon(Main.class
						.getResource("/img/部门管理.jpg")));
				button5.setBounds(30, 530, 70, 70);
				button5.setCursor(cursor);
				button5.setBorder(null);
				leftJPane.add(button5);
			}			

			{
				JButton button7 = new JButton("");
				button7.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {

						JLabel lblWelcomeToUse = new JLabel(
								"Welcome to use the HRMS");
						lblWelcomeToUse.setForeground(Color.LIGHT_GRAY);
						lblWelcomeToUse.setFont(new Font("Dialog", Font.BOLD
								| Font.ITALIC, 45));
						lblWelcomeToUse.setBounds(103, 50, 574, 100);
						jPanel.removeAll();
						jPanel.add(lblWelcomeToUse);
						jPanel.repaint();

						JPanel p = new Aboutus();
						splitPane.setRightComponent(p);
					}
				});
				button7.setIcon(new ImageIcon(Main.class
						.getResource("/img/关于我们.jpg")));
				button7.setBounds(130, 30, 70, 80);
				button7.setCursor(cursor);
				button7.setBorder(null);
				leftJPane.add(button7);
			}
			{
				JButton button8 = new JButton("");
				button8.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						new JOptionPane();
						int s = JOptionPane.showConfirmDialog(null, "确认退出系统？",
								"确认", JOptionPane.YES_NO_OPTION);
						if (s == JOptionPane.YES_OPTION) {
							System.exit(0);
						}
					}
				});
				button8.setIcon(new ImageIcon(Main.class
						.getResource("/img/退出系统.jpg")));
				button8.setBounds(130, 160, 70, 80);
				button8.setCursor(cursor);
				button8.setBorder(null);
				leftJPane.add(button8);
			}
		}
		return splitPane;
	}

	private JLabel getLabel() {
		if (label == null) {
			label = new JLabel("");
			label.setBounds(0, 0, 793, 489);
			label
					.setIcon(new ImageIcon(Main.class
							.getResource("/img/main.jpg")));
		}
		return label;
	}

	private JPanel getJPanel() {
		if (jPanel == null) {
			jPanel = new JPanel();
			jPanel.setBorder(null);
			jPanel.setBackground(Color.WHITE);
			jPanel.setBounds(230, 0, 788, 150);
			jPanel.setLayout(null);
			{
				JLabel lblWelcomeToUse = new JLabel("Welcome to use the HRMS");
				lblWelcomeToUse.setForeground(Color.LIGHT_GRAY);
				lblWelcomeToUse.setFont(new Font("Dialog", Font.BOLD
						| Font.ITALIC, 45));
				lblWelcomeToUse.setBounds(103, 50, 574, 100);
				jPanel.add(lblWelcomeToUse);
			}
		}
		return jPanel;
	}

	private JPanel getJContentPane() {
		if (contentPane == null) {
			contentPane = new JPanel();
			contentPane.setBackground(Color.WHITE);
			contentPane.setLayout(null);
			contentPane.add(getJPanel());
			contentPane.add(getJSplitPane());
		}
		return contentPane;
	}
}
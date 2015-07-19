package com.dlnu;

import java.awt.Cursor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;

public class Login extends JFrame {

	private static final long serialVersionUID = 1L;
	private JLabel jLabel = null;
	private JTextField jTextField = null;
	private JPasswordField jPasswordField = null;
	private JButton jButton1 = null;
	private JButton jButton2 = null;
	private JPanel jPanel = null;
	private Cursor cursor = new Cursor(Cursor.HAND_CURSOR);

	private JTextField getJTextField() {
		if (jTextField == null) {
			jTextField = new JTextField();
			jTextField.setBounds(498, 309, 153, 24);
			jTextField.setText("1");
		}
		return jTextField;
	}

	private JPasswordField getJPasswordField() {
		if (jPasswordField == null) {
			jPasswordField = new JPasswordField();
			jPasswordField.setBounds(498, 349, 153, 24);
			jPasswordField.setText("1");
		}
		return jPasswordField;
	}

	private JButton getJButton1() {
		if (jButton1 == null) {
			jButton1 = new JButton("登录");
			jButton1.setCursor(cursor);
			jButton1.addActionListener(new ActionListener() {
				@SuppressWarnings("deprecation")
				public void actionPerformed(ActionEvent e) {
					if (getJTextField().getText().equals("")) {
						JOptionPane.showMessageDialog(null, "用户名不能为空！", "提示",
								JOptionPane.WARNING_MESSAGE);
						jTextField.requestFocus();
					} else if (getJPasswordField().getText().equals("")) {
						JOptionPane.showMessageDialog(null, "密码不能为空！", "提示",
								JOptionPane.WARNING_MESSAGE);
						jPasswordField.requestFocus();
						return;
					} else {
						String sql = "select * from t_user where User_Name='"
								+ jTextField.getText() + "'and User_Pass='"
								+ jPasswordField.getText() + "'";
						login(sql);
					}
				}

			});
			jButton1.setBounds(482, 390, 70, 26);
			jButton1.setBorderPainted(false);
			jButton1.setContentAreaFilled(false);
		}
		return jButton1;
	}

	private JButton getJButton2() {
		if (jButton2 == null) {
			jButton2 = new JButton("重置");
			jButton2.setCursor(cursor);
			jButton2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					jTextField.setText("");
					jPasswordField.setText("");
					jTextField.requestFocus();
				}
			});
			jButton2.setBounds(580, 390, 70, 26);
			jButton2.setBorderPainted(false);
			jButton2.setContentAreaFilled(false);
		}
		return jButton2;
	}

	public Login() {
		super();
		setResizable(false);
		initialize();
	}

	private void initialize() {
		
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		int w = toolkit.getScreenSize().width;
		int h = toolkit.getScreenSize().height;
		this.setIconImage(SwingResourceManager.getImage(Login.class,"/img/hrms.gif"));
		this.setBounds(w / 2 - 425, h / 2 - 295, 850, 590);
		this.setContentPane(getJContentPane());
		this.setTitle("用户登录");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		try {
			UIManager.setLookAndFeel("com.birosoft.liquid.LiquidLookAndFeel");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private JPanel getJContentPane() {

		if (jPanel == null) {
			jLabel = new JLabel();
			jLabel.setIcon(SwingResourceManager.getIcon(Login.class,"/img/login.jpg"));
			jLabel.setSize(850, 590);

			jPanel = new JPanel();
			jPanel.setLayout(null);
			jPanel.add(getJTextField(), null);
			jPanel.add(getJPasswordField(), null);
			jPanel.add(getJButton1(), null);
			jPanel.add(getJButton2(), null);
			jPanel.add(jLabel);
		}
		return jPanel;
	}

	public void login(String sqlstring) {
		
		if (DBConnection.joinDB()) {
			if (DBConnection.query(sqlstring))
				try {
					if (DBConnection.rs.isBeforeFirst()) {						
						dispose();	
						DBConnection.cn.close();
						new Main().setVisible(true);
					} else {
						JOptionPane.showMessageDialog(null, "用户名或密码错误，请重新输入！",
								"提示", JOptionPane.WARNING_MESSAGE);
						jTextField.requestFocus();
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
		}
	}

	public static void main(String[] args) {
		Login login = new Login();
		login.setVisible(true);
	}
}

package hacs;

import javax.swing.*;

import hacs.UserInfoItem.USER_TYPE;

import java.awt.*;
import java.awt.event.*;
import java.io.*;


public class Login extends JDialog {

	boolean mBExit = false;
	JLabel jLabel1 = new JLabel();
	JLabel jLabel2 = new JLabel();
	JButton loginButton = new JButton();
	JButton buttonExit = new JButton();
	JTextField userNameText = new JTextField();
	JPasswordField passwordText = new JPasswordField();
	JRadioButton studentRadio = new JRadioButton();
	JRadioButton instructorRadio = new JRadioButton();
	ButtonGroup buttonGroup1 = new ButtonGroup();

	private String userBox = null;
	private USER_TYPE userType = USER_TYPE.Student; // default to Student

	public Login() {
		try {
			jbInit();
			setSize(300, 300);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void jbInit() throws Exception {
		this.getContentPane().setLayout(null);
		jLabel1.setText("UserName");
		jLabel1.setBounds(new Rectangle(26, 52, 80, 18));
		jLabel2.setText("Password");
		jLabel2.setBounds(new Rectangle(23, 119, 80, 18));
		loginButton.setText("Login");
		loginButton.setBounds(new Rectangle(31, 212, 85, 28));
		loginButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loginButtonActionPerformed(e);
			}
		});
		buttonExit.setText("Exit");
		buttonExit.setBounds(new Rectangle(180, 211, 97, 28));
		buttonExit.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buttonExitActionPerformed(e);
			}
		});
		userNameText.setBounds(new Rectangle(119, 52, 144, 22));
		passwordText.setBounds(new Rectangle(118, 119, 147, 22));
		studentRadio.setSelected(true);
		studentRadio.setText("Student");
		studentRadio.setBounds(new Rectangle(37, 164, 103, 26));
		instructorRadio.setText("Instructor");
		instructorRadio.setBounds(new Rectangle(177, 162, 103, 26));
		this.getContentPane().add(jLabel1, null);
		this.getContentPane().add(jLabel2, null);
		this.getContentPane().add(loginButton, null);
		this.getContentPane().add(buttonExit, null);
		this.getContentPane().add(userNameText, null);
		this.getContentPane().add(passwordText, null);
		this.getContentPane().add(studentRadio, null);
		this.getContentPane().add(instructorRadio, null);
		buttonGroup1.add(studentRadio);
		buttonGroup1.add(instructorRadio);
	}

	void loginButtonActionPerformed(ActionEvent e) {
		BufferedReader file;
		mBExit = false;
		System.out.println("login clicked");
		try {
			if (studentRadio.isSelected()) {
				userType = USER_TYPE.Student;
				file = new BufferedReader(new FileReader("./src/main/java/hacs/StuInfo.txt"));
			} else {
				userType = USER_TYPE.Instructor;
				file = new BufferedReader(new FileReader("./src/main/java/hacs/InsInfor.txt"));
			}
			userBox = userNameText.getText();
			String PasswordBox = new String(passwordText.getPassword());
			String loginName = null;
			String aline = null, userName = null, password = null;
			while ((aline = file.readLine()) != null) {
				userName = getUserName(aline);
				password = getPassword(aline);
				if (userName.compareTo(userBox) == 0 && password.compareTo(PasswordBox) == 0)
					loginName = userName;
			}
			if (loginName != null) {
				this.hide();
			}
		} catch (Exception ee) {
			;
		}

	}

	private String getUserName(String aline) {
		int Sep = aline.lastIndexOf(':');
		return aline.substring(0, Sep);
	}

	private String getPassword(String aline) {
		int Sep = aline.lastIndexOf(':');
		return aline.substring(Sep + 1, aline.length());
	}

	public String getUserName() {
		return userBox;
	}

	public USER_TYPE getUserType() {
		return userType;
	}

	public boolean isExit() {
		return mBExit;
	}

	void buttonExitActionPerformed(ActionEvent e) {
		mBExit = true;
		hide();
	}
}
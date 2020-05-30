package chatroom;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class GUI implements ActionListener {
	
	private static JLabel LoginUserLabel;
	private static JTextField LoginUserText;
	private static JLabel LoginPasswordLabel;
	private static JPasswordField LoginPasswordText;
	
	private static JLabel RegisterUserLabel;
	private static JTextField RegisterUserText;
	private static JLabel  RegisterPasswordLabel;
	private static JPasswordField RegisterPasswordText;
	private static JLabel RegisterConfirmLabel;
	private static JPasswordField RegisterConfirmText;
	
	private static JButton LoginButton;
	private static JButton RegisterButton;
	private static JButton HomeLoginButton;
	private static JButton HomeRegisterButton;
	
	private static JButton BackButton;
	
	private static JLabel success;
  
	private void LoginGUI() {
		JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		
		frame.setSize(400, 200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.add(panel);
		
		panel.setLayout(null);
		
		LoginUserLabel = new JLabel("User");
		LoginUserLabel.setBounds(10, 20, 80, 25);
		panel.add(LoginUserLabel);
		
		LoginUserText = new JTextField();
		LoginUserText.setBounds(100, 20, 165, 25);
		panel.add(LoginUserText);
		
		LoginPasswordLabel = new JLabel("Password");
		LoginPasswordLabel.setBounds(10,50,100,25);
		panel.add(LoginPasswordLabel);
		
		LoginPasswordText = new JPasswordField();
		LoginPasswordText.setBounds(100,50, 165, 25);
		panel.add(LoginPasswordText);
		
		LoginButton = new JButton("Login");
		LoginButton.setBounds(140, 120, 100, 25);
		LoginButton.addActionListener(new GUI());
		panel.add(LoginButton);
		
		BackButton = new JButton("Back");
		BackButton.setBounds(250,120,75,25);
		BackButton.addActionListener(new GUI());
		panel.add(BackButton);
		
		success = new JLabel("");
		
		success.setBounds(10, 80, 300, 25);
		panel.add(success);
	}
	
	public void HomeGUI () {
		JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		
		frame.setSize(400, 200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.add(panel);
		
		panel.setLayout(null);
		
		HomeLoginButton = new JButton("Login");
		HomeLoginButton.setBounds(135, 40, 100, 25);
		HomeLoginButton.addActionListener(new GUI());
		panel.add(HomeLoginButton);
		
		HomeRegisterButton = new JButton("Register");
		HomeRegisterButton.setBounds(135, 90, 100, 25);
		HomeRegisterButton.addActionListener(new GUI());
		panel.add(HomeRegisterButton);
	}
	
	private void RegisterGUI() {
		JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		
		panel.setLayout(null);
		
		frame.setSize(400, 200);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frame.setVisible(true);
		frame.add(panel);
		
		RegisterUserLabel = new JLabel("User");
		RegisterUserLabel.setBounds(40, 20, 80, 25);
		panel.add(RegisterUserLabel);
		
		RegisterUserText = new JTextField();
		RegisterUserText.setBounds(100, 20, 165, 25);
		panel.add(RegisterUserText);
		
		RegisterPasswordLabel = new JLabel("Password");
		RegisterPasswordLabel.setBounds(40,50,100,25);
		panel.add(RegisterPasswordLabel);
		
		RegisterPasswordText = new JPasswordField();
		RegisterPasswordText.setBounds(100,50, 165, 25);
		panel.add(RegisterPasswordText);
		
		
		RegisterConfirmLabel = new JLabel("Confirm");
		RegisterConfirmLabel.setBounds(40,80,100,25);
		panel.add(RegisterConfirmLabel);
		
		RegisterConfirmText =  new JPasswordField();
		RegisterConfirmText.setBounds(100,80,165,25);
		panel.add(RegisterConfirmText);
		
		RegisterButton = new JButton("Register");
		RegisterButton.setBounds(140, 120, 100, 25);
		RegisterButton.addActionListener(new GUI());
		panel.add(RegisterButton);
		
		BackButton = new JButton("Back");
		BackButton.setBounds(250,120,75,25);
		BackButton.addActionListener(new GUI());
		panel.add(BackButton);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		Object  source=e.getSource();
			
		if (source == HomeLoginButton) {
			LoginGUI();	// click HomeLoginButton
		}
		
		if (source == HomeRegisterButton) {
			RegisterGUI();
		}
		
		if (source == BackButton) {
			HomeGUI();
		}
		
		String user = LoginUserText.getText();
		String password = LoginPasswordText.getText();
		
		if(user.equals("Hippo") && password.equals("oskour")){
			success.setText("Login successful!");
			
		}else if(user.equals("")||password.equals("")){
			success.setText("Please fill in all the fields.");
			
		}else{
			success.setText("Username and password do not match.");
		}	
	}	
}

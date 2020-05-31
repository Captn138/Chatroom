package client;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
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
	
	private static JLabel ChatroomUsername;
	private static JTextField ChatroomMessageText;
	
	private static JButton LoginButton;
	private static JButton RegisterButton;
	private static JButton HomeLoginButton;
	private static JButton HomeRegisterButton;
	private static JButton SendButton;
	
	private static JButton BackButton;
	
	private static JLabel LoginSuccess;
	private static JLabel RegisterSuccess;
  
	private void LoginGUI() {
		JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		
		frame.setSize(400,300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.add(panel);
		
		panel.setLayout(null);
		
		LoginUserLabel = new JLabel("User");
		LoginUserLabel.setBounds(10, 20, 80, 25);
		panel.add(LoginUserLabel);
		
		LoginUserText = new JFormattedTextField();
		LoginUserText.setBounds(100, 20, 165, 25);
		panel.add(LoginUserText);
		
		LoginPasswordLabel = new JLabel("Password");
		LoginPasswordLabel.setBounds(10,50,100,25);
		panel.add(LoginPasswordLabel);
		
		LoginPasswordText = new JPasswordField();
		LoginPasswordText.setBounds(100,50, 165, 25);
		panel.add(LoginPasswordText);
		
		LoginButton = new JButton("Login");
		LoginButton.setBounds(140, 150, 100, 25);
		LoginButton.addActionListener(new GUI());
		panel.add(LoginButton);
		
		BackButton = new JButton("Back");
		BackButton.setBounds(250,150,75,25);
		BackButton.addActionListener(new GUI());
		panel.add(BackButton);
		
		LoginSuccess = new JLabel("");
		LoginSuccess.setBounds(10, 80, 300, 25);
		panel.add(LoginSuccess);
		
	}
	
	public void HomeGUI () {
		JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		
		frame.setSize(400,300);
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
		
		frame.setSize(400,300);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frame.setVisible(true);
		frame.add(panel);
		
		RegisterUserLabel = new JLabel("User");
		RegisterUserLabel.setBounds(40, 20, 80, 25);
		panel.add(RegisterUserLabel);
		
		RegisterUserText = new JFormattedTextField();
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
		RegisterButton.setBounds(140, 150, 100, 25);
		RegisterButton.addActionListener(new GUI());
		panel.add(RegisterButton);
		
		BackButton = new JButton("Back");
		BackButton.setBounds(250,150,75,25);
		BackButton.addActionListener(new GUI());
		panel.add(BackButton);	
		
		RegisterSuccess = new JLabel("");
		RegisterSuccess.setBounds(10,120,300,25);
		panel.add(RegisterSuccess);
		
	}
	
	private void ChatroomGUI() {			
		JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		
		panel.setLayout(null);
		
		frame.setSize(400, 600);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frame.setVisible(true);
		frame.add(panel);
		
		ChatroomUsername = new JLabel(LoginUserText.getText()); 	
		ChatroomUsername.setBounds(50,30,100,25);
		panel.add(ChatroomUsername);
		
		ChatroomMessageText = new JTextField();
		ChatroomMessageText.setBounds(50,500,180,25);
		panel.add(ChatroomMessageText);
		
		SendButton = new JButton("Send");
		SendButton.setBounds(250,500,100,25);
		SendButton.addActionListener(new GUI());
		panel.add(SendButton);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		Object  source=e.getSource();
			
		if (source == HomeLoginButton) {
			LoginGUI();	
		}
		
		if (source == HomeRegisterButton) {
			RegisterGUI();
		}
		
		if (source == BackButton) {
			HomeGUI();
		}
		
		String LoginUser = LoginUserText.getText();
		String LoginPassword = LoginPasswordText.getText();
		
		String RegisterUser = RegisterUserText.getText();
		String RegisterPassword = RegisterPasswordText.getText();
		String RegisterConfirm = RegisterConfirmText.getText();
		
		String ChatroomMessage = ChatroomMessageText.getText();
		
		
		Client.send(new Message(LoginUser, LoginPassword, 1));
		
		while (Message.type  != 3){
			Client.delFirstElemFromList();
			Message message = Client.getFirstElemFromList();
		}
		
		if(Message.content = true) {
			LoginSuccess.setText("Login Successful!");
			ChatroomGUI();
		}else if(LoginUser.equals("")||LoginPassword.equals("")){
			LoginSuccess.setText("Please fill in all the fields.");
		}else{
			LoginSuccess.setText("Username and password do not match.");
		}	
		
		Client.send(new Message(RegisterUser, RegisterPassword, 5));
		
		while (Message.type != 4){
			Client.delFirstElemFromList();
			Message message = Client.getFirstElemFromList();
		}
		
		if(RegisterUser.equals("") || RegisterPassword.equals("") || RegisterConfirm.equals("")) {
			RegisterSuccess.setText("Please fill in all the fields.");
		}else if(RegisterUser.contains("|") ==  true || RegisterPassword.contains("|") ==  true || RegisterConfirm.contains("|") ==  true) {
			RegisterSuccess.setText("Invalid character!");
		}else if((RegisterPassword) != (RegisterConfirm)){
			RegisterSuccess.setText("Please enter twice the same password.");
		}else if (Message.content = false){
			RegisterSuccess.setText("This username already exists");
		}else{
			RegisterSuccess.setText("User registered");
			LoginGUI();
		}
			
		if (source == SendButton) {
			Client.send(new Message(LoginUser, ChatroomMessage, 2));
			ChatroomMessageText.setText("");
		//TODO - PATCH "Cannot make a static reference to the non-static method/field
		//TODO - DISPLAYING LAST TYPE 2 MESSAGES
		}
	}	
}

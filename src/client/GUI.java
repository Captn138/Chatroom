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

import chatroom.*;

public class GUI implements ActionListener {
	
	
	/*JLabel, JTextField, JPasswordField and JButton we need in our GUI  */ 
	private static JLabel LoginUserLabel; 						// In LoginGUI(), display "Username" on frame.
	private static JTextField LoginUserText;					// In LoginGUI(), username textfield.
	private static JLabel LoginPasswordLabel;					// In LoginGUI(), display "Password" on frame.
	private static JPasswordField LoginPasswordText;			// In LoginGUI(), password textfield.
	
	private static JLabel RegisterUserLabel;					// In RegisterGUI(), display "Username" on frame.
	private static JTextField RegisterUserText;					// In RegisterGUI(), username textfield.
	private static JLabel  RegisterPasswordLabel;				// In RegisterGUI(), display "Password" on frame.
	private static JPasswordField RegisterPasswordText;			// In RegisterGUI(), password textfield.
	private static JLabel RegisterConfirmLabel;					// In RegisterGUI(), display "Confirm" on frame.
	private static JPasswordField RegisterConfirmText;			// In RegisterGUI(), password confirmation textfield.
	
	private static JLabel ChatroomUsername;						// In ChatroomGUI(), display the current username on frame.
	private static JTextField ChatroomSendMessageText;			// In ChatroomGUI(), message-to-send field.
	private static JLabel ChatroomMessageLabel;					// In ChatroomGUI(), last received message.
	
	private static JButton LoginButton;							// In LoginGUI(), button to login.
	private static JButton RegisterButton;						// In RegisterGUI(), button to register.
	private static JButton HomeLoginButton;						// In HomeGUI(), button to go to LoginGUI().
	private static JButton HomeRegisterButton;					// In HomeGUI(), button to go to RegisterGUI().
	private static JButton SendButton;							// In ChatroomGUI(), button to send message.
	
	private static JButton BackButton;							// In LoginGUI() and Register(), button to go back to HomeGUI().
	
	private static JLabel LoginSuccess;							// In LoginGUI(), confirm or not if user successfully logged in.
	private static JLabel RegisterSuccess;						// In RegisterGUI(), confirm or not if user sucessfully registered.
  
	
	/*The Login Window, accessible from HomeGUI()*/
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
	
	/*The Home Window is public because this is the first one user will access. */
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
	
	/*The Register Window, accessible from HomeGUI() */
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
	
	/*The Chatroom Window, accessible from LoginGUI()*/
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
		
		ChatroomSendMessageText = new JTextField();
		ChatroomSendMessageText.setBounds(50,500,180,25);
		panel.add(ChatroomSendMessageText);
		
		SendButton = new JButton("Send");
		SendButton.setBounds(250,500,100,25);
		SendButton.addActionListener(new GUI());
		panel.add(SendButton);
		
		ChatroomMessageLabel = new JLabel("");
		ChatroomMessageLabel.setBounds(50,400,180,25);
		panel.add(ChatroomMessageLabel);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		Object  source=e.getSource();
		
		Client c = new Client("localhost");
			
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
		
		String ChatroomMessage = ChatroomSendMessageText.getText();
		
		c.send(new Message(LoginUser, LoginPassword, 1));
		Message m = c.getFirstElemFromList();
		
		while (m.getType()  != 3 || m.getSender() != LoginUser){										// ERROR
			c.delFirstElemFromList();
			m = c.getFirstElemFromList();
		}
		
		if(m.getContent() == "yes") {											// ERROR
			LoginSuccess.setText("Login Successful!");
			ChatroomGUI();
		}else if(LoginUser.equals("")||LoginPassword.equals("")){
			LoginSuccess.setText("Please fill in all the fields.");
		}else{
			LoginSuccess.setText("Username and password do not match.");
		}	
		
		c.send(new Message(RegisterUser, RegisterPassword, 5));
		
		while (m.getType() != 4 || m.getSender() != RegisterUser ){												// ERROR
			c.delFirstElemFromList();
			c.getFirstElemFromList();
		}
		
		if(RegisterUser.equals("") || RegisterPassword.equals("") || RegisterConfirm.equals("")) {
			RegisterSuccess.setText("Please fill in all the fields.");
		}else if(RegisterUser.contains("|") ==  true || RegisterPassword.contains("|") ==  true || RegisterConfirm.contains("|") ==  true) {
			RegisterSuccess.setText("Invalid character!");
		}else if((RegisterPassword) != (RegisterConfirm)){
			RegisterSuccess.setText("Please enter twice the same password.");
		}else if (m.getContent() == "yes"){										// ERROR
			RegisterSuccess.setText("This username already exists");
		}else{
			RegisterSuccess.setText("User registered");
			LoginGUI();
		}
			
		if (source == SendButton) {
			c.send(new Message(LoginUser, ChatroomMessage, 2));
			ChatroomSendMessageText.setText("");
		}
		
		while (m.getType() != 2){
			c.delFirstElemFromList();
			m = c.getFirstElemFromList();
		}
		
		if (m.getType() == 2) {
				ChatroomMessageLabel.setText(m.getTime()+":"+m.getSender()+":"+m.getContent());
		}
	}	
}


//TODO throws IOException : WHERE ???
//TODO add Refresh button

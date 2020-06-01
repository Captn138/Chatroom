package client;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import chatroom.*;

/**
 * A GUI object is the Window that will appear to the user. The GUI starts with
 * the HomeGUI(), where the user can choose to either Login or Register. A new
 * GUI will appear depending on where they clicked, LoginGUI() or RegisterGUI().
 * If they correctly registered, they will be able to Login. They can always go
 * back to HomeGUI(). Once the user is logged in, the ChatroomGUI() appears
 * which is the place they can discuss with other users.
 * 
 * @author Groupe Télétravail, Famine, Pates-Riz : ALMEIDA Mickael, BERNARD
 *         Hippolyte, DRAY Gabriel
 */

public class GUI implements ActionListener {

	/* JLabel, JTextField, JPasswordField and JButton we need in our GUI */
	private static JLabel LoginUserLabel; // In LoginGUI(), display "Username" on frame.
	private static JTextField LoginUserText; // In LoginGUI(), username textfield.
	private static JLabel LoginPasswordLabel; // In LoginGUI(), display "Password" on frame.
	private static JPasswordField LoginPasswordText; // In LoginGUI(), password textfield.

	private static JLabel RegisterUserLabel; // In RegisterGUI(), display "Username" on frame.
	private static JTextField RegisterUserText; // In RegisterGUI(), username textfield.
	private static JLabel RegisterPasswordLabel; // In RegisterGUI(), display "Password" on frame.
	private static JPasswordField RegisterPasswordText; // In RegisterGUI(), password textfield.
	private static JLabel RegisterConfirmLabel; // In RegisterGUI(), display "Confirm" on frame.
	private static JPasswordField RegisterConfirmText; // In RegisterGUI(), password confirmation textfield.

	private static JLabel ChatroomUsername; // In ChatroomGUI(), display the current username on frame.
	private static JTextField ChatroomSendMessageText; // In ChatroomGUI(), message-to-send field.
	private static JLabel ChatroomMessageLabel; // In ChatroomGUI(), last received message.

	private static JButton LoginButton; // In LoginGUI(), button to login.
	private static JButton RegisterButton; // In RegisterGUI(), button to register.
	private static JButton HomeLoginButton; // In HomeGUI(), button to go to LoginGUI().
	private static JButton HomeRegisterButton; // In HomeGUI(), button to go to RegisterGUI().
	private static JButton SendButton; // In ChatroomGUI(), button to send message.

	private static JButton BackButton; // In LoginGUI() and Register(), button to go back to HomeGUI().
	private static JButton RefreshButton;

	private static JLabel LoginSuccess; // In LoginGUI(), confirm or not if user successfully logged in.
	private static JLabel RegisterSuccess; // In RegisterGUI(), confirm or not if user sucessfully registered.
	
	public static void main(String[] args) {
	    GUI gui = new GUI();
	    gui.HomeGUI();
	    
	/**
	 * The Login Window. LoginGUI() is accessible from HomeGUI() and can give access
	 * to ChatroomGUI() and HomeGUI(). It contains 2 TextFields, 3 Labels, 2 Buttons
	 * with ActionListener
	 */
	
	}
	private void LoginGUI() {
		JFrame frame = new JFrame();
		JPanel panel = new JPanel();

		frame.setSize(400, 300);
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
		LoginPasswordLabel.setBounds(10, 50, 100, 25);
		panel.add(LoginPasswordLabel);

		LoginPasswordText = new JPasswordField();
		LoginPasswordText.setBounds(100, 50, 165, 25);
		panel.add(LoginPasswordText);

		LoginButton = new JButton("Login");
		LoginButton.setBounds(140, 150, 100, 25);
		LoginButton.addActionListener(new GUI());
		panel.add(LoginButton);

		BackButton = new JButton("Back");
		BackButton.setBounds(250, 150, 75, 25);
		BackButton.addActionListener(new GUI());
		panel.add(BackButton);

		LoginSuccess = new JLabel("");
		LoginSuccess.setBounds(10, 80, 300, 25);
		panel.add(LoginSuccess);

	}

	/**
	 * The Home Window. HomeGUI() is accessible by starting the application and by
	 * LoginGUI() and RegisterGUI() and can give access to LoginGUI() and
	 * RegisterGUI(). It contains 2 Buttons with ActionListener
	 */
	public void HomeGUI() {
		JFrame frame = new JFrame();
		JPanel panel = new JPanel();

		frame.setSize(400, 300);
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

	/**
	 * The Register Window. RegisterGUI() accessible from HomeGUI() and can give
	 * access to HomeGUI() It contains 3 TextFields, 4 Labels and 2 Buttons with
	 * ActionListener
	 */
	private void RegisterGUI() {
		JFrame frame = new JFrame();
		JPanel panel = new JPanel();

		panel.setLayout(null);

		frame.setSize(400, 300);
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
		RegisterPasswordLabel.setBounds(40, 50, 100, 25);
		panel.add(RegisterPasswordLabel);

		RegisterPasswordText = new JPasswordField();
		RegisterPasswordText.setBounds(100, 50, 165, 25);
		panel.add(RegisterPasswordText);

		RegisterConfirmLabel = new JLabel("Confirm");
		RegisterConfirmLabel.setBounds(40, 80, 100, 25);
		panel.add(RegisterConfirmLabel);

		RegisterConfirmText = new JPasswordField();
		RegisterConfirmText.setBounds(100, 80, 165, 25);
		panel.add(RegisterConfirmText);

		RegisterButton = new JButton("Register");
		RegisterButton.setBounds(140, 150, 100, 25);
		RegisterButton.addActionListener(new GUI());
		panel.add(RegisterButton);

		BackButton = new JButton("Back");
		BackButton.setBounds(250, 150, 75, 25);
		BackButton.addActionListener(new GUI());
		panel.add(BackButton);

		RegisterSuccess = new JLabel("");
		RegisterSuccess.setBounds(10, 120, 300, 25);
		panel.add(RegisterSuccess);

	}

	/**
	 * The Chatroom Window ChatroomGUI() is accessible from LoginGUI() It contains 2
	 * Labels, 1 Textfield and 1 Button with ActionListener
	 */
	private void ChatroomGUI() {
		JFrame frame = new JFrame();
		JPanel panel = new JPanel();

		panel.setLayout(null);

		frame.setSize(400, 600);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frame.setVisible(true);
		frame.add(panel);

		ChatroomUsername = new JLabel(LoginUserText.getText());
		ChatroomUsername.setBounds(50, 30, 100, 25);
		panel.add(ChatroomUsername);

		ChatroomSendMessageText = new JTextField();
		ChatroomSendMessageText.setBounds(50, 500, 180, 25);
		panel.add(ChatroomSendMessageText);

		SendButton = new JButton("Send");
		SendButton.setBounds(250, 500, 100, 25);
		SendButton.addActionListener(new GUI());
		panel.add(SendButton);

		ChatroomMessageLabel = new JLabel("");
		ChatroomMessageLabel.setBounds(50, 400, 180, 25);
		panel.add(ChatroomMessageLabel);
		
		RefreshButton = new JButton("Refresh");
		RefreshButton.setBounds(250,30,100,25);
		RefreshButton.addActionListener(new GUI());
		panel.add(RefreshButton);

	}
	/**
	 * Change GUI appearance when user clicks on buttons
	 * @param e (ActionEvent) : button clicked by the user
	 */

	@Override
	public void actionPerformed(ActionEvent e) {

		Object source = e.getSource();

		Client c = new Client("localhost");

		/*
		 * In HomeGUI(), give access to LoginGUI() if user clicks "Login" Button
		 */

		if (source == HomeLoginButton) {
			LoginGUI();
		}

		/*
		 * In HomeGUI(), give access to RegisterGUI() if user clicks "Register" Button
		 */

		if (source == HomeRegisterButton) {
			RegisterGUI();
		}

		/*
		 * In RegisterGUI() and LoginGUI(), return to HomeGUI() if user clicks "Back"
		 * Button
		 */

		if (source == BackButton) {
			HomeGUI();
		}

		String LoginUser = LoginUserText.getText();
		String LoginPassword = LoginPasswordText.getSelectedText();

		String RegisterUser = RegisterUserText.getText();
		String RegisterPassword = RegisterPasswordText.getSelectedText();
		String RegisterConfirm = RegisterConfirmText.getSelectedText();

		String ChatroomMessage = ChatroomSendMessageText.getText();

		/*
		 * User makes a Login request
		 */

		if (source == RegisterButton) {
			try {
				c.send(new Message(LoginUser, LoginPassword, 1));
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			Message m = c.getFirstElemFromList();
		
		/*
		 * As soon as we don't receive a confirmation message (Type 3) or the corresponding Username
		 * We delete first Message and we try to get the next one
		 */
		
			while (m.getType()  != 3 || m.getSender() != LoginUser){									
				c.delFirstElemFromList();
				m = c.getFirstElemFromList();
			}
		
		/*
		 * Content Interpretation
		 */
		
			if(m.getContent() == "yes") {											
				LoginSuccess.setText("Login Successful!");
				ChatroomGUI();
			}else if(LoginUser.equals("")||LoginPassword.equals("")){
				LoginSuccess.setText("Please fill in all the fields.");
			}else{
				LoginSuccess.setText("Username and password do not match.");
			}	
		}
		/*
		 * User makes a Register request
		 */
		
		if (source == RegisterButton){
			try {
				c.send(new Message(RegisterUser, RegisterPassword, 5));
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			Message m = c.getFirstElemFromList();
		
			while (m.getType() != 4 || m.getSender() != RegisterUser ){												
				c.delFirstElemFromList();
				c.getFirstElemFromList();
			}
		
		/*
		 * Content Interpretation
		 */
		
		
			if(RegisterUser.equals("") || RegisterPassword.equals("") || RegisterConfirm.equals("")) {
				RegisterSuccess.setText("Please fill in all the fields.");
			}else if(RegisterUser.contains("|") ==  true || RegisterPassword.contains("|") ==  true || RegisterConfirm.contains("|") ==  true) {
				RegisterSuccess.setText("Invalid character!");
			}else if((RegisterPassword) != (RegisterConfirm)){
				RegisterSuccess.setText("Please enter twice the same password.");
			}else if (m.getContent() == "yes"){										
				RegisterSuccess.setText("This username already exists");
			}else{
				RegisterSuccess.setText("User registered");
				LoginGUI();
			}
		}
		
		/*
		 * Send a Type 2 message and clear the TextField so the user can type a new one
		 */
		
		if (source == SendButton) {
			try {
				c.send(new Message(LoginUser, ChatroomMessage, 2));
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			ChatroomSendMessageText.setText("");
		}
		
		
		/*
		 * We check if the first element of the list is a message to show to the user (Type 2)
		 */
		
		if (source == RefreshButton) {
			Message m = c.getFirstElemFromList();
			while (m.getType() != 2){
				c.delFirstElemFromList();
				m = c.getFirstElemFromList();
			}
		
		/*
		 * Message appears to user under this form : "xx:xx" (time) - xxxxxx (sender) : xx xxxx xxxxxx (message).
		 */
		
			if (m.getType() == 2) {
				ChatroomMessageLabel.setText(m.getTime()+"-"+m.getSender()+":"+m.getContent());
			}
		}
	}	
}
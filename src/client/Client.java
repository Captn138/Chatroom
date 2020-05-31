package client;

import java.io.*;
import java.net.*;
import java.util.LinkedList;
import chatroom.*;

/**
 * A Client object is an object that will handle connections to the server, as well as sending and reading messages.
 * @author Groupe Télétravail, Famine, Pâtes-Riz : ALMEIDA Mickael, BERNARD Hippolyte, DRAY Gabriel
 * @see Sender
 * @see Reciever
 * @see Message
 * @see ThreadTemplate
 * @see Secure
 */
public class Client {
	
	private ObjectOutputStream output;
	private ObjectInputStream input;
	private Socket socket;
	private Sender sender;
	private Reciever reciever;
	private int port = 6666;
	private LinkedList<Message> list;
	private Secure s;
	

	/**
	 * Creates the socket, searches for the input and output stream, creates the sender and reciever threads and starts them.
	 * @param ip (String) : the ip address of the server
	 * @see Sender
	 * @see Reciever
	 * @See threadTemplate
	 */
	public Client(String ip) {
		s = new Secure();
        try  {
			list = new LinkedList<Message>();

			//create the socket; it is defined by an remote IP address (the address of the server) and a port number
			socket = new Socket(ip, port);

			//create the streams that will handle the objects coming and going through the sockets
			output = new ObjectOutputStream(socket.getOutputStream());
			input = new ObjectInputStream(socket.getInputStream());

			//Creates the Threads that will handle reception of messages and sending them
			sender = new Sender(input, output);
			reciever = new Reciever(input, output, list);
			sender.start();
			reciever.start();
	    } catch  (UnknownHostException uhe) {
			uhe.printStackTrace();
		} catch (ConnectException ce) {
			System.out.println("Server not found!\nApplication will now shutdown...");
		}catch  (IOException ioe) {
			ioe.printStackTrace();
		}
	}

	/**
	 * Stops the execution of the threads and closes the socket
	 */
	public void disconnect() {
		try {
			sender.interrupt();
			reciever.interrupt();
			input.close();
			output.close();
			socket.close();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}

	
	/** 
	 * Gets the first Message recieved from the reciever thread.
	 * @return Message
	 */
	public Message getFirstElemFromList(){
		return list.get(0);
	}

	/**
	 * Deletes the first element in the list of messages recieved by the reciever thread. Generally called after getFirstElemFromList().
	 */
	public void delFirstElemFromList(){
		list.remove(0);
	}

	
	/** 
	 * Tells the sender thread to send a message to the server.
	 * @param msg (Message) : message to be sent
	 * @throws IOException
	 */
	public void send(Message msg) throws IOException {
		sender.send(msg);
	}

	/**
	 * Calls the method hash(pwd) from Secure to hash a password.
	 * @param pwd (String) : the password to hash
	 * @return String
	 * @see Secure
	 */
	public String hash(String pwd){
		return s.hash(pwd);
	}
}
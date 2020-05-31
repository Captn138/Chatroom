package server;

import java.io.*;
import java.net.*;
import java.util.LinkedList;
import chatroom.*;

/**
 * A Server object is an object that will handle all the incoming connections from the clients as well as all the messages.
 * @author Groupe Télétravail, Famine, Pâtes-Riz : ALMEIDA Mickael, BERNARD Hippolyte, DRAY Gabriel
 * @see Sender
 * @see Reciever
 * @see ThreadTemplate
 * @see Message
 */
public class Server {

	private ObjectOutputStream output;
	private ObjectInputStream input;
	private ServerSocket ss;
	private Socket socket;
	private Sender sender;
	private Reciever reciever;
	private final int port = 6666;
	private LinkedList<Message> list;
	
	/**
	 * Creates the socket, searches for the input and output stream, creates the sender and reciever threads and starts them.
	 * @see Sender
	 * @see Reciever
	 * @see ThreadTemplate
	 */
	public Server() {
		try{
			list = new LinkedList<Message>();

			//creates the socket
			ss = new ServerSocket(port);
			System.out.println("Server waiting for connection...");
			socket = ss.accept();

			//Create the streams that will handle the objects coming through the sockets
			input = new ObjectInputStream(socket.getInputStream());
			output = new ObjectOutputStream(socket.getOutputStream());

			//Creates the threads
			sender = new Sender(input, output);
			reciever = new Reciever(input, output, list);
			sender.start();
			reciever.start();
		}catch(final IOException ioe){
			ioe.printStackTrace();
			if(ss != null && !ss.isClosed()){
				try{
					ss.close();
				}catch(final IOException e){
					e.printStackTrace(System.err);
				}
			}
		}
	}

	/**
	 * Main processing function of the server. Searches for the messages recieved and processes them following their type.
	 * @see Message
	 * @see Sender
	 * @see Reciever
	 * @see ThreadTemplate
	 */
	public void run(){
		while(true){
			try{
				if(list.size() > 0){
					final Message msg = list.get(0);
					final int type = msg.getType();
					if(type == 1){
						if(connexion(msg) == true){
							sender.send(new Message(msg.getSender(), "yes", 3));
						}else{
							sender.send(new Message(msg.getSender(), "no", 3));
						}
					}else if(type == 2){
						saveMessage(msg);
					}else if(type == 5){
						if(register(msg) == true){
							sender.send(new Message(msg.getSender(), "yes", 4));
						}else{
							sender.send(new Message(msg.getSender(), "no", 4));
						}
					}
					list.remove(0);
				}
			}catch(final Exception ex){
				ex.printStackTrace();
			}
		}
	}

	
	/** 
	 * Checks if the couple username/password hash is in the database and returns true or false if not.
	 * @param msg (Message) : the connection request message containing the username and the password hash
	 * @return boolean
	 */
	private boolean connexion(final Message msg){
		//if username and password are in the users database
		return true;
		//else return false
	}

	
	/** 
	 * Checks if the requested username is not in the database yet, then saves the new user and returns true or returns false if not.
	 * @param msg (Message) : the register request message containing the username and the password hash
	 * @return boolean
	 */
	private boolean register(final Message msg){
		//if username not taken
		return true;
		//else return false
	}

	
	/** 
	 * Saves a message in the messages database and send it to everyone
	 * @param msg (Message) : the message to save
	 * @throws IOException
	 */
	private void saveMessage(final Message msg) throws IOException {
		sender.send(msg);
		//save message in the messages database
	}

	public static void main (final String[] args) {
		final Server serv = new Server();
		serv.run();
	}
}
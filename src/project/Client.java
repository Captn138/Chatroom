package project;

import java.io.*;
import java.net.*;
import java.util.LinkedList; 

public class Client {
	
	private ObjectOutputStream output;
	private ObjectInputStream input;
	private Socket socket;
	private Sender sender;
	private Reciever reciever;
	private int port = 6666;
	private LinkedList<Message> list;
	
	public Client(String ip) {
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

	public Message getFirstElemFromList(){
		return list.get(0);
	}

	public void delFirstElemFromList(){
		list.remove(0);
	}
}
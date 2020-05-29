package project;

import java.io.*;
import java.net.*; 

public class Client {
	
	private ObjectOutputStream output;
	private ObjectInputStream input;
	private Socket socket;
	private Sender sender;
	private Reciever reciever;
	private int port = 6666;
	private String username;
	
	public Client(String ip) {
        try  {
			//create the socket; it is defined by an remote IP address (the address of the server) and a port number
			socket = new Socket(ip, port);

			//create the streams that will handle the objects coming and going through the sockets
			output = new ObjectOutputStream(socket.getOutputStream());
			input = new ObjectInputStream(socket.getInputStream());
			sender = new Sender(socket, input, output, ip, port);
			reciever = new Reciever(socket, input, output, ip, port);
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
}
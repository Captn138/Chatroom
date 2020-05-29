package project;

import java.io.*;
import java.net.*; 

public class Reciever extends ThreadTemplate{

	private ObjectOutputStream output;
	private ObjectInputStream input;
	private Socket socket;

	public Reciever(Socket socket, ObjectInputStream input, ObjectOutputStream output, String ip, int port) {
		super(socket, input, output, ip, port);
	}

	public void connect(String ip)
	{
		int port = 6666;
        try  {
			//create the socket; it is defined by an remote IP address (the address of the server) and a port number
			socket = new Socket(ip, port);

			//create the streams that will handle the objects coming and going through the sockets
			output = new ObjectOutputStream(socket.getOutputStream());
            input = new ObjectInputStream(socket.getInputStream());
	    } catch  (UnknownHostException uhe) {
			uhe.printStackTrace();
		}
		catch  (IOException ioe) {
			ioe.printStackTrace();
		}
		finally {
			try {
				input.close();
				output.close();
				socket.close();
			} catch (IOException ioe) {
				ioe.printStackTrace();
			}
		}
	}
}
package project;

import java.io.*;
import java.net.*;
import java.util.LinkedList;

public class Server {

	private ObjectOutputStream output;
	private ObjectInputStream input;
	private ServerSocket ss;
	private Socket socket;
	private Sender sender;
	private Reciever reciever;
	private int port = 6666;
	private LinkedList<Message> list;
	
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
		}catch(IOException ioe){
			ioe.printStackTrace();
			if(ss != null && !ss.isClosed()){
				try{
					ss.close();
				}catch(IOException e){
					e.printStackTrace(System.err);
				}
			}
		}
	}

	public void run(){
		while(true){
			try{
				if(list.size() > 0){
					Message msg = list.get(0);
					int type = msg.getType();
					if(type == 1){
						if(connexion(msg) == true){
							sender.send(new Message("server", msg.getSender() + "|" + "yes", 3));
						}else{
							sender.send(new Message("server", msg.getSender() + "|" + "no", 3));
						}
					}else if(type == 2){
						saveMessage(msg);
					}else if(type == 5){
						if(register(msg) == true){
							sender.send(new Message("server", msg.getSender() + "|" + "yes", 4));
						}else{
							sender.send(new Message("server", msg.getSender() + "|" + "no", 4));
						}
					}
					list.remove(0);
				}
			}catch(Exception ex){
				ex.printStackTrace();
			}
		}
	}

	private boolean connexion(Message msg){
		//if username and password are in the users database
		return true;
		//else return false
	}

	private boolean register(Message msg){
		//if username not taken
		return true;
		//else return false
	}

	private void saveMessage(Message msg) throws IOException {
		sender.send(msg);
		//save message in the messages database
	}
}
package project;

import java.io.*;
import java.util.LinkedList;

public class Reciever extends ThreadTemplate {

	private ObjectInputStream input;
	private LinkedList<Message> list;

	public Reciever(ObjectInputStream input, ObjectOutputStream output, LinkedList<Message> list) {
		super(input, output);
		this.list = list;
	}

	public synchronized void run() {
		while (true) {
			Message nm;
			try {
				nm = (Message) input.readObject();
				if(nm.getContent().length() > 0){
					list.add(nm);
				}
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
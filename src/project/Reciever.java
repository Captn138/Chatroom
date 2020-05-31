package project;

import java.io.*;
import java.util.LinkedList;

/**
 * A Reciever object is a Thread that will constantly check for new messages and write them in a LinkedList.
 * @author Groupe Télétravail, Famine, Pâtes-Riz : ALMEIDA Mickael, BERNARD Hippolyte, DRAY Gabriel
 * @see ThreadTemplate
 * @see Message
 */
public class Reciever extends ThreadTemplate {

	private ObjectInputStream input;
	private LinkedList<Message> list;

	/**
	 * Sets the input and output streams using ThreadTemplate's constructor as well as the list to store incoming messages.
	 * @param input (ObjectInputStream) : the input stream
	 * @param output (ObjectOutputStream) : the output stream
	 * @param list (LinkedList<Message>) : the list to store incoming messages
	 * @see ThreadTemplate
	 */
	public Reciever(ObjectInputStream input, ObjectOutputStream output, LinkedList<Message> list) {
		super(input, output);
		this.list = list;
	}

	/**
	 * Always reads what is coming from the input stream. When it reads a message, proceeds to adding it to the list.
	 * @see Message
	 */
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
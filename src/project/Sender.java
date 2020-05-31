package project;

import java.io.*;

/**
* A Sender object is a Thread that will send new messages.
* @author Groupe Télétravail, Famine, Pâtes-Riz : ALMEIDA Mickael, BERNARD Hippolyte, DRAY Gabriel
* @see ThreadTemplate
* @see Message
*/
public class Sender extends ThreadTemplate {

	private ObjectOutputStream output;

	/**
	 * Sets the input and output stream using ThreadTemplate's constructor.
	 * @param input (ObjectInputStream) : the input stream
	 * @param output (ObjectOutputStream) : the output stream
	 * @see ThreadTemplate
	 */
	public Sender(ObjectInputStream input, ObjectOutputStream output) {
		super(input, output);
	}

	
	/** 
	 * Sends a message through the output stream.
	 * @param nm (Message) : the new message to be sent
	 * @throws IOException
	 * @see Message
	 */
	public synchronized void send(Message nm) throws IOException {
		output.writeObject(nm);
	}
}
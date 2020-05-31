package chatroom;

import java.io.*;

/**
 * ThreadTemplate is an abstract class to group networking threads with a common constructor.
 * @author Groupe Télétravail, Famine, Pâtes-Riz : ALMEIDA Mickael, BERNARD Hippolyte, DRAY Gabriel
 * @see Sender
 * @see Reciever
 */
public abstract class ThreadTemplate extends Thread {

    private ObjectOutputStream output;
	private ObjectInputStream input;

	/**
	 * Sets the input and output streams.
	 * @param input (ObjectInputStream) : the input stream
	 * @param output (ObjectOutputStream) : the output stream
	 */
	public ThreadTemplate(ObjectInputStream input, ObjectOutputStream output) {
		this.input = input;
        this.output = output;
	}
}
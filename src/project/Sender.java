package project;

import java.io.*;

public class Sender extends ThreadTemplate {

	private ObjectOutputStream output;

	public Sender(ObjectInputStream input, ObjectOutputStream output) {
		super(input, output);
	}

	public synchronized void send(Message nm) throws IOException {
		output.writeObject(nm);
	}
}
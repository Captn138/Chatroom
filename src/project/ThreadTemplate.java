package project;

import java.io.*;

public abstract class ThreadTemplate extends Thread {

    private ObjectOutputStream output;
	private ObjectInputStream input;

	public ThreadTemplate(ObjectInputStream input, ObjectOutputStream output) {
		this.input = input;
        this.output = output;
	}
}
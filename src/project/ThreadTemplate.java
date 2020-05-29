package project;

import java.io.*;
import java.net.*;

public abstract class ThreadTemplate extends Thread {

    private ObjectOutputStream output;
	private ObjectInputStream input;
    private Socket socket;
    private String ip;
    private int port;

	public ThreadTemplate(Socket socket, ObjectInputStream input, ObjectOutputStream output, String ip, int port) {
		this.socket = socket;
		this.input = input;
        this.output = output;
        this.ip = ip;
        this.port = port;
	}
}
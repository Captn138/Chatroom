package chatroom;

import java.util.Date;
import java.sql.Timestamp;  

public class Message {
	private String sender;
	private Timestamp time;
	private String content;
	private int type;
	
	public Message(String sender, String content, int type) {
		this.sender = sender;
		this.content = content;
		this.type = type;
		time = new Timestamp((new Date()).getTime());
	}

	
	public String getSender() {
		return sender;
	}

	public String getContent() {
		return content;
	}
	
	public int getType() {
		return type;
	}

		
	public Timestamp getTime() {
		return time;
	}
		
	
}
package project;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Message {
    
    private String sender;
    private String content;
    private int type;
    private LocalDateTime time;
    private DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");

    public String getSender() {
        return sender;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public String getStringTime() {
        return dtf.format(time);
    }

    public String getContent() {
        return content;
    }

    public int getType() {
        return type;
    }

    public Message(String sender, String content, int type) {
        this.sender = sender;
        this.content = content;
        this.type = type;
        time = LocalDateTime.now();
    }
}
package chatroom;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * A Message object is an object that contains the author, the time when it was created, the content as well as a type.
 * The different types are:
 * 1 for connexions request, use the username as sender and the password hash as content.
 * 2 for messages sending, use the username as sender and the message content as content.
 * 3 for connexion response (server-side), use the username as sender and yes or no as content if the user can connect or not.
 * 4 for register response (server-side), use the username as sender and yes or no as content if the register was complete or not.
 * 5 for register request, use the username as sender and the password hash as content.
 * @author Groupe Télétravail, Famine, Pâtes-Riz : ALMEIDA Mickael, BERNARD Hippolyte, DRAY Gabriel
 * @see Secure
 */
public class Message {
    
    private String sender;
    private String content;
    private int type;
    private LocalDateTime time;
    private DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");

    
    /**
     * Gets the message sender.
     * @return String
     */
    public String getSender() {
        return sender;
    }

    
    /** 
     * Gets the time of the message in a computer readable format.
     * @return LocalDateTime
     */
    public LocalDateTime getTime() {
        return time;
    }

    
    /** 
     * Gets the time of the message in a human readable format "yyyy/MM/dd HH:mm:ss".
     * @return String
     */
    public String getStringTime() {
        return dtf.format(time);
    }

    
    /** 
     * Gets the content of the message.
     * @return String
     */
    public String getContent() {
        return content;
    }

    
    /** 
     * Gets the type of the message.
     * @return int
     */
    public int getType() {
        return type;
    }

    /**
     * Sets the parameters of the message as well as the time at wich it was created.
     * @param sender (String) : the sender of the message
     * @param content (String) : the content of the message
     * @param type (int) : the type of the message from 1 to 5
     */
    public Message(String sender, String content, int type) {
        this.sender = sender;
        this.content = content;
        this.type = type;
        time = LocalDateTime.now();
    }
}
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;  

public class message {
	private String sender;
	private String time;
	private String content;
	private int type;

	
	public String getSender() {
		return sender;
	}

	public String getContent() {
		return content;
	}
	
	public int getType() {
		return type;
	}

	public static void main(String[] args) {  
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		LocalDateTime now = LocalDateTime.now();
		System.out.println(dtf.format(now));
	}
}
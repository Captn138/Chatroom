package chatroomtest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import chatroom.Message;

class MessageTest {

	@Test
	void testgetSender() {
		String sender = new String();
		String content = new String();
		int[] type = {1, 2, 3, 4, 5};
		for(int i=0; i<5;i++) {
			Message m = new Message(sender, content, type[i]);
			assertNotNull(m.getSender());
		}
		
	}
	
	@Test
	void testgetTime() {
		String sender = new String();
		String content = new String();
		int type = 2;
		Message m = new Message(sender, content, type);
		assertNotNull(m.getTime());
	}
	
	@Test
	void testgetStringTime() {
		String sender = new String();
		String content = new String();
		int type = 2;
		Message m = new Message(sender, content, type);
		assertNotNull(m.getStringTime());
	}
	
	@Test
	void testgetContent() {
		String sender = new String();
		String content = new String();
		int type = 2;
		Message m = new Message(sender, content, type);
		assertNotNull(m.getContent());
	}
	
	@Test
	void testgetType() {
		String sender = new String();
		String content = new String();
		int type = 2;
		Message m = new Message(sender, content, type);
		assertTrue(m.getType() > 0);
	}
}

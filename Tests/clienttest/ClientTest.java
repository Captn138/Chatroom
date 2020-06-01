package clienttest;

import static org.junit.Assert.assertNotNull;

import org.junit.jupiter.api.Test;

import client.Client;

class ClientTest {

	@Test
	void testgetFirstElemFromList() {
		try{
			String ip = "6.6.6.6";
			Client c = new Client(ip);
			assertNotNull(c.getFirstElemFromList());
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	@Test
	void testhash() {
		String ip = "6.6.6.6";
		String pwd = "password";
		Client c = new Client(ip);
		assertNotNull(c.hash(pwd));
		
	}
}

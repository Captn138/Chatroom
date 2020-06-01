package clienttest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import client.Secure;

class SecureTest {

	@Test
	void testhash() {
		Secure s = new Secure();
		String pwd = "password";
		assertEquals(s.hash(pwd), "b109f3bbbc244eb82441917ed06d618b9008dd09b3befd1b5e07394c706a8bb980b1d7785e5976ec049b46df5f1326af5a2ea6d103fd07c95385ffab0cacbc86");
	}

}

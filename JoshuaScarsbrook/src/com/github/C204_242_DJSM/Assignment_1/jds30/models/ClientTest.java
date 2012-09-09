/**
 * 
 */
package com.github.C204_242_DJSM.Assignment_1.jds30.models;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import com.github.C204_242_DJSM.Assignment_1.jds30.exceptions.NotPrivException;
import com.github.C204_242_DJSM.Assignment_1.jds30.exceptions.PasswordsDoNotMatchException;
import com.github.C204_242_DJSM.Assignment_1.jds30.session.ClientSession;

/**
 * @author Joshua Scarsbrook
 *
 */
public class ClientTest {

	@Test
	public void testCheckPassword() {
		ArrayList<String[]> clientAddressTest = new ArrayList<>();
		clientAddressTest.add(new String[] {
			"Testing",
			"1231",
			"Hello World"
		});
		assertTrue(new ClientLoginSupport("hello world", clientAddressTest, "world", ClientPrivilegeLevel.DEBUG).checkPassword("world"));
		assertFalse(new ClientLoginSupport("hello world", clientAddressTest, "world", ClientPrivilegeLevel.DEBUG).checkPassword("testing"));
	}
	
	@Test
	public void testChangePassword() {
		ArrayList<String[]> clientAddressTest = new ArrayList<>();
		clientAddressTest.add(new String[] {
			"Testing",
			"1231",
			"Hello World"
		});
		ClientLoginSupport testing = new ClientLoginSupport("hello world", clientAddressTest, "world", ClientPrivilegeLevel.DEBUG);
		ClientSession sess = ClientSession.CreateDummySession(testing);
		assertTrue(sess.getSelf().checkPassword("world"));
		try {
			sess.getSelf().changePassword(sess, "world", "world2");
		} catch (NotPrivException e) {
			// TODO Auto-generated catch block
			fail("Privlage Error");
		} catch (PasswordsDoNotMatchException e) {
			// TODO Auto-generated catch block
			fail("Password Match Error");
		}
		assertFalse(sess.getSelf().checkPassword("world"));
		assertTrue(sess.getSelf().checkPassword("world2"));
	}

}

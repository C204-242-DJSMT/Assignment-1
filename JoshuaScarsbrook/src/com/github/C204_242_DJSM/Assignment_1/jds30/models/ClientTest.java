/**
 * 
 */
package com.github.C204_242_DJSM.Assignment_1.jds30.models;

import static org.junit.Assert.*;

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
		assertTrue(new Client("hello", "world", ClientPrivilegeLevel.DEBUG).checkPassword("world"));
		assertFalse(new Client("hello", "world", ClientPrivilegeLevel.DEBUG).checkPassword("testing"));
	}
	
	@Test
	public void testChangePassword() {
		Client testing = new Client("hello", "world", ClientPrivilegeLevel.DEBUG);
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

package com.github.C204_242_DJSM.Assignment_1.jds30.models;

import external.*;

import java.security.MessageDigest;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;

import com.github.C204_242_DJSM.Assignment_1.jds30.exceptions.NotPrivException;
import com.github.C204_242_DJSM.Assignment_1.jds30.exceptions.PasswordsDoNotMatchException;
import com.github.C204_242_DJSM.Assignment_1.jds30.session.ClientSession;

public class ClientLoginSupport extends Client {
	private byte[] _password;
	private ClientPrivilegeLevel _level;
	
	public ClientLoginSupport(String name, ArrayList<String[]> addresses, String password, ClientPrivilegeLevel level) {
		super(name, addresses);
		_password = MD5Crypt(password);
		_level = level;
	}
	
	public ClientPrivilegeLevel getPrivLevel() {
		return _level;
	}
	
	public Boolean checkPassword(String input) {
		return Arrays.equals(MD5Crypt(input), _password);
	}
	
	private byte[] MD5Crypt(String input) {
		MessageDigest digest = null;
		try {
			digest = MessageDigest.getInstance("md5");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			return new byte[] {};
		}
		digest.update(input.getBytes());
		return digest.digest();
	}
	
	public void changePassword(ClientSession session, String oldPassword, String newPassword) throws NotPrivException, PasswordsDoNotMatchException {
		if (!session.hasPrivilege(ClientSession.ClientPrivileges.CHANGEPASSWORD)) {
			throw new NotPrivException(ClientSession.ClientPrivileges.CHANGEPASSWORD);
		}
		if (checkPassword(oldPassword) == false) {
			throw new PasswordsDoNotMatchException();
		}
		_password = MD5Crypt(newPassword);
	}
}

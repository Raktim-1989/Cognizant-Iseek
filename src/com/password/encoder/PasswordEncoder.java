package com.password.encoder;

import org.apache.commons.codec.binary.Base64;

public class PasswordEncoder {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "";
		byte[] encodedString = Base64.encodeBase64(str.getBytes());
		System.out.println("Encoded String is " + " " + new String(encodedString));
	}

}

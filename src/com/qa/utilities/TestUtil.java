package com.qa.utilities;

import org.apache.commons.codec.binary.Base64;

public class TestUtil {

	public static String decodeString(String password)
	{
	       byte[] decodePassword = Base64.decodeBase64(password);
	       return (new String(decodePassword));
	}
	
}

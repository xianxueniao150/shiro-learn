package com.how2java;

import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;

public class TestEncryption {

	public static void main(String[] args) {
		String password = "123";
		String salt = new SecureRandomNumberGenerator().nextBytes().toString();
		int times = 2;
		String algorithmName = "md5";
		
		String encodedPassword = new SimpleHash(algorithmName,password,salt,times).toString();
		
		
		
		System.out.printf("ԭʼ������ %s , ���ǣ� %s, ��������ǣ� %d, ��������������ǣ�%s ",password,salt,times,encodedPassword);
		
	}
}

package com.spring.utils;

import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.password.PasswordEncoder;

public class PasswordEncryptDecryptUtils implements PasswordEncoder {

	@Override
	public String encode(CharSequence rawPassword) {
		return BCrypt.hashpw(rawPassword.toString(), BCrypt.gensalt(12));
	}

	@Override
	public boolean matches(CharSequence rawPassword, String encodedPassword) {
		return BCrypt.checkpw(rawPassword.toString(), encodedPassword);
	}

	public static void main(String[] args) {
		PasswordEncryptDecryptUtils utils = new PasswordEncryptDecryptUtils();
		System.out.println("Password : "+utils.encode("spring"));
	}
}

package br.com.testeFila.fifo;

import com.amazonaws.auth.BasicAWSCredentials;

public class Credentials {
	static BasicAWSCredentials awsCreds = new BasicAWSCredentials("access", "secret");
	
	public static BasicAWSCredentials getCredentials() {
		return awsCreds;
	}
}

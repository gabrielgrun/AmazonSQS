package br.com.testeFila.fifo;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.client.builder.AwsClientBuilder.EndpointConfiguration;
import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.AmazonSQSClientBuilder;

public class QueueFactory {
	public static AmazonSQS getQueue() {
		return AmazonSQSClientBuilder
		.standard()
		.withCredentials(new AWSStaticCredentialsProvider(Credentials.getCredentials()))
		.withEndpointConfiguration(new EndpointConfiguration("http://localhost:4566/", "us-east-2"))
		.build();
	}
}

package br.com.testeFila.fifo;

import java.util.List;

import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.model.Message;
import com.amazonaws.services.sqs.model.ReceiveMessageRequest;

public class Read {
	public static void main(String[] args) {
		AmazonSQS sqs = QueueFactory.getQueue();
		String queueUrl = "http://localhost:4566/000000000000/testeViaCodigo2.fifo";
		
		ReceiveMessageRequest receiveRequest = new ReceiveMessageRequest()
				.withQueueUrl(queueUrl)
				.withWaitTimeSeconds(1)
				.withVisibilityTimeout(1)
				.withMessageAttributeNames("All")
				.withMaxNumberOfMessages(10);
		
		List<Message> messages = sqs.receiveMessage(receiveRequest).getMessages();
		
		for (Message message : messages) {
			System.out.println(message);
		}
	}
}

package br.com.testeFila.fifo;

import java.util.List;

import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.model.DeleteMessageResult;
import com.amazonaws.services.sqs.model.Message;
import com.amazonaws.services.sqs.model.ReceiveMessageRequest;

public class Delete {
	public static void main(String[] args) {
		AmazonSQS sqs = QueueFactory.getQueue();
		String queueUrl = "http://localhost:4566/000000000000/testeViaCodigo2.fifo";
		ReceiveMessageRequest receiveRequest = new ReceiveMessageRequest()
				.withQueueUrl(queueUrl)
				.withMaxNumberOfMessages(1);
		List<Message> messages = sqs.receiveMessage(receiveRequest).getMessages();
		for (Message message : messages) {
			DeleteMessageResult result = sqs.deleteMessage(queueUrl, message.getReceiptHandle());
			System.out.println(result.getSdkResponseMetadata());
		}
	}
}

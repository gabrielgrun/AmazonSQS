package br.com.testeFila.standard;

import java.util.List;

import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.AmazonSQSClientBuilder;
import com.amazonaws.services.sqs.model.DeleteMessageResult;
import com.amazonaws.services.sqs.model.Message;
import com.amazonaws.services.sqs.model.ReceiveMessageRequest;

public class Delete {
	public static void main(String[] args) {
		AmazonSQS sqs = AmazonSQSClientBuilder.standard().build();
		String queueUrl = "https://sqs.us-east-2.amazonaws.com/122651698824/FilaTeste";
		ReceiveMessageRequest receiveRequest = new ReceiveMessageRequest()
				.withQueueUrl(queueUrl)
				.withMaxNumberOfMessages(10);
		List<Message> messages = sqs.receiveMessage(receiveRequest).getMessages();
		for (Message message : messages) {
			DeleteMessageResult result = sqs.deleteMessage(queueUrl, message.getReceiptHandle());
			System.out.println(result.getSdkResponseMetadata());
		}
	}
}

package br.com.testeFila.standard;

import java.util.HashMap;
import java.util.Map;

import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.AmazonSQSClientBuilder;
import com.amazonaws.services.sqs.model.MessageAttributeValue;
import com.amazonaws.services.sqs.model.SendMessageRequest;
import com.amazonaws.services.sqs.model.SendMessageResult;

public class Send {
	public static void main(String[] args) {
		String queueUrl = "https://sqs.us-east-2.amazonaws.com/122651698824/FilaTeste";
		AmazonSQS sqs = AmazonSQSClientBuilder.standard().build();
		Map<String, MessageAttributeValue> messageAttributes = new HashMap<>();
		messageAttributes.put("Name", new MessageAttributeValue().withStringValue("Grün").withDataType("String"));
		
		int i=0;
		
		while(i<100) {
			SendMessageRequest sendMessageReq = new SendMessageRequest()
					.withQueueUrl(queueUrl)
					.withMessageBody("Teste" + i)
					.withMessageAttributes(messageAttributes)
					.withDelaySeconds(5);
			i++;
			SendMessageResult result = sqs.sendMessage(sendMessageReq);
			System.out.println(result.getMessageId());
		}
	}
}

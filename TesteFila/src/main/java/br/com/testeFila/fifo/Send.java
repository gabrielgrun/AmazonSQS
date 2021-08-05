package br.com.testeFila.fifo;

import java.util.HashMap;
import java.util.Map;

import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.model.MessageAttributeValue;
import com.amazonaws.services.sqs.model.SendMessageRequest;
import com.amazonaws.services.sqs.model.SendMessageResult;

public class Send {
	public static void main(String[] args) {
		String queueUrl = "http://localhost:4566/000000000000/testeViaCodigo2.fifo";
		AmazonSQS sqs = QueueFactory.getQueue();
		Map<String, MessageAttributeValue> messageAttributes = new HashMap<>();
		messageAttributes.put("Name", new MessageAttributeValue().withStringValue("Grün").withDataType("String"));
		messageAttributes.put("Name2", new MessageAttributeValue().withStringValue("Grün2").withDataType("String"));
		messageAttributes.put("Name3", new MessageAttributeValue().withStringValue("Grün3").withDataType("String"));
		messageAttributes.put("Name4", new MessageAttributeValue().withStringValue("Grün4").withDataType("String"));
		messageAttributes.put("Name5", new MessageAttributeValue().withStringValue("Grün5").withDataType("String"));
		messageAttributes.put("Name6", new MessageAttributeValue().withStringValue("Grün6").withDataType("String"));
		messageAttributes.put("Name7", new MessageAttributeValue().withStringValue("Grün7").withDataType("String"));
		messageAttributes.put("Name8", new MessageAttributeValue().withStringValue("Grün8").withDataType("String"));
		messageAttributes.put("Name9", new MessageAttributeValue().withStringValue("Grün9").withDataType("String"));
		messageAttributes.put("Name10", new MessageAttributeValue().withStringValue("Grün10").withDataType("String"));
		
		int i=0;
		
		while(i<10) {
			SendMessageRequest sendMessageReq = new SendMessageRequest()
					.withQueueUrl(queueUrl)
					.withMessageGroupId("1")
					.withMessageBody("Teste" + i)
					.withMessageAttributes(messageAttributes);
			i++;
			SendMessageResult result = sqs.sendMessage(sendMessageReq);
			System.out.println(result.getMessageId());
		}
	}
}

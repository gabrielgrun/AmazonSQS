package br.com.testeFila.fifo;

import java.util.HashMap;
import java.util.Map;

import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.model.AmazonSQSException;
import com.amazonaws.services.sqs.model.CreateQueueRequest;
import com.amazonaws.services.sqs.model.ListQueuesResult;

public class Queue {
	public static void main(String[] args) {
		AmazonSQS sqs = QueueFactory.getQueue();
		Map<String, String> queueAttributes = new HashMap<String, String>();
		queueAttributes.put("FifoQueue", "true");
		queueAttributes.put("ContentBasedDeduplication", "true");
		queueAttributes.put("DelaySeconds", "60");
		queueAttributes.put("MessageRetentionPeriod", "86400");
		
		CreateQueueRequest create_request = new CreateQueueRequest("testeViaCodigo2.fifo")
				.withAttributes(queueAttributes);
		        
		try {
		    sqs.createQueue(create_request);
		} catch (AmazonSQSException e) {
		    if (!e.getErrorCode().equals("QueueAlreadyExists")) {
		        throw e;
		    }
		}
		
		ListQueuesResult a  = sqs.listQueues();
		System.out.println(a.getQueueUrls());
	}
}

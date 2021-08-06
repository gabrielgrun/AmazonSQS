package br.com.testeFila.fifo;

import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.model.GetQueueAttributesRequest;
import com.amazonaws.services.sqs.model.GetQueueAttributesResult;
import com.amazonaws.services.sqs.model.ListQueuesResult;

public class QueueQuery {
	public static void main(String[] args) {
		AmazonSQS sqs = QueueFactory.getQueue();
		ListQueuesResult list = sqs.listQueues();
		System.out.println(list.getQueueUrls());
		GetQueueAttributesResult queueAttributesResult = sqs.getQueueAttributes(new GetQueueAttributesRequest("http://localhost:4566/000000000000/testeViaCodigo2.fifo"));
		System.out.println("Número aproximado de mensagens: " + queueAttributesResult.getAttributes().get("ApproximateNumberOfMessages"));
	}
}

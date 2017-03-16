package com.ait.q1;

import java.util.Hashtable;
import javax.naming.*;
import javax.jms.*;

class SendToQueue {
	public static void main(String args[]) throws NamingException, JMSException {
		// pick up a reference to the JMS implementation from
		// JNDI (type QueueConnectionFactory)
		Hashtable<String, String> properties = new Hashtable<String, String>();
		properties.put(Context.INITIAL_CONTEXT_FACTORY, "org.exolab.jms.jndi.InitialContextFactory");
		properties.put(Context.PROVIDER_URL, "rmi://localhost:1099/");
		Context context = new InitialContext(properties);
		QueueConnectionFactory qcf = (QueueConnectionFactory) context.lookup("JmsQueueConnectionFactory");
		// create queue connection object
		QueueConnection qc = qcf.createQueueConnection();
		// create a queue session object
		// transactions false, auto ack receipt of messages
		QueueSession qSession = qc.createQueueSession(false, Session.AUTO_ACKNOWLEDGE);
		
		// pick up a ref to existing queue from JNDI
		javax.jms.Queue q = (javax.jms.Queue) context.lookup("queue1");
		
		// create a queue sender associated with this Q
		QueueSender qSender = qSession.createSender(q);
		// send a message to the queue
		TextMessage message = qSession.createTextMessage();
		message.setText("Hello there.");
		qSender.send(message);
		System.out.println("SendToQueue has sent to Q");
	}

}

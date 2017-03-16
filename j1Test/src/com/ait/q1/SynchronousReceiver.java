package com.ait.q1;

import java.util.Hashtable;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueReceiver;
import javax.jms.QueueSender;
import javax.jms.QueueSession;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

class SynchronousReceiver {

	public static void main(String[] args) throws NamingException, JMSException {
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
		
		// create a queueReceiver associated with this Q 
		QueueReceiver queueReceiver = qSession.createReceiver(q);
		// start delivery of incoming messages
		qc.start();

		// receive message
		Message message = queueReceiver.receive();
		String messageText = null ;
		if (message instanceof TextMessage)
			messageText = 
		            ((TextMessage)message).getText();
		System.out.println(messageText);


	}

}

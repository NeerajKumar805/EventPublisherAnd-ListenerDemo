package com.event.listeners.listners;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.event.listeners.events.OrderCreateEvent;

@Component
public class SendEmailListener {
	
	@EventListener
	public void handleSendEmailListener(OrderCreateEvent event) {
		System.out.println("Email sent with order id : " + event.getOrderId()); // listening the OrderCreateEvent event
	}
}

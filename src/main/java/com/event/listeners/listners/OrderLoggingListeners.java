package com.event.listeners.listners;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.event.listeners.events.OrderCreateEvent;

@Component
public class OrderLoggingListeners {

	@EventListener
	public void doOrderLogg(OrderCreateEvent event) {
		System.out.println("Order plcaed with orderId:" + event.getOrderId()); // listening the OrderCreateEvent event
	}
}

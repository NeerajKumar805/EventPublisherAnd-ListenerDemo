package com.event.listeners.service;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import com.event.listeners.events.OrderCreateEvent;

@Service
public class OrderService {

	private final ApplicationEventPublisher publisher;

	public OrderService(ApplicationEventPublisher publisher) {
		this.publisher = publisher;
	}

	public String createOrder(Long orderId) {
		String msg = "Order succesfully created with id: " + orderId;
		System.out.println(msg);
		// publishing the event to the listeners
		publisher.publishEvent(new OrderCreateEvent(orderId));
		return msg;
	}
}

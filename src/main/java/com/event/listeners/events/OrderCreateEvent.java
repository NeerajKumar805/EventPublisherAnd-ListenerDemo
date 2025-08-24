package com.event.listeners.events;

public class OrderCreateEvent {

	private Long orderId;

	public OrderCreateEvent(Long orderId) {
		this.orderId = orderId;
	}

	public Long getOrderId() {
		return orderId;
	}

}

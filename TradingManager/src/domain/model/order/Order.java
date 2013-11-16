package domain.model.order;

import domain.model.OrderEvent;
import domain.model.client.ClientRequest;

public interface Order {
	long getOrderId();
	ClientRequest getClientRequest();
	
}

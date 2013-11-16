package store;

import domain.model.order.Order;

public interface OrderRepository {
	Order getOrder(long orderId);
	void saveOrder(Order order);
}

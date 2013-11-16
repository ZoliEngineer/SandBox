package executor.context;

import domain.model.OrderEvent;
import domain.model.order.Order;

public interface ContextFactory {

	<I extends OrderEvent, O extends OrderEvent> Context<I,O> getContext(I Event, Order order);
}

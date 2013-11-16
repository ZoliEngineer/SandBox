package domain.workflow;

import domain.model.OrderEvent;
import domain.model.order.Order;

public interface Workflow<I extends OrderEvent, O extends OrderEvent> {
	void execute(I input);
}

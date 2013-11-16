package executor.context;

import domain.model.OrderEvent;
import domain.model.order.Order;

public interface Context<I extends OrderEvent, O extends OrderEvent> {
	Order getOrder();
	I getInput();
	void setOutput(O output);
	O getOutput();
}

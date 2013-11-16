package domain.workflow;

import domain.model.OrderEvent;
import domain.model.order.Order;
import executor.context.Context;
import executor.context.ContextFactory;
import store.OrderRepository;

public abstract class AbstractWorkflow<I extends OrderEvent, O extends OrderEvent> implements Workflow<I,O>{
	private final OrderRepository orderRepository;
	private final ContextFactory contextFactory;
	
	public AbstractWorkflow(OrderRepository orderRepository,
			ContextFactory contextFactory) {
		this.orderRepository = orderRepository;
		this.contextFactory = contextFactory;
	}	
	
	@Override
	public void execute(I input) {
		Order order = loadOrder(input);
		Context<I, O> context = contextFactory.getContext(input, order);
		perform(context);		
		saveOrder(order);		
	}
	
	private void saveOrder(Order order) {
		orderRepository.saveOrder(order);		
	}

	private Order loadOrder(I input) {
		return orderRepository.getOrder(input.getOrderId());		
	}

	protected abstract void perform(Context<I,O> context);

}

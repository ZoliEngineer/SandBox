package domain.workflow.clientflow;

import java.nio.ByteBuffer;

import store.OrderRepository;
import tasks.validation.Validator;
import connection.connector.MarketConnector;
import connection.encoder.Encoder;
import converter.Converter;
import domain.model.client.ClientOrderNew;
import domain.model.client.ClientOrderReplace;
import domain.model.market.MarketOrderNew;
import domain.model.market.MarketOrderReplace;
import domain.workflow.AbstractWorkflow;
import executor.context.Context;
import executor.context.ContextFactory;

public class ReplaceOrderFlow extends AbstractWorkflow<ClientOrderReplace, MarketOrderReplace> {
	private final Validator<ClientOrderReplace> validator;
	private final Converter<ClientOrderReplace, MarketOrderReplace> converter;
	private final MarketConnector connector;
	private final Encoder<MarketOrderReplace> encoder;	

	public ReplaceOrderFlow(OrderRepository orderRepository,
			ContextFactory contextFactory,
			Validator<ClientOrderReplace> validator,
			Converter<ClientOrderReplace, MarketOrderReplace> converter,
			MarketConnector connector, Encoder<MarketOrderReplace> encoder) {
		super(orderRepository, contextFactory);
		this.validator = validator;
		this.converter = converter;
		this.connector = connector;
		this.encoder = encoder;
	}

	@Override
	protected void perform(Context<ClientOrderReplace, MarketOrderReplace> context) {
		validateInput(context);
		createMarketRequest(context);
		sendToMarket(context);		
	}
	
	private void validateInput(Context<ClientOrderReplace, MarketOrderReplace> context) {
		ClientOrderReplace clientRequest = context.getInput();
		validator.validate(clientRequest);
	}
	
	private void createMarketRequest(
			Context<ClientOrderReplace, MarketOrderReplace> context) {
		ClientOrderReplace clientRequest = context.getInput();
		MarketOrderReplace marketRequest = converter.convert(clientRequest);
		context.setOutput(marketRequest);		
	}

	private void sendToMarket(Context<ClientOrderReplace, MarketOrderReplace> context) {
		MarketOrderReplace marketRequest = context.getOutput();
		ByteBuffer message = encoder.encode(marketRequest);
		connector.send(message);
	}	
}
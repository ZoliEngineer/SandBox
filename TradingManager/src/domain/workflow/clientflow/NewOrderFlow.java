package domain.workflow.clientflow;

import java.nio.ByteBuffer;

import store.OrderRepository;
import tasks.validation.Validator;
import connection.connector.MarketConnector;
import connection.encoder.Encoder;
import converter.Converter;
import domain.model.client.ClientOrderNew;
import domain.model.market.MarketOrderNew;
import domain.workflow.AbstractWorkflow;
import executor.context.Context;
import executor.context.ContextFactory;

public class NewOrderFlow extends
		AbstractWorkflow<ClientOrderNew, MarketOrderNew> {
	private final Validator<ClientOrderNew> validator;
	private final Converter<ClientOrderNew, MarketOrderNew> converter;
	private final MarketConnector connector;
	private final Encoder<MarketOrderNew> encoder;

	public NewOrderFlow(OrderRepository orderRepository,
			ContextFactory contextFactory, Validator<ClientOrderNew> validator,
			Converter<ClientOrderNew, MarketOrderNew> converter,
			MarketConnector connector, Encoder<MarketOrderNew> encoder) {
		super(orderRepository, contextFactory);
		this.validator = validator;
		this.converter = converter;
		this.connector = connector;
		this.encoder = encoder;
	}

	@Override
	protected void perform(Context<ClientOrderNew, MarketOrderNew> context) {
		validateInput(context);
		createMarketRequest(context);
		sendToMarket(context);
	}

	private void validateInput(Context<ClientOrderNew, MarketOrderNew> context) {
		ClientOrderNew clientRequest = context.getInput();
		validator.validate(clientRequest);
	}

	private void createMarketRequest(
			Context<ClientOrderNew, MarketOrderNew> context) {
		ClientOrderNew clientRequest = context.getInput();
		MarketOrderNew marketRequest = converter.convert(clientRequest);
		context.setOutput(marketRequest);
	}

	private void sendToMarket(Context<ClientOrderNew, MarketOrderNew> context) {
		MarketOrderNew marketRequest = context.getOutput();
		ByteBuffer message = encoder.encode(marketRequest);
		connector.send(message);
	}
}

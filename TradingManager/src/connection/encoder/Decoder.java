package connection.encoder;

import java.nio.ByteBuffer;

import domain.model.OrderEvent;

public interface Decoder<T extends OrderEvent> {

	T decode(ByteBuffer message);

}
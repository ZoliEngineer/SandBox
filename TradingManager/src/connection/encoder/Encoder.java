package connection.encoder;

import java.nio.ByteBuffer;

import domain.model.OrderEvent;

public interface Encoder<T extends OrderEvent> {

	ByteBuffer encode(T orderEvent);

}

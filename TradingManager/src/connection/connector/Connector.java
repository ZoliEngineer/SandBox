package connection.connector;

import java.nio.ByteBuffer;

public interface Connector {
	void send(ByteBuffer message);
}

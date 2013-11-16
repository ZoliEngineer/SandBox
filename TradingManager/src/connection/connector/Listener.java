package connection.connector;

import java.nio.ByteBuffer;

public interface Listener {

	void listen(ByteBuffer message);
	
}

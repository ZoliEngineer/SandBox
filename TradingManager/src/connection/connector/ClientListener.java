package connection.connector;

import java.nio.ByteBuffer;

public class ClientListener implements Listener{
	WorkflowExecutor executor;
	
	@Override
	public void listen(ByteBuffer message){
		executor.dispatch(message);
	}
	
}

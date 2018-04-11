import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class ChatAula extends UnicastRemoteObject implements IChatAula{

	public ChatAula() throws RemoteException{
		super();		
	}

	@Override
	public void sendMenssage(Message msg) throws RemoteException {
		Message.setLstMessage(msg);	
	}

	@Override
	public List<Message> retriveMessage() throws RemoteException {
		return Message.getLstMessage();
	}
	
}

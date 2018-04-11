import java.io.Serializable;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.print.attribute.standard.DateTimeAtCompleted;

import br.com.proj.controller.MessageDB;
import br.com.proj.model.Mensagem;

public class Message implements Serializable {

	private String user;
	private String message;
	private Date dt;
	
	private static List<Message> lstMessage = new ArrayList<Message>();
	
	public Message(String user, String message ){
		Date dat = new Date();//Pega a data atual 
		this.user = user;
		this.message = message;
		this.dt = dat;
	
	}


	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Date getDt() {
		return dt;
	}

	public void setDt(Date dt) {
		this.dt = dt;
	}

	public static List<Message> getLstMessage() {
		return lstMessage;
	}

	public static void setLstMessage(Message msg)  {
		lstMessage.add(msg);
		
		Mensagem msgdb = new Mensagem();
		msgdb.setMessage(msg.getMessage());
		msgdb.setUser(msg.getUser());
		msgdb.setDt(msg.getDt());
		
	    
		new MessageDB().insertMessage(msgdb);

	}
	@Override
	public String toString(){		
		return  MessageFormat.format("{0} - {1} : {2} ", this.dt , this.user != null ? this.user : "Não Informado" , this.message != null ? this.message : "Conversa Encerrada");
	}

}

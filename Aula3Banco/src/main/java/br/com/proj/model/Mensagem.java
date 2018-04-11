package br.com.proj.model;

import java.text.MessageFormat;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.print.attribute.standard.DateTimeAtCompleted;

@Entity
public class Mensagem {

	public static final String QUERY_ALL="Message.All";
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) //para id ser pk
	private int codigo; 
	private Date dt;
	private String user;
	private String message;
	
	
	public Mensagem(){}
	
	public Mensagem(int codigo, String user, String message ) {
		Date dat = new Date();//Pega a data atual
		this.codigo = codigo;
		this.user = user;
		this.message = message;
		this.dt = dat;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public Date getDt() {
		return dt;
	}

	public void setDt(Date dt) {
		this.dt = dt;
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
	@Override
	public String toString(){		
		return  MessageFormat.format("{0} - {1} : {2} ", this.dt , this.user != null ? this.user : "Não Informado" , this.message != null ? this.message : "Conversa Encerrada");
	}
}

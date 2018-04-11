package br.com.proj.util;

import br.com.proj.controller.MessageDB;
import br.com.proj.model.Mensagem;

public class teste {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Mensagem msg = new Mensagem();
	//	msg.set(0);
		msg.setUser("aaaaaa");
		msg.setMessage("eeeeeee");
		new MessageDB().insertMessage(msg);
	}


}

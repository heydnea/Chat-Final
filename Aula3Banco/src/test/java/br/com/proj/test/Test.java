package br.com.proj.test;

import br.com.proj.controller.MessageDB;
import br.com.proj.model.Mensagem;
import junit.framework.TestCase;

public class Test extends TestCase{

	public void testInsert() {
		Mensagem message = new Mensagem();
		message.setUser("Teste");
		message.setMessage("2345");

        new MessageDB().insertMessage(message);
	}
	
}

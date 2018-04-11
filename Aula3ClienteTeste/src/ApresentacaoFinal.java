import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.text.MessageFormat;
import java.util.List;

import javax.swing.JOptionPane;

import br.com.proj.controller.MessageDB;
import br.com.proj.model.Mensagem;

public class ApresentacaoFinal {

	public static void main(String[] args) {
		String nome = "";
		String msgp = "";

		nome = JOptionPane.showInputDialog("Bem vindo, ao Chat, Qual é o seu nome?");

		try {
			while (msgp != null) {
				msgp = JOptionPane.showInputDialog("Chat - " + nome
						+ " Entre com a mensage ou aperte CANCELAR para sair. Para gerar o LOG informe GerarTxt");
				IChatAula objChat = (IChatAula) Naming.lookup("rmi://localhost:8282/chat");

				Message msg = new Message(nome, msgp);
				
				if (msgp != null && msgp.equals("GerarTxt") )
					GerarTxt();

				objChat.sendMenssage(msg);
				System.out.println(returnMessage(objChat.retriveMessage()));
			}

		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static String returnMessage(List<Message> lst) {
		String valor = "";

		for (Message message : lst) {

			valor += message.getUser() + ": " + message.getMessage() + "\n";
		}
		return valor;
	}

	private static void GerarTxt() {
		try {
			// Cria arquivo
			File file = new File("teste.txt");

			// Verifica se o arquivo existe senão ele cria
			if (!file.exists()) {
				file.createNewFile();
			}

			// Prepara para escrever no arquivo
			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			PrintWriter bw = new PrintWriter(fw);
			// Instancia a classe MessageDB para gerar o select  no bd 
			MessageDB db = new MessageDB();
			List<Mensagem> lstmsg = db.selectAll();//joga em uma lista o retorno 
			
			for (Mensagem mensagem : lstmsg) {
				//utiliza o if ternario para verificar se o campo esta null se tiver coloca algo no lugar 
				String mensagemFormatada  = MessageFormat.format("{0} - {1} : {2} ", mensagem.getDt() , mensagem.getUser() != null ? mensagem.getUser() : "Não Informado" , mensagem.getMessage() != null ? mensagem.getMessage() : "Conversa Encerrada");
				bw.println(mensagemFormatada);
			}
			bw.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}

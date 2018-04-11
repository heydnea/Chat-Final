import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.text.MessageFormat;
import java.util.List;

import br.com.proj.controller.MessageDB;
import br.com.proj.model.Mensagem;

public class testetxt {
	public static void main(String[] args) {
		try {
			MessageDB db = new MessageDB();
			
			// Cria arquivo
			File file = new File("teste.txt");
 			//Verifica se o arquivo existe senão ele gera
			if (!file.exists()) {
				file.createNewFile();
			}
			//Prepara para escrever no arquivo
			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			PrintWriter bw = new PrintWriter(fw);

			List<Mensagem> lstmsg = db.selectAll();
			for (Mensagem mensagem : lstmsg) {
		
				//bw.println(mensagem.getDt() + " - ");
				//MessageFormat.format("{0} - {1} : {2}", mensagem.getDt() , mensagem.getUser() != null ? mensagem.getUser() :  "Não Informado" ,mensagem.getMessage() != null ? mensagem.getMessage(): "Conversa Encerrada" )
			//	bw.write(mensagem.getUser() + " : ");
				//bw.write(mensagem.getMessage() != null ?  mensagem.getMessage() :"Conversa Encerrada" + "\n");
				bw.println();
			}
	     	bw.close();

		} catch (Exception e) {
			// TODO: handle exception
		}
	}


}

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.CardLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

import br.com.proj.controller.MessageDB;
import br.com.proj.model.Mensagem;

import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.GridLayout;
import net.miginfocom.swing.MigLayout;
import java.awt.GridBagLayout;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JTextPane;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.text.MessageFormat;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JList;

public class JFrameMensagem extends JFrame {
	private JTextField txtNome;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrameMensagem frame = new JFrameMensagem();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public JFrameMensagem() {
		
		setTitle("CHAT");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 418, 452);

		getContentPane().setLayout(null);
		txtNome = new JTextField();
		txtNome.setBounds(167, 6, 153, 20);
		getContentPane().add(txtNome);
		txtNome.setColumns(10);

		JTextArea textArea = new JTextArea();
		textArea.setBounds(10, 295, 262, 98);
		getContentPane().add(textArea);
		
		JList list = new JList();
		list.setBounds(10, 282, 382, -259);
		getContentPane().add(list);

		JButton btnInserirMensagm = new JButton("Enviar");
		btnInserirMensagm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					String nome = txtNome.getText();
					String msgtxt = textArea.getText();
					IChatAula objChat;

					objChat = (IChatAula) Naming.lookup("rmi://localhost:8282/chat");

					Message msg = new Message(nome, msgtxt);
					
					objChat.sendMenssage(msg);
					textArea.setText("");

				} catch (MalformedURLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (RemoteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (NotBoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});
		btnInserirMensagm.setBounds(281, 296, 111, 23);
		getContentPane().add(btnInserirMensagm);

		JButton btnGerarLog = new JButton("Gerar LOG");
		btnGerarLog.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				GerarTxt();

			}
		});
		btnGerarLog.setBounds(282, 330, 110, 23);
		getContentPane().add(btnGerarLog);

		JButton btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});

		btnSair.setBounds(281, 370, 111, 23);
		getContentPane().add(btnSair);

		

		JLabel lblInformeSeuNome = new JLabel("Informe seu Nome:");
		lblInformeSeuNome.setBounds(10, 9, 136, 14);
		getContentPane().add(lblInformeSeuNome);

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
			// Instancia a classe MessageDB para gerar o select no bd
			MessageDB db = new MessageDB();
			List<Mensagem> lstmsg = db.selectAll();// joga em uma lista o retorno

			for (Mensagem mensagem : lstmsg) {
				// utiliza o if ternario para verificar se o campo esta null se
				// tiver coloca algo no lugar
				String mensagemFormatada = MessageFormat.format("{0} - {1} : {2} ", mensagem.getDt(),
						mensagem.getUser() != null ? mensagem.getUser() : "Não Informado",
						mensagem.getMessage() != null ? mensagem.getMessage() : "Conversa Encerrada");
				bw.println(mensagemFormatada);
			}
			bw.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}

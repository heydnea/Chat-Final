import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.Naming;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import br.com.proj.controller.MessageDB;
import br.com.proj.model.Mensagem;
import net.miginfocom.swing.MigLayout;

public class JFramePrincipal extends JFrame {

	private JPanel contentPane;
	private JButton btnIniciarConversa;
	private JLabel label;
	private JButton btnSair;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFramePrincipal frame = new JFramePrincipal();
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
	public JFramePrincipal() {
		setTitle("Principal");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 364, 250);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		btnIniciarConversa = new JButton("Iniciar Conversa");
		btnIniciarConversa.setBounds(10, 78, 141, 23);
		btnIniciarConversa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//Chama a tela de mensagem 
				JFrameMensagem frameMsg = new JFrameMensagem();
				frameMsg.setVisible(true);
			}
		});
		
		label = new JLabel("");
		label.setBounds(45, 78, 0, 0);
		contentPane.add(label);
		contentPane.add(btnIniciarConversa);
		
		
		btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnSair.setBounds(185, 78, 107, 23);
		contentPane.add(btnSair);
		

		
	}
}

import javax.swing.JPanel;
import javax.swing.JDesktopPane;
import java.awt.Label;
import java.awt.TextField;

public class JPanelPrincipal extends JPanel {

	/**
	 * Create the panel.
	 */
	public JPanelPrincipal() {
		
		Label lblNome = new Label("Qual \u00E9 o seu nome ?");
		lblNome.setAlignment(Label.CENTER);
		add(lblNome);
		
		JDesktopPane desktopPane = new JDesktopPane();
		add(desktopPane);
		
		TextField txtNome = new TextField();
		add(txtNome);

	}

}

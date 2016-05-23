package disp;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MyFrame extends JFrame {

	public MyFrame() {

		this.setTitle("Ma première fenêtre Java");

		this.setSize(400, 100);

		this.setLocationRelativeTo(null);

		// Instanciation d'un objet JPanel

		JPanel pan = new JPanel();

		// On prévient notre JFrame que notre JPanel sera son content pane

		this.setContentPane(pan);

		this.setVisible(true);

	}

}

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Vital {
	private JFrame frame;

	Vital() {
		setFrame();
	}

	private void setFrame() {
		frame = new JFrame("View");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(305, 327);
		frame.setLocationRelativeTo(null);
		setActuators();
		frame.setVisible(true);
	}

	private void setActuators() {
		Model model = new Model();
		View view = new View(model);
		Controller control = new Controller(model, view);
		frame.add(view);
		LoginForm login = new LoginForm();
		LoginLogic logLogic = new LoginLogic(login);
		logLogic.addObserver(control);
		frame.add(login);
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new Vital();
			}
		});
	}
}

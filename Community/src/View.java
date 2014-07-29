import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.util.Observable;
import java.util.Observer;

import javax.swing.*;

public class View extends JComponent implements Observer {
	private int figureSize = 10;
	private Model model;

	public View(Model model) {
		this.model = model;
		model.addObserver(this);
	}

	public void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		Rectangle2D player = new Rectangle2D.Double(model.getX(), model.getY(),
				figureSize, figureSize);
		g2.setColor(new Color(94, 94, 94));
		for (int a = 0; a < 100; a++)
			for (int b = 0; b < 100; b++) {
				g2.fill(new Rectangle2D.Double(a * figureSize, b * figureSize,
						figureSize, figureSize));
			}
		g2.setColor(new Color(30, 30, 30));
		g2.fill(player);
	}

	public void update(Observable observ, Object obj) {
		repaint();
	}
}

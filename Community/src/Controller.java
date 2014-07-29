import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Observable;
import java.util.Observer;

public class Controller implements Observer {
	private Model model;
	private View view;
	private long lastUPD;

	public Controller(Model model, View view) {
		this.model = model;
		this.view = view;
		attachListener();
	}

	private void attachListener() {
		view.setFocusable(true);
		view.addKeyListener(new KeyListener() {

			public void keyPressed(KeyEvent e) {
				long callTime = System.currentTimeMillis();
				if (callTime - lastUPD < 20) {
					return;
				}
				System.out.println(System.currentTimeMillis() - lastUPD);
				model.moveTo(e.getExtendedKeyCode());
				lastUPD = System.currentTimeMillis();
			}

			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
			}

			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
			}
		});
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}
}

import java.util.Observable;

public class Model extends Observable {
	private int x, y;
	private int step;

	public Model() {
		initialize();
	}

	private void initialize() {
		x = 10;
		y = 10;
		step = 15;
	}

	public void moveTo(int keyCode) {
		if (keyCode == 37) {
			x -= step;
			setChanged();
			notifyObservers();
			return;
		}
		if (keyCode == 38) {
			y -= step;
			setChanged();
			notifyObservers();
			return;
		}
		if (keyCode == 39) {
			x += step;
			setChanged();
			notifyObservers();
			return;
		}
		if (keyCode == 40) {
			y += step;
			setChanged();
			notifyObservers();
			return;
		}
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
}

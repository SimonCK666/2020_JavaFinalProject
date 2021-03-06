import javax.swing.JFrame;

public abstract class View<T extends Controller> extends JFrame implements ModelListener {
	// create the protected variables
	protected Bank m;
	protected T c; 
	
	public View(Bank m, T c) {
		// create the constructor
		this.m = m;
		this.c = c;
	}
	
	// the abstract method
	public abstract void update();
}

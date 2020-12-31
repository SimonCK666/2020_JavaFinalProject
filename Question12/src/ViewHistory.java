import javax.swing.JFrame;

public class ViewHistory extends View {
	public ViewHistory(Bank m, ControllerHIstory c) {
		// create the constructor
		super(m, c);
		
		m.addListeners(this);
		
		HIstoryPanel hp = new HIstoryPanel(m);
		
		// set windows
		this.setTitle("View Hostory");
		this.setSize(400 ,300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// add hp
		this.add(hp);
		
		this.setVisible(true);
	}
	
	@Override
	public void update() {
		// repaint it
		repaint();
	}
}

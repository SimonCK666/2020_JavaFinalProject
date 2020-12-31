import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class ViewSimple extends JFrame implements ModelListener {
	// create the instance variables
	private Bank m;
	private ControllerSimple c;
	private JLabel label;
	
	public ViewSimple(Bank m, ControllerSimple c) {
		// create the constructor
		m.addListeners(this);
		// creates a JLabel object, stores it in the label instance variable of the ViewSimple clas
		label = new JLabel("Total money: " + m.totalMoney(), JLabel.CENTER);
		
		this.setTitle("View Simple");
		this.setSize(400, 300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new GridLayout());
		
		this.add(label);
		
		this.setVisible(true);
	}
	
	public void update() {
		label.setText("The total money in the bank is: " + m.totalMoney());
	}
}

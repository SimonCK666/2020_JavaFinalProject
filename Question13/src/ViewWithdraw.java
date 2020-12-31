import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class ViewWithdraw extends View<ControllerWithdraw> {
	private JTextField t1;
	private JTextField t2;
	
	public ViewWithdraw(Bank m, ControllerWithdraw c) {
		// create the constructor
		super(m, c);
		
		// add listener
		m.addListeners(this);
		
		t1 = new JTextField("Type a customer name here");
		t2 = new JTextField("Type an amount of money here");
		
		// Create the button
		JButton jb = new JButton("Withdraw");
		
		// add action listener
		jb.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String str = c.withdraw(t1.getText(), t2.getText());
				
				if(str != null) {
					JOptionPane.showMessageDialog(null, str);
				}
			}
		});
		
		// set the windows
		this.setTitle("View Withdraw");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(400,  300);
		
		// use the GridLayout
		this.setLayout(new GridLayout(3, 0, 0, 0));
		
		// add t1, t2
		this.add(t1);
		this.add(t2);
		
		this.add(jb);
		
		this.setVisible(true);
	}
	
	@Override 
	public void update() {
		/*
		 * The update method of the ViewWithdraw class does nothing, 
		 * because the ViewWithdraw class does not graphically display 
		 * any data from the bank (the model)
		 */
	}
}

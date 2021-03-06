import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class ViewCreate extends View<ControllerCreate> {
	private JTextField t1;
	private JTextField t2;
	private JComboBox<String> cb;
	
	public ViewCreate(Bank m, ControllerCreate c) {
		// create the constructor
		super(m, c);
		
		// add listener
		m.addListeners(this);
		
		t1 = new JTextField("Type a new customer name here");
		t2 = new JTextField("Type an amount of money here");
		
		cb = new JComboBox<String>();
		
		// create a button
		JButton jb = new JButton("Create");
		
		// add action listener
		jb.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String str = c.create(t1.getText(), t2.getText(), cb.getSelectedIndex());
				
				if(str != null) {
					JOptionPane.showConfirmDialog(null, str);
				}
			}
		});
		
		//  set the window
		this.setTitle("View Create");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(400, 300);
		
		// use the GridLayout
		this.setLayout(new GridLayout(4, 0, 0, 0));
		
		// add t2, t2
		this.add(t1);
		this.add(t2);
		
		this.add(cb);
		this.add(jb);
		
		this.setVisible(true);
		
	}
	
	@Override
	public void update() {
		/*
		 * The update method of the ViewCreate class does nothing, 
		 * because the ViewCreate class does not graphically display 
		 * any data from the bank (the model).
		 */
	}
}

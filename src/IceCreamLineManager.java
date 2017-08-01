import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * IceCreamLineManager is a GUI application with JButtons to add a
 * random order to the line and to remove the next order from the line.
 * 
 * @author Xueying Xu (Shirley)
 * @version Assignment 6
 */
public class IceCreamLineManager extends JPanel implements ActionListener {
	
	private IceCreamLine line;
	
	private JButton randomOrderButton;
	
	private JButton serveNextButton;
	
	/**
	 * Constructor.
	 */
	public IceCreamLineManager() {
		
		super( new BorderLayout() );
		
		// Create the buttons at the top
		addControls();
		
		line = new IceCreamLine();
		
		add(line, BorderLayout.CENTER);
		
	}
    
	// Create the buttons and the JPanel to contain and display them.
	private void addControls() {
		
		// Create the two buttons
		randomOrderButton = new JButton("Add a random order");
		
		randomOrderButton.addActionListener(this);
		
		serveNextButton = new JButton("Serve the next order");
		
		serveNextButton.addActionListener(this);
		
		// Create a JPanel for the two buttons
		JPanel buttonsPanel = new JPanel(new GridLayout(2, 1));
		
		buttonsPanel.add(randomOrderButton);
		
		buttonsPanel.add(serveNextButton);
		
		// add the JPanel at the top
		add(buttonsPanel, BorderLayout.NORTH);
		
	}
	
	/**
	 * Required by ActionListener.
	 * 
	 * @param e the click
	 */
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == randomOrderButton) {
			
			line.addRandomOrder();
			
		} else if (e.getSource() == serveNextButton) {
			
			line.removeOrder();
		}
		
	}
	
}

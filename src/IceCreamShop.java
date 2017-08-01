import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * IceCreamShop builds off of the queue-based IceCreamLine and the stack-based IceCreamMaker.
 * The user can create the ice cream and serve it to the next order in line.
 * 
 * @author Xueying Xu (Shirley)
 * @version Assignment 6
 */

public class IceCreamShop extends JPanel implements ActionListener {
	
	/** Points awarded **/
	public final int CORRECT_MATCH_SCORE = 10;
	
	/** Points subtracted **/
	public final int INCORRECT_MATCH_SCORE = -5;
	
	/** Instructions displayed at the top **/
	public final String INSTRUCTIONS = "<html>Make ice cream cones to match the next order (at the top).<br>"
			+ "Every correct order served earns you 10 points.<br>" + "Make the wrong cone and you'll lose 5 points.<br></html>";
	
	private IceCreamMaker maker;
	
	private IceCreamLine line;
	
	private int score = 0;
	
	private JLabel scoreLabel;
	
	private JButton serveNextButton;
	
	private JButton orderButton;
	
	/**
	 * Constructor.
	 */
	public IceCreamShop() {
		
		super( new BorderLayout() );
		
		maker = new IceCreamMaker();
		
		line = new IceCreamLine();
		
		add(addInstructionsPanel(), BorderLayout.NORTH);
		
		add(addControlPanel(), BorderLayout.CENTER);
		
	}
	
	// Create a JPanel for the order area which includes the line and the orderButton.
	private JPanel addOrderArea() {
		
		orderButton = new JButton("Add a random order");
		
		orderButton.addActionListener(this);
		
		JPanel orderArea = new JPanel( new BorderLayout() );
		
		orderArea.add(line, BorderLayout.CENTER);
		
		orderArea.add(orderButton, BorderLayout.SOUTH);
		
		return orderArea;
	}
	
	// Create a JPanel for the serveNextButton and another JPanel which includes
	// the order area and the ice cream maker area.
	private JPanel addControlPanel() {
		
		serveNextButton = new JButton("Serve the next order");
		
		serveNextButton.addActionListener(this);
		
		// a JPanel for displaying the order area and the maker area
		JPanel gamePanel = new JPanel( new BorderLayout() );
		
		gamePanel.add( addOrderArea(), BorderLayout.WEST );
		
		gamePanel.add(maker, BorderLayout.EAST);
		
		JPanel controlPanel = new JPanel( new BorderLayout() );
		
		controlPanel.add(serveNextButton, BorderLayout.NORTH);
		
		controlPanel.add(gamePanel, BorderLayout.CENTER);
		
		return controlPanel;
		
	}
	
	// Create a JPanel for displaying the instructions and the score
	// at the top.
	private JPanel addInstructionsPanel() {
		
		JPanel instructionsPanel = new JPanel( new GridLayout(2, 1) );
		
		JLabel instructionsLabel = new JLabel(INSTRUCTIONS);
		
		scoreLabel = new JLabel("Score: " + score);
		
		instructionsPanel.add(instructionsLabel);
		
		instructionsPanel.add(scoreLabel);
		
		return instructionsPanel;
		
	}
	
	// update the score at the top
	private void updateScore() {
		
		scoreLabel.setText("Score: " + score);
	}
	
	
	/**
	 * Serve the ice cream cone made by the user to the next order in the line.
	 */
	public void serve() {
		
		// the next order in the line (could be null)
		IceCreamCone nextOrder = line.getNextOrder();
		
		// the ice cream cone made by the user
		IceCreamCone madeCone = maker.getCone();
		
		// check match or not only if there is an actual order in the line
		if (nextOrder != null) {
		
		   if ( match(nextOrder, madeCone) ) {
			   
			   // update the score
			   score = score + CORRECT_MATCH_SCORE;
			
			   updateScore();
			   
			   // remove the order from the view of the line
			   line.removeOrder();
			   
			   // reset the ice cream maker so new ice cream cones can be created
			   maker.reset();
			
		   } else {
			   
			   // update the score
			   score = score + INCORRECT_MATCH_SCORE;
			
			   updateScore();
			   
			   // remove the order from the view of the line
			   line.removeOrder();
			   
			   // reset the ice cream maker so new ice cream cones can be created
			   maker.reset();
		   
		   }
		
		}
		
	}
	
	
	/**
	 * Check if two ice cream cones are the same.
	 * @param c1 the first ice cream cone
	 * @param c2 the second ice cream cone
	 * @return true iff the two ice cream cones are the same.
	 */
	private boolean match(IceCreamCone c1, IceCreamCone c2) {
		
		// two ice cream cones are the same iff the string
		// representations of their scoopFlavorStack are the same
		String cone1 = c1.getScoopFlavorStack().toString();
		
		String cone2 = c2.getScoopFlavorStack().toString();
		
		return cone1.equals(cone2);
					
	}
	
	/**
	 * Required by ActionListener.
	 * 
	 *  @param e the action event
	 */
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == serveNextButton) {
			
			serve();
			
		} else if (e.getSource() == orderButton) {
			
			line.addRandomOrder();
		}
	
	}

}

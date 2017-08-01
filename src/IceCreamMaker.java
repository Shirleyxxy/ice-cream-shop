import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * IceCreamMaker uses the ice cream cone class to add and remove scoops from a cone.
 * 
 * @author Xueying Xu (Shirley)
 * @version Assignment 6
 */

public class IceCreamMaker extends JPanel implements ActionListener {

    private IceCreamCone cone;
    
    private JButton peach;
    
    private JButton blueberry;
    
    private JButton caramel;
    
    private JButton greenTea;
    
    private JButton trashButton;
    
    /**
     * Constructor.
     */
    public IceCreamMaker() {
    	
    	super( new BorderLayout() );
    	
    	cone = new IceCreamCone();
    	
    	add(addPanel(), BorderLayout.NORTH);
    	
    	add(cone, BorderLayout.CENTER);
    	
    }
    
    // Create a JPanel which has four JButtons for users to choose 
    // the flavors and one additional JButton to remove the top scoop
    private JPanel addPanel() {
    	
    	JPanel buttonsPanel = new JPanel(new GridLayout(2, 1));
    	
    	buttonsPanel.add(createFlavorMenu());
    	
    	buttonsPanel.add(createTrashButton());
    	
    	return buttonsPanel;
    	
    }
    
    // Create a JPanel menu with four JButtons for ice cream flavors
    private JPanel createFlavorMenu() {
    	
    	JPanel menu = new JPanel(new GridLayout(1, 4));
    	
    	// the peach JButton
        peach = new JButton("peach");
    	
    	peach.addActionListener(this);
    	
    	peach.setBackground(new Color(254, 207, 217));
    	
    	peach.setBorderPainted(false);
    	
    	peach.setOpaque(true);
    	
    	// the blueberry JButton
    	blueberry = new JButton("blueberry");
    	
    	blueberry.addActionListener(this);
    	
    	blueberry.setBackground(new Color(198, 211, 254));
    	
    	blueberry.setBorderPainted(false);
    	
    	blueberry.setOpaque(true);
    	
    	// the caramel JButton
    	caramel = new JButton("caramel");
    	
    	caramel.addActionListener(this);
    	
    	caramel.setBackground(new Color(238, 203, 173));
    	
    	caramel.setBorderPainted(false);
    	
    	caramel.setOpaque(true);
    	
    	// the green tea JButton
    	greenTea = new JButton("green tea");
    	
    	greenTea.addActionListener(this);
    	
    	greenTea.setBackground(new Color(185, 255, 218));
    	
    	greenTea.setBorderPainted(false);
    	
    	greenTea.setOpaque(true);
    	
    	// add four flavors to the menu
    	menu.add(peach);
    	
    	menu.add(blueberry);
    	
    	menu.add(caramel);
    	
    	menu.add(greenTea);
    	
    	return menu;
    	 	
    }
    
    // Create a JButton for removing the top scoop
    private JButton createTrashButton() {
    	
    	trashButton = new JButton("Trash the top scoop!");
    	
    	trashButton.addActionListener(this);
    	
    	return trashButton;
    	
    }
	
    /**
     * Remove the top scoop or add a scoop of a particular flavor
     * based on the source of each click.
     * 
     * @param e the click
     */
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == trashButton) {
			
			cone.popTopScoop();
					
		} else if (e.getSource() == peach) {
			
			cone.addScoop("peach");
			
		} else if (e.getSource() == blueberry) {
			
			cone.addScoop("blueberry");
		
		} else if (e.getSource() == caramel) {
			
			cone.addScoop("caramel");

		} else if (e.getSource() == greenTea) {
			
			cone.addScoop("green tea");
		}
		
		// update the view of the ice cream
		repaint();
		
	}
	
	/**
	 * Get the ice cream cone.
	 * @return cone the ice cream cone
	 */
	public IceCreamCone getCone() {
		
		return cone;
	
	}
	
	/**
	 * Reset the ice cream maker by emptying the stack.
	 * Repaint the view of the scoops.
	 */
	public void reset() {
		
		while (!cone.getScoopFlavorStack().isEmpty()) {
			
			cone.popTopScoop();
	    }
		
		repaint();
		
	}

}

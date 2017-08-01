import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JComponent;

/**
 * IceCreamCone maintains a stack of ice cream scoop flavors.
 * It also creates the view of the ice cream cone.
 * 
 * @author Xueying Xu (Shirley)
 * @version Assignment 6
 */

public class IceCreamCone extends JComponent{
    
	/** An array of ice cream flavors **/
	public static final String[] FLAVORS = {"peach", "blueberry", "caramel", "green tea"};
	
	/** An array of ice cream colors **/
	public static final Color[] PAINT_COLORS = { new Color(254, 207, 217), new Color(198, 211, 254), 
		
		                                         new Color(238, 203, 173), new Color(185, 255, 218) };
			
	public static final int CONE_WIDTH = 25;
	
	public static final int CONE_HEIGHT = 45;
	
	public static final int SCOOP_DIAMETER = 40;
	
	public static final int OVERLAP = 10;
	
	// an instance of StackLL to maintain a stack of ice cream scoop flavors
	private StackLL<String> scoopFlavorStack;
	
	/**
	 * Constructor.
	 */
	public IceCreamCone() {
		
		super();
		
		scoopFlavorStack = new StackLL<String>();
		
	}
    
	/**
	 * Get the stack for scoops.
	 * 
	 * @return scoopFlavorStack
	 */
	public StackLL<String> getScoopFlavorStack() {
		
		return scoopFlavorStack;
			
	}
	
	/**
	 * Add a scoop of the flavor indicated to the top of the ice cream cone.
	 * 
	 * @param flavor the flavor to be added
	 */	
	public void addScoop(String flavor) {
		
		scoopFlavorStack.push(flavor);
    
	}
	
	/**
	 * Add a scoop of a random flavor to the top of the ice cream cone.
	 */	
	public void addRandomScoop() {
		
		int flavorIdx = (int) (Math.random() * 4);
		
		if (flavorIdx == 0) {
			
		    addScoop(FLAVORS[0]);
		
		} else if (flavorIdx == 1) {
			
			addScoop(FLAVORS[1]);
			
		} else if (flavorIdx == 2) {
			
			addScoop(FLAVORS[2]);
			
		} else {
			
			addScoop(FLAVORS[3]);
		}
		
	}
	
	/**
	 * Pop out the scoop on the top of the ice cream cone.
	 * 
	 * @return the flavor popped out
	 */
	public String popTopScoop() {
		
		return scoopFlavorStack.pop();
	
	}


	/**
	 * Paint the view of the ice cream.
	 * 
	 * @param g the Graphics object to paint the ice cream.
	 */
	public void paint(Graphics g) {
		
		paintCone(g);
		
		paintScoops(g);
		
	}
	
	// Paint the view of the ice cream cone.
	public void paintCone(Graphics g) {
		
		g.setColor(new Color(255, 203, 133));
		
		int x1 = getWidth() / 2;
		
		int x2 = getWidth() / 2 - CONE_WIDTH / 2;
		
		int x3 = getWidth() / 2 + CONE_WIDTH / 2;
		
		int y1 = getHeight();
		
		int y2 = getHeight() - CONE_HEIGHT;
		
		int y3 = getHeight() - CONE_HEIGHT;
		
		// x-coordinates of the three vertices of the cone
		int[] xPoints = {x1, x2, x3};
		
		// y-coordinates of the three vertices of the cone
		int[] yPoints = {y1, y2, y3};
		
		g.fillPolygon(xPoints, yPoints, 3);
		
	}
	
	
	// Paint a single ice cream scoop.
	private void paintScoop(Graphics g, int flavorIndex, int x, int y) {
		
		g.setColor(PAINT_COLORS[flavorIndex]);
		
		g.fillOval(x, y, SCOOP_DIAMETER, SCOOP_DIAMETER);
		
	}
	
	/** 
	 * Get the index of a specific flavor in the array of flavors.
	 * 
	 * @param flavor the ice cream flavor
	 * @return the corresponding index in the array
	 */
	private int findFlavorIndex(String flavor) {
		
		if (flavor.equals("peach")) {
			
			return 0;
		
		} else if (flavor.equals("blueberry")) {
			
			return 1;
		
		} else if (flavor.equals("caramel")) {
			
			return 2;
		
		} else {
			
			return 3;
		}
		
	}
	
	/**
	 * Paint the view of the current ice cream scoops.
	 * 
	 * @param g the Graphics object to paint all the ice cream scoops.
	 */
	private void paintScoops(Graphics g) {
		
		// a temporary stack to help display all the scoops in the right order
		StackLL<String> tempStack = new StackLL<String>();
		
		// move the scoops from the original stack to the temporary stack one by one
		while (!scoopFlavorStack.isEmpty()) {
			
			tempStack.push(scoopFlavorStack.pop());
			
		}
		
		// x-coordinate of the first scoop
		int x = getWidth() / 2 - SCOOP_DIAMETER / 2;
		
		// y-coordinate of the first scoop
		int y = getHeight() - CONE_HEIGHT - SCOOP_DIAMETER + OVERLAP;
		
		while (!tempStack.isEmpty()) {
			
			String currentFlavor = tempStack.pop();
			
			int flavorIndex = findFlavorIndex(currentFlavor);
			
			// paint the current scoop
			paintScoop(g, flavorIndex, x, y);
			
			// put the scoop back to the original stack after painting it
			scoopFlavorStack.push(currentFlavor);
			
			// update the y-coordinate for the next scoop
			y = y - SCOOP_DIAMETER + OVERLAP;
					
		}
		
	}

}

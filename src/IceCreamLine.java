import javax.swing.Box;
import javax.swing.BoxLayout;

/**
 * IceCreamLine maintains a queue of ice cream cone orders.
 * It also creates the view of the ice cream order line.
 * 
 * @author Xueying Xu (Shirley)
 * @version Assignment 6
 */

public class IceCreamLine extends Box {
	
	private QueueLL<IceCreamCone> orderLine;
	
	/**
	 * Constructor.
	 */
	public IceCreamLine() {
		
		// add components vertically
		super( BoxLayout.Y_AXIS );
		
		orderLine = new QueueLL<IceCreamCone>();
			
	}
    
	/**
	 * Check if there is an order in the line.
	 * 
	 * @return true iff the order line is not empty.
	 */
	public boolean hasOrder() {
		
		return ( !orderLine.isEmpty() );
		
	}
	
	/**
	 * Add a specific ice cream cone to the order line.
	 * 
	 * @param cone the ice cream cone
	 */
	public void addOrder(IceCreamCone cone) {
		
		orderLine.enqueue(cone);
		
		// add a component
		add(cone);
		
		// added a component
		validate();
		
		// repaint the change
		repaint();
		
	}

	
	/**
	 * Add a random ice cream cone to the order line.
	 */
	public void addRandomOrder() {
		
		IceCreamCone cone = new IceCreamCone();
		
		// each order is an ice cream cone with between 1 and 4 random scoop flavors
		int numScoops = (int) (Math.random() * 4 + 1);
		
		for (int i = 0; i < numScoops; i++) {
			
			cone.addRandomScoop();
			
		}
		
		addOrder(cone);
		
	}
	
	/**
	 * Remove an order from the order line.
	 */
	public void removeOrder() {
		
		if (!orderLine.isEmpty()) {
			
			IceCreamCone nextCone = orderLine.dequeue();
			
			// remove a component
			remove(nextCone);
			
			// removed a component
			validate();
			
			// repaint the change
			repaint();	
			
		}
			
	}
   
   /**
    * Get the next ice cream order.
    * 
    * @return the next ice cream cone order
    */
   public IceCreamCone getNextOrder() {
	   
      return orderLine.peek();
	   
   }
	
}

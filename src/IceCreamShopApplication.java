import javax.swing.JFrame;

/**
 * IceCreamShopApplication is the class to test out the ice cream shop program.
 * 
 * @author Xueying Xu (Shirley)
 * @version Assignment 6
 */

public class IceCreamShopApplication {
	
	/**
	 * Creates a JFrame that holds the IceCreamShop.
	 **/
	public static void main(String[] args) {
		
		JFrame guiFrame = new JFrame( "Shirley's Ice Cream Shop" );
		
		guiFrame.setSize( 850, 700 );

		guiFrame.add( new IceCreamShop() );
				
		// Exit normally on closing the window
		guiFrame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

		// Show frame
		guiFrame.setVisible( true );

	}

}

import javax.swing.JFrame;

/**
 * IceCreamManagerApplication is the class to test out the ice cream line manager program.
 * 
 * @author Xueying Xu (Shirley)
 * @version Assignment 6
 */
public class IceCreamManagerApplication {
    
	/**
	 * Creates a JFrame that holds the IceCreamLineManager.
	 **/
	public static void main(String[] args) {
		
		JFrame guiFrame = new JFrame( "Ice cream line" );
		
		guiFrame.setSize( 350, 750 );

		guiFrame.add( new IceCreamLineManager() );
				
		// Exit normally on closing the window
		guiFrame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

		// Show frame
		guiFrame.setVisible( true );
		
	}

}

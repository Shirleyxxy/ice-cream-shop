import javax.swing.JFrame;
/**
 * IceCreamMakerApplication is the class to test out the ice cream cone maker program.
 * 
 * @author Xueying Xu (Shirley)
 * @version Assignment 5
 */

public class IceCreamMakerApplication {
    
	/**
	 * Creates a JFrame that holds the IceCreamMaker.
	 * 
	 **/
	public static void main(String[] args) {
		
			JFrame guiFrame = new JFrame( "Ice cream cone maker" );
					
			guiFrame.setSize( 450, 600 );

			guiFrame.add( new IceCreamMaker() );
					
			// Exit normally on closing the window
			guiFrame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

			// Show frame
			guiFrame.setVisible( true );

	}

}

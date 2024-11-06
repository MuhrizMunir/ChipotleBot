import kareltherobot.*;

public class JumpThoseHurdles {
  // Find the hurdle with the max height!!
  // This is the Robot we will use to jump the hurdles
  
	Robot hurdler = new Robot(1,1,Directions.East, 0); // What is different about the 
													//	location of this line of code?
	
	public static void main(String[] args) {
		new JumpThoseHurdles().start();
	}

	public void start() {
		loadWorld();
		
		int w = 0; //This creates a variable to save your width
    	int h = 0; //This creates a variable to save your height.

		w = findHurdle(); //Discuss with your partner what this line of code is intended to do.
		h = climbHurdle();
  
    
		clearHurdle();
		
	}

	/**
	 * This method assumes the Robot is named hurdler and is facing East
	 * This moves hurdler to the next wall (hurdle). It returns the number
	 * of moves it took to get to the hurdle.
   * When the method is called. It will return an int. You can set it to anything you want
	 */
	private int findHurdle() {

		return 0;
	}
	/**
	 * This method assumes the Robot is named hurdler, is facing East and
	 * is at the base of the hurdle. 
	 * This moves the Robot to the top of the hurdle so that it can clear
	 * the wall.  
	 * @return The number of steps to get above the hurdle (height)
	 */
	private int climbHurdle() {
		
		return 0;
	}

	/** 
	 * Moves the Robot (hurdler) over the wall and moves it to the ground so 
	 * that the Robot has its back to the hurdle and is facing the next one.
	 */
	private void clearHurdle() {
		
	}

	private void loadWorld() {
		// line below "hardcodes" this to use one specific world
		// it would be better to ask the user...
		String worldName = "Worldb.wld";
		World.readWorld(worldName);
		World.setVisible(true);
		World.setDelay(5);
	}

}

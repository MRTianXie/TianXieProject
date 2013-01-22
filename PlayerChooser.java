package basicUserInterface;

import princeton.stdlib.*;

public class PlayerChooser implements CourtAndPlayerProvider{
	
	private final int BACKGROUND_CENTER_X = 200;
	private final int BACKGROUND_CENTER_Y = 200;
	private final int BACKGROUND_SIZE = 450;
	private final int MAX_DISTANCE = 70;
	private final int BACK_CENTER_X = 350;
	private final int BACK_CENTER_Y = 50;
	private final int BUTTON_SIZE = 50;
	private double x;
	private double y;
	
	public PlayerChooser() {
		StdDraw.picture(BACKGROUND_CENTER_X, BACKGROUND_CENTER_Y,
				"res//BCourlt1.jpg", BACKGROUND_SIZE, BACKGROUND_SIZE);
		StdDraw.picture(BACK_CENTER_X, BACK_CENTER_Y, "res//back.png", BUTTON_SIZE, BUTTON_SIZE);
		
		while(true) {
			if(StdDraw.mousePressed()) {
				StdDraw.show(20);
				this.x = StdDraw.mouseX();
				this.y = StdDraw.mouseY();
				if((Math.sqrt(Math.pow((this.x - BACK_CENTER_X), 2)
						+ Math.pow((this.y - BACK_CENTER_Y), 2)) <= MAX_DISTANCE)) {
					clearXY();
					StdDraw.show(20);
					new MyUserInterface();
				}
			}
		}
	}
	
	private void clearXY() {
		this.x = 0;
		this.y = 0;
	}
}

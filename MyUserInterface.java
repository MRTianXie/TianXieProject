package basicUserInterface;

import princeton.stdlib.*;

public class MyUserInterface implements CourtAndPlayerProvider{
	
	private final int START_CENTER_X = 50;
	private final int START_CENTER_Y = 300;
	private final int COURT_CENTER_X = 50;
	private final int COURT_CENTER_Y = 200;
	private final int PLAYER_CENTER_X = 50;
	private final int PLAYER_CENTER_Y = 100;
	private final int BUTTON_SIZE = 50;
	private final int BACKGROUND_CENTER_X = 200;
	private final int BACKGROUND_CENTER_Y = 200;
	private final int BACKGROUND_SIZE = 450;
	private final int MAX_DISTANCE = 70;
	private double x;
	private double y;

	public MyUserInterface() {		
		StdDraw.picture(BACKGROUND_CENTER_X, BACKGROUND_CENTER_Y,
				"res//BCourlt1.jpg", BACKGROUND_SIZE, BACKGROUND_SIZE);
		StdDraw.picture(START_CENTER_X, START_CENTER_Y, "res//start3.png", BUTTON_SIZE, BUTTON_SIZE);
		StdDraw.picture(COURT_CENTER_X, COURT_CENTER_Y, 
				"res//CourtButton.png", BUTTON_SIZE, BUTTON_SIZE);
		StdDraw.picture(PLAYER_CENTER_X, PLAYER_CENTER_Y, 
				"res//PlayerButton.png", BUTTON_SIZE, BUTTON_SIZE);
		
		while(true) {
			if(StdDraw.mousePressed()) {
				StdDraw.show(20);
				this.x = StdDraw.mouseX();
				this.y = StdDraw.mouseY();
				if((Math.sqrt(Math.pow((this.x - START_CENTER_X), 2)
						+ Math.pow((this.y - START_CENTER_Y), 2)) <= MAX_DISTANCE)) {
					clearXY();
					new Gaming();
				}
			}
			
			if(StdDraw.mousePressed()) {
				StdDraw.show(20);
				this.x = StdDraw.mouseX();
				this.y = StdDraw.mouseY();
				if((Math.sqrt(Math.pow((this.x - COURT_CENTER_X), 2)
						+ Math.pow((this.y - COURT_CENTER_Y), 2)) <= MAX_DISTANCE)) {
					clearXY();
					new CourtChooser();
				}
			}
			
			if(StdDraw.mousePressed()) {
				StdDraw.show(20);
				this.x = StdDraw.mouseX();
				this.y = StdDraw.mouseY();
				if((Math.sqrt(Math.pow((this.x - PLAYER_CENTER_X), 2)
						+ Math.pow((this.y - PLAYER_CENTER_Y), 2)) <= MAX_DISTANCE)) {
					clearXY();
					new PlayerChooser();
				}
			}
		}		
	}
	
	private void clearXY() {
		this.x = 0;
		this.y = 0;
	}
}
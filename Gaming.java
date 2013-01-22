package basicUserInterface;

import java.awt.event.KeyEvent;

import princeton.stdlib.*;

public class Gaming implements CourtAndPlayerProvider{
	
	private final int BACKGROUND_CENTER_X = 200;
	private final int BACKGROUND_CENTER_Y = 200;
	private final int BACKGROUND_SIZE = 450;
	private final int BALL_WIDTH = 200;
	private final int BALL_HEIGHT = 130;
	private final int LEFTSIDE_X = 0;
	private final int LEFTSIDE_Y = 200;
	private final int CENTER_X = 200;
	private final int CENTER_Y = 0;
	private final int RIGHTSIDE_X = 400;
	private final int RIGHTSIDE_Y = 200;
	private final int UP_X = 330;
	private final int UP_Y = 350;
	private final int DOWN_X = 330;
	private final int DOWN_Y = 290;
	private final int DUAL_X = 330;
	private final int DUAL_Y = 320;
	private final int RIGHT_X = 360;
	private final int RIGHT_Y = 320;
	private final int LEFT_X = 300;
	private final int LEFT_Y = 320;
	private final int DIRECTION_SYMBOL_SIZE = 25;
	private final int movingDegreeInc = 72;
	private final int inHandDegreeInc = 72;
	
	private boolean leftToRight = true;
	private int degreeOfBall = 0;
	private int mskCounter = 0;
	private int bingoCounter = 0;
	
	public Gaming() {
		
		int i = 0;
		int increment = 10;
		int model;
		
		while(true) {
			if(mskCounter > 5) {
				break;
			}
			increment += (bingoCounter / 7);
			model = StdRandom.uniform(0, 4);
			drawStableBackground(model);
			
			inHand();

			if(StdDraw.hasNextKeyTyped()) {
				if(model == 0) {
					if((leftToRight)&&(StdDraw.isKeyPressed(KeyEvent.VK_A))) {
						System.out.println("Bingo! Stay Left!");
						bingoCounter ++;
						while(i < 200) {
							StdDraw.clear();
							drawBackground(model);
							StdDraw.picture(LEFTSIDE_X, LEFTSIDE_Y - i,"res//BBall1.gif",
									BALL_WIDTH, BALL_HEIGHT, degreeOfBall);
							StdDraw.show(1);
							i = i + increment;
							changeDegree(movingDegreeInc);
						}
						i = 0;
						while(i < 200) {
							StdDraw.clear();
							drawBackground(model);
							StdDraw.picture(LEFTSIDE_X, i,"res//BBall1.gif", 
									BALL_WIDTH, BALL_HEIGHT, degreeOfBall);
							StdDraw.show(1);
							i = i + increment;
							changeDegree(movingDegreeInc);
						}
						i = 0;
					}
					else if((!leftToRight)&&(StdDraw.isKeyPressed(KeyEvent.VK_D))) {
						System.out.println("Bingo! Stay Right!");
						bingoCounter ++;
						while(i < 200) {
							StdDraw.clear();
							drawBackground(model);
							StdDraw.picture(RIGHTSIDE_X, RIGHTSIDE_Y - i,"res//BBall1.gif", 
									BALL_WIDTH, BALL_HEIGHT, degreeOfBall);
							StdDraw.show(1);
							i = i + increment;
							changeDegree(movingDegreeInc);
						}
						i = 0;
						while(i < 200) {
							StdDraw.clear();
							drawBackground(model);
							StdDraw.picture(RIGHTSIDE_X, i,"res//BBall1.gif", 
									BALL_WIDTH, BALL_HEIGHT, degreeOfBall);
							StdDraw.show(1);
							i = i + increment;
							changeDegree(movingDegreeInc);
						}
						i = 0;
					}
					else {
						System.out.println("Wrong!");
						mskCounter ++;
					}
				}
				
				if(model == 1) {
					if((leftToRight)&&(StdDraw.isKeyPressed(KeyEvent.VK_D))) {
						System.out.println("Bingo! Left to Right!");
						bingoCounter ++;
						while((i < 200)&&(leftToRight)) {
							StdDraw.clear();
							drawBackground(model);
							StdDraw.picture(LEFTSIDE_X + i, LEFTSIDE_Y - i,"res//BBall1.gif", 
									BALL_WIDTH, BALL_HEIGHT, degreeOfBall);
							StdDraw.show(1);
							i = i + increment;
							changeDegree(movingDegreeInc);
						}
						
						while((i >= CENTER_X)&&(i <= RIGHTSIDE_X)&&(leftToRight)) {
							StdDraw.clear();
							drawBackground(model);
							StdDraw.picture(LEFTSIDE_X + i, CENTER_Y + i - 200,"res//BBall1.gif", 
									BALL_WIDTH, BALL_HEIGHT, degreeOfBall);
							StdDraw.show(1);
							i = i + increment;
							changeDegree(movingDegreeInc);
						}
						
						i = 0;
						leftToRight = false;
					}
					else if((!leftToRight)&&(StdDraw.isKeyPressed(KeyEvent.VK_A))) {
						System.out.println("Bingo! Right to Left!");
						bingoCounter ++;
						while((i < CENTER_X)&&(!leftToRight)) {
							StdDraw.clear();
							drawBackground(model);
							StdDraw.picture(RIGHTSIDE_X - i, RIGHTSIDE_Y - i,"res//BBall1.gif", 
									BALL_WIDTH, BALL_HEIGHT, degreeOfBall);
							StdDraw.show(1);
							i = i + increment;
							changeDegree(movingDegreeInc);
						}
						
						while((i >= CENTER_X)&&(i <= RIGHTSIDE_X)&&(!leftToRight)) {
							StdDraw.clear();
							drawBackground(model);
							StdDraw.picture(RIGHTSIDE_X - i, CENTER_Y + i - 200,"res//BBall1.gif", 
									BALL_WIDTH, BALL_HEIGHT, degreeOfBall);
							StdDraw.show(1);
							i = i + increment;
							changeDegree(movingDegreeInc);
						}
						
						i = 0;
						leftToRight = true;
					}
					else {
						System.out.println("Wrong!");
						mskCounter ++;
					}
				}
				
				if(model == 2) {
					if(StdDraw.isKeyPressed(KeyEvent.VK_W)) {
						System.out.println("Bingo! Go Up!");
						bingoCounter ++;
						if(leftToRight) {
							System.out.println("Bingo! Left to Right!");
							while((i < 200)&&(leftToRight)) {
								StdDraw.clear();
								drawBackground(model);
								StdDraw.picture(LEFTSIDE_X + i, LEFTSIDE_Y - i,"res//BBall1.gif", 
										BALL_WIDTH, BALL_HEIGHT, degreeOfBall);
								StdDraw.show(1);
								i = i + increment;
								changeDegree(movingDegreeInc);
							}
							
							while((i >= CENTER_X)&&(i <= RIGHTSIDE_X)&&(leftToRight)) {
								StdDraw.clear();
								drawBackground(model);
								StdDraw.picture(LEFTSIDE_X + i, CENTER_Y + i - 200,"res//BBall1.gif", 
										BALL_WIDTH, BALL_HEIGHT, degreeOfBall);
								StdDraw.show(1);
								i = i + increment;
								changeDegree(movingDegreeInc);
							}
							
							i = 0;
							leftToRight = false;
						}
						else {
							while((i < CENTER_X)&&(!leftToRight)) {
								StdDraw.clear();
								drawBackground(model);
								StdDraw.picture(RIGHTSIDE_X - i, RIGHTSIDE_Y - i,"res//BBall1.gif", 
										BALL_WIDTH, BALL_HEIGHT, degreeOfBall);
								StdDraw.show(1);
								i = i + increment;
								changeDegree(movingDegreeInc);
							}
							
							while((i >= CENTER_X)&&(i <= RIGHTSIDE_X)&&(!leftToRight)) {
								StdDraw.clear();
								drawBackground(model);
								StdDraw.picture(RIGHTSIDE_X - i, CENTER_Y + i - 200,"res//BBall1.gif", 
										BALL_WIDTH, BALL_HEIGHT, degreeOfBall);
								StdDraw.show(1);
								i = i + increment;
								changeDegree(movingDegreeInc);
							}
							
							i = 0;
							leftToRight = true;
						}
					}
					else {
						System.out.println("Wrong!");
						mskCounter ++;
					}
				}
				
				if(model == 3) {
					if(StdDraw.isKeyPressed(KeyEvent.VK_S)) {
						System.out.println("Bingo! Go Down!");
						bingoCounter ++;
						if(leftToRight) {
							System.out.println("Bingo! Left to Right!");
							while((i < 200)&&(leftToRight)) {
								StdDraw.clear();
								drawBackground(model);
								StdDraw.picture(LEFTSIDE_X + i, LEFTSIDE_Y - i,"res//BBall1.gif", 
										BALL_WIDTH, BALL_HEIGHT, degreeOfBall);
								StdDraw.show(1);
								i = i + increment;
								changeDegree(movingDegreeInc);
							}
							
							while((i >= CENTER_X)&&(i <= RIGHTSIDE_X)&&(leftToRight)) {
								StdDraw.clear();
								drawBackground(model);
								StdDraw.picture(LEFTSIDE_X + i, CENTER_Y + i - 200,"res//BBall1.gif", 
										BALL_WIDTH, BALL_HEIGHT, degreeOfBall);
								StdDraw.show(1);
								i = i + increment;
								changeDegree(movingDegreeInc);
							}
							
							i = 0;
							leftToRight = false;
						}
						else {
							while((i < CENTER_X)&&(!leftToRight)) {
								StdDraw.clear();
								drawBackground(model);
								StdDraw.picture(RIGHTSIDE_X - i, RIGHTSIDE_Y - i,"res//BBall1.gif", 
										BALL_WIDTH, BALL_HEIGHT, degreeOfBall);
								StdDraw.show(1);
								i = i + increment;
								changeDegree(movingDegreeInc);
							}
							
							while((i >= CENTER_X)&&(i <= RIGHTSIDE_X)&&(!leftToRight)) {
								StdDraw.clear();
								drawBackground(model);
								StdDraw.picture(RIGHTSIDE_X - i, CENTER_Y + i - 200,"res//BBall1.gif", 
										BALL_WIDTH, BALL_HEIGHT, degreeOfBall);
								StdDraw.show(1);
								i = i + increment;
								changeDegree(movingDegreeInc);
							}
							
							i = 0;
							leftToRight = true;
						}
					}
					else {
						System.out.println("Wrong!");
						mskCounter ++;
					}
				}
			}
			else {
				System.out.println("Time out!");
				mskCounter ++;
			}
		}
		endGame();
	}
	
	private void changeDegree(int inc) {
		degreeOfBall = degreeOfBall + inc;
		if(degreeOfBall >= 360) {
			degreeOfBall = 0;
		}
	}
	
	private void drawStableBackground(int model) {
		
		if(model == 0) {
			if(leftToRight) {
				StdDraw.picture(BACKGROUND_CENTER_X, BACKGROUND_CENTER_Y, 
						"res//BCourlt1.jpg", BACKGROUND_SIZE, BACKGROUND_SIZE);
				StdDraw.picture(DUAL_X, DUAL_Y, "res//dual_green.png", 
						DIRECTION_SYMBOL_SIZE, DIRECTION_SYMBOL_SIZE);
				StdDraw.picture(LEFT_X, LEFT_Y, "res//left_red.png", 
						DIRECTION_SYMBOL_SIZE, DIRECTION_SYMBOL_SIZE);
				StdDraw.picture(RIGHT_X, RIGHT_Y, "res//right_green.png", 
						DIRECTION_SYMBOL_SIZE, DIRECTION_SYMBOL_SIZE);
				StdDraw.picture(UP_X, UP_Y, "res//up_green.png", 
						DIRECTION_SYMBOL_SIZE, DIRECTION_SYMBOL_SIZE);
				StdDraw.picture(DOWN_X, DOWN_Y, "res//down_green.png", 
						DIRECTION_SYMBOL_SIZE, DIRECTION_SYMBOL_SIZE);
				StdDraw.picture(LEFTSIDE_X, LEFTSIDE_Y,"res//BBall1.gif", 
						BALL_WIDTH, BALL_HEIGHT, degreeOfBall);
			}
			else {
				StdDraw.picture(BACKGROUND_CENTER_X, BACKGROUND_CENTER_Y, 
						"res//BCourlt1.jpg", BACKGROUND_SIZE, BACKGROUND_SIZE);
				StdDraw.picture(DUAL_X, DUAL_Y, "res//dual_green.png", 
						DIRECTION_SYMBOL_SIZE, DIRECTION_SYMBOL_SIZE);
				StdDraw.picture(LEFT_X, LEFT_Y, "res//left_green.png", 
						DIRECTION_SYMBOL_SIZE, DIRECTION_SYMBOL_SIZE);
				StdDraw.picture(RIGHT_X, RIGHT_Y, "res//right_red.png", 
						DIRECTION_SYMBOL_SIZE, DIRECTION_SYMBOL_SIZE);
				StdDraw.picture(UP_X, UP_Y, "res//up_green.png", 
						DIRECTION_SYMBOL_SIZE, DIRECTION_SYMBOL_SIZE);
				StdDraw.picture(DOWN_X, DOWN_Y, "res//down_green.png", 
						DIRECTION_SYMBOL_SIZE, DIRECTION_SYMBOL_SIZE);
				StdDraw.picture(RIGHTSIDE_X, RIGHTSIDE_Y,"res//BBall1.gif", 
						BALL_WIDTH, BALL_HEIGHT, degreeOfBall);
			}
		}
		
		if(model == 1) {
			StdDraw.picture(BACKGROUND_CENTER_X, BACKGROUND_CENTER_Y, 
					"res//BCourlt1.jpg", BACKGROUND_SIZE, BACKGROUND_SIZE);
			StdDraw.picture(DUAL_X, DUAL_Y, "res//dual_red.png", 
					DIRECTION_SYMBOL_SIZE, DIRECTION_SYMBOL_SIZE);
			StdDraw.picture(LEFT_X, LEFT_Y, "res//left_green.png", 
					DIRECTION_SYMBOL_SIZE, DIRECTION_SYMBOL_SIZE);
			StdDraw.picture(RIGHT_X, RIGHT_Y, "res//right_green.png", 
					DIRECTION_SYMBOL_SIZE, DIRECTION_SYMBOL_SIZE);
			StdDraw.picture(UP_X, UP_Y, "res//up_green.png", 
					DIRECTION_SYMBOL_SIZE, DIRECTION_SYMBOL_SIZE);
			StdDraw.picture(DOWN_X, DOWN_Y, "res//down_green.png", 
					DIRECTION_SYMBOL_SIZE, DIRECTION_SYMBOL_SIZE);
			if(leftToRight) StdDraw.picture(LEFTSIDE_X, LEFTSIDE_Y,"res//BBall1.gif", 
					BALL_WIDTH, BALL_HEIGHT, degreeOfBall);
			else StdDraw.picture(RIGHTSIDE_X, RIGHTSIDE_Y,"res//BBall1.gif", 
					BALL_WIDTH, BALL_HEIGHT, degreeOfBall);
		}
		
		if(model == 2) {
			StdDraw.picture(BACKGROUND_CENTER_X, BACKGROUND_CENTER_Y, 
					"res//BCourlt1.jpg", BACKGROUND_SIZE, BACKGROUND_SIZE);
			StdDraw.picture(DUAL_X, DUAL_Y, "res//dual_green.png", 
					DIRECTION_SYMBOL_SIZE, DIRECTION_SYMBOL_SIZE);
			StdDraw.picture(LEFT_X, LEFT_Y, "res//left_green.png", 
					DIRECTION_SYMBOL_SIZE, DIRECTION_SYMBOL_SIZE);
			StdDraw.picture(RIGHT_X, RIGHT_Y, "res//right_green.png", 
					DIRECTION_SYMBOL_SIZE, DIRECTION_SYMBOL_SIZE);
			StdDraw.picture(UP_X, UP_Y, "res//up_red.png", 
					DIRECTION_SYMBOL_SIZE, DIRECTION_SYMBOL_SIZE);
			StdDraw.picture(DOWN_X, DOWN_Y, "res//down_green.png", 
					DIRECTION_SYMBOL_SIZE, DIRECTION_SYMBOL_SIZE);
			if(leftToRight) StdDraw.picture(LEFTSIDE_X, LEFTSIDE_Y,"res//BBall1.gif", 
					BALL_WIDTH, BALL_HEIGHT, degreeOfBall);
			else StdDraw.picture(RIGHTSIDE_X, RIGHTSIDE_Y,"res//BBall1.gif", 
					BALL_WIDTH, BALL_HEIGHT, degreeOfBall);
		}
		
		if(model == 3) {
			StdDraw.picture(BACKGROUND_CENTER_X, BACKGROUND_CENTER_Y, 
					"res//BCourlt1.jpg", BACKGROUND_SIZE, BACKGROUND_SIZE);
			StdDraw.picture(DUAL_X, DUAL_Y, "res//dual_green.png", 
					DIRECTION_SYMBOL_SIZE, DIRECTION_SYMBOL_SIZE);
			StdDraw.picture(LEFT_X, LEFT_Y, "res//left_green.png", 
					DIRECTION_SYMBOL_SIZE, DIRECTION_SYMBOL_SIZE);
			StdDraw.picture(RIGHT_X, RIGHT_Y, "res//right_green.png", 
					DIRECTION_SYMBOL_SIZE, DIRECTION_SYMBOL_SIZE);
			StdDraw.picture(UP_X, UP_Y, "res//up_green.png", 
					DIRECTION_SYMBOL_SIZE, DIRECTION_SYMBOL_SIZE);
			StdDraw.picture(DOWN_X, DOWN_Y, "res//down_red.png", 
					DIRECTION_SYMBOL_SIZE, DIRECTION_SYMBOL_SIZE);
			if(leftToRight) StdDraw.picture(LEFTSIDE_X, LEFTSIDE_Y,"res//BBall1.gif", 
					BALL_WIDTH, BALL_HEIGHT, degreeOfBall);
			else StdDraw.picture(RIGHTSIDE_X, RIGHTSIDE_Y,"res//BBall1.gif", 
					BALL_WIDTH, BALL_HEIGHT, degreeOfBall);
		}	
	}

	private void drawBackground(int model) {
		StdDraw.picture(BACKGROUND_CENTER_X, BACKGROUND_CENTER_Y, 
				"res//BCourlt1.jpg", BACKGROUND_SIZE, BACKGROUND_SIZE);
		StdDraw.picture(DUAL_X, DUAL_Y, "res//dual_green.png", 
				DIRECTION_SYMBOL_SIZE, DIRECTION_SYMBOL_SIZE);
		StdDraw.picture(LEFT_X, LEFT_Y, "res//left_green.png", 
				DIRECTION_SYMBOL_SIZE, DIRECTION_SYMBOL_SIZE);
		StdDraw.picture(RIGHT_X, RIGHT_Y, "res//right_green.png", 
				DIRECTION_SYMBOL_SIZE, DIRECTION_SYMBOL_SIZE);
		StdDraw.picture(UP_X, UP_Y, "res//up_green.png", 
				DIRECTION_SYMBOL_SIZE, DIRECTION_SYMBOL_SIZE);
		StdDraw.picture(DOWN_X, DOWN_Y, "res//down_green.png", 
				DIRECTION_SYMBOL_SIZE, DIRECTION_SYMBOL_SIZE);
		
		if(model == 0) {
			if(leftToRight) {
				StdDraw.picture(BACKGROUND_CENTER_X, BACKGROUND_CENTER_Y, 
						"res//BCourlt1.jpg", BACKGROUND_SIZE, BACKGROUND_SIZE);
				StdDraw.picture(DUAL_X, DUAL_Y, "res//dual_green.png", 
						DIRECTION_SYMBOL_SIZE, DIRECTION_SYMBOL_SIZE);
				StdDraw.picture(LEFT_X, LEFT_Y, "res//left_red.png", 
						DIRECTION_SYMBOL_SIZE, DIRECTION_SYMBOL_SIZE);
				StdDraw.picture(RIGHT_X, RIGHT_Y, "res//right_green.png", 
						DIRECTION_SYMBOL_SIZE, DIRECTION_SYMBOL_SIZE);
				StdDraw.picture(UP_X, UP_Y, "res//up_green.png", 
						DIRECTION_SYMBOL_SIZE, DIRECTION_SYMBOL_SIZE);
				StdDraw.picture(DOWN_X, DOWN_Y, "res//down_green.png", 
						DIRECTION_SYMBOL_SIZE, DIRECTION_SYMBOL_SIZE);
			}
			else {
				StdDraw.picture(BACKGROUND_CENTER_X, BACKGROUND_CENTER_Y, 
						"res//BCourlt1.jpg", BACKGROUND_SIZE, BACKGROUND_SIZE);
				StdDraw.picture(DUAL_X, DUAL_Y, "res//dual_green.png", 
						DIRECTION_SYMBOL_SIZE, DIRECTION_SYMBOL_SIZE);
				StdDraw.picture(LEFT_X, LEFT_Y, "res//left_green.png", 
						DIRECTION_SYMBOL_SIZE, DIRECTION_SYMBOL_SIZE);
				StdDraw.picture(RIGHT_X, RIGHT_Y, "res//right_red.png", 
						DIRECTION_SYMBOL_SIZE, DIRECTION_SYMBOL_SIZE);
				StdDraw.picture(UP_X, UP_Y, "res//up_green.png", 
						DIRECTION_SYMBOL_SIZE, DIRECTION_SYMBOL_SIZE);
				StdDraw.picture(DOWN_X, DOWN_Y, "res//down_green.png", 
						DIRECTION_SYMBOL_SIZE, DIRECTION_SYMBOL_SIZE);
			}
		}
		
		if(model == 1) {
			StdDraw.picture(BACKGROUND_CENTER_X, BACKGROUND_CENTER_Y, 
					"res//BCourlt1.jpg", BACKGROUND_SIZE, BACKGROUND_SIZE);
			StdDraw.picture(DUAL_X, DUAL_Y, "res//dual_red.png", 
					DIRECTION_SYMBOL_SIZE, DIRECTION_SYMBOL_SIZE);
			StdDraw.picture(LEFT_X, LEFT_Y, "res//left_green.png", 
					DIRECTION_SYMBOL_SIZE, DIRECTION_SYMBOL_SIZE);
			StdDraw.picture(RIGHT_X, RIGHT_Y, "res//right_green.png", 
					DIRECTION_SYMBOL_SIZE, DIRECTION_SYMBOL_SIZE);
			StdDraw.picture(UP_X, UP_Y, "res//up_green.png", 
					DIRECTION_SYMBOL_SIZE, DIRECTION_SYMBOL_SIZE);
			StdDraw.picture(DOWN_X, DOWN_Y, "res//down_green.png", 
					DIRECTION_SYMBOL_SIZE, DIRECTION_SYMBOL_SIZE);
		}
		
		if(model == 2) {
			StdDraw.picture(BACKGROUND_CENTER_X, BACKGROUND_CENTER_Y, 
					"res//BCourlt1.jpg", BACKGROUND_SIZE, BACKGROUND_SIZE);
			StdDraw.picture(DUAL_X, DUAL_Y, "res//dual_green.png", 
					DIRECTION_SYMBOL_SIZE, DIRECTION_SYMBOL_SIZE);
			StdDraw.picture(LEFT_X, LEFT_Y, "res//left_green.png", 
					DIRECTION_SYMBOL_SIZE, DIRECTION_SYMBOL_SIZE);
			StdDraw.picture(RIGHT_X, RIGHT_Y, "res//right_green.png", 
					DIRECTION_SYMBOL_SIZE, DIRECTION_SYMBOL_SIZE);
			StdDraw.picture(UP_X, UP_Y, "res//up_red.png", 
					DIRECTION_SYMBOL_SIZE, DIRECTION_SYMBOL_SIZE);
			StdDraw.picture(DOWN_X, DOWN_Y, "res//down_green.png", 
					DIRECTION_SYMBOL_SIZE, DIRECTION_SYMBOL_SIZE);
		}
		
		if(model == 3) {
			StdDraw.picture(BACKGROUND_CENTER_X, BACKGROUND_CENTER_Y, 
					"res//BCourlt1.jpg", BACKGROUND_SIZE, BACKGROUND_SIZE);
			StdDraw.picture(DUAL_X, DUAL_Y, "res//dual_green.png", 
					DIRECTION_SYMBOL_SIZE, DIRECTION_SYMBOL_SIZE);
			StdDraw.picture(LEFT_X, LEFT_Y, "res//left_green.png", 
					DIRECTION_SYMBOL_SIZE, DIRECTION_SYMBOL_SIZE);
			StdDraw.picture(RIGHT_X, RIGHT_Y, "res//right_green.png", 
					DIRECTION_SYMBOL_SIZE, DIRECTION_SYMBOL_SIZE);
			StdDraw.picture(UP_X, UP_Y, "res//up_green.png", 
					DIRECTION_SYMBOL_SIZE, DIRECTION_SYMBOL_SIZE);
			StdDraw.picture(DOWN_X, DOWN_Y, "res//down_red.png", 
					DIRECTION_SYMBOL_SIZE, DIRECTION_SYMBOL_SIZE);
		}
	}
	
	private void inHand() {
		int count = 20 - (bingoCounter / 7) * 2;
		for(int i = 0; i < count; i ++) {
			if(leftToRight) StdDraw.picture(LEFTSIDE_X, LEFTSIDE_Y,"res//BBall1.gif", 
					BALL_WIDTH, BALL_HEIGHT, degreeOfBall);
			else StdDraw.picture(RIGHTSIDE_X, RIGHTSIDE_Y,"res//BBall1.gif", 
					BALL_WIDTH, BALL_HEIGHT, degreeOfBall);
			StdDraw.show(50);
			changeDegree(inHandDegreeInc);
		}
	}
	
	private void endGame() {
		StdDraw.show(20);
		new MyUserInterface();
	}
}

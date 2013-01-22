package basicUserInterface;

import princeton.stdlib.*;

public class Main {
	
	private static final int CANVA_SIZE = 800;
	private static final int X_SCALE = 400;
	private static final int Y_SCALE = 400;
	
	public static void main(String[] args) {
		StdDraw.setCanvasSize(CANVA_SIZE, CANVA_SIZE);
		StdDraw.setXscale(0, X_SCALE);
		StdDraw.setYscale(0, Y_SCALE);
		
		new MyUserInterface();
	}
}
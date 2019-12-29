

import java.awt.Graphics2D;

public class DrawShapes {
	static final int LARGE = 240;
	  //private static final int MEDIUM = 120;
	  //private static final int SMALL = 80;
	  private static final int VERY_SMALL = 60;

	  private int X_COORDINATE;
	  private int Y_COORDINATE;
	  private ShapeLocation shapeLocation;
	  private Graphics2D graphics;
	  private RandomPosition randomPosition;
	  public DrawShapes(Graphics2D g){
	  	graphics = g;
	  }

	  public DrawShapes(Graphics2D g, String side){

		  graphics = g;
		  if(side.equalsIgnoreCase("L1")){
			  X_COORDINATE = 10;
			  Y_COORDINATE = 10;
		  }
		  else if(side.equalsIgnoreCase("L2")) {
			  X_COORDINATE = 10+240+10;
			  Y_COORDINATE = 10;
		  }
		  else if(side.equalsIgnoreCase("L3")) {
			  X_COORDINATE = 10;
			  Y_COORDINATE = 10+240+10;
		  }
		  else if(side.equalsIgnoreCase("L4")) {
			  X_COORDINATE = 10+240+10;
			  Y_COORDINATE = 10+240+10;
		  }
		  else if(side.equalsIgnoreCase("L5")) {
			  X_COORDINATE = 10;
			  Y_COORDINATE = 10+240+10+240+10;
		  }
		  else if(side.equalsIgnoreCase("L6")) {
			  X_COORDINATE = 10+240+10;
			  Y_COORDINATE = 10+240+10+240+10;
		  }
		  else if(side.equalsIgnoreCase("R1")) {
			  X_COORDINATE = 10+240+10+240+10;
			  Y_COORDINATE = 10;
		  }
		  else if(side.equalsIgnoreCase("R2")) {
			  X_COORDINATE = 10+240+10+240+10+240+10;
			  Y_COORDINATE = 10;
		  }
		  else if(side.equalsIgnoreCase("R3")) {
			  X_COORDINATE = 10+240+10+240+10;
			  Y_COORDINATE = 10+240+10;
		  }
		  else if(side.equalsIgnoreCase("R4")) {
			  X_COORDINATE = 10+240+10+240+10+240+10;
			  Y_COORDINATE = 10+240+10;
		  }
		  else if(side.equalsIgnoreCase("R5")) {
			  X_COORDINATE = 10+240+10+240+10;
			  Y_COORDINATE = 10+240+10+240+10;
		  }
		  else {
			  X_COORDINATE = 10+240+10+240+10+240+10;
			  Y_COORDINATE = 10+240+10+240+10;
		  }

		  shapeLocation = new ShapeLocation(X_COORDINATE,Y_COORDINATE);
	  }
	
	public void drawMainShape() {
		graphics.drawRect(X_COORDINATE,Y_COORDINATE,LARGE,LARGE);
	}

	public void drawFiguresAtRandomPosition() {
	  	String shape = shapeLocation.getRandomFigure();
	  	randomPosition = shapeLocation.getRandomPositions();
	  	//System.out.println("X: "+randomPosition.getHorizontalPosition()+" Y: "+randomPosition.getVerticalPosition());
		if(shape.equalsIgnoreCase("Triangle") || shape.equalsIgnoreCase("TR")) {
			int x1 = shapeLocation.findStartingXPosition(randomPosition.getHorizontalPosition(), shape);
			int y1 = shapeLocation.findStartingYPosition(randomPosition.getVerticalPosition(), shape);
			int x2 = x1+VERY_SMALL;
			int y2 = y1;
			int x3 = x1+(VERY_SMALL/2);
			int y3 = y1-shapeLocation.getTriangleHeight();
			graphics.drawLine(x1, y1, x2, y2);
			graphics.drawLine(x1, y1, x3, y3);
			graphics.drawLine(x2, y2, x3, y3);
		}
		else if (shape.equalsIgnoreCase("Square") || shape.equalsIgnoreCase("SQ")) {
			int x = shapeLocation.findStartingXPosition(randomPosition.getHorizontalPosition(), shape);
			int y = shapeLocation.findStartingYPosition(randomPosition.getVerticalPosition(), shape);
			graphics.drawRect(x, y, VERY_SMALL, VERY_SMALL);
		}
		else {
			int x = shapeLocation.findStartingXPosition(randomPosition.getHorizontalPosition(), shape);
			int y = shapeLocation.findStartingYPosition(randomPosition.getVerticalPosition(), shape);
			graphics.drawOval(x, y, VERY_SMALL, VERY_SMALL);
		}

	}
	public void drawFigureInside(String shape, String horizontalPosition, String verticalPosition) {
	  	int x,y;
		if(horizontalPosition.equalsIgnoreCase("*") && verticalPosition.equalsIgnoreCase("*")){
			randomPosition = shapeLocation.getRandomPositions();
			x = shapeLocation.findStartingXPosition(randomPosition.getHorizontalPosition(),shape);
			y = shapeLocation.findStartingYPosition(randomPosition.getVerticalPosition(),shape);

		}
		else {
			x = shapeLocation.findStartingXPosition(horizontalPosition,shape);
			y = shapeLocation.findStartingYPosition(verticalPosition,shape);
		}
		if(shape.equalsIgnoreCase("Triangle") || shape.equalsIgnoreCase("TR")) {

			int x2 = x+VERY_SMALL;
			int y2 = y;
			int x3 = x+(VERY_SMALL/2);
			int y3 = y-shapeLocation.getTriangleHeight();
			graphics.drawLine(x, y, x2, y2);
			graphics.drawLine(x, y, x3, y3);
			graphics.drawLine(x2, y2, x3, y3);
		}
		else if (shape.equalsIgnoreCase("Square") || shape.equalsIgnoreCase("SQ")) {

			graphics.drawRect(x, y, VERY_SMALL, VERY_SMALL);
		}
		else {

			graphics.drawOval(x, y, VERY_SMALL, VERY_SMALL);
		}
	}

}

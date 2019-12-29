import java.awt.Graphics;

import javax.swing.JComponent;
import javax.swing.JFrame;


class MyCanvas extends JComponent {
  static final int LARGE = 240;
  static final int MEDIUM = 120;
  static final int SMALL = 80;
  static final int VERY_SMALL = 40;

  static final int X_COORDINATE = 10;
  static final int Y_COORDINATE = 10;


public void drawShapesInside(String verticalPosition, String horizontalPosition, String shape, String size, Graphics g ) {
  int xCoordinate = findStartingXPosition(horizontalPosition);
  int yCoordinate = findStartingYPosition(verticalPosition);
  if(shape.equalsIgnoreCase("Square")|| shape.equalsIgnoreCase("SQ")){
    if(size.equalsIgnoreCase("Medium") || size.equalsIgnoreCase("ME")){
      g.drawRect(xCoordinate,yCoordinate,MEDIUM,MEDIUM);
    }
  else  if(size.equalsIgnoreCase("Small") || size.equalsIgnoreCase("SM")){
      g.drawRect(xCoordinate,yCoordinate,SMALL,SMALL);
    }
    else if(size.equalsIgnoreCase("VERY SMALL") || size.equalsIgnoreCase("VS")){
        g.drawRect(xCoordinate,yCoordinate,VERY_SMALL,VERY_SMALL);
      }
  }


}
public int findStartingYPosition(String verticalPosition){
  int yCoordinate;
  if(verticalPosition.equalsIgnoreCase("Top") || verticalPosition.equalsIgnoreCase("T")){
    yCoordinate = Y_COORDINATE+10;
  }
  else if(verticalPosition.equalsIgnoreCase("Bottom") || verticalPosition.equalsIgnoreCase("B")){
    yCoordinate = (Y_COORDINATE+(LARGE/2))-10;
  }
  else {
    int maxLimit = (LARGE/2)+10;
    int minLimit = 10;
    yCoordinate = (int)(Math.random()* ((maxLimit-minLimit)+1))+minLimit;
  }
  return yCoordinate;

}
public int findStartingXPosition(String horizontalPosition){
  int xCoordinate;
  if(horizontalPosition.equalsIgnoreCase("Left") || horizontalPosition.equalsIgnoreCase("L")){
    xCoordinate = X_COORDINATE+10;
  }
  else if(horizontalPosition.equalsIgnoreCase("Right") || horizontalPosition.equalsIgnoreCase("R")){
    xCoordinate = (X_COORDINATE+(LARGE/2))-10;
  }
  else {
    int maxLimit = (LARGE/2)+10;
    int minLimit = 10;
    xCoordinate = (int)(Math.random()* ((maxLimit-minLimit)+1))+minLimit;
    System.out.println(xCoordinate);
  }
  return xCoordinate;
}
  public void paint(Graphics g) {
    g.drawRect (X_COORDINATE, Y_COORDINATE, LARGE, LARGE);
    drawShapesInside("B","*","SQ","SM",g);
  }
}
class Shapes {
  public static void main(String[] args){
    JFrame window = new JFrame();
    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    window.setBounds(30, 30, 300, 300);
    window.getContentPane().add(new MyCanvas());
    window.setVisible(true);
  }
}

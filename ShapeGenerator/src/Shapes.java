import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;


import org.apache.batik.dom.GenericDOMImplementation;
import org.apache.batik.svggen.SVGGraphics2D;
import org.apache.batik.svggen.SVGGraphics2DIOException;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;



class Shapes {
  public void generateShapes(int leftFiguresInside,int rightFiguresInside,int figureCount) throws UnsupportedEncodingException, SVGGraphics2DIOException, FileNotFoundException{
	  DOMImplementation domImpl =
		      GenericDOMImplementation.getDOMImplementation();

		    // Create an instance of org.w3c.dom.Document.
		    String svgNS = "http://www.w3.org/2000/svg";
		    Document document = domImpl.createDocument(svgNS, "svg", null);

		    // Create an instance of the SVG Generator.
		    SVGGraphics2D svgGenerator = new SVGGraphics2D(document);

		    // Ask the test to render into the SVG Graphics2D implementation.
	  		for(int i=1;i<=6;i++){ // For the left hand side figures
				DrawShapes shapeGen = new DrawShapes(svgGenerator,"L"+i);
				shapeGen.drawMainShape();
				for(int j=1;j<=leftFiguresInside;j++){
					// For random Position
					shapeGen.drawFiguresAtRandomPosition();
					//For selected figure we have to select positions as random, because it's not possible to generate a figure with one or two sides locked as this makes the permutations impossible
					//shapeGen.drawFigureInside("SQ","*","*");
				}
			}
		    for(int i=1;i<=6;i++){  // For right hand side figures
				  DrawShapes shapeGen = new DrawShapes(svgGenerator,"R"+i);
				  shapeGen.drawMainShape();
				  for(int j=1;j<=rightFiguresInside;j++){
					  shapeGen.drawFiguresAtRandomPosition();
					 // shapeGen.drawFigureInside("CI","*","*");
				  }
		    }



//		    shapeGen.drawFigureInside("SQ", "L", "T");
//		    shapeGen.drawFigureInside("TR", "R", "B");
//		    shapeGen.drawFigureInside("CI", "C", "C");
//		    shapeGen.drawFigureInside("SQ","*","*");

		    // Finally, stream out SVG to the standard output using
		    // UTF-8 encoding.
		    String filePath = "svgs/Shape"+figureCount+".svg";
		    FileOutputStream f = new FileOutputStream(filePath);
		    boolean useCSS = true; // we want to use CSS style attributes
		    Writer out = new OutputStreamWriter(f, "UTF-8");
		    svgGenerator.stream(out, useCSS);
  }
}

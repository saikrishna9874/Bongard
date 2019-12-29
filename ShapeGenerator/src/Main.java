import org.apache.batik.svggen.SVGGraphics2DIOException;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException, SVGGraphics2DIOException {

        // Type number of figures to be generated
        for(int i =1;i<=500;i++){
            Shapes shape = new Shapes();
            shape.generateShapes(4,5,i);
        }
        // For Extra side figure

//        for(int i =1;i<=2;i++){
//            DoubleShapes shape = new DoubleShapes();
//            shape.generateShapes(6,5,i);
//        }
    }
}

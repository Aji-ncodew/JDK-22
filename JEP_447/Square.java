//Statements before super(…) – JEP 447

package JEP_447;

public class Square extends Rectangle{
    public Square(String color, int area){
        if (area < 0) throw new IllegalArgumentException();
        double sideLength = Math.sqrt(area);
        super(color, sideLength, sideLength);
    }
}


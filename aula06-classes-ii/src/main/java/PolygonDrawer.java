/**
 * Draw regular polygons using the Turtle graphics technique.
 */
public class PolygonDrawer {

    /**
     * The main code.
     * The first CLI argument must the quantity of sides
     *
     * @param args the arguments
     */
    public static void main(String[] args) {
        if (args.length < 1) {
            throw new IllegalArgumentException("Usage: PolygonDrawer <nsides>");
        }

        var sides = Integer.parseInt(args[0]);
        var angle = 360.0 / sides;
        System.out.println(angle);
        var sideLength = Math.sin(Math.PI / sides);
        var turtle = new TurtleGraphics(0.5, 0.0, angle/2);

        turtle.setCanvasSize(600,600);

        for (int i = 0; i < sides; i++) {
            turtle.goForward(sideLength);
            turtle.turnLeft(angle);
        }

        turtle.show();
    }
}

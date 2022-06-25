import java.awt.Color;

/**
 * Data type for turtle graphics using standard draw.
 *
 * Based on: https://introcs.cs.princeton.edu/java/32class/Turtle.java.html
 */
public class TurtleGraphics {
    private double x, y;     // turtle is at (x, y)
    private double angle;    // facing this many degrees counterclockwise from the x-axis

    // start at (x0, y0), facing a0 degrees counterclockwise from the x-axis

    /**
     * Build a Turtle graphics instance, startint at (x0, y0) facinf a0 degrees
     * counterclockwise.
     *
     * @param x0 the x-coordinate
     * @param y0 the y-coordinate
     * @param a0 the counterclockwise angle
     */
    public TurtleGraphics(double x0, double y0, double a0) {
        x = x0;
        y = y0;
        angle = a0;
    }

    /**
     * Rotate the turtle the amount of degrees counterclockwise.
     *
     * @param delta the amount of degrees
     */
    public void turnLeft(double delta) {
        angle += delta;
    }

    // move forward the given amount, with the pen down

    /**
     * Move the turtle forward in the amount specified.
     *
     * @param step the amount of movement
     */
    public void goForward(double step) {
        double oldx = x;
        double oldy = y;
        x += step * Math.cos(Math.toRadians(angle));
        y += step * Math.sin(Math.toRadians(angle));
        StdDraw.line(oldx, oldy, x, y);
    }

    /**
     * Show the graphics result in a GUI.
     */
    public void show() {
        StdDraw.show();
    }

    /**
     * Pause an amount of milliseconds (for animation purposes)
     *
      * @param t the amount of milliseconds
     */
    public void pause(int t) {
        StdDraw.pause(t);
    }

    /**
     * Set the pen color.
     *
     * @param color the color
     */
    public void setPenColor(Color color) {
        StdDraw.setPenColor(color);
    }

    /**
     * Set pen radius.
     *
     * @param radius the pen radius
     */
    public void setPenRadius(double radius) {
        StdDraw.setPenRadius(radius);
    }

    /**
     * Set the size of the canves.
     *
     * @param width the width
     * @param height the height
     */
    public void setCanvasSize(int width, int height) {
        StdDraw.setCanvasSize(width, height);
    }

    public void setXscale(double min, double max) {
        StdDraw.setXscale(min, max);
    }

    /**
     * Set the scale of the Y axis.
     *
     * @param min the minimum value
     * @param max the maximum value
     */
    public void setYscale(double min, double max) {
        StdDraw.setYscale(min, max);
    }


    /**
     * Ad-hoc tests.
     *
     * @param args the args
     */
    public static void main(String[] args) {
        StdDraw.enableDoubleBuffering();
        double x0 = 0.5;
        double y0 = 0.0;
        double a0 = 60.0;
        double step = Math.sqrt(3)/2;
        TurtleGraphics turtleGraphics = new TurtleGraphics(x0, y0, a0);
        turtleGraphics.goForward(step);
        turtleGraphics.turnLeft(120.0);
        turtleGraphics.goForward(step);
        turtleGraphics.turnLeft(120.0);
        turtleGraphics.goForward(step);
        turtleGraphics.turnLeft(120.0);
        turtleGraphics.show();
    }

}

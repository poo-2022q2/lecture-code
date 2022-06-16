import java.awt.Color;
import java.util.Arrays;

public class ArrayOfObjects {
    public static void main(String[] args) {
        Color[] colors = new Color[2];

        colors[0] = new Color(255, 255, 0);
        colors[1] = new Color(160, 82, 45);

        System.out.println(Arrays.toString(colors));
    }
}

import java.awt.Color;
/**
 * Runner for Project
 *
 * @Sneha Singh
 */
public class Runner
{
    // Creates Strawberry Tesselation objects and runs methods for objects.
    public static void main(String[] args)
    {
        Tessellation t = new Tessellation(7, 9);
        Color newColor = new Color(0,0,255);
        Color secondNewColor = new Color(0, 255, 0);
        t.setDiagnol(newColor, secondNewColor);
        t.animateRow(3);
        Canvas canvas = Canvas.getCanvas();
        canvas.wait(3000);
        t.eraseRandom();
    }
}

import java.awt.Color;
/**
 * A tile (Strawberry) that can be manipulated and is drawn
 *
 * @Sneha Singh
 */
public class Tile
{
    // instance variables - replace the example below with your own
    private int x;
    private Color color;
    private int y;
    private PolygonClass head;
    private Line leftLine;
    private Line rightLine;
    private Ellipse[] seeds;
    private Circle leftLeaf;
    private Circle rightLeaf;
    private PolygonClass verticalShine;
    private PolygonClass horizontalShine;
    private PolygonClass firstBite;
    /**
     * Constructor to create Strawberry objects
     */
    public Tile(int x, int y)
    {
        // initialise instance variables
        this.x = x;
        this.y = y;
        color = new Color(255,0,0);
        draw();
    }
    
    //Method to draw Strawberry
    public void draw()
    {
        int[][] headCoord = {{x,y},{x + 30,y},{x + 30, y - 30},{x + 60, y - 30},
                {x + 60, y},{x + 90, y},{x + 90, y - 30},{x + 120, y - 30},{x + 120, y},
                {x + 150, y},{x + 150, y + 60},{x + 120, y + 60},{x + 120, y + 90},
                {x + 90, y + 90},{x + 90, y + 120},{x + 60, y + 120},{x + 60, y + 90},
                {x + 30, y + 90},{x + 30, y + 60},{x, y + 60}};
        int[][] firstCoord = {{x,y},{x + 30,y},{x + 30, y - 30},{x + 60, y - 30},
                {x + 60, y},{x + 80, y},{x + 90, y + 20},{x + 110, y + 20},{x + 110, y + 40},
                {x + 140, y + 40},{x + 140, y + 60},{x + 120, y + 60},{x + 120, y + 90},
                {x + 90, y + 90},{x + 90, y + 120},{x + 60, y + 120},{x + 60, y + 90},
                {x + 30, y + 90},{x + 30, y + 60},{x, y + 60}};
        firstBite = new PolygonClass(firstCoord, color);
        head = new PolygonClass(headCoord, color);
        leftLeaf = new Circle(x + 10, y + 10, 25);
        rightLeaf = new Circle(x + 25, y - 10, 25);
        Color leafGreen = new Color(107, 142, 35);
        leftLeaf.changeColor(leafGreen);
        leftLine = new Line(x - 2, y + 10, x + 17, y + 11);
        rightLeaf.changeColor(leafGreen);
        rightLine = new Line(x + 22, y - 15, x + 28, y + 4);
        seeds = new Ellipse[8];
        Color seedBrown = new Color(127, 60, 0);
        seeds[0] = new Ellipse(x + 40, y + 30, 4, 12, seedBrown);
        seeds[1] = new Ellipse(x + 50, y + 60, 4, 12, seedBrown);
        seeds[2] = new Ellipse(x + 100, y + 60, 4, 12, seedBrown);
        seeds[3] = new Ellipse(x + 75, y + 25, 4, 12, seedBrown);
        seeds[4] = new Ellipse(x + 75, y + 90, 4, 12, seedBrown);
        seeds[5] = new Ellipse(x + 100, y - 10, 4, 12, seedBrown);
        seeds[6] = new Ellipse(x + 135, y + 10, 4, 12, seedBrown);
        seeds[7] = new Ellipse(x + 130, y + 45, 4, 12, seedBrown);
        Color shineColor = new Color(255,250,250);
        int[][] vShineCoord = {{x + 100, y}, {x + 110, y}, {x + 110, y + 20},
                {x + 100, y + 20}};
        verticalShine = new PolygonClass(vShineCoord, shineColor);
        int[][] hShineCoord = {{x + 110, y + 20}, {x + 130, y + 20}, 
                {x + 130, y + 30}, {x + 110, y + 30}};
        horizontalShine = new PolygonClass(hShineCoord, shineColor);
    }
    
    //Method to change color of strawberry
    public void changeColor(Color newColor)
    {
        erase();
        color = newColor;
        draw();
    }
    
    //Method to erase strawberry.
    public void erase()
    {
        for (int a = 0; a < seeds.length; a++)
        {
            seeds[a].erase();
        }
        verticalShine.erase();
        horizontalShine.erase();
        leftLine.erase();
        rightLine.erase();
        leftLeaf.erase();
        rightLeaf.erase();
        firstBite.erase();
        head.erase();
    }
    
    //Method to animate strawberry so that it appears as if a bite has been taken
    public void animation()
    {
        seeds[5].erase();
        seeds[6].erase();
        verticalShine.erase();
        horizontalShine.erase();
        head.erase();
    }
}

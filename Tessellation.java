 import java.awt.Color;
/**
 * Class for tessellations that can be manipulated and are made of tiles
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Tessellation
{
    Tile[][] tiles;
    int rows;
    int columns;
    /**
     * Constructor for objects of class Tessellation
     */
    public Tessellation(int rows, int columns)
    {
        this.rows = rows;
        this.columns = columns;
        tiles = new Tile[rows][columns];
        for (int r = 0; r < rows; r++)
        {
            for (int c = 0; c < columns; c++)
            {
                if (c % 2 == 0)
                {
                    tiles[r][c] = new Tile(c * 120 - 30, r * 120);
                }
                else
                {
                    tiles[r][c] = new Tile((c - 1) * 120 + 120 - 30, r * 120 - 60);
                }
            }
        }
    }

    //Method to change the color of the strawberries in a set order to a set color.
    public void changeColorInRow(Color newColor)
    {
        for (int r = 0; r < rows; r++)
        {
            for (int c = 0; c < columns; c++)
            {
                tiles[r][c].changeColor(newColor);
            }
        }
    }
    
    //Method to change the color of each strawberry to a random color.
    public void setRandomColor()
    {
        for (int r = 0; r < rows; r++)
        {
            for (int c = 0; c < columns; c++)
            {
                Color newColor = new Color((int)(Math.random() * 256), (int)(Math.random() * 256), (int)(Math.random() * 256));    
                tiles[r][c].changeColor(newColor);
            }
        }
    }

    //Method to change the color of the strawberries so that every other diagonal in the tessellation is the same
    public void setDiagnol(Color first, Color second)
    {
        
        for (int r = 0; r < rows; r++)
        {
            for (int c = 0; c < columns; c++)
            {
                if (c == 0 && r % 2 == 0)
                {
                    tiles[r][c].changeColor(first);
                }
                else if ((c == 2 || c == 6) && r % 2 !=0)
                {
                    tiles[r][c].changeColor(first);
                }
                else if ((c == 1 || c == 5 || c == 9) && r % 2 !=0)
                {
                    tiles[r][c].changeColor(first);
                }
                else if ((c == 3 || c == 4) && r % 2 ==0)
                {
                    tiles[r][c].changeColor(first);
                }
                else if ((c == 7 || c == 8) && r % 2 ==0)
                {
                    tiles[r][c].changeColor(first);
                }
                else
                {
                    tiles[r][c].changeColor(second);
                }
            }
        }
    }
    
    //Method to erase the strawberries in a set order
    public void eraseRightToLeft()
    {
        for (int c = columns - 1; c >= 0; c--)
        {
            for (int r = rows - 1; r >= 0; r--)
            {
                tiles[r][c].erase();
            }
        }
    }
    
    //Method to erase the strawberries in a random order
    public void eraseRandom()
    {
        for (int r = rows - 1; r >= 0; r--)
        {
            for (int c = columns - 1; c >= 0; c--)
            {
                int a = (int)(Math.random() * rows);
                int b = (int)(Math.random() * columns);
                if (tiles[a][b] != null)
                {
                    tiles[a][b].erase();
                    tiles[a][b] = null;
                }
                else
                {
                    c++;
                }
            }
        }
    }
    
    //Method to have a specified row animated so that there is a bite taken out of each strawberry
    public void animateRow(int rowNum)
    {
        for (int a = 0; a < columns; a++)
        {
            tiles[rowNum][a].animation();   
        }
    }
}

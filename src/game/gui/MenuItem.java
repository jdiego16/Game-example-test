package game.gui;

import game.framework.GameTime;
import game.framework.Rectangle;
import game.framework.Vector2;
import game.input.Mouse;
import game.input.MouseKeys;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

public abstract class MenuItem extends GuiComponent 
{
    private Vector2 position;
    private final String LABEL;
    // Properties to be set by parent items
    private Font font;
    private Color fontColor;
    private Rectangle bounds;
        
    /**
     * Complete Constructor
     * @param LABEL Text label that is displayed in the Menu.
     */
    public MenuItem(String LABEL)
    {
        this.LABEL = LABEL;
    }
    
    /**
     * Sets the dimensions of this MenuItem.
     * @param width Width of this MenuItem.
     * @param height Height of this MenuItem.
     */
    protected void setDimensions(int width, int height)
    {
        this.bounds = new Rectangle((int)position.x, (int)position.y, width, height);
    }
    
    /**
     * Sets the position of this MenuItem.
     * @param position A Vector2 containing the position of this MenuItem.
     */
    protected void setPosition(Vector2 position)
    {
        this.position = position;
    }
    
    /**
     * Sets the font color of this MenuItem.
     * @param fontColor Desired Color of the font.
     */
    protected void setFontColor(Color fontColor)
    {
        this.fontColor = fontColor;
    }
    
    /**
     * Sets the font of this MenuItem.
     * @param font Desired font to draw the label with.
     */
    protected void setFont(Font font)
    {
        this.font = font;
    }

    /**
     * Initializes this MenuItem.
     */
    @Override
    public void initialize(){}

    /**
     * Loads Content Needed for this MenuItem.
     */
    @Override
    public void loadContent(){}

    /**
     * Updates this MenuItem.
     * @param gameTime GameTime object containing the current time in game.
     */
    @Override
    public void update(GameTime gameTime) 
    {
        if(bounds.intersects(Mouse.getPosition()))
        {
            fontColor = Color.YELLOW;
            if(Mouse.buttonDownOnce(MouseKeys.BUTTON_1))
                action();
        }    
        else
            fontColor = Color.WHITE;
    }

    /**
     * Draws this MenuItem.
     * @param g2d Graphics2D object to draw this MenuItem
     */
    @Override
    public void draw(Graphics2D g2d) 
    {
        g2d.setFont(font);
        g2d.setColor(fontColor);
        g2d.drawString(LABEL, position.x + 5, position.y + 15);
    }
    
    /**
     * Method to to be invoked by actions on the menu.
     */
    protected abstract void action();
}
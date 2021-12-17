package me.pepe.JuegoSSII.Objects;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Rectangle;

import me.pepe.GameAPI.Game.Game;
import me.pepe.GameAPI.Game.Objects.GameObject;
import me.pepe.GameAPI.Utils.GameLocation;
import me.pepe.GameAPI.Utils.ObjectDimension;

public abstract class Button extends GameObject {
	private String text = "";
	private boolean over = false;
	private boolean show = true;
	private Color color;
	public Button(Color color, String text, GameLocation gameLocation, Game game, ObjectDimension dimension) {
		super(gameLocation, game, dimension);
		this.text = text;
		this.color = color;
	}
	public Button(String text, GameLocation gameLocation, Game game, ObjectDimension dimension) {
		super(gameLocation, game, dimension);
		this.text = text;
		this.color = Color.GRAY;
	}
	public String getText() {
		return text;
	}
	public boolean isShow() {
		return show;
	}
	public void setShow(boolean show) {
		this.show = show;
	}
	@Override
	public void tick() {
		boolean newover = getGame().getScreen().isTouch(getGame().getScreen().getMouseLocation(), this);
		if (!over && newover) {
			onOver();
		}
		if (over && !newover) {
			onUnOver();
		}
		over = newover;
	}
	@Override
	public void render(Graphics g) {
		if (show) {
			if (color != null) {
				g.setColor(new Color(color.getRed(), color.getGreen(), color.getBlue(), over ? 255 : 100));
			} else {
				g.setColor(new Color(125, 125, 125, over ? 255 : 100));
			}
			g.fillRect(x - (over ? 5 : 0), y - (over ? 5 : 0), getDimension().getX() + (over ? 10 : 0), getDimension().getY() + (over ? 10 : 0));
			g.setColor(new Color(255, 0, 0, over ? 255 : 150));
			drawCenteredString(g, text, new Rectangle(x, y, getDimension().getX(), getDimension().getY()), new Font("Aria", Font.PLAIN, over ? 55 : 50));
		}
	}
	public boolean isOver() {
		return over;
	}
	public abstract void onClick();
	public abstract void onOver();
	public abstract void onUnOver();
	private void drawCenteredString(Graphics g, String text, Rectangle rect, Font font) {
	    // Get the FontMetrics
	    FontMetrics metrics = g.getFontMetrics(font);
	    // Determine the X coordinate for the text
	    int x = rect.x + (rect.width - metrics.stringWidth(text)) / 2;
	    // Determine the Y coordinate for the text (note we add the ascent, as in java 2d 0 is top of the screen)
	    int y = (int) (rect.y + ((rect.height - metrics.getHeight()) / 2) + (metrics.getAscent() * 1.1));
	    // Set the font
	    g.setFont(font);
	    // Draw the String
	    g.drawString(text, x, y);
	}
}

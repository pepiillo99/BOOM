package me.pepe.JuegoSSII.Screen;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;

import me.pepe.GameAPI.Game.Game;
import me.pepe.GameAPI.Game.Objects.GameObject;
import me.pepe.GameAPI.Screen.Screen;
import me.pepe.GameAPI.Utils.GameLocation;
import me.pepe.GameAPI.Utils.ObjectDimension;
import me.pepe.GameAPI.Utils.Utils;
import me.pepe.GameAPI.Windows.MouseInput;
import me.pepe.GameAPI.Windows.Windows;
import me.pepe.GameAPI.Windows.Buttons.MouseButtons;
import me.pepe.JuegoSSII.Objects.Button;

public class RulesScreen extends Screen {
	private Rectangle rec;
	private Rectangle rec2;
	private Rectangle rec3;
	private Rectangle rec4;
	private Rectangle rec5;
	private Rectangle rec9;
	private Font font = new Font("Aria", Font.PLAIN, 100);
	public RulesScreen(Windows windows, Game game) {
		super(windows, game);
		rec = new Rectangle(((getGame().getWindows().getX()/2)-125), (getGame().getWindows().getY()/2)-350, 250, 50);
		rec2 = new Rectangle(((getGame().getWindows().getX()/2)-125), (getGame().getWindows().getY()/2)-250, 250, 50);
		rec3 = new Rectangle(((getGame().getWindows().getX()/2)-125), (getGame().getWindows().getY()/2)-200, 250, 50);
		rec4 = new Rectangle(((getGame().getWindows().getX()/2)-125), (getGame().getWindows().getY()/2)-130, 250, 50);
		rec5 = new Rectangle(((getGame().getWindows().getX()/2)-125), (getGame().getWindows().getY()/2)-80, 250, 50);
		rec9 = new Rectangle(((getGame().getWindows().getX()/2)+250), (getGame().getWindows().getY()/2)+250, 250, 50);
		setMouseInput(new MouseInput() {
			@Override
			public void tick() {
				
			}
			@Override
			public void onClick(MouseButtons mouseButton) {}
			@Override
			public void onWheelMoved(MouseButtons mouseButton) {}
			@Override
			public void onButtonPressed(MouseButtons mouseButton) {
				for (GameObject object : getGameObjects()) {
					if (object instanceof Button) {
						Button button = (Button) object;
						if (button.isOver()) {
							button.onClick();
						}
					}
				}
			}
			@Override
			public void onButtonReleased(MouseButtons mouseButton) {}			
		});
		addGameObject(new Button("Volver", new GameLocation(50, 550), game, new ObjectDimension(200, 70)) {
			@Override
			public void onClick() {
				getGame().setScreen("main");
			}
			@Override
			public void onOver() {}
			@Override
			public void onUnOver() {}			
		});
	}

	@Override
	public void internalTick() {}

	@Override
	protected void paintLevel(Graphics g) {		
		g.setColor(Color.WHITE);
		Utils.drawCenteredString(g, "Reglas:", rec, font.deriveFont(Font.PLAIN, 50));
		Utils.drawCenteredString(g, "1.- Debes eliminar los cables con", rec2, font.deriveFont(Font.PLAIN, 40));
		Utils.drawCenteredString(g, "respuestas incorrectas para ganar.", rec3, font.deriveFont(Font.PLAIN, 40));
		Utils.drawCenteredString(g, "2.- Si fallas perderás todo", rec4, font.deriveFont(Font.PLAIN, 40));
		Utils.drawCenteredString(g, "el dinero.", rec5, font.deriveFont(Font.PLAIN, 40));
		Utils.drawCenteredString(g, "Creador: Pepe", rec9, font.deriveFont(Font.PLAIN, 20)); 
	}

}
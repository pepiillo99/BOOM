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

public class WinLoseScreen extends Screen {
	private Font font = new Font("Aria", Font.PLAIN, 100);
	public WinLoseScreen(Windows windows, Game game) {
		super(windows, game);
		setMouseInput(new MouseInput() {
			@Override
			public void tick() {
				
			}
			@Override
			public void onClick(MouseButtons mouseButton) {
				
			}
			@Override
			public void onWheelMoved(MouseButtons mouseButton) {
				
			}
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
			public void onButtonReleased(MouseButtons mouseButton) {
				
			}			
		});
		addGameObject(new Button("Volver", new GameLocation(50, 500), game, new ObjectDimension(200, 70)) {
			@Override
			public void onClick() {
				getGame().setScreen("main");
			}
			@Override
			public void onOver() {
				
			}
			@Override
			public void onUnOver() {
				
			}			
		});
	}

	@Override
	public void internalTick() {}

	@Override
	protected void paintLevel(Graphics g) {
		Rectangle rec = new Rectangle(((getGame().getWindows().getX()/2)-125), (getGame().getWindows().getY()/2)-100, 250, 50);		
		g.setColor(new Color(255, 255, 255, 255));
		Utils.drawCenteredString(g, "¡Has " + (((GameScreen) getGame().getScreenManager().getScreen("game")).isWinned() ? "ganado" : "perdido") + "!", rec, font); 
	}
}

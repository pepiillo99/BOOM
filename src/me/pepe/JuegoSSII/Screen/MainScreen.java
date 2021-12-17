package me.pepe.JuegoSSII.Screen;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import me.pepe.GameAPI.Game.Game;
import me.pepe.GameAPI.Game.Objects.GameObject;
import me.pepe.GameAPI.Screen.Screen;
import me.pepe.GameAPI.TextureManager.TextureDistance;
import me.pepe.GameAPI.Utils.GameLocation;
import me.pepe.GameAPI.Utils.ObjectDimension;
import me.pepe.GameAPI.Utils.Utils;
import me.pepe.GameAPI.Windows.KeyInput;
import me.pepe.GameAPI.Windows.MouseInput;
import me.pepe.GameAPI.Windows.Windows;
import me.pepe.GameAPI.Windows.Buttons.MouseButtons;
import me.pepe.JuegoSSII.Main;
import me.pepe.JuegoSSII.Objects.Button;
import me.pepe.JuegoSSII.Utils.TexturePath;

public class MainScreen extends Screen {
	private Font font = new Font("Aria", Font.PLAIN, 40);
	public MainScreen(Windows windows, Game game) {
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
		setKeyInput(new KeyInput() {
			@Override
			public void tick() {

			}
			@Override
			public void onKeyPressed(int key) {
				
			}
			@Override
			public void onKeyReleased(int key) {
				
			}			
		});
		addGameObject(new Button("Jugar", new GameLocation(50, 500), game, new ObjectDimension(200, 70)) {
			@Override
			public void onClick() {
				((GameScreen) getGame().getScreenManager().getScreen("game")).restartGame();
				((GameScreen) getGame().getScreenManager().getScreen("game")).createGame();
				getGame().setScreen("game");
			}
			@Override
			public void onOver() {
				
			}
			@Override
			public void onUnOver() {
				
			}			
		});
		addGameObject(new Button("Reglas", new GameLocation(930, 500), game, new ObjectDimension(200, 70)) {
			@Override
			public void onClick() {
				getGame().setScreen("rules");
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
	public void internalTick() {
		
	}
	@Override
	protected void paintLevel(Graphics g) {
		g.setColor(new Color(Utils.random.nextInt(255), Utils.random.nextInt(255), Utils.random.nextInt(255)));
		g.setFont(font);
		g.drawString("BOOM!", 530, 525);
		g.drawImage(Main.getInstance().getTextureManager().getTexture(TexturePath.LOGO.getName()).getTexture(TextureDistance.LOD), 375, 75, 447, 395, null, null);
	}
}

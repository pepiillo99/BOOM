package me.pepe.JuegoSSII.Screen;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import me.pepe.GameAPI.Game.Game;
import me.pepe.GameAPI.Screen.Screen;
import me.pepe.GameAPI.TextureManager.TextureDistance;
import me.pepe.GameAPI.TextureManager.Texture.Texture;
import me.pepe.GameAPI.TextureManager.Texture.UniqueTexture;
import me.pepe.GameAPI.Utils.Callback;
import me.pepe.GameAPI.Windows.Windows;
import me.pepe.JuegoSSII.Main;
import me.pepe.JuegoSSII.Utils.TexturePath;

public class LoadScreen extends Screen {
	private int contentLoaded = 0;
	private int toLoad = 4;
	private int loaded = 0;
	private int leavetime = 0;
	private BufferedImage logoTexture;
	private boolean error = false;
	public LoadScreen(Windows windows, Game game) {
		super(windows, game);
		new Thread() {
			@Override
			public void run() {
				try {
					logoTexture= ImageIO.read(getClass().getClassLoader().getResourceAsStream("images/logo.png"));
				} catch (IOException e) {
					e.printStackTrace();
				}
				toLoad += TexturePath.values().length;
				try {
					sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				for (TexturePath tp : TexturePath.values()) {
					Texture tex = new UniqueTexture(tp.getName());
					Main.getInstance().getTextureManager().registerTexture(tex);
					tex.registerImage(TextureDistance.LOD, tp.getPath());
					tex.loadDistance(TextureDistance.LOD, new Callback<Boolean>() {
						@Override
						public void done(Boolean result, Exception ex) {
							if (result) {
								addToLoad();
							} else {
								System.out.println("Error al cargar " + tp.getName() + " " + ex.getMessage());
							}
						}							
					});				
				}
				getGame().getScreenManager().registerNewScreen("game", new GameScreen(windows, game));
				addToLoad();
				getGame().getScreenManager().registerNewScreen("main", new MainScreen(windows, game));
				addToLoad();
				getGame().getScreenManager().registerNewScreen("winlose", new WinLoseScreen(windows, game));
				addToLoad();
				getGame().getScreenManager().registerNewScreen("rules", new RulesScreen(windows, game));
				addToLoad();
				/**
				getGame().getScreenManager().registerNewScreen("attack", new AttackScreen(game.getWindows(), game));
				addToLoad();
				getGame().getScreenManager().registerNewScreen("you", new YourBoatsScreen(game.getWindows(), game));
				addToLoad();
				getGame().getScreenManager().registerNewScreen("main", new MainScreen(game.getWindows(), game));
				addToLoad();
				SinkTheFloat.getInstance().getFontManager().registerFont("Airborne", "Airborne.ttf");
				addToLoad();
				*/
			}
		}.start();
	}
	private void addToLoad() {
		contentLoaded++;
		loaded = contentLoaded * 100 / toLoad;		
	}
	@Override
	public void internalTick() {
		if (loaded == 100) {
			leavetime++;
			if (leavetime >= getGame().getMaxTPS() * 2) {
				getGame().setScreen("main");
			}
		}
	}
	@Override
	protected void paintLevel(Graphics g) {
		g.setColor(Color.blue);
		g.fillRect(0, 0, getWindows().getX(), getWindows().getY());
		g.setColor(loaded != 100 ? (error ? Color.RED : Color.WHITE) : Color.GREEN);
		g.drawRect(getWindows().getX() / 4, (int) (getWindows().getY() / 1.5), getWindows().getX() / 2, 50);
		g.setColor(loaded != 100 ? (error ? Color.RED : Color.WHITE) : Color.GREEN);
		if (error) {
			g.fillRect((getWindows().getX() / 4) + 4, (int) (getWindows().getY() / 1.5) + 4, (getWindows().getX() / 2) - 8, 50 - 8);
		} else {
			int maxLoad = (getWindows().getX() / 2) - 8;
			int calc = (maxLoad * loaded) / 100;
			g.fillRect((getWindows().getX() / 4) + 4, (int) (getWindows().getY() / 1.5) + 4, calc, 50 - 8);
		}
		g.setColor(loaded != 100 ? (error ? Color.RED : Color.WHITE) : Color.GREEN);
		g.setFont(new Font("Aria", Font.PLAIN, 20));
		g.drawString(loaded != 100 ? (error ? "Error" : loaded + "%") : "100% :-)", 565, 575);
		g.drawImage(logoTexture, 400, 50, 400, 400, null, null);
	}
}

package me.pepe.GameAPI.TextureManager;

import java.awt.Color;
import java.awt.Graphics;

import me.pepe.GameAPI.TextureManager.Texture.Texture;
import me.pepe.GameAPI.Utils.GameLocation;
import me.pepe.GameAPI.Utils.ObjectDimension;
import me.pepe.GameAPI.Utils.Utils;

public abstract class Animation {
	private Texture[] textures;
	private long durationPerFotogram = 0;
	private GameLocation loc;
	private ObjectDimension dim;
	private int pos = 0;
	private boolean bucle = false;
	private boolean finish = false;
	private long timer = 0;
	public Animation(Texture[] textures, long durationPerFotogram, GameLocation loc, ObjectDimension dim) {
		this.textures = textures;
		this.durationPerFotogram = durationPerFotogram;
		this.loc = loc;
		this.dim = dim;
		this.timer = durationPerFotogram + System.currentTimeMillis();
	}
	public void render(Graphics g) {
		if (!finish) {
			if (textures[pos].isTextureDistanceLoaded(textures[pos].getMaxTextureDistance())) {
				g.drawImage(textures[pos].getTexture(textures[pos].getMaxTextureDistance()), loc.getX(), loc.getY(), dim.getX(), dim.getY(), null, null);
			} else {
				g.setColor(Utils.random.nextBoolean() ? Color.WHITE : Color.BLACK);
				g.fillRect(loc.getX(), loc.getY(), dim.getX(), dim.getY());
			}
			if (timer - System.currentTimeMillis() <= 0) {
				timer = durationPerFotogram + System.currentTimeMillis();
				pos++;
				if (pos >= textures.length) {
					if (bucle) {
						pos = 0;
					} else {
						finish = true;
						onFinish();
					}
				}
			}
		}
	}
	public void setBucle(boolean bucle) {
		this.bucle = bucle;
	}
	public abstract void onFinish();
}

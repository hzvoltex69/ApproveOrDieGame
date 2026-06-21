package com.mygdx.game.courses;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.MathUtils;
import com.mygdx.game.drops.BadDrop;
import com.mygdx.game.drops.Drop;
import com.mygdx.game.drops.GoodDrop;
import com.mygdx.game.drops.PowerUpDrop;

public abstract class DropStrategy {
	public abstract float getDropSpeed();
	public abstract float getSpawnRate();
	public abstract float getBadDropChance();
	public abstract float getPowerUpChance();
	
	public Drop createDrop(Texture goodTexture, Texture badTexture, Texture powerUpTexture, int vidas) {
        float rand = MathUtils.random();
        if (rand < getBadDropChance())
            return new BadDrop(badTexture, getDropSpeed());
        else if (vidas < 3 && rand < getBadDropChance() + getPowerUpChance())
            return new PowerUpDrop(powerUpTexture, getDropSpeed());
        else
            return new GoodDrop(goodTexture, getDropSpeed());
    }
}
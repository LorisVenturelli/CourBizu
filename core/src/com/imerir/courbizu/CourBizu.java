package com.imerir.courbizu;

import com.badlogic.gdx.Game;
import com.imerir.courbizu.screens.GameScreen;
import com.imerir.courbizu.utils.FontManager;

public class CourBizu extends Game {

	@Override
	public void create() {
		FontManager.loadFont();
		setScreen(new GameScreen());
	}

}

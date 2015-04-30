package com.imerir.courbizu.utils;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;

import java.util.HashMap;

/**
 * Created by rcdsm on 30/04/15.
 */
public class FontManager {
    private static BitmapFont smallFont;
    private static BitmapFont largeFont;

    private FontManager() {

    }

    public static void loadFont() {

        FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("font.ttf"));
        FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
        parameter.size = 36;
        smallFont = generator.generateFont(parameter);
        smallFont.setColor(.21f, .22f, .21f, 1f);
        parameter.size = 72;
        largeFont = generator.generateFont(parameter);
        largeFont.setColor(.21f, .22f, .21f, 1f);
        generator.dispose();

    }
    public static BitmapFont getSmallFont() {
        return smallFont;
    }

    public static BitmapFont getLargeFont() {
        return largeFont;
    }

    public static void dispose() {
        smallFont.dispose();
        largeFont.dispose();
    }
}

package com.imerir.courbizu.enums;


import com.imerir.courbizu.utils.Constants;

/**
 * Created by rcdsm on 29/04/15.
 */
public enum CoinType {

    FLYING_SMALL(1f, 1f, Constants.COIN_X, Constants.FLYING_COIN_Y, Constants.COIN_DENSITY, Constants.FLYING_SMALL_COIN_REGION_NAMES);

    private float width;
    private float height;
    private float x;
    private float y;
    private float density;
    private String[] regions;

    CoinType(float width, float height, float x, float y, float density, String[] regions) {
        this.width = width;
        this.height = height;
        this.x = x;
        this.y = y;
        this.density = density;
        this.regions = regions;
    }

    public float getWidth() {
        return width;
    }

    public float getHeight() {
        return height;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public float getDensity() {
        return density;
    }

    public String[] getRegions() {
        return regions;
    }
}

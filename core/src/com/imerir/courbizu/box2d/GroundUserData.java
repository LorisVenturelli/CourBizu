package com.imerir.courbizu.box2d;

import com.imerir.courbizu.enums.UserDataType;

/**
 * Created by rcdsm on 29/04/15.
 */
public class GroundUserData extends UserData {

    public GroundUserData(float width, float height) {
        super(width, height);
        userDataType = UserDataType.GROUND;
    }

}
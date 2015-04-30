package com.imerir.courbizu.utils;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;

/**
 * Created by rcdsm on 30/04/15.
 */
public class AudioManager {

    private static AudioManager ourInstance = new AudioManager();
    private static Music music;
    private static Sound coinSound;

    private AudioManager() {
    }

    public static AudioManager getInstance() {
        return ourInstance;
    }

    public void init() {
        music = Gdx.audio.newMusic(Gdx.files.internal("music.mp3"));
        music.setLooping(true);
        playMusic();

        //coinSound = createSound("coin.wav");
    }

    public Sound createSound(String soundFileName) {
        return Gdx.audio.newSound(Gdx.files.internal(soundFileName));
    }

    public void playMusic() {
        music.play();
    }

    public void pauseMusic() {
        music.pause();
    }

    public void stopMusic() {
        music.stop();
    }

    public void restartMusic() {
        stopMusic();
        playMusic();
    }

    public void playCoinSound() {
        coinSound.play();
    }

    public void stopCoinSound() {
        coinSound.stop();
    }

    public static void dispose() {
        music.dispose();
        coinSound.dispose();
    }

}


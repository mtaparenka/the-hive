package com.mtaparenka.hivegameserver;

public enum GameStatus {
    GAME_STARTED("gameStarted");

    public final String value;

    GameStatus(String value) {
        this.value = value;
    }
}

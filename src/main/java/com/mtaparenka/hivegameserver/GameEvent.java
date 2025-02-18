package com.mtaparenka.hivegameserver;

public abstract class GameEvent {
    public final String gameId;

    public GameEvent(String gameId) {
        this.gameId = gameId;
    }
}

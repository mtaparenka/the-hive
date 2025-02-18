package com.mtaparenka.hivegameserver;

public class GameStartedEvent extends GameEvent {
    public final GameConfig gameConfig;
    public GameStartedEvent(String gameId, GameConfig gameConfig) {
        super(gameId);
        this.gameConfig = gameConfig;
    }
}

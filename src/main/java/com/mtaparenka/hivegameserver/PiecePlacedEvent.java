package com.mtaparenka.hivegameserver;

public class PiecePlacedEvent extends GameEvent {
    public PiecePlacedEvent(String gameId, String playerId, Piece piece, Vector3 position) {
        super(gameId);
    }
}

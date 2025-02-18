package com.mtaparenka.hivegameserver;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class GameEngine {
    private final GameEventsStorage gameEventsStorage;
    private final GameConfigStorage gameConfigStorage;

    public GameEngine(GameEventsStorage gameEventsStorage, GameConfigStorage gameConfigStorage) {
        this.gameEventsStorage = gameEventsStorage;
        this.gameConfigStorage = gameConfigStorage;
    }

    public String startGame(String player1Id, String player2Id) {
        String gameId = UUID.randomUUID().toString();

        //gameEventsStorage.saveEvent(new GameStartedEvent(gameId, player1Id, player2Id));

        return gameId;
    }

    public void movePiece(String gameId, String playerId, Vector3 from, Vector3 to) {
    }

    public void placePiece(String gameId, String playerId, Piece piece, Vector3 to) {
        GameState gameState = buildGameState(gameId);


        GameEvent event = new PiecePlacedEvent(gameId, playerId, piece, to);

        gameEventsStorage.saveEvent(event);
    }

    private GameState buildGameState(String gameId) {
        List<GameEvent> events = gameEventsStorage.getGameEvents(gameId);
        GameConfig gameConfig = gameConfigStorage.getGameConfig(gameId);
        GameStatus gameStatus = null;
        Map<Vector3, Piece> field = new HashMap<>();
        String nextTurnPlayer = "";

        for (GameEvent event: events) {
            switch (event) {
                case GameStartedEvent e -> {
                    gameStatus = GameStatus.GAME_STARTED;
                    nextTurnPlayer = e.gameConfig.nextTurnPlayer();
                }

                case PiecePlacedEvent e -> {

                }

                case PieceMovedEvent e -> {

                }

                default -> throw new IllegalStateException("Unexpected value: " + event);
            }
        }

        return new GameState(gameId, gameStatus, field, nextTurnPlayer);
    }
}

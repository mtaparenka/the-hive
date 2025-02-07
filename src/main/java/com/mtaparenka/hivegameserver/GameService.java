package com.mtaparenka.hivegameserver;

public class GameService {
    private final GameStateStorage gameStateStorage;

    public GameService(GameStateStorage gameStateStorage) {
        this.gameStateStorage = gameStateStorage;
    }

    public String startGame(String player1Id, String player2Id) {
        gameStateStorage.saveEvent(new GameStartedEvent(null, player1Id, player2Id));

        return null;
    }

    public void movePiece(String gameId, String playerId, Vector3 from, Vector3 to) {
        //TODO validate method parameters
        GameState gameState = gameStateStorage.getGameState(gameId);
        Piece piece = gameState.field().get(from);
        //validate turn

        if (!piece.canMoveTo(gameState.field(), to)) {
            throw new RuntimeException("Illegal turn");
        }

        GameEvent event = new PieceMovedEvent(gameId, playerId, piece, from, to);

        gameStateStorage.saveEvent(event);
    }

    public void placePiece(String gameId, String playerId, Piece piece, Vector3 to) {
        GameState gameState = gameStateStorage.getGameState(gameId);


        GameEvent event = new PiecePlacedEvent(gameId, playerId, piece, to);

        gameStateStorage.saveEvent(event);
    }

    /*private static void validateGameStatus(GameState gameState) {
        if (!"ACTIVE".equals(gameState.gameStatus())) {
            throw new RuntimeException("Game " + gameState.gameId() + " is not active");
        }
    }

    private static void validatePlayerEligibility(String playerId, Piece piece, GameState gameState) {
        if (!playerId.equals(gameState.activePlayerId())) {
            throw new RuntimeException("Player " + playerId + " is not eligible to make a turn");
        }

        if (playerId.equals(gameState.player1Id())) {
            if (!piece.color().equals(gameState.player1PieceColor())) {
                throw new RuntimeException("Player " + playerId + " cannot move " + piece.color() + " pieces");
            }
        } else {
            if (!piece.color().equals(gameState.player2PieceColor())) {
                throw new RuntimeException("Player " + playerId + " cannot move " + piece.color() + " pieces");
            }
        }
    }*/
}

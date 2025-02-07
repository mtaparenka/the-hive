package com.mtaparenka.hivegameserver;

import java.util.Map;

public record GameState(
        String gameId,
        String gameStatus,
        Map<Vector3, Piece> field,
        String player1Id,
        String player2Id,
        String player1PieceColor,
        String player2PieceColor,
        String activePlayerId) {
}

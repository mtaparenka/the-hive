package com.mtaparenka.hivegameserver;

public record GameConfig(
        String player1Id,
        String player2Id,
        PieceColor player1PieceColor,
        PieceColor player2PieceColor,
        String nextTurnPlayer) {
}

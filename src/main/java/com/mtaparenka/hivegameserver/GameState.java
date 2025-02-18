package com.mtaparenka.hivegameserver;

import java.util.Map;

public record GameState(
        String gameId,
        GameStatus gameStatus,
        Map<Vector3, Piece> field,
        String activePlayerId) {
}

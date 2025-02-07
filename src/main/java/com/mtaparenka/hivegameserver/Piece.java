package com.mtaparenka.hivegameserver;

import java.util.Map;
import java.util.Set;

public abstract class Piece {
    public final String color;

    public Piece(String color) {
        this.color = color;
    }

    public abstract boolean canMoveTo(Map<Vector3, Piece> field, Vector3 to);
    public abstract Set<Vector3> getPossibleMoves(Map<Vector3, Piece> field);
}

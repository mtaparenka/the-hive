package com.mtaparenka.hivegameserver;

import java.util.LinkedHashMap;
import java.util.Map;

public class Field {
    //clockwise, starting from north-east
    private static final Vector3[] CELL_DIRECTIONS = new Vector3[]{
            new Vector3(1, -1, 0), //north-east
            new Vector3(1, 0, -1), //east
            new Vector3(0, 1, -1), //south-east
            new Vector3(-1, 1, 0), //south-west
            new Vector3(-1, 0, 1), //west
            new Vector3(0, -1, 1), //north-west
    };

    private final Map<Vector3, Piece> field = new LinkedHashMap<>();
    private final Object writeLock = new Object();

    public void putPiece(Vector3 cell, Piece piece) {
        synchronized (writeLock) {
            if (field.isEmpty()) {
                field.put(new Vector3(0, 0, 0), piece);

                for (Vector3 vector : CELL_DIRECTIONS) {
                    field.put(vector, null);
                }
            } else {
                if (!field.containsKey(cell)) {
                    field.put(cell, piece);
                }

                for (Vector3 vector : CELL_DIRECTIONS) {
                    Vector3 newVector = new Vector3(vector.q() + cell.q(), vector.r() + cell.r(), vector.s() + cell.s());

                    if (!field.containsKey(newVector)) {
                        field.put(newVector, null);
                    }
                }
            }
        }
    }

    @Override
    public String toString() {
        return field.toString();
    }
}

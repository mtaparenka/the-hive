package com.mtaparenka.hivegameserver;

public record Vector3(int q, int r, int s) {

    public Vector3(int q, int r, int s) {
        this.q = q;
        this.r = r;
        this.s = s;
    }

    public Vector3(Vector3 vector) {
        this(vector.q, vector.r, vector.s);
    }

    public Vector3 add(Vector3 vector) {
        return new Vector3(q + vector.q, r + vector.r, s + vector.s);
    }
}

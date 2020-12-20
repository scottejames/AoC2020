package com.scottejames.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Tripple {


    public int x = 0;
    public int y = 0;
    public int z = 0;
    public int w = 0;


    public Tripple(int x, int y, int z,int w) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.w = w;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tripple tripple = (Tripple) o;
        return x == tripple.x &&
                y == tripple.y &&
                z == tripple.z &&
                w == tripple.w;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y, z, w);
    }
}

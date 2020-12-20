package com.scottejames.utils;

import java.util.HashSet;
import java.util.List;

public class SparceGrid {

    private int minX = Integer.MAX_VALUE;
    private int minY = Integer.MAX_VALUE;
    private int minZ = Integer.MAX_VALUE;
    private int minW = Integer.MAX_VALUE;
    private int maxX = Integer.MIN_VALUE;
    private int maxY = Integer.MIN_VALUE;
    private int maxZ = Integer.MIN_VALUE;
    private int maxW = Integer.MIN_VALUE;

    char empty = ' ';
    char initial = '.';

    private HashSet<Tripple> grid = new HashSet<>();

    public SparceGrid(List<Tripple> grid) {
        for (Tripple coord : grid) {
            setActive( coord,this.grid);
        }
    }
    private void setActive( Tripple coord,HashSet<Tripple> grid) {
        this.minX = Math.min(this.minX, coord.x - 1);
        this.minY = Math.min(this.minY, coord.y - 1);
        this.minZ = Math.min(this.minZ, coord.z - 1);
        this.minW = Math.min(this.minW, coord.w - 1);
        this.maxX = Math.max(this.maxX, coord.x + 1);
        this.maxY = Math.max(this.maxY, coord.y + 1);
        this.maxZ = Math.max(this.maxZ, coord.z + 1);
        this.maxW = Math.max(this.maxW, coord.w + 1);
        grid.add(coord);
    }
    public int countActive() {
        return this.grid.size();
    }

    private int countNeighbors(Tripple coord) {
        int count = 0;
        for (int x = coord.x - 1; x <= coord.x + 1; x++) {
            for (int y = coord.y - 1; y <= coord.y + 1; y++) {
                for (int z = coord.z - 1; z <= coord.z + 1; z++) {
                    if (x == coord.x && y == coord.y && z == coord.z) {
                        continue;
                    }
                    count += this.grid.contains(new Tripple(x, y, z, 0)) ? 1 : 0;
                }
            }
        }
        return count;
    }
    private int countNeighbors4d(Tripple coord) {
        int count = 0;
        for (int x = coord.x - 1; x <= coord.x + 1; x++) {
            for (int y = coord.y - 1; y <= coord.y + 1; y++) {
                for (int z = coord.z - 1; z <= coord.z + 1; z++) {
                    for (int w = coord.w - 1; w <= coord.w + 1; w++) {
                        if (x == coord.x && y == coord.y && z == coord.z && w == coord.w) {
                            continue;
                        }
                        count += this.grid.contains(new Tripple(x, y, z, w)) ? 1 : 0;
                    }
                }
            }
        }
        return count;
    };
    public void tick4d() {
        final HashSet<Tripple> newGrid = new HashSet<>();

        for (int x = this.minX ; x <= maxX; x++) {
            for (int y = this.minY; y <= maxY; y++) {
                for (int z = this.minZ; z <= maxZ; z++) {
                    for (int w = this.minW; w <= maxW; w++) {
                        final Tripple coord = new Tripple(x, y, z, w);
                        final int neighbors = countNeighbors4d(coord);
                        final boolean status = this.grid.contains(coord);
                        if (status && (neighbors == 2 || neighbors == 3)) {
                            setActive(coord, newGrid);
                        } else if (!status && neighbors == 3) {
                            setActive(coord, newGrid);
                        }
                    }
                }
            }
        }
        this.grid = newGrid;
    }
    public void tick() {
        final HashSet<Tripple> newGrid = new HashSet<>();


        for (int x = this.minX ; x <= maxX; x++) {
            for (int y = this.minY; y <= maxY; y++) {
                for (int z = this.minZ; z <= maxZ; z++) {

                    final Tripple coord = new Tripple(x, y, z, 0);
                    final int neighbors = countNeighbors(coord);
                    final boolean status = this.grid.contains(coord);
                    if (status && (neighbors == 2 || neighbors == 3)) {
                        setActive(coord,newGrid);
                    } else if (!status && neighbors == 3) {
                        setActive(coord,newGrid);
                    }
                }
            }
        }

        this.grid = newGrid;
    }

    public void showGrid(){

        for (int z=minZ; z<= maxZ;z++){
            System.out.println("z : " + z);
            for (int y=minY; y <= maxY;y++){
                for (int x=minX; x <=maxX;x++){
                    final boolean status = this.grid.contains(new Tripple(x, y, z, 0));
                    char c = status?'#':'.';
                    System.out.print(c);
                }
                System.out.println("");
            }
        }

    }

}

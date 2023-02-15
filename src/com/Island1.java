package com;

import java.util.Set;

class Island1 {
    public int numIslands(char[][] grid) {
        //Set<Integer>
        boolean[][] visited = new boolean[grid.length][grid[0].length];

        int count = 0;
        for(int m = 0; m < grid.length; m++){
            for(int n = 0; n < grid[0].length; n++){
                if(checkIsland(false, m, n, grid, visited)){
                    count++;
                }
            }
        }
        return count;
    }

    public boolean checkIsland(boolean parentIsland, int i, int j,
                               char[][] grid,
                               boolean[][] visited){
        if(visited[i][j] || i < 0 || j< 0
                || i >= grid.length || j >= grid[0].length){
            return false;
        }

        visited[i][j] = true;

        if(grid[i][j] == '1'){
            checkIsland(true, i - 1, j, grid, visited);
            checkIsland(true, i, j - 1, grid, visited);
            checkIsland(true, i + 1 , j, grid, visited);
            checkIsland(true, i , j + 1, grid, visited);
            return !parentIsland;
        }

        return false;
    }

    public static void main(String[] args) {
        Island1 island1 = new Island1();
        char[][] grid = new char[][]{{'1','1','1'},{'0','1','0'},{'1','1','1'}};
        System.out.println(island1.numIslands(grid));
    }
}
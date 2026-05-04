package org.example.SnakeAndLadder;

import java.util.ArrayList;

public class Board {
    ArrayList<Snake> snakeList = new ArrayList<>();
    ArrayList<Ladder> ladderList  = new ArrayList<>();
    ArrayList<Player> playerList = new ArrayList<>();
    int[][]board = new int[10][10];


    public void setLadderList(ArrayList<Ladder> ladderList) {
        this.ladderList = ladderList;
    }

    public void setSnakeList(ArrayList<Snake> snakeList) {
        this.snakeList = snakeList;
    }

    public void setPlayerList(ArrayList<Player> playerList) {
        this.playerList = playerList;
    }
}

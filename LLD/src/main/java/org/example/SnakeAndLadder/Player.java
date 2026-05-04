package org.example.SnakeAndLadder;

public class Player {
    String name;
    String id;
    int row;
    int col;

    Player(String name,String id)
    {
        this.name = name;
        this.id = id;
        this.row = 0;
        this.col = 0;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public void setCol(int col) {
        this.col = col;
    }

    Dice dice = new Dice();
    public int rollDice()
    {
        return dice.roll();
    }


}

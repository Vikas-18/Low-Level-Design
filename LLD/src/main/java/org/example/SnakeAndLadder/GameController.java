package org.example.SnakeAndLadder;

import java.util.ArrayList;
import java.util.List;

public class GameController {
    public static void main(String[] args) {
        ArrayList<Ladder> ladders = new ArrayList<>();
        ArrayList<Snake> snakes = new ArrayList<>();
        ArrayList<Player> players = new ArrayList<>();
        Ladder ladder1 = new Ladder(2,5,4,5);
        Ladder ladder2 = new Ladder(6,3,7,6);
        Ladder ladder3 = new Ladder(4,3,9,6);
        Ladder ladder4 = new Ladder(5,3,8,6);

        Snake snake1 = new Snake(3,3,1,1);
        Snake snake2 = new Snake(9,9,1,1);
        Snake snake3 = new Snake(7,9,2,1);
        Snake snake4 = new Snake(4,6,3,1);

        Player player1 = new Player("Vikas","1");
        Player player2 = new Player("Nilabjo","2");

        Board board = new Board();
        board.setLadderList(ladders);
        board.setSnakeList(snakes);
        board.setPlayerList(players);

        boolean player1Turn = true;

        while (true) {

            if (player1Turn) {

                int number = player1.rollDice();
                System.out.println(player1.name + " got " + number);

                int currRow = player1.row;
                int currCol = player1.col;

                int newRow = currRow;
                int newCol = currCol + number;

                // Handle row crossing
                if (newCol >= 10) {
                    newRow += newCol / 10;
                    newCol = newCol % 10;
                }

                int newPosition = newRow * 10 + newCol;

                // Check bounds BEFORE updating player
                if (newPosition > 99) {
                    System.out.println("Out of bounds move for "+player1.name);
                } else {
                    player1.setRow(newRow);
                    player1.setCol(newCol);

                    System.out.println(player1.name+" new position " + newPosition);

                    if (newPosition == 99) {
                        System.out.println(player1.name +" won");
                        break;
                    }
                }

                if (number != 6) {
                    player1Turn = false;
                }

            } else {

                int number = player2.rollDice();
                System.out.println(player2.name + " got " + number);

                int currRow = player2.row;
                int currCol = player2.col;

                int newRow = currRow;
                int newCol = currCol + number;

                if (newCol >= 10) {
                    newRow += newCol / 10;
                    newCol = newCol % 10;
                }

                int newPosition = newRow * 10 + newCol;

                if (newPosition > 99) {
                    System.out.println("Out of bounds move for "+ player2.name);
                } else {
                    player2.setRow(newRow);
                    player2.setCol(newCol);

                    System.out.println(player2.name+" new position " + newPosition);

                    if (newPosition == 99) {
                        System.out.println(player2.name+" won");
                        break;
                    }
                }

                if (number != 6) {
                    player1Turn = true;
                }
            }
        }





    }
}

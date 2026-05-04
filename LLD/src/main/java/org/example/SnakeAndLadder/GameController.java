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
        while(true)
        {
            if(player1Turn)
            {

                int number = player1.rollDice();
                System.out.println("Player1 got " + number);
                int currRow = player1.row;
                int currCol = player1.col;
                int position = 0;
                if((currCol+number)%10!=0)
                {
                    currRow++;
                    position = (currRow*10)+currCol+number;
                    currCol = (currCol+number)%10;
                    player1.setRow(currRow);
                    player1.setCol(currCol);
                }
                else {
                    position = (currRow*10)+currCol+number;
                    currCol = (currCol+number)%10;
                    player1.setRow(currRow);
                    player1.setCol(currCol);
                }

                System.out.println("Player 1 new position "+ position);
                if(position==99)
                {
                    System.out.println("Player1 won");
                    break;
                }
                if(number!=1 && number!=6)
                {
                    player1Turn = false;
                }
            }
            else {
                int number = player2.rollDice();
                System.out.println("Player2 got " + number);
                int currRow = player2.row;
                int currCol = player2.col;
                int position = 0;
                if((currCol+number)%10!=0)
                {
                    currRow++;
                    position = (currRow*10)+currCol+number;
                    currCol = (currCol+number)%10;
                    player2.setRow(currRow);
                    player2.setCol(currCol);
                }
                else {
                    position = (currRow*10)+currCol+number;
                    currCol = (currCol+number)%10;
                    player2.setRow(currRow);
                    player2.setCol(currCol);
                }

                System.out.println("Player 2 new position "+ position);
                if(position==99)
                {
                    System.out.println("Player2 won");
                    break;
                }
                if(number!=1 && number!=6)
                {
                    player1Turn = true;
                }
            }
        }





    }
}

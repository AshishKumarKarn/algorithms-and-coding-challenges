package com.karn.design.LLD;

import java.util.*;
import java.util.stream.Collectors;

public class SnakeLadderGame {
    public static void main(String[] args) {
        Player player1 = new Player("Ashish");
        Player player2 = new Player("Amit");
        Player player3 = new Player("Alok");
        List<Player> players = List.of(player1,player2,player3);
        Dice dice = new Dice(2);

        Board board = new DefaultBoard(dice);
        playGame(players, board);
        Board board2 = new CustomBoard(dice, 3, 12, 1000);
        playGame(players, board2);
    }

    private static void playGame(List<Player> players, Board board) {
        //reset players
        resetPlayersState(players);
        List<Player> activePlayers= new ArrayList<>(players);
        while((activePlayers.size()>1)){
            boolean anyOneWon = false;
            for (Player p:activePlayers){
                board.rollDice(p);
                System.out.println(p.getName() +" is at "+ p.getPosition());
                if(p.isWon()) {
                    System.out.println(p.getName() +" won!!");
                    anyOneWon = true;
                    break;
                }
            }
            if(anyOneWon)
                activePlayers = activePlayers.stream().filter(Player::isWon).toList();
        }
    }

    private static void resetPlayersState(List<Player> players) {
        for (Player p: players){
            p.setPosition(1);
            p.setWon(false);
        }
    }


}
class DefaultBoard extends Board{
    DefaultBoard(Dice dice){
        super(dice, 5, 5,100);

    }
}
class CustomBoard extends Board{
    CustomBoard(Dice dice, int snakesCount, int ladderCount, int boardSize){
        super(dice, snakesCount, ladderCount,boardSize);

    }
}
abstract class Board{

    private Map<Integer, Integer> snakes;
    private Map<Integer, Integer> ladder;
    protected int size;
    private Dice dice;
    public Board(Dice dice, int snakesCount, int ladderCount, int boardSize){
        if(boardSize<30){
            throw new IllegalArgumentException("Board Size should be more than size 30");
        }
        initBoard(dice, snakesCount,ladderCount, boardSize);
    }

    private void initBoard(Dice dice, int snakesCount, int ladderCount, int boardSize) {
        this.dice = dice;
        this.size=boardSize;
        snakes = new HashMap<>();
        ladder = new HashMap<>();
        while (snakesCount>0){
            int head = generateRandom( 20, boardSize-10);//all snakes or ladder should stay under 10th and 95th index
            while(snakes.containsKey(head)){
                head = generateRandom(20,boardSize-10);
            }
            int tail = generateRandom(10, head );
            snakes.put(head, tail);
            snakesCount--;
        }
        while (ladderCount>0){
            int down = generateRandom( 10, boardSize-10);//all snakes or ladder should stay under 10th and 95th index
            while(snakes.containsKey(down)){//ladder and snake can't stay together
                down = generateRandom(20,boardSize-10);
            }
            while(ladder.containsKey(down)){//two ladder can't stay together
                down = generateRandom(20,boardSize-10);
            }

            int up = generateRandom(down+1, boardSize-10 );
            while(snakes.containsKey(up)){//ladder and snake can't stay together
                up = generateRandom(down+1,boardSize-10);
            }
            while(ladder.containsKey(up)){//two ladder can't stay together
                up = generateRandom(down+1,boardSize-10);
            }
            ladder.put(down, up);
            ladderCount--;
        }

    }

    Random random = new Random();
    private int generateRandom(int i, int j) {
        return random.nextInt(i, j);
    }

    public void rollDice(Player p){
        int inc = this.dice.rollDice(this.random);
        System.out.println("Dice output "+inc);
        updatePlayerPosition(p, inc);
    }

    private void updatePlayerPosition(Player p, int inc) {
        int newTempPosition = p.getPosition()+ inc;
        if(newTempPosition>size){
            return;
        }
        if(newTempPosition==size){
            System.out.println(p.getName()+" reached");
            p.setPosition(size);
            p.setWon(true);
            return;
        }
        if(ladder.containsKey(newTempPosition)){
            System.out.println(p.getName()+" got ladder from" +newTempPosition+" to "+ ladder.get(newTempPosition));
            p.setPosition(ladder.get(newTempPosition));
            return;
        }else if(snakes.containsKey(newTempPosition)){
            System.out.println(p.getName()+" got snake from" +newTempPosition+" to "+ snakes.get(newTempPosition));
            p.setPosition(snakes.get(newTempPosition));
            return;
        }
        p.setPosition(newTempPosition);
    }

}
class Player{
    private int position;
    private boolean won;
    private final String name;

    public Player(String name) {
        this.position = 0;
        this.won = false;
        this.name = name;
    }

    public void setWon(boolean won) {
        this.won = won;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public boolean isWon() {
        return won;
    }
}
class Dice{
    private int numberOfDice;
    Dice(int numberOfDice){
        this.numberOfDice = numberOfDice;
    }
    Dice() { this.numberOfDice = 1;}

    public int getNumberOfDice() {
        return numberOfDice;
    }

    int rollDice(Random random){
        return random.nextInt(numberOfDice, numberOfDice*6+1);
    }
}
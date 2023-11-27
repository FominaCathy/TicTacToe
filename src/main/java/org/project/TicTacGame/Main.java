package org.project.TicTacGame;

import org.project.TicTacGame.Game.ConsoleUI;

public class Main {

    public static void main(String[] args) {
        int sizeField = 5;
        int winCount = 4;
        ConsoleUI.game(sizeField, winCount);

    }

}
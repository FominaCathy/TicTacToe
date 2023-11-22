package org.project.TicTacGame;

import java.util.Scanner;

public class ConsoleUI {
    static Scanner scanner = new Scanner(System.in);

    /**
     * игра
     */
    public static void game() {
        //TODO доделать класс
        boolean stop = false;
        TicTacGame game = new TicTacGame(5, 3);
        Robot robot = new Robot(game);

        while (!stop) {
            game.startGame();
            boolean finish = false;


            game.printField();
            //TODO есть какая-то проблема. пока не могу поймать
            while (!finish) {
                stepGamer();
                if (game.checkWin(TicTacGame.getDotGamer())) {
                    System.out.println("Ура! вы победили");
                    finish = true;
                } else {
                    stepRobot(robot);

                    if (game.checkWin(TicTacGame.getDotRobot())) {
                        System.out.println("Победил робот");
                        finish = true;
                    }
                }
                game.printField();
            }
            if (!nextGame()) {
                stop = true;
            }
        }
        System.out.println("Пока!");
    }

    /**
     * шаг игрока
     */
    public static void stepGamer() {
        boolean flag = false;
        System.out.println("ваш ход (введите номер строки и столбца через пробел):");
        while (!flag) {

            String step = scanner.nextLine();
            if (step.matches("[0-9+]\\s[0-9+]")) {
                int i = Integer.parseInt(step.split(" ")[0]);
                int j = Integer.parseInt(step.split(" ")[1]);
                flag = TicTacGame.stepGame(i - 1, j - 1, TicTacGame.getDotGamer());
            }
            if (!flag) {
                System.out.println("ошибка. поробуйте еще раз");
            }
        }
    }

    /**
     * шаг робота
     * @param robot
     */
    public static void stepRobot(Robot robot) {
        int[] coord = robot.step();
        TicTacGame.stepGame(coord[0], coord[1], TicTacGame.getDotRobot());
    }

    /**
     * запрос у ирока будет ли он игратть следующий раунд
     * @return
     */
    public static boolean nextGame() {
        System.out.println("Сыграем еще раз? Да: укажи Y, y, Д, д. Нет: любой другой символ");
        String step = scanner.nextLine();
        if (step.matches("[YyДд]")) {
            return true;
        }
        return false;
    }
}

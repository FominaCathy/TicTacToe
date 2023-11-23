package org.project.TicTacGame;

/**
 * игра крестики-нолики. минимальный размер поля = 3 минимальное кол-во фишек для победы = 3
 */
public class TicTacGame {
    private static char dotGamer = 'X';
    private static char dotRobot = 'O';
    private static char empty = '*';
    private static int sizeField;
    private static int lastXGamer;
    private static int lastYGamer;
    private static int winCount;


    private static char[][] field;

    public TicTacGame(int sizeField, int winCount) {
        this.sizeField = Math.max(sizeField, 3);
        this.winCount = Math.min(Math.max(winCount, 3), Math.max(sizeField, 3));


        field = new char[sizeField][sizeField];

    }

    public static char getEmpty() {
        return empty;
    }

    public static int getSizeField() {
        return sizeField;
    }

    public static char[][] getField() {
        return field;
    }

    public static char getDotGamer() {
        return dotGamer;
    }

    public static char getDotRobot() {
        return dotRobot;
    }

    public static int getLastXGamer() {
        return lastXGamer;
    }

    public static int getLastYGamer() {
        return lastYGamer;
    }

    public static int getWinCount() {
        return winCount;
    }

    public static boolean stepGame(int i, int j, char dot) {
        if ((i < sizeField) && (j < sizeField) && (field[i][j] == empty)) {
            TicTacGame.field[i][j] = dot;
            lastXGamer = i;
            lastYGamer = j;
            return true;
        }
        return false;
    }

    public void startGame() {
        for (int i = 0; i < sizeField; i++) {
            for (int j = 0; j < sizeField; j++) {
                field[i][j] = empty;
            }
        }
    }

    //TODO сделать чтобы возвращал строку ???
    public void printField() {
        System.out.print("\t" + "- ");
        for (int j = 0; j < sizeField; j++) {
            System.out.print((j + 1) + "\t" + "- ");
        }
        System.out.println();
        for (int i = 0; i < sizeField; i++) {
            System.out.print((i + 1) + "\t" + "|");
            for (int j = 0; j < sizeField; j++) {
                System.out.print(" " + field[i][j] + " |");
            }
            System.out.println();
        }
    }

    /**
     * проверка выигрыша игрока
     *
     * @param dot - фишка игрока
     * @return да или нет
     */
    public boolean checkWin(char dot) {
        //TODO убрать эти переменные в соответствующие методы
//        int firstX = Math.max((lastXGamer - winCount + 1), 0);
//        int firstY = Math.max((lastYGamer - winCount + 1), 0);
//        int firstYRev = Math.min((lastYGamer + winCount - 1), sizeField - 1);

        return checkVertical(dot) || (checkHorizontal(dot)) ||
                (checkDiagonal(dot)) || (checkDiagonalReversed(dot));
    }


    /**
     * проверка выигрышной комбинации по вертикали с использованием скользящего окна
     *
     * @param dot - фишка игрока
     * @return да или нет
     */
    private boolean checkVertical(char dot) {
        int shift = Math.max((lastXGamer - winCount + 1), 0);
        int countDot = 0;
        //TODO проверить второе условие
        while ((shift + winCount <= sizeField) && (shift <= lastXGamer)) {
            for (int i = 0; i < winCount; i++) {
                if (field[shift + i][lastYGamer] == dot) {
                    countDot++;
                }
            }
            if (countDot == winCount) {
                return true;
            }
            countDot = 0;
            shift++;
        }
        return false;
    }

    /**
     * проверка выигрышной комбинации по горизонтали с использованием скользящего окна
     *
     * @param dot - фишка игрока
     * @return да или нет
     */
    private boolean checkHorizontal(char dot) {
        int shift = Math.max((lastYGamer - winCount + 1), 0);
        ;
        int countDot = 0;
        //TODO проверить второе условие
        while ((shift + winCount <= sizeField) && (shift <= lastYGamer)) {
            for (int j = 0; j < winCount; j++) {
                if (field[lastXGamer][shift + j] == dot) {
                    countDot++;
                }
            }
            if (countDot == winCount) {
                return true;
            }
            countDot = 0;
            shift++;
        }
        return false;
    }

    /**
     * проверка выигрышной комбинации по диагонали
     *
     * @param dot фишка игрока
     * @return да или нет
     */
    private boolean checkDiagonal(char dot) {
        //TODO доделать
        int shift = Math.min(winCount - 1, Math.min(lastXGamer, lastYGamer));
        int shiftX = lastXGamer - shift;
        int shiftY = lastYGamer - shift;
        int countDot = 0;

        while ((shiftX + winCount <= sizeField) && (shiftY + winCount <= sizeField) && (shiftX <= lastXGamer)) {
            for (int j = 0; j < winCount; j++) {
                if (field[shiftX + j][shiftY + j] == dot) {
                    countDot++;
                }
            }
            if (countDot == winCount) {
                return true;
            }
            countDot = 0;
            shiftX++;
            shiftY++;
        }
        return false;
    }

    /**
     * проверка выигрышной комбинации по обратной диагонали
     *
     * @param dot фишка игрока
     * @return да или нет
     */
    private boolean checkDiagonalReversed(char dot) {
        //TODO доделать
        int shift = Math.min(winCount - 1, Math.min(lastXGamer, sizeField - 1 - lastYGamer));
        int shiftX = lastXGamer - shift;
        int shiftY = lastYGamer + shift;
        int countDot = 0;

        while ((shiftX + winCount <= sizeField) && (shiftY - winCount + 1 >= 0) && (shiftX <= lastXGamer)) {
            for (int j = 0; j < winCount; j++) {
                if (field[shiftX + j][shiftY - j] == dot) {
                    countDot++;
                }
            }
            if (countDot == winCount) {
                return true;
            }
            countDot = 0;
            shiftX++;
            shiftY--;
        }
        return false;
    }
}

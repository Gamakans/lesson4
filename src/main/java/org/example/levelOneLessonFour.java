package org.example;
import java.util.Random;
import java.util.Scanner;

public class levelOneLessonFour {

    public static Scanner scanner;
    public static Random random = new Random();
    public static String[][] map;
    public static final int SIZE = 3;
    public static final String MAP_ELEMENT_EMPTY = "*";
    public static final String MAP_ELEMENT_X = "X";
    public static final String MAP_ELEMENT_O = "O";


    public static void main(String[] args) {
        scanner = new Scanner(System.in);

        System.out.println("PLAY GAME XO");
        System.out.println();
        int variant;
        System.out.println("Будете играть вдвоем или с AI");
        System.out.println();
        System.out.println("Вариант 1 с AI");
        System.out.println("Вариант 2 с другим игроком");
        System.out.println();


        do {
            System.out.println("Введите ваш выбор:");
            variant = scanner.nextInt();
            if (variant == 1) {
                initMap();
                printMap();
                while (true) {
                    playerTurn();
                    printMap();
                    if (chekWin("X")) {
                        System.out.println("Вы победили!!!");
                        break;
                    }
                    if (mapFull()) {
                        System.out.println("Больше ходить некуда. Ничья");
                        break;
                    }
                    aiTurn();
                    printMap();
                    if (chekWin("O")) {
                        System.out.println("Победил AI!");
                        break;
                    }
                    if (mapFull()) {
                        System.out.println("Больше ходить некуда. Ничья");
                        break;
                    }
                }
            } else if (variant == 2) {
                initMap();
                printMap();
                while (true) {
                    playerTurn();
                    printMap();
                    if (chekWin("X")) {
                        System.out.println("Вы победили!!!");
                        break;
                    }
                    if (mapFull()) {
                        System.out.println("Больше ходить некуда. Ничья");
                        break;
                    }
                    playerTwoTurn();
                    printMap();
                    if (chekWin("O")) {
                        System.out.println("Победил AI!");
                        break;
                    }
                    if (mapFull()) {
                        System.out.println("Больше ходить некуда. Ничья");
                        break;
                    }
                }

            }
            System.out.println("variant = "+variant);
            if(variant !=1 && variant !=2){
                System.out.println("Выбранный вариант не соответствует вариантам выберите 1 или 2");
            }
        }
        while (variant != 1 && variant != 2);
        System.out.println("Спасибо за игру приходите еще!!!");

    }


    public static void initMap() {
        map = new String[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                map[i][j] = MAP_ELEMENT_EMPTY;
            }
        }
    }

    public static void printMap() {
        for (int numberXmap = 0; numberXmap <= SIZE; numberXmap++) {
            System.out.print(numberXmap + " ");
        }
        System.out.println();
        for (int i = 0; i < SIZE; i++) {
            System.out.print(i + 1 + " ");
            for (int j = 0; j < SIZE; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void playerTurn() {
        int x, y;
        do {
            System.out.println("Игрок 1 введите координаты X от 0 до " + SIZE);
            x = scanner.nextInt() - 1;
            System.out.println("Игрок 1 введите координаты Y от 0 до " + SIZE);
            y = scanner.nextInt() - 1;

        }
        while (x < 0 || x >= SIZE || y < 0 || y >= SIZE || map[x][y] == MAP_ELEMENT_X || map[x][y] == MAP_ELEMENT_O);

        map[x][y] = MAP_ELEMENT_X;
    }
    public static void playerTwoTurn() {
        int x, y;
        do {
            System.out.println("Игрок 2 введите координаты X от 0 до " + SIZE);
            x = scanner.nextInt() - 1;
            System.out.println("Игрок 2 введите координаты Y от 0 до " + SIZE);
            y = scanner.nextInt() - 1;

        }
        while (x < 0 || x >= SIZE || y < 0 || y >= SIZE || map[x][y] == MAP_ELEMENT_X || map[x][y] == MAP_ELEMENT_O);

        map[x][y] = MAP_ELEMENT_O;
    }

    public static void aiTurn() {
        int x, y;
        do {
            x = random.nextInt(SIZE);
            y = random.nextInt(SIZE);
        }
        while (map[x][y] == MAP_ELEMENT_O || map[x][y] == MAP_ELEMENT_X);
        map[x][y] = MAP_ELEMENT_O;
        x += 1;
        y += 1;
        System.out.println("Соперник походил X " + x + " Y " + y);
    }

    public static boolean mapFull() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] == MAP_ELEMENT_EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean chekWin(String element) {
        if (map[0][0] == element && map[1][0] == element && map[2][0] == element) {
            return true;
        }
        if (map[2][0] == element && map[2][1] == element && map[2][2] == element) {
            return true;
        }
        if (map[0][2] == element && map[1][2] == element && map[2][2] == element) {
            return true;
        }
        if (map[0][0] == element && map[0][1] == element && map[0][2] == element) {
            return true;
        }
        if (map[0][0] == element && map[1][1] == element && map[2][2] == element) {
            return true;
        }
        if (map[0][2] == element && map[1][1] == element && map[2][0] == element) {
            return true;
        }
        return false;
    }
}
package YandexContestAlgorithms5.HomeWork1_Simple_Algorithms;

import java.util.Scanner;

public class TaskD {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char[][] board = new char[8][8];
        for (int i = 0; i < 8; i++) {
            String line = scanner.nextLine().trim();
            for (int j = 0; j < 8; j++) {
                board[i][j] = line.charAt(j);
            }
        }
        System.out.println(64 - solve(board));
    }

    public static int solve(char[][] board) {
        int ans = 0;
        boolean[][] isFree = new boolean[8][8];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                isFree[i][j] = true;
            }
        }
        for (int x = 0; x < 8; x++) {
            for (int y = 0; y < 8; y++) {
                if (board[x][y] == 'R') {
                    isFree[x][y] = false;
                    ans++;
                    for (int i = x + 1; i < 8; i++) {
                        if (board[i][y] == '*') {
                            if(isFree[i][y]) {
                                ans++;
                                isFree[i][y] = false;
                            }
                        } else break;
                    }
                    for (int i = x - 1; i >= 0; i--) {
                        if (board[i][y] == '*') {
                            if(isFree[i][y]) {
                                ans++;
                                isFree[i][y] = false;
                            }
                        } else break;
                    }
                    for (int i = y + 1; i < 8; i++) {
                        if (board[x][i] == '*') {
                            if(isFree[x][i]) {
                                ans++;
                                isFree[x][i] = false;
                            }
                        } else break;
                    }
                    for (int i = y - 1; i >= 0; i--) {
                        if (board[x][i] == '*') {
                            if(isFree[x][i]) {
                                ans++;
                                isFree[x][i] = false;
                            }
                        } else break;
                    }
                } else if (board[x][y] == 'B') {
                    isFree[x][y] = false;
                    ans++;
                    for (int i = x - 1, j = y - 1; i >= 0 && j >= 0; i--, j--) {
                        if (board[i][j] == '*') {
                            if(isFree[i][j]) {
                                ans++;
                                isFree[i][j] = false;
                            }
                        } else break;
                    }

                    for (int i = x + 1, j = y - 1; i < 8 && j >= 0; i++, j--) {
                        if (board[i][j] == '*') {
                            if(isFree[i][j]) {
                                ans++;
                                isFree[i][j] = false;
                            }
                        } else break;
                    }

                    for (int i = x - 1, j = y + 1; i >= 0 && j < 8; i--, j++) {
                        if (board[i][j] == '*') {
                            if(isFree[i][j]) {
                                ans++;
                                isFree[i][j] = false;
                            }
                        } else break;
                    }

                    for (int i = x + 1, j = y + 1; i < 8 && j < 8; i++, j++) {
                        if (board[i][j] == '*') {
                            if(isFree[i][j]) {
                                ans++;
                                isFree[i][j] = false;
                            }
                        } else break;
                    }
                }
            }
        }
        return ans;
    }
}


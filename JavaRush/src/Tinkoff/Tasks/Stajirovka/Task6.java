package Tinkoff.Tasks.Stajirovka;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Task6 {
    private static final byte
            KING_MARK = 1,
            HORSE_MARK = 1 << 1,
            VISITED_AS_KING = 1 << 2,
            VISITED_AS_HORSE = 1 << 3,
            FINISH = 1 << 4;

    private static int startX, startY;
    private static Cell[][] field;

    public static void main(String[] args) {
        readField();

        int result = -1;

        Queue<Step> queue = new ArrayDeque<>();
        queue.add(new Step(HORSE_MARK, 0, field[startX][startY]));
        while (!queue.isEmpty()) {
            var step = queue.poll();
            var cell = step.cell;
            var x = cell.x;
            var y = cell.y;
            if ((cell.mark & FINISH) != 0) {
                result = step.stepCount;
                break;
            } else if ((step.mark & HORSE_MARK) != 0) {
                tryToAddStep(x - 2, y - 1, step.stepCount + 1, queue, step.mark);
                tryToAddStep(x - 1, y - 2, step.stepCount + 1, queue, step.mark);
                tryToAddStep(x + 1, y - 2, step.stepCount + 1, queue, step.mark);
                tryToAddStep(x + 2, y - 1, step.stepCount + 1, queue, step.mark);

                tryToAddStep(x - 2, y + 1, step.stepCount + 1, queue, step.mark);
                tryToAddStep(x - 1, y + 2, step.stepCount + 1, queue, step.mark);
                tryToAddStep(x + 1, y + 2, step.stepCount + 1, queue, step.mark);
                tryToAddStep(x + 2, y + 1, step.stepCount + 1, queue, step.mark);
            } else if ((step.mark & KING_MARK) != 0) {
                tryToAddStep(x - 1, y, step.stepCount + 1, queue, step.mark);
                tryToAddStep(x - 1, y - 1, step.stepCount + 1, queue, step.mark);
                tryToAddStep(x, y - 1, step.stepCount + 1, queue, step.mark);
                tryToAddStep(x + 1, y - 1, step.stepCount + 1, queue, step.mark);

                tryToAddStep(x + 1, y, step.stepCount + 1, queue, step.mark);
                tryToAddStep(x + 1, y + 1, step.stepCount + 1, queue, step.mark);
                tryToAddStep(x, y + 1, step.stepCount + 1, queue, step.mark);
                tryToAddStep(x - 1, y + 1, step.stepCount + 1, queue, step.mark);
            } else {
                System.out.println("hmmm...");
            }
        }

        System.out.println(result);
    }

    private static void tryToAddStep(int x, int y, int stepCount, Queue<Step> queue, byte mark) {
        if (x < 0 || x >= field.length || y < 0 || y >= field.length) {
            return;
        }

        Cell cell = field[x][y];

        var nextMark = mark;
        if ((cell.mark & HORSE_MARK) != 0) {
            nextMark = HORSE_MARK;
        } else if ((cell.mark & KING_MARK) != 0) {
            nextMark = KING_MARK;
        }

        if (mark == HORSE_MARK && ((cell.mark & VISITED_AS_HORSE) == 0)) {
            cell.mark |= VISITED_AS_HORSE;
            queue.add(new Step(nextMark, stepCount, cell));
        } else if (mark == KING_MARK && ((cell.mark & VISITED_AS_KING) == 0)) {
            cell.mark |= VISITED_AS_KING;
            queue.add(new Step(nextMark, stepCount, cell));
        }
    }

    private static void readField() {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        field = new Cell[n][n];
        startX = 0;
        startY = 0;
        for (int x = 0; x < n; x++) {
            String line = scan.next();
            for (int y = 0; y < n; y++) {
                char c = line.charAt(y);
                Cell cell = new Cell(x, y);
                field[x][y] = cell;
                byte mark = c == 'K' ? HORSE_MARK : (c == 'G' ? KING_MARK : 0);
                if (c == 'S') {
                    startX = x;
                    startY = y;
                } else if (c == 'F') {
                    mark = FINISH;
                }
                cell.mark = mark;
            }
        }
    }

    private static class Cell {
        public int x;
        public int y;
        public byte mark;

        public Cell(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private record Step(byte mark, int stepCount, Cell cell) {
    }
}


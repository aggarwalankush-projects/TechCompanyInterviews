package IndeedPrime;

public class RobotCircle {
    enum Direction {
        N, E, S, W;
        private static Direction[] directions = values();

        public Direction right() {
            return directions[(this.ordinal() + 1) % 4];
        }

        public Direction left() {
            return directions[(4 + this.ordinal() - 1) % 4];
        }

    }

    public static void main(String[] args) {
        String input = "GLLG";
        System.out.println(robotInCircle(input));
    }

    public static String robotInCircle(String input) {
        if (input == null)
            return "NO";
        int x = 0, y = 0;
        Direction direction = Direction.N;
        for (char move : input.toCharArray()) {
            switch (move) {
                case 'R':
                    direction = direction.right();
                    break;
                case 'L':
                    direction = direction.left();
                    break;
                case 'G':
                    switch (direction) {
                        case N:
                            y++;
                            break;
                        case S:
                            y--;
                            break;
                        case W:
                            x--;
                            break;
                        case E:
                            x++;
                            break;
                    }
                    break;
            }
        }

        return (x == 0 && y == 0) || (direction != Direction.N) ? "YES" : "NO";
    }


}

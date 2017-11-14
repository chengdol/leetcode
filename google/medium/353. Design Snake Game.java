// medium

/*
Design a Snake game that is played on a device with screen size = width x height.
Play the game online if you are not familiar with the game.

The snake is initially positioned at the top left corner (0,0) with length = 1 unit.

You are given a list of food's positions in row-column order. When a snake eats
the food, its length and the game's score both increase by 1.

Each food appears one by one on the screen. For example, the second food will
not appear until the first food was eaten by the snake.

When a food does appear on the screen, it is guaranteed that it will not appear
on a block occupied by the snake.
*/

class SnakeGame {
    // for direction
    private Map<String, int[]> map;

    private int width;
    private int height;
    // food
    private int foodIdx;
    private int[][] food;
    // snake body
    private Deque<int[]> snake;
    // 需要换算一下
    private Set<Integer> body;

    /** Initialize your data structure here.
        @param width - screen width
        @param height - screen height
        @param food - A list of food positions
        E.g food = [[1,1], [1,0]] means the first food is positioned at [1,1], the second is at [1,0]. */
    public SnakeGame(int width, int height, int[][] food)
    {
        this.width = width;
        this.height = height;

        this.food = food;
        this.foodIdx = 0;

        map = new HashMap<>();
        // init
        map.put("U", new int[]{-1, 0});
        map.put("L", new int[]{0, -1});
        map.put("R", new int[]{0, 1});
        map.put("D", new int[]{1, 0});

        snake = new ArrayDeque<>();
        body = new HashSet<>();
        // init
        snake.addFirst(new int[]{0, 0});
        body.add(0);
    }

    /** Moves the snake.
        @param direction - 'U' = Up, 'L' = Left, 'R' = Right, 'D' = Down
        @return The game's score after the move. Return -1 if game over.
        Game over when snake crosses the screen boundary or bites its body. */
    public int move(String direction)
    {
        // get direction
        int[] dir = map.get(direction);
        int[] head = snake.peekFirst();
        // next position
        int[] newHead = new int[]{head[0] + dir[0], head[1] + dir[1]};
        // corss boundary?
        if (newHead[0] < 0 || newHead[0] >= height || newHead[1] < 0 || newHead[1] >= width) { return -1; }
        // meet food?
        if (foodIdx < food.length && newHead[0] == food[foodIdx][0] && newHead[1] == food[foodIdx][1])
        {
            foodIdx++;
        }
        else
        {
            // remove tail
            // 先移动尾巴，否则可能出错，比如一个循环的时候，先检查头部就咬到了
            int[] tail = snake.pollLast();
            body.remove(tail[0] * width + tail[1]);
        }
        // bite itself?
        int tmp = newHead[0] * width + newHead[1];
        if (body.contains(tmp)) { return -1; }

        // add new head to body and snake
        snake.addFirst(newHead);
        body.add(tmp);
        return foodIdx;
    }
}

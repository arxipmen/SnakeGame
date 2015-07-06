package arx.game.objects;

public class Snake {

    public int direction    = 0;            // Направление
    public int lengthSnake  = 2;            // Исходная длина змейки
    public int snakeX[] = new int[100];
    public int snakeY[] = new int[100];

    public Snake(int x0, int y0, int x1, int y1) {
        snakeX[0] = x0;
        snakeY[0] = y0;
        snakeX[1] = x1;
        snakeY[1] = y1;
    }

    public void move() {
        for(int tail = lengthSnake; tail > 0; tail--) {
            snakeX[tail] = snakeX[tail - 1];
            snakeY[tail] = snakeY[tail - 1];
        }
        if(direction == 0) snakeX[0]++;
        if(direction == 1) snakeY[0]++;
        if(direction == 2) snakeX[0]--;
        if(direction == 3) snakeY[0]--;
    }
}

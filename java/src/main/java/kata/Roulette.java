package kata;

public class Roulette {

    private Ball ball;

    public Roulette(Ball ball) {
	this.ball = ball;
    }

    public void playGame() {
	ball.roll();
    }

}

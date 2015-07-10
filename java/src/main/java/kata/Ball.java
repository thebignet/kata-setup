package kata;

public class Ball {

    private int timeInMilliseconds;

    public Ball(int timeInMilliseconds) {
	this.timeInMilliseconds = timeInMilliseconds;
    }

    public void roll() {
	try {
	    Thread.sleep(timeInMilliseconds);
	} catch (InterruptedException e) {}
    }

}

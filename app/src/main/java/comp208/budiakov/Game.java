package comp208.budiakov;

public class Game {
    public Integer attempts;
    private long start;

    public Game() {
        this.setStart(System.currentTimeMillis());
        this.attempts = 0;
    }

    public Integer addAttempt(){
        return ++attempts;
    }

    public long getStart() {
        return start;
    }

    public void setStart(long start) {
        this.start = start;
    }

    public long getTimeElapsed(){
        return (System.currentTimeMillis() - this.getStart()) / 1000;
    }
}

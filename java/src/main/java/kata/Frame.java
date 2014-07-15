package kata;

public interface Frame {

    static final Frame NULL_FRAME = new Frame() {
        
        @Override
        public int score() {
            return 0;
        }
    
        @Override
        public int getFirst() {
            return 0;
        }

	@Override
	public void setNext(Frame nextFrame, Frame secondFrame) {
	}

	@Override
	public int nextTwoBalls() {
	    return 0;
	}
    };

    int score();
    int nextTwoBalls();

    int getFirst();

    void setNext(Frame nextFrame, Frame secondFrame);
    
    

}

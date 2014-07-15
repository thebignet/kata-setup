package kata;

public interface Frame {

    static final Frame NULL_FRAME = new Frame() {
        
        @Override
        public int score(Frame nextFrame) {
            return 0;
        }
    
        @Override
        public int getFirst() {
            return 0;
        }
    };

    int score(Frame nextFrame);

    int getFirst();

}

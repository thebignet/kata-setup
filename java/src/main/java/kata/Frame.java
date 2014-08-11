package kata;

public interface Frame {

    // public interface
    int score();
    
    // internal business, only frames should know about it
    int nextTwoBalls();
    int getFirst();

    // must be used to finalize construction, 
    // introduces implicit temporary coupling
    void setNext(Frame nextFrame);
    
    

}

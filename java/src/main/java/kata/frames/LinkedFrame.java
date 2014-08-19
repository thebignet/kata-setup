package kata.frames;

import kata.Frame;

public abstract class LinkedFrame implements Frame {
    
    protected LinkedFrame nextFrame;
    
    // must be used to finalize construction, 
    // introduces implicit temporary coupling
    public void setNext(LinkedFrame nextFrame) {
	this.nextFrame = nextFrame;
    }

    protected abstract int nextTwoBalls();
    protected abstract int getFirst();
    
    
}
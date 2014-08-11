package kata;

public interface Frame {

    // public interface
    int score();
    

    public abstract class BaseFrame implements Frame {
	// internal business, only frames should know about it
	protected abstract int nextTwoBalls();
	protected abstract int getFirst();
	
	// must be used to finalize construction, 
	// introduces implicit temporary coupling
	protected abstract void setNext(BaseFrame nextFrame);
	
    }
    
}



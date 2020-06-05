
public class Page {
	private boolean presence = false;
    private long lastTime = 0;

    public boolean isPresence() {
        return presence;
    }

    public void setPresence(boolean presence) {
        this.presence = presence;
    }

    public void setLastTime(long lastTime) {
        this.lastTime = lastTime;
    }
    
    public long getLastTime() {
        return lastTime;
    }

}

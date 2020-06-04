
public class Page {
	private boolean presence;
    private int number;
    private boolean r;

    public Page(boolean presence, boolean r){
        this.r = r;
        this.presence = presence;
    }

    public boolean isPresence() {
        return presence;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public boolean isRadius() {
        return r;
    }

    public void setPresence(boolean presence) {
        this.presence = presence;
    }

    public void setRadius(boolean r) {
        this.r = r;
    }

}

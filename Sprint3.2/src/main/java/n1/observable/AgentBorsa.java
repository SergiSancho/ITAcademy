package n1.observable;

public class AgentBorsa extends Observable {

    private int estat;

    public int getEstat() {
        return estat;
    }

    public void setEstat(int estat) {
        this.estat = estat;
        this.notificarObservadors();
    }
}

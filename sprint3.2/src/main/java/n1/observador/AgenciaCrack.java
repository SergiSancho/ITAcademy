package n1.observador;

import n1.observable.AgentBorsa;

public class AgenciaCrack implements Observador {

    private final AgentBorsa agentBorsa;

    public AgenciaCrack(AgentBorsa agentBorsa) {
        this.agentBorsa = agentBorsa;
        this.agentBorsa.afegirObservador(this);
    }

    @Override
    public void actualitzar() {
        System.out.println("AgenciaCrack: subjecte agentBorsa comunica que la borsa ha cambiat a: "
                + this.agentBorsa.getEstat() + " punts." );
    }
}

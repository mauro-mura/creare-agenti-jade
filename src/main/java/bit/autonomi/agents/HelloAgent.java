package bit.autonomi.agents;

import jade.core.Agent;

public class HelloAgent extends Agent {
    @Override
    protected void setup() {
        System.out.println("Ciao, sono l'agente " + getLocalName());
    }
}

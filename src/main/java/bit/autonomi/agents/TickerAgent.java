package bit.autonomi.agents;

import jade.core.Agent;
import jade.core.behaviours.TickerBehaviour;

public class TickerAgent extends Agent {
    protected void setup() {
        addBehaviour(new TickerBehaviour(this, 3000) { // ogni 3 secondi
            @Override
            protected void onTick() {
                System.out.println("Sto ancora lavorando... [" + System.currentTimeMillis() + "]");
            }
        });
    }
}

package bit.autonomi.agents;

import jade.core.Agent;
import jade.lang.acl.ACLMessage;

public class ReceiverAgent extends Agent {

    @Override
    protected void setup() {
        System.out.println("[" + getLocalName() + "] In attesa di messaggi...");

        ACLMessage msg = blockingReceive();
        if (msg != null) {
            System.out.println("[" + getLocalName() + "] Ricevuto: " + msg.getContent());
        }
    }
}
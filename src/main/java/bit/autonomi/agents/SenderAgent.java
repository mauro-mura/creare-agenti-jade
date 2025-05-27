package bit.autonomi.agents;

import jade.core.Agent;
import jade.lang.acl.ACLMessage;

public class SenderAgent extends Agent {

    @Override
    protected void setup() {
        System.out.println("[" + getLocalName() + "] Avvio");

        ACLMessage msg = new ACLMessage(ACLMessage.INFORM);
        msg.addReceiver(getAID("Receiver"));
        msg.setContent("Ciao, sono il mittente!");
        send(msg);

        System.out.println("[" + getLocalName() + "] Messaggio inviato");
    }
}
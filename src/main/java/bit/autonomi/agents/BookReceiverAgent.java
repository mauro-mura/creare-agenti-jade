package bit.autonomi.agents;

import bit.autonomi.Book;
import bit.autonomi.BookOntology;
import jade.content.ContentElement;
import jade.content.lang.sl.SLCodec;
import jade.content.onto.basic.Action;
import jade.core.Agent;
import jade.lang.acl.ACLMessage;

public class BookReceiverAgent extends Agent {
    @Override
    protected void setup() {
        getContentManager().registerLanguage(new SLCodec());
        getContentManager().registerOntology(BookOntology.getInstance());

        ACLMessage msg = blockingReceive();
        if (msg != null) {
            try {
                ContentElement ce = getContentManager().extractContent(msg);
                if (ce instanceof Action action) {
                    Object actObj = action.getAction();
                    if (actObj instanceof Book book) {
                        System.out.println("Ricevuto libro: " + book.getTitle() + " (€" + book.getPrice() + ")");
                    } else {
                        System.out.println("Oggetto azione non riconosciuto.");
                    }
                } else {
                    System.out.println("Contenuto non di tipo Action.");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
package bit.autonomi.agents;

import bit.autonomi.Book;
import bit.autonomi.BookOntology;
import jade.core.Agent;
import jade.core.AID;
import jade.domain.FIPANames;
import jade.lang.acl.ACLMessage;
import jade.content.lang.sl.SLCodec;
import jade.content.onto.basic.Action;

public class BookSenderAgent extends Agent {
    @Override
    protected void setup() {
        getContentManager().registerLanguage(new SLCodec());
        getContentManager().registerOntology(BookOntology.getInstance());

        // Creazione del concetto
        Book book = new Book();
        book.setTitle("JADE in Action");
        book.setPrice(29.90f);

        // Incapsulamento in un'azione fittizia
        Action action = new Action(getAID(), book);

        ACLMessage msg = new ACLMessage(ACLMessage.INFORM);
        msg.addReceiver(new AID("book-receiver", AID.ISLOCALNAME));
        msg.setLanguage(FIPANames.ContentLanguage.FIPA_SL);
        msg.setOntology(BookOntology.ONTOLOGY_NAME);

        try {
            getContentManager().fillContent(msg, action);
            send(msg);
            System.out.println("Messaggio inviato con contenuto strutturato.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
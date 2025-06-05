package bit.autonomi;

import jade.content.onto.*;
import jade.content.schema.*;

public class BookOntology extends Ontology {
    public static final String ONTOLOGY_NAME = "Book-Ontology";

    public static final String BOOK = "Book";
    public static final String TITLE = "title";
    public static final String PRICE = "price";

    private static Ontology instance = new BookOntology();

    public static Ontology getInstance() {
        return instance;
    }

    private BookOntology() {
        super(ONTOLOGY_NAME, BasicOntology.getInstance());

        try {
            add(new ConceptSchema(BOOK), Book.class);
            ConceptSchema cs = (ConceptSchema) getSchema(BOOK);
            cs.add(TITLE, (PrimitiveSchema) getSchema(BasicOntology.STRING));
            cs.add(PRICE, (PrimitiveSchema) getSchema(BasicOntology.FLOAT));
        } catch (OntologyException e) {
            e.printStackTrace();
        }
    }
}
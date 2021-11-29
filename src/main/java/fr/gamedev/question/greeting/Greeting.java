package fr.gamedev.question.greeting;

/**
 * @author djer1
 *
 */
public class Greeting {

    /**
     * The greeting id.
     */
    private final long id;

    /**
     * The greeting content.
     */
    private final String content;

    /**
     * Gets a new instance of the class {@link Greeting}.
     *
     * @param newId      the id of the new instance
     * @param newContent the content of the new instance
     */
    public Greeting(final long newId, final String newContent) {
        this.id = newId;
        this.content = newContent;
    }

    /**
     * @return the id
     */
    public long getId() {
        return id;
    }

    /**
     * @return the content
     */
    public String getContent() {
        return content;
    }

}

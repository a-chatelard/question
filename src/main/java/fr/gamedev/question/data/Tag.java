package fr.gamedev.question.data;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
public class Tag {
    /**
     * The tag id.
     */
    @GeneratedValue(generator = "seq_gen_tag")
    @GenericGenerator(
            name = "seq_gen_tag",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @Parameter(name = "sequence_name", value = "seq_tag"),
                    @Parameter(name = "initial_value", value = "0"), @Parameter(name = "increment_size", value = "1")
            })
    @Id
    private long id;

    /**
     * The users associated to the tag.
     */
    @ManyToMany(mappedBy = "tags")
    private List<User> users = new ArrayList<>();

    /**
     * The tag's category.
     */
    @ManyToOne
    private Category category;

    /**
     * The tag's label.
     */
    private String label;

    /**
     * @return the id
     */
    public long getId() {
        return id;
    }

    /**
     * @param newId the id to set
     */
    public void setId(final long newId) {
        this.id = newId;
    }

    /**
     * @return the users
     */
    public List<User> getUsers() {
        return users;
    }

    /**
     * @param newUsers the users to set
     */
    public void setUsers(final List<User> newUsers) {
        this.users = newUsers;
    }

    /**
     * @return the category of the tag
     */
    public Category getCategory() {
        return category;
    }

    /**
     * @param newCategory the category to set
     */
    public void setCategory(final Category newCategory) {
        this.category = newCategory;
    }

    /**
     * @return the label
     */
    public String getLabel() {
        return label;
    }

    /**
     * @param newLabel the label to set
     */
    public void setLabel(final String newLabel) {
        this.label = newLabel;
    }
}

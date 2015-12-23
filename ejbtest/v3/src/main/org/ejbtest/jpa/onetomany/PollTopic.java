/**
 * Copyright reserved by Tellabs Communication Corp. LTD. The file org.jpa.onetomany.PollTopic.java
 * is created on 2008-7-15
 */
package org.ejbtest.jpa.onetomany;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

/**
 * 
 */
@Entity
@DiscriminatorValue(value = "PollTopic")
public class PollTopic extends Topic {

    private boolean multiple;// Number(1,0)
    
    @Column(name = "MAX_CHOICES")
    private int maxChoices;

    @OneToMany(mappedBy = "pollTopic", cascade = CascadeType.ALL)
    private Set<PollOption> options;

    /**
     * @return get method for the field maxChoices
     */
    public int getMaxChoices() {

        return this.maxChoices;
    }

    /**
     * @param maxChoices
     *            the maxChoices to set
     */
    public void setMaxChoices(int maxChoices) {

        this.maxChoices = maxChoices;
    }

    /**
     * @return get method for the field multiple
     */
    public boolean isMultiple() {

        return this.multiple;
    }

    /**
     * @param multiple
     *            the multiple to set
     */
    public void setMultiple(boolean multiple) {

        this.multiple = multiple;
    }

    /**
     * @return get method for the field options
     */
    public Set<PollOption> getOptions() {

        if (this.options == null) {
            this.options = new HashSet<PollOption>();
        }
        return this.options;
    }

    public void addPollOption(PollOption option) {

        option.setPollTopic(this);
        this.getOptions().add(option);
    }

    /**
     * @param options
     *            the options to set
     */
    public void setOptions(Set<PollOption> options) {

        this.options = options;
    }

}

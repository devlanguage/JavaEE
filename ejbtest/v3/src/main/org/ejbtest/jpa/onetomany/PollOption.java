/**
 * Copyright reserved by Tellabs Communication Corp. LTD. The file org.jpa.onetomany.PollOption.java
 * is created on 2008-7-15
 */
package org.ejbtest.jpa.onetomany;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * 
 */
@Entity(name = "jpa_otm_polloption")
public class PollOption {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "OPTION_ID")
    private int optionId;

    @Column(name = "OPTION_ITEM")
    private String optionItem;

    @ManyToOne
    @JoinColumn(name = "TOPIC_ID", nullable = false)
    private PollTopic pollTopic;

    /**
     * @return get method for the field optionId
     */
    public int getOptionId() {

        return this.optionId;
    }

    /**
     * @param optionId
     *            the optionId to set
     */
    public void setOptionId(int optionId) {

        this.optionId = optionId;
    }

    /**
     * @return get method for the field optionItem
     */
    public String getOptionItem() {

        return this.optionItem;
    }

    /**
     * @param optionItem
     *            the optionItem to set
     */
    public void setOptionItem(String optionItem) {

        this.optionItem = optionItem;
    }

    /**
     * @return get method for the field pollTopic
     */
    public PollTopic getPollTopic() {

        return this.pollTopic;
    }

    /**
     * @param pollTopic
     *            the pollTopic to set
     */
    public void setPollTopic(PollTopic pollTopic) {

        this.pollTopic = pollTopic;
    }

}

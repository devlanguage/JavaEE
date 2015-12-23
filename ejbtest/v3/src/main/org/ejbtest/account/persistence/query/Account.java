/**
 * Copyright reserved by Tellabs Communication Corp. LTD. The file
 * org.ejbtest.account.persistence.Account.java is created on 2008-7-1
 */
package org.ejbtest.account.persistence.query;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedNativeQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * 
 */
@Entity
@Table(name = "EJB_Query_Account")
//@javax.persistence.NamedNativeQueries( 
//   { @NamedNativeQuery(name = "nnq_listAccounts", query = "select * from EJB_Query_Account") }
//)
//@javax.persistence.NamedNativeQuery(name = "nnq_listDepartmentByDepId", query = "select * from EJB_Query_Account where where = :department_id")

@javax.persistence.NamedQueries(
        { @javax.persistence.NamedQuery(name = "nq_listAccounts", query = "from Account acc") }
)
@javax.persistence.NamedQuery(name = "nq_listDepartmentByDepId", query = "from Account where department.depId= :depId")
public class Account implements Serializable {

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 5865551488417619977L;
    @Id
    @GeneratedValue(generator = "account_id_generator", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "account_id_generator", sequenceName = "ejb_seq_acc_id")
    private int id;
    @Column(name = "first_name", nullable = false, length = 100, unique = true)
    private String firstName;
    @Column(name = "last_name", nullable = true, length = 100, unique = false)
    private String lastName;
    @Column(name = "email_address", nullable = true, length = 100, unique = false)
    private String emailAddress;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "department_id", referencedColumnName = "dep_id")
    private Department department;

    /**
     * @return get method for the field emailAddress
     */

    public String getEmailAddress() {

        return this.emailAddress;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    /**
     * @param emailAddress
     *            the emailAddress to set
     */
    public void setEmailAddress(String emailAddress) {

        this.emailAddress = emailAddress;
    }

    /**
     * @return get method for the field firstName
     */

    public String getFirstName() {

        return this.firstName;
    }

    /**
     * @param firstName
     *            the firstName to set
     */
    public void setFirstName(String firstName) {

        this.firstName = firstName;
    }

    /**
     * @return get method for the field id
     */
    public int getId() {

        return this.id;
    }

    /**
     * @param id
     *            the id to set
     */
    public void setId(int id) {

        this.id = id;
    }

    /**
     * @return get method for the field lastName
     */

    public String getLastName() {

        return this.lastName;
    }

    /**
     * @param lastName
     *            the lastName to set
     */
    public void setLastName(String lastName) {

        this.lastName = lastName;
    }

    public Account() {
    }

    public Account(String firstName) {
        this.firstName = firstName;
    };

    @Override
    public String toString() {

        return new StringBuffer(getClass().getSimpleName()).append(":[id=").append(this.id).append(", firstName=")
                .append(this.firstName).append(", lastName=").append(this.lastName).append(", emailAddress=").append(
                        this.emailAddress).toString();
    }
}

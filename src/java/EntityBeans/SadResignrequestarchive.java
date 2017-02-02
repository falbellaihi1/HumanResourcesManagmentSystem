/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EntityBeans.exceptions;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Falbe
 */
@Entity
@Table(name = "sad_resignrequestarchive")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SadResignrequestarchive.findAll", query = "SELECT s FROM SadResignrequestarchive s"),
    @NamedQuery(name = "SadResignrequestarchive.findById", query = "SELECT s FROM SadResignrequestarchive s WHERE s.id = :id"),
    @NamedQuery(name = "SadResignrequestarchive.findByUsername", query = "SELECT s FROM SadResignrequestarchive s WHERE s.username = :username"),
    @NamedQuery(name = "SadResignrequestarchive.findByDateofRequest", query = "SELECT s FROM SadResignrequestarchive s WHERE s.dateofRequest = :dateofRequest"),
    @NamedQuery(name = "SadResignrequestarchive.findByNameofEmployee", query = "SELECT s FROM SadResignrequestarchive s WHERE s.nameofEmployee = :nameofEmployee")})
public class SadResignrequestarchive implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "Username")
    private String username;
    @Basic(optional = false)
    @Column(name = "DateofRequest")
    @Temporal(TemporalType.DATE)
    private Date dateofRequest;
    @Basic(optional = false)
    @Column(name = "Name of Employee")
    private String nameofEmployee;

    public SadResignrequestarchive() {
    }

    public SadResignrequestarchive(Integer id) {
        this.id = id;
    }

    public SadResignrequestarchive(Integer id, String username, Date dateofRequest, String nameofEmployee) {
        this.id = id;
        this.username = username;
        this.dateofRequest = dateofRequest;
        this.nameofEmployee = nameofEmployee;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Date getDateofRequest() {
        return dateofRequest;
    }

    public void setDateofRequest(Date dateofRequest) {
        this.dateofRequest = dateofRequest;
    }

    public String getNameofEmployee() {
        return nameofEmployee;
    }

    public void setNameofEmployee(String nameofEmployee) {
        this.nameofEmployee = nameofEmployee;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SadResignrequestarchive)) {
            return false;
        }
        SadResignrequestarchive other = (SadResignrequestarchive) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "EntityBeans.exceptions.SadResignrequestarchive[ id=" + id + " ]";
    }
    
}

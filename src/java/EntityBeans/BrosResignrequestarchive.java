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
@Table(name = "bros_resignrequestarchive")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BrosResignrequestarchive.findAll", query = "SELECT b FROM BrosResignrequestarchive b"),
    @NamedQuery(name = "BrosResignrequestarchive.findById", query = "SELECT b FROM BrosResignrequestarchive b WHERE b.id = :id"),
    @NamedQuery(name = "BrosResignrequestarchive.findByUsername", query = "SELECT b FROM BrosResignrequestarchive b WHERE b.username = :username"),
    @NamedQuery(name = "BrosResignrequestarchive.findByDateofRequest", query = "SELECT b FROM BrosResignrequestarchive b WHERE b.dateofRequest = :dateofRequest"),
    @NamedQuery(name = "BrosResignrequestarchive.findByNameofEmployee", query = "SELECT b FROM BrosResignrequestarchive b WHERE b.nameofEmployee = :nameofEmployee")})
public class BrosResignrequestarchive implements Serializable {

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

    public BrosResignrequestarchive() {
    }

    public BrosResignrequestarchive(Integer id) {
        this.id = id;
    }

    public BrosResignrequestarchive(Integer id, String username, Date dateofRequest, String nameofEmployee) {
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
        if (!(object instanceof BrosResignrequestarchive)) {
            return false;
        }
        BrosResignrequestarchive other = (BrosResignrequestarchive) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "EntityBeans.exceptions.BrosResignrequestarchive[ id=" + id + " ]";
    }
    
}

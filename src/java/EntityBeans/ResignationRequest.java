/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EntityBeans;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Falbe
 */
@Entity
@Table(name = "resignation_request")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ResignationRequest.findAll", query = "SELECT r FROM ResignationRequest r"),
    @NamedQuery(name = "ResignationRequest.findById", query = "SELECT r FROM ResignationRequest r WHERE r.id = :id"),
    @NamedQuery(name = "ResignationRequest.findByName", query = "SELECT r FROM ResignationRequest r WHERE r.name = :name"),
    @NamedQuery(name = "ResignationRequest.findByEmployeeNum", query = "SELECT r FROM ResignationRequest r WHERE r.employeeNum = :employeeNum"),
    @NamedQuery(name = "ResignationRequest.findByNationalID", query = "SELECT r FROM ResignationRequest r WHERE r.nationalID = :nationalID"),
    @NamedQuery(name = "ResignationRequest.findByNotes", query = "SELECT r FROM ResignationRequest r WHERE r.notes = :notes")})
public class ResignationRequest implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "Name")
    private String name;
    @Basic(optional = false)
    @Column(name = "Employee_Num")
    private String employeeNum;
    @Basic(optional = false)
    @Column(name = "National_ID")
    private String nationalID;
    @Basic(optional = false)
    @Column(name = "Notes")
    private String notes;
    @JoinColumn(name = "UserID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Users userID;

    public ResignationRequest() {
    }

    public ResignationRequest(Integer id) {
        this.id = id;
    }

    public ResignationRequest(Integer id, String name, String employeeNum, String nationalID, String notes) {
        this.id = id;
        this.name = name;
        this.employeeNum = employeeNum;
        this.nationalID = nationalID;
        this.notes = notes;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmployeeNum() {
        return employeeNum;
    }

    public void setEmployeeNum(String employeeNum) {
        this.employeeNum = employeeNum;
    }

    public String getNationalID() {
        return nationalID;
    }

    public void setNationalID(String nationalID) {
        this.nationalID = nationalID;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Users getUserID() {
        return userID;
    }

    public void setUserID(Users userID) {
        this.userID = userID;
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
        if (!(object instanceof ResignationRequest)) {
            return false;
        }
        ResignationRequest other = (ResignationRequest) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "EntityBeans.ResignationRequest[ id=" + id + " ]";
    }
    
}

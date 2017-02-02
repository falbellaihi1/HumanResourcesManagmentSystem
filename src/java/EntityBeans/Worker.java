/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EntityBeans;

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
@Table(name = "worker")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Worker.findAll", query = "SELECT w FROM Worker w"),
    @NamedQuery(name = "Worker.findById", query = "SELECT w FROM Worker w WHERE w.id = :id"),
    @NamedQuery(name = "Worker.findByWorkerName", query = "SELECT w FROM Worker w WHERE w.workerName = :workerName"),
    @NamedQuery(name = "Worker.findByNationality", query = "SELECT w FROM Worker w WHERE w.nationality = :nationality"),
    @NamedQuery(name = "Worker.findByResidenceCardNumber", query = "SELECT w FROM Worker w WHERE w.residenceCardNumber = :residenceCardNumber"),
    @NamedQuery(name = "Worker.findByPassportNumber", query = "SELECT w FROM Worker w WHERE w.passportNumber = :passportNumber"),
    @NamedQuery(name = "Worker.findByBankAccountNumber", query = "SELECT w FROM Worker w WHERE w.bankAccountNumber = :bankAccountNumber"),
    @NamedQuery(name = "Worker.findByResidenceCardExpiry", query = "SELECT w FROM Worker w WHERE w.residenceCardExpiry = :residenceCardExpiry"),
    @NamedQuery(name = "Worker.findByPassportExpiry", query = "SELECT w FROM Worker w WHERE w.passportExpiry = :passportExpiry"),
    @NamedQuery(name = "Worker.findByPassportPicture", query = "SELECT w FROM Worker w WHERE w.passportPicture = :passportPicture"),
    @NamedQuery(name = "Worker.findByResidencyCardPicture", query = "SELECT w FROM Worker w WHERE w.residencyCardPicture = :residencyCardPicture"),
    @NamedQuery(name = "Worker.findByWorkerPicture", query = "SELECT w FROM Worker w WHERE w.workerPicture = :workerPicture"),
    @NamedQuery(name = "Worker.findByOtherAttachment", query = "SELECT w FROM Worker w WHERE w.otherAttachment = :otherAttachment"),
    @NamedQuery(name = "Worker.findByEnteryIDNumber", query = "SELECT w FROM Worker w WHERE w.enteryIDNumber = :enteryIDNumber"),
    @NamedQuery(name = "Worker.findByInsuranceNumber", query = "SELECT w FROM Worker w WHERE w.insuranceNumber = :insuranceNumber"),
    @NamedQuery(name = "Worker.findByEnteryDate", query = "SELECT w FROM Worker w WHERE w.enteryDate = :enteryDate")})
public class Worker implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "WorkerName")
    private String workerName;
    @Basic(optional = false)
    @Column(name = "Nationality")
    private String nationality;
    @Basic(optional = false)
    @Column(name = "ResidenceCardNumber")
    private String residenceCardNumber;
    @Basic(optional = false)
    @Column(name = "PassportNumber")
    private String passportNumber;
    @Basic(optional = false)
    @Column(name = "BankAccountNumber")
    private String bankAccountNumber;
    @Basic(optional = false)
    @Column(name = "ResidenceCardExpiry")
    @Temporal(TemporalType.DATE)
    private Date residenceCardExpiry;
    @Basic(optional = false)
    @Column(name = "PassportExpiry")
    @Temporal(TemporalType.DATE)
    private Date passportExpiry;
    @Basic(optional = false)
    @Column(name = "PassportPicture")
    private String passportPicture;
    @Basic(optional = false)
    @Column(name = "ResidencyCardPicture")
    private String residencyCardPicture;
    @Basic(optional = false)
    @Column(name = "WorkerPicture")
    private String workerPicture;
    @Basic(optional = false)
    @Column(name = "OtherAttachment")
    private String otherAttachment;
    @Column(name = "EnteryIDNumber")
    private String enteryIDNumber;
    @Column(name = "InsuranceNumber")
    private String insuranceNumber;
    @Column(name = "EnteryDate")
    @Temporal(TemporalType.DATE)
    private Date enteryDate;

    public Worker() {
    }

    public Worker(Integer id) {
        this.id = id;
    }

    public Worker(Integer id, String workerName, String nationality, String residenceCardNumber, String passportNumber, String bankAccountNumber, Date residenceCardExpiry, Date passportExpiry, String passportPicture, String residencyCardPicture, String workerPicture, String otherAttachment) {
        this.id = id;
        this.workerName = workerName;
        this.nationality = nationality;
        this.residenceCardNumber = residenceCardNumber;
        this.passportNumber = passportNumber;
        this.bankAccountNumber = bankAccountNumber;
        this.residenceCardExpiry = residenceCardExpiry;
        this.passportExpiry = passportExpiry;
        this.passportPicture = passportPicture;
        this.residencyCardPicture = residencyCardPicture;
        this.workerPicture = workerPicture;
        this.otherAttachment = otherAttachment;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getWorkerName() {
        return workerName;
    }

    public void setWorkerName(String workerName) {
        this.workerName = workerName;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getResidenceCardNumber() {
        return residenceCardNumber;
    }

    public void setResidenceCardNumber(String residenceCardNumber) {
        this.residenceCardNumber = residenceCardNumber;
    }

    public String getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }

    public String getBankAccountNumber() {
        return bankAccountNumber;
    }

    public void setBankAccountNumber(String bankAccountNumber) {
        this.bankAccountNumber = bankAccountNumber;
    }

    public Date getResidenceCardExpiry() {
        return residenceCardExpiry;
    }

    public void setResidenceCardExpiry(Date residenceCardExpiry) {
        this.residenceCardExpiry = residenceCardExpiry;
    }

    public Date getPassportExpiry() {
        return passportExpiry;
    }

    public void setPassportExpiry(Date passportExpiry) {
        this.passportExpiry = passportExpiry;
    }

    public String getPassportPicture() {
        return passportPicture;
    }

    public void setPassportPicture(String passportPicture) {
        this.passportPicture = passportPicture;
    }

    public String getResidencyCardPicture() {
        return residencyCardPicture;
    }

    public void setResidencyCardPicture(String residencyCardPicture) {
        this.residencyCardPicture = residencyCardPicture;
    }

    public String getWorkerPicture() {
        return workerPicture;
    }

    public void setWorkerPicture(String workerPicture) {
        this.workerPicture = workerPicture;
    }

    public String getOtherAttachment() {
        return otherAttachment;
    }

    public void setOtherAttachment(String otherAttachment) {
        this.otherAttachment = otherAttachment;
    }

    public String getEnteryIDNumber() {
        return enteryIDNumber;
    }

    public void setEnteryIDNumber(String enteryIDNumber) {
        this.enteryIDNumber = enteryIDNumber;
    }

    public String getInsuranceNumber() {
        return insuranceNumber;
    }

    public void setInsuranceNumber(String insuranceNumber) {
        this.insuranceNumber = insuranceNumber;
    }

    public Date getEnteryDate() {
        return enteryDate;
    }

    public void setEnteryDate(Date enteryDate) {
        this.enteryDate = enteryDate;
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
        if (!(object instanceof Worker)) {
            return false;
        }
        Worker other = (Worker) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "EntityBeans.exceptions.Worker[ id=" + id + " ]";
    }
    
}

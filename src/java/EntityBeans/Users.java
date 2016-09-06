/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EntityBeans;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Falbe
 */
@Entity
@Table(name = "users")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Users.findAll", query = "SELECT u FROM Users u"),
    @NamedQuery(name = "Users.findById", query = "SELECT u FROM Users u WHERE u.id = :id"),
    @NamedQuery(name = "Users.findByUsername", query = "SELECT u FROM Users u WHERE u.username = :username"),
    @NamedQuery(name = "Users.findByPassword", query = "SELECT u FROM Users u WHERE u.password = :password"),
    @NamedQuery(name = "Users.findByType", query = "SELECT u FROM Users u WHERE u.type = :type"),
    @NamedQuery(name = "Users.findByPictureID", query = "SELECT u FROM Users u WHERE u.pictureID = :pictureID"),
    @NamedQuery(name = "Users.findByName", query = "SELECT u FROM Users u WHERE u.name = :name"),
    @NamedQuery(name = "Users.findByEmployenum", query = "SELECT u FROM Users u WHERE u.employenum = :employenum"),
    @NamedQuery(name = "Users.findByVacationBalance", query = "SELECT u FROM Users u WHERE u.vacationBalance = :vacationBalance"),
    @NamedQuery(name = "Users.findByLeavePermissiontimes", query = "SELECT u FROM Users u WHERE u.leavePermissiontimes = :leavePermissiontimes"),
    @NamedQuery(name = "Users.findByNotes", query = "SELECT u FROM Users u WHERE u.notes = :notes"),
    @NamedQuery(name = "Users.findByUsernameAndPassword", query = "SELECT u FROM Users u WHERE u.username = :username and u.password=:password and u.type=:type"),
    @NamedQuery(name = "Users.findBySalary", query = "SELECT u FROM Users u WHERE u.salary = :salary")})
public class Users implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "username")
    private String username;
    @Basic(optional = false)
    @Column(name = "password")
    private String password;
    @Basic(optional = false)
    @Column(name = "type")
    private int type;
    @Basic(optional = false)
    @Column(name = "Picture_ID")
    private String pictureID;
    @Basic(optional = false)
    @Column(name = "Name")
    private String name;
    @Basic(optional = false)
    @Lob
    @Column(name = "Email")
    private String email;
    @Basic(optional = false)
    @Lob
    @Column(name = "Phone")
    private String phone;
    @Basic(optional = false)
    @Column(name = "Employe_num")
    private String employenum;
    @Basic(optional = false)
    @Column(name = "Vacation_Balance")
    private int vacationBalance;
    @Basic(optional = false)
    @Column(name = "Leave_Permission_times")
    private int leavePermissiontimes;
    @Basic(optional = false)
    @Column(name = "Notes")
    private String notes;
    @Basic(optional = false)
    @Column(name = "Salary")
    private String salary;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userID")
    private Collection<ResignationRequest> resignationRequestCollection;

    public Users() {
    }

    public Users(Integer id) {
        this.id = id;
    }

    public Users(Integer id, String username, String password, int type, String pictureID, String name, String email, String phone, String employenum, int vacationBalance, int leavePermissiontimes, String notes, String salary) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.type = type;
        this.pictureID = pictureID;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.employenum = employenum;
        this.vacationBalance = vacationBalance;
        this.leavePermissiontimes = leavePermissiontimes;
        this.notes = notes;
        this.salary = salary;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getPictureID() {
        return pictureID;
    }

    public void setPictureID(String pictureID) {
        this.pictureID = pictureID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmployenum() {
        return employenum;
    }

    public void setEmployenum(String employenum) {
        this.employenum = employenum;
    }

    public int getVacationBalance() {
        return vacationBalance;
    }

    public void setVacationBalance(int vacationBalance) {
        this.vacationBalance = vacationBalance;
    }

    public int getLeavePermissiontimes() {
        return leavePermissiontimes;
    }

    public void setLeavePermissiontimes(int leavePermissiontimes) {
        this.leavePermissiontimes = leavePermissiontimes;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    @XmlTransient
    public Collection<ResignationRequest> getResignationRequestCollection() {
        return resignationRequestCollection;
    }

    public void setResignationRequestCollection(Collection<ResignationRequest> resignationRequestCollection) {
        this.resignationRequestCollection = resignationRequestCollection;
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
        if (!(object instanceof Users)) {
            return false;
        }
        Users other = (Users) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return name; //returns the name of the employee that the request is hanging on
    }

}

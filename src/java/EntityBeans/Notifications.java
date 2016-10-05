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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Falbe
 */
@Entity
@Table(name = "notifications")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Notifications.findAll", query = "SELECT n FROM Notifications n"),
    @NamedQuery(name = "Notifications.findById", query = "SELECT n FROM Notifications n WHERE n.id = :id"),
    @NamedQuery(name = "Notifications.findByNotificationMessage2", query = "SELECT n FROM Notifications n WHERE n.notificationMessage2 = :notificationMessage2"),
    @NamedQuery(name = "Notifications.findByNotificationMessage3", query = "SELECT n FROM Notifications n WHERE n.notificationMessage3 = :notificationMessage3"),
    @NamedQuery(name = "Notifications.findByNotificationMessage4", query = "SELECT n FROM Notifications n WHERE n.notificationMessage4 = :notificationMessage4")})
public class Notifications implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "NotificationMessage2")
    private String notificationMessage2;
    @Basic(optional = false)
    @Column(name = "NotificationMessage3")
    private String notificationMessage3;
    @Basic(optional = false)
    @Column(name = "NotificationMessage4")
    private String notificationMessage4;

    public Notifications() {
    }

    public Notifications(Integer id) {
        this.id = id;
    }

    public Notifications(Integer id, String notificationMessage2, String notificationMessage3, String notificationMessage4) {
        this.id = id;
        this.notificationMessage2 = notificationMessage2;
        this.notificationMessage3 = notificationMessage3;
        this.notificationMessage4 = notificationMessage4;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNotificationMessage2() {
        return notificationMessage2;
    }

    public void setNotificationMessage2(String notificationMessage2) {
        this.notificationMessage2 = notificationMessage2;
    }

    public String getNotificationMessage3() {
        return notificationMessage3;
    }

    public void setNotificationMessage3(String notificationMessage3) {
        this.notificationMessage3 = notificationMessage3;
    }

    public String getNotificationMessage4() {
        return notificationMessage4;
    }

    public void setNotificationMessage4(String notificationMessage4) {
        this.notificationMessage4 = notificationMessage4;
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
        if (!(object instanceof Notifications)) {
            return false;
        }
        Notifications other = (Notifications) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "EntityBeans.Notifications[ id=" + id + " ]";
    }
    
}

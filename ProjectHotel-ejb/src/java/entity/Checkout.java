/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Willi
 */
@Entity
@Table(name = "checkout")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Checkout.findAll", query = "SELECT c FROM Checkout c"),
    @NamedQuery(name = "Checkout.findByCheckOutId", query = "SELECT c FROM Checkout c WHERE c.checkOutId = :checkOutId"),
    @NamedQuery(name = "Checkout.findByDateChekout", query = "SELECT c FROM Checkout c WHERE c.dateChekout = :dateChekout"),
    @NamedQuery(name = "Checkout.findByTotal", query = "SELECT c FROM Checkout c WHERE c.total = :total")})
public class Checkout implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "checkOutId")
    private Integer checkOutId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dateChekout")
    @Temporal(TemporalType.DATE)
    private Date dateChekout;
    @Basic(optional = false)
    @NotNull
    @Column(name = "total")
    private float total;
    @JoinColumn(name = "checkInId", referencedColumnName = "checkinId")
    @ManyToOne(optional = false)
    private Checkin checkInId;

    public Checkout() {
    }

    public Checkout(Integer checkOutId) {
        this.checkOutId = checkOutId;
    }

    public Checkout(Integer checkOutId, Date dateChekout, float total) {
        this.checkOutId = checkOutId;
        this.dateChekout = dateChekout;
        this.total = total;
    }

    public Integer getCheckOutId() {
        return checkOutId;
    }

    public void setCheckOutId(Integer checkOutId) {
        this.checkOutId = checkOutId;
    }

    public Date getDateChekout() {
        return dateChekout;
    }

    public void setDateChekout(Date dateChekout) {
        this.dateChekout = dateChekout;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public Checkin getCheckInId() {
        return checkInId;
    }

    public void setCheckInId(Checkin checkInId) {
        this.checkInId = checkInId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (checkOutId != null ? checkOutId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Checkout)) {
            return false;
        }
        Checkout other = (Checkout) object;
        if ((this.checkOutId == null && other.checkOutId != null) || (this.checkOutId != null && !this.checkOutId.equals(other.checkOutId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Checkout[ checkOutId=" + checkOutId + " ]";
    }
    
}

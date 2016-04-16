/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Willi
 */
@Entity
@Table(name = "checkin")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Checkin.findAll", query = "SELECT c FROM Checkin c"),
    @NamedQuery(name = "Checkin.findByCheckinId", query = "SELECT c FROM Checkin c WHERE c.checkinId = :checkinId"),
    @NamedQuery(name = "Checkin.findByDateIn", query = "SELECT c FROM Checkin c WHERE c.dateIn = :dateIn"),
    @NamedQuery(name = "Checkin.findByDateOut", query = "SELECT c FROM Checkin c WHERE c.dateOut = :dateOut"),
    @NamedQuery(name = "Checkin.findByDiscount", query = "SELECT c FROM Checkin c WHERE c.discount = :discount"),
    @NamedQuery(name = "Checkin.findByTax", query = "SELECT c FROM Checkin c WHERE c.tax = :tax"),
    @NamedQuery(name = "Checkin.findByOutOfTime", query = "SELECT c FROM Checkin c WHERE c.outOfTime = :outOfTime"),
    @NamedQuery(name = "Checkin.findByRoomCharge", query = "SELECT c FROM Checkin c WHERE c.roomCharge = :roomCharge"),
    @NamedQuery(name = "Checkin.findByRoomStatus", query = "SELECT c FROM Checkin c WHERE c.roomStatus = :roomStatus"),
    @NamedQuery(name = "Checkin.findByComment", query = "SELECT c FROM Checkin c WHERE c.comment = :comment")})
public class Checkin implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "checkinId")
    private Integer checkinId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dateIn")
    @Temporal(TemporalType.DATE)
    private Date dateIn;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dateOut")
    @Temporal(TemporalType.DATE)
    private Date dateOut;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "discount")
    private Float discount;
    @Column(name = "tax")
    private Integer tax;
    @Basic(optional = false)
    @NotNull
    @Column(name = "outOfTime")
    private int outOfTime;
    @Column(name = "roomCharge")
    private Double roomCharge;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "roomStatus")
    private String roomStatus;
    @Size(max = 200)
    @Column(name = "comment")
    private String comment;
    @JoinColumn(name = "customerId", referencedColumnName = "customerId")
    @ManyToOne(optional = false)
    private Customer customerId;
    @JoinColumn(name = "roomId", referencedColumnName = "roomId")
    @ManyToOne(optional = false)
    private Room roomId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "checkinId")
    private List<Usedservice> usedserviceList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "checkInId")
    private List<Checkout> checkoutList;

    public Checkin() {
    }

    public Checkin(Integer checkinId) {
        this.checkinId = checkinId;
    }

    public Checkin(Integer checkinId, Date dateIn, Date dateOut, int outOfTime, String roomStatus) {
        this.checkinId = checkinId;
        this.dateIn = dateIn;
        this.dateOut = dateOut;
        this.outOfTime = outOfTime;
        this.roomStatus = roomStatus;
    }

    public Integer getCheckinId() {
        return checkinId;
    }

    public void setCheckinId(Integer checkinId) {
        this.checkinId = checkinId;
    }

    public Date getDateIn() {
        return dateIn;
    }

    public void setDateIn(Date dateIn) {
        this.dateIn = dateIn;
    }

    public Date getDateOut() {
        return dateOut;
    }

    public void setDateOut(Date dateOut) {
        this.dateOut = dateOut;
    }

    public Float getDiscount() {
        return discount;
    }

    public void setDiscount(Float discount) {
        this.discount = discount;
    }

    public Integer getTax() {
        return tax;
    }

    public void setTax(Integer tax) {
        this.tax = tax;
    }

    public int getOutOfTime() {
        return outOfTime;
    }

    public void setOutOfTime(int outOfTime) {
        this.outOfTime = outOfTime;
    }

    public Double getRoomCharge() {
        return roomCharge;
    }

    public void setRoomCharge(Double roomCharge) {
        this.roomCharge = roomCharge;
    }

    public String getRoomStatus() {
        return roomStatus;
    }

    public void setRoomStatus(String roomStatus) {
        this.roomStatus = roomStatus;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Customer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Customer customerId) {
        this.customerId = customerId;
    }

    public Room getRoomId() {
        return roomId;
    }

    public void setRoomId(Room roomId) {
        this.roomId = roomId;
    }

    @XmlTransient
    public List<Usedservice> getUsedserviceList() {
        return usedserviceList;
    }

    public void setUsedserviceList(List<Usedservice> usedserviceList) {
        this.usedserviceList = usedserviceList;
    }

    @XmlTransient
    public List<Checkout> getCheckoutList() {
        return checkoutList;
    }

    public void setCheckoutList(List<Checkout> checkoutList) {
        this.checkoutList = checkoutList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (checkinId != null ? checkinId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Checkin)) {
            return false;
        }
        Checkin other = (Checkin) object;
        if ((this.checkinId == null && other.checkinId != null) || (this.checkinId != null && !this.checkinId.equals(other.checkinId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Checkin[ checkinId=" + checkinId + " ]";
    }
    
}

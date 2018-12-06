package main.java.entities;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;

@Entity
@Table(name = "LabOrder", schema = "dbo", catalog = "Laboratory")
public class LabOrderEntity {
    private int orderId;
    private int price;
    private Integer discountedPrice;
    private Timestamp dateOfPurchase;
    private int status;
    private Date completionTime;

    @Id
    @Column(name = "Order_ID", nullable = false)
    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    @Basic
    @Column(name = "Price", nullable = false)
    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Basic
    @Column(name = "Discounted_price", nullable = true)
    public Integer getDiscountedPrice() {
        return discountedPrice;
    }

    public void setDiscountedPrice(Integer discountedPrice) {
        this.discountedPrice = discountedPrice;
    }

    @Basic
    @Column(name = "Date_of_purchase", nullable = true)
    public Timestamp getDateOfPurchase() {
        return dateOfPurchase;
    }

    public void setDateOfPurchase(Timestamp dateOfPurchase) {
        this.dateOfPurchase = dateOfPurchase;
    }

    @Basic
    @Column(name = "Status", nullable = false)
    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Basic
    @Column(name = "Completion_time", nullable = true)
    public Date getCompletionTime() {
        return completionTime;
    }

    public void setCompletionTime(Date completionTime) {
        this.completionTime = completionTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LabOrderEntity that = (LabOrderEntity) o;

        if (orderId != that.orderId) return false;
        if (price != that.price) return false;
        if (status != that.status) return false;
        if (discountedPrice != null ? !discountedPrice.equals(that.discountedPrice) : that.discountedPrice != null)
            return false;
        if (dateOfPurchase != null ? !dateOfPurchase.equals(that.dateOfPurchase) : that.dateOfPurchase != null)
            return false;
        if (completionTime != null ? !completionTime.equals(that.completionTime) : that.completionTime != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = orderId;
        result = 31 * result + price;
        result = 31 * result + (discountedPrice != null ? discountedPrice.hashCode() : 0);
        result = 31 * result + (dateOfPurchase != null ? dateOfPurchase.hashCode() : 0);
        result = 31 * result + status;
        result = 31 * result + (completionTime != null ? completionTime.hashCode() : 0);
        return result;
    }
}

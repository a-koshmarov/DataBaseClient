package main.java.dao;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "LabOrder", schema = "dbo", catalog = "Laboratory")
public class LabOrderDAO {
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
        LabOrderDAO that = (LabOrderDAO) o;
        return orderId == that.orderId &&
                price == that.price &&
                status == that.status &&
                Objects.equals(discountedPrice, that.discountedPrice) &&
                Objects.equals(dateOfPurchase, that.dateOfPurchase) &&
                Objects.equals(completionTime, that.completionTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId, price, discountedPrice, dateOfPurchase, status, completionTime);
    }
}

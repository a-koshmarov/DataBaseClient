package main.java.dao.entities;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "Employee", schema = "dbo", catalog = "Laboratory")
public class EmployeeEntity {
    private int employeeId;
    private String fullName;
    private Timestamp dateOfEmployment;
    private String position;
    private int orderCount;

    @Id
    @Column(name = "Employee_ID", nullable = false)
    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    @Basic
    @Column(name = "Full_name", nullable = true, length = 50)
    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    @Basic
    @Column(name = "Date_of_employment", nullable = true)
    public Timestamp getDateOfEmployment() {
        return dateOfEmployment;
    }

    public void setDateOfEmployment(Timestamp dateOfEmployment) {
        this.dateOfEmployment = dateOfEmployment;
    }

    @Basic
    @Column(name = "Position", nullable = true, length = 30)
    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @Basic
    @Column(name = "Order_count", nullable = false)
    public int getOrderCount() {
        return orderCount;
    }

    public void setOrderCount(int orderCount) {
        this.orderCount = orderCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EmployeeEntity that = (EmployeeEntity) o;

        if (employeeId != that.employeeId) return false;
        if (orderCount != that.orderCount) return false;
        if (fullName != null ? !fullName.equals(that.fullName) : that.fullName != null) return false;
        if (dateOfEmployment != null ? !dateOfEmployment.equals(that.dateOfEmployment) : that.dateOfEmployment != null)
            return false;
        if (position != null ? !position.equals(that.position) : that.position != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = employeeId;
        result = 31 * result + (fullName != null ? fullName.hashCode() : 0);
        result = 31 * result + (dateOfEmployment != null ? dateOfEmployment.hashCode() : 0);
        result = 31 * result + (position != null ? position.hashCode() : 0);
        result = 31 * result + orderCount;
        return result;
    }
}

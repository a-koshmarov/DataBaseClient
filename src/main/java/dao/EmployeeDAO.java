package main.java.dao;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "Employee", schema = "dbo", catalog = "Laboratory")
public class EmployeeDAO {
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
        EmployeeDAO that = (EmployeeDAO) o;
        return employeeId == that.employeeId &&
                orderCount == that.orderCount &&
                Objects.equals(fullName, that.fullName) &&
                Objects.equals(dateOfEmployment, that.dateOfEmployment) &&
                Objects.equals(position, that.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(employeeId, fullName, dateOfEmployment, position, orderCount);
    }
}

package main.java.dao;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "Lab", schema = "dbo", catalog = "Laboratory")
public class LabDAO {
    private int labId;
    private String labName;
    private String labAddress;
    private int employeesNumber;
    private String workingHours;

    @Id
    @Column(name = "Lab_ID", nullable = false)
    public int getLabId() {
        return labId;
    }

    public void setLabId(int labId) {
        this.labId = labId;
    }

    @Basic
    @Column(name = "Lab_name", nullable = true, length = 50)
    public String getLabName() {
        return labName;
    }

    public void setLabName(String labName) {
        this.labName = labName;
    }

    @Basic
    @Column(name = "Lab_address", nullable = false, length = 150)
    public String getLabAddress() {
        return labAddress;
    }

    public void setLabAddress(String labAddress) {
        this.labAddress = labAddress;
    }

    @Basic
    @Column(name = "Employees_number", nullable = false)
    public int getEmployeesNumber() {
        return employeesNumber;
    }

    public void setEmployeesNumber(int employeesNumber) {
        this.employeesNumber = employeesNumber;
    }

    @Basic
    @Column(name = "Working_hours", nullable = false, length = 30)
    public String getWorkingHours() {
        return workingHours;
    }

    public void setWorkingHours(String workingHours) {
        this.workingHours = workingHours;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LabDAO labDAO = (LabDAO) o;
        return labId == labDAO.labId &&
                employeesNumber == labDAO.employeesNumber &&
                Objects.equals(labName, labDAO.labName) &&
                Objects.equals(labAddress, labDAO.labAddress) &&
                Objects.equals(workingHours, labDAO.workingHours);
    }

    @Override
    public int hashCode() {
        return Objects.hash(labId, labName, labAddress, employeesNumber, workingHours);
    }
}

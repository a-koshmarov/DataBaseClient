package main.java.dao.entities;

import javax.persistence.*;

@Entity
@Table(name = "Lab", schema = "dbo", catalog = "Laboratory")
public class LabEntity {
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

        LabEntity labEntity = (LabEntity) o;

        if (labId != labEntity.labId) return false;
        if (employeesNumber != labEntity.employeesNumber) return false;
        if (labName != null ? !labName.equals(labEntity.labName) : labEntity.labName != null) return false;
        if (labAddress != null ? !labAddress.equals(labEntity.labAddress) : labEntity.labAddress != null) return false;
        if (workingHours != null ? !workingHours.equals(labEntity.workingHours) : labEntity.workingHours != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = labId;
        result = 31 * result + (labName != null ? labName.hashCode() : 0);
        result = 31 * result + (labAddress != null ? labAddress.hashCode() : 0);
        result = 31 * result + employeesNumber;
        result = 31 * result + (workingHours != null ? workingHours.hashCode() : 0);
        return result;
    }
}

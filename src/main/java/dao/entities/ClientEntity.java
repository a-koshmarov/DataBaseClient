package main.java.dao.entities;


import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "Client", schema = "dbo", catalog = "Laboratory")
public class ClientEntity {
    private int cardNumber;
    private String fullName;
    private String phone;
    private String email;
    private Timestamp dateRecieved;
    private Timestamp dateOfBirth;
    private Integer discount;

    @Id
    @Column(name = "Card_number", nullable = false)
    public int getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(int cardNumber) {
        this.cardNumber = cardNumber;
    }

    @Basic
    @Column(name = "Full_Name", nullable = true, length = 50)
    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    @Basic
    @Column(name = "Phone", nullable = true, length = 20)
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Basic
    @Column(name = "Email", nullable = true, length = 50)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "Date_recieved", nullable = true)
    public Timestamp getDateRecieved() {
        return dateRecieved;
    }

    public void setDateRecieved(Timestamp dateRecieved) {
        this.dateRecieved = dateRecieved;
    }

    @Basic
    @Column(name = "Date_of_birth", nullable = true)
    public Timestamp getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Timestamp dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    @Basic
    @Column(name = "Discount", nullable = true)
    public Integer getDiscount() {
        return discount;
    }

    public void setDiscount(Integer discount) {
        this.discount = discount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ClientEntity that = (ClientEntity) o;

        if (cardNumber != that.cardNumber) return false;
        if (fullName != null ? !fullName.equals(that.fullName) : that.fullName != null) return false;
        if (phone != null ? !phone.equals(that.phone) : that.phone != null) return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;
        if (dateRecieved != null ? !dateRecieved.equals(that.dateRecieved) : that.dateRecieved != null) return false;
        if (dateOfBirth != null ? !dateOfBirth.equals(that.dateOfBirth) : that.dateOfBirth != null) return false;
        if (discount != null ? !discount.equals(that.discount) : that.discount != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = cardNumber;
        result = 31 * result + (fullName != null ? fullName.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (dateRecieved != null ? dateRecieved.hashCode() : 0);
        result = 31 * result + (dateOfBirth != null ? dateOfBirth.hashCode() : 0);
        result = 31 * result + (discount != null ? discount.hashCode() : 0);
        return result;
    }
}

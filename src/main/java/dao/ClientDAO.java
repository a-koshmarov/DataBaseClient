package main.java.dao;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "Client", schema = "dbo", catalog = "Laboratory")
public class ClientDAO {
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
        ClientDAO clientDAO = (ClientDAO) o;
        return cardNumber == clientDAO.cardNumber &&
                Objects.equals(fullName, clientDAO.fullName) &&
                Objects.equals(phone, clientDAO.phone) &&
                Objects.equals(email, clientDAO.email) &&
                Objects.equals(dateRecieved, clientDAO.dateRecieved) &&
                Objects.equals(dateOfBirth, clientDAO.dateOfBirth) &&
                Objects.equals(discount, clientDAO.discount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cardNumber, fullName, phone, email, dateRecieved, dateOfBirth, discount);
    }
}

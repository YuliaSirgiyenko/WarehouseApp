package com.sirgiyenko.App_warehouse.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "CUSTOMER")
public class Customer {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "CUSTOMER_ID", nullable = false)
    private int id;

    @Column(name = "CUSTOMER_FIRST_NAME", length = 20, nullable = false)
    private String firstName;

    @Column(name = "CUSTOMER_LAST_NAME", length = 20, nullable = false)
    private String lastName;

    @Column(name = "CUSTOMER_COMPANY", length = 20)
    private String company;

    @Column(name = "CUSTOMER_STATUS", nullable = false)
    private String status;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", company='" + company + '\'' +
                ", status='" + status + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Customer)) return false;
        Customer customer = (Customer) o;
        return getId() == customer.getId() &&
                Objects.equals(getFirstName(), customer.getFirstName()) &&
                Objects.equals(getLastName(), customer.getLastName()) &&
                Objects.equals(getCompany(), customer.getCompany()) &&
                Objects.equals(getStatus(), customer.getStatus());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getFirstName(), getLastName(), getCompany(), getStatus());
    }
}

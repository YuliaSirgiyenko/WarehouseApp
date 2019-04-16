package com.sirgiyenko.App_warehouse.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "PRODUCT_OWNER")
public class ProductOwner {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "PRODUCT_OWNER_ID", nullable = false)
    @JsonIgnore
    private int id;

    @Column(name = "PRODUCT_OWNER_FIRST_NAME", length = 20, nullable = false)
    @JsonProperty("firstName")
    private String firstName;

    @Column(name = "PRODUCT_OWNER_LAST_NAME", length = 20, nullable = false)
    @JsonProperty("lastName")
    private String lastName;

    @Column(name = "PRODUCT_OWNER_COMPANY", length = 20)
    @JsonProperty("company")
    private String company;

    @Column(name = "PRODUCT_OWNER_STATUS", nullable = false)
    @JsonIgnore
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
        return "ProductOwner{" +
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
        if (!(o instanceof ProductOwner)) return false;
        ProductOwner productOwner = (ProductOwner) o;
        return getId() == productOwner.getId() &&
                Objects.equals(getFirstName(), productOwner.getFirstName()) &&
                Objects.equals(getLastName(), productOwner.getLastName()) &&
                Objects.equals(getCompany(), productOwner.getCompany()) &&
                Objects.equals(getStatus(), productOwner.getStatus());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getFirstName(), getLastName(), getCompany(), getStatus());
    }
}

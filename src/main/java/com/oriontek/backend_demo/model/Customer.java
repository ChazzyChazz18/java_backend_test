package com.oriontek.backend_demo.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    
    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Email> emailList;

    private String name;
    private String lastName;
    private String companyName;

    public Customer(long id, String name, String lastName, String companyName, List<Email> emailList) {
        this.id = id;
        this.emailList = emailList;
        this.name = name;
        this.lastName = lastName;
        this.companyName = companyName;
    }

    public Long getID() {
        return id;
    }

    public void setID (long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }    

    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }    

    public List<Email> getEmailList() {
        return emailList;
    }

    public void setEmailList(List<Email> email) {
        this.emailList = email;
    }    

    public String getCompanyName() {
        return companyName;
    }
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
    
}

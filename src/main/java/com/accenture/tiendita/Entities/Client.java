package com.accenture.tiendita.Entities;

import javax.persistence.criteria.CriteriaBuilder;

public class Client {
    private Integer idClient;
    private String name;
    private String address;
    private Integer idNumber;

    public Client(Integer idClient, String name, String address, Integer idNumber) {
        this.idClient = idClient;
        this.name = name;
        this.address = address;
        this.idNumber = idNumber;
    }

    @Override
    public String toString() {
        return "Client{" +
                "idClient=" + idClient +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", idNumber='" + idNumber + '\'' +
                '}';
    }

    public Integer getIdClient() {
        return idClient;
    }

    public void setIdClient(Integer idClient) {
        this.idClient = idClient;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(Integer idNumber) {
        this.idNumber = idNumber;
    }
}

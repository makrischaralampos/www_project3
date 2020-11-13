/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author makri
 */
@Entity
@Table(name = "product_data")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProductData.findAll", query = "SELECT p FROM ProductData p"),
    @NamedQuery(name = "ProductData.findByBarcode", query = "SELECT p FROM ProductData p WHERE p.barcode = :barcode"),
    @NamedQuery(name = "ProductData.findByName", query = "SELECT p FROM ProductData p WHERE p.name = :name"),
    @NamedQuery(name = "ProductData.findByColor", query = "SELECT p FROM ProductData p WHERE p.color = :color"),
    @NamedQuery(name = "ProductData.findByDescription", query = "SELECT p FROM ProductData p WHERE p.description = :description")})
public class ProductData implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "barcode")
    private String barcode;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @Column(name = "color")
    private String color;
    @Basic(optional = false)
    @Column(name = "description")
    private String description;

    public ProductData() {
    }

    public ProductData(String barcode) {
        this.barcode = barcode;
    }

    public ProductData(String barcode, String name, String color, String description) {
        this.barcode = barcode;
        this.name = name;
        this.color = color;
        this.description = description;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (barcode != null ? barcode.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProductData)) {
            return false;
        }
        ProductData other = (ProductData) object;
        if ((this.barcode == null && other.barcode != null) || (this.barcode != null && !this.barcode.equals(other.barcode))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.example.model.ProductData[ barcode=" + barcode + " ]";
    }
    
}

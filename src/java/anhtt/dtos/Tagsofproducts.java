/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package anhtt.dtos;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Yorkit Tran
 */
@Entity
@Table(name = "tagsofproducts")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tagsofproducts.findAll", query = "SELECT t FROM Tagsofproducts t")
    , @NamedQuery(name = "Tagsofproducts.findById", query = "SELECT t FROM Tagsofproducts t WHERE t.id = :id")
    , @NamedQuery(name = "Tagsofproducts.findByTagId", query = "SELECT t FROM Tagsofproducts t WHERE t.tagId = :tagId")
    , @NamedQuery(name = "Tagsofproducts.findByProductId", query = "SELECT t FROM Tagsofproducts t WHERE t.productId = :productId")})
public class Tagsofproducts implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Products productId;
    @JoinColumn(name = "tag_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Tags tagId;

    public Tagsofproducts() {
    }

    public Tagsofproducts(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Products getProductId() {
        return productId;
    }

    public void setProductId(Products productId) {
        this.productId = productId;
    }

    public Tags getTagId() {
        return tagId;
    }

    public void setTagId(Tags tagId) {
        this.tagId = tagId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tagsofproducts)) {
            return false;
        }
        Tagsofproducts other = (Tagsofproducts) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "anhtt.dtos.Tagsofproducts[ id=" + id + " ]";
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package anhtt.dtos;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Yorkit Tran
 */
@Entity
@Table(name = "products")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Products.findAll", query = "SELECT p FROM Products p")
    , @NamedQuery(name = "Products.findById", query = "SELECT p FROM Products p WHERE p.id = :id")
    , @NamedQuery(name = "Products.findByName", query = "SELECT p FROM Products p WHERE p.name = :name")
    , @NamedQuery(name = "Products.findByColour", query = "SELECT p FROM Products p WHERE p.colour = :colour")
    , @NamedQuery(name = "Products.findByDescription", query = "SELECT p FROM Products p WHERE p.description = :description")
    , @NamedQuery(name = "Products.findByImage", query = "SELECT p FROM Products p WHERE p.image = :image")
    , @NamedQuery(name = "Products.findByUrl", query = "SELECT p FROM Products p WHERE p.url = :url")
    , @NamedQuery(name = "Products.findByRecommend", query = "SELECT p FROM Products p WHERE p.recommend = :recommend")})
public class Products implements Serializable {

    @OneToMany(mappedBy = "layerId")
    private Collection<Favorites> favoritesCollection;
    @OneToMany(mappedBy = "topId")
    private Collection<Favorites> favoritesCollection1;
    @OneToMany(mappedBy = "bottomId")
    private Collection<Favorites> favoritesCollection2;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "colour")
    private String colour;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "description")
    private String description;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "image")
    private String image;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "url")
    private String url;
    @Basic(optional = false)
    @NotNull
    @Column(name = "recommend")
    private int recommend;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "productId")
    private Collection<Tagsofproducts> tagsofproductsCollection;
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Categories categoryId;

    public Products() {
    }

    public Products(Integer id) {
        this.id = id;
    }

    public Products(Integer id, String name, String colour, String description, String image, String url, int recommend) {
        this.id = id;
        this.name = name;
        this.colour = colour;
        this.description = description;
        this.image = image;
        this.url = url;
        this.recommend = recommend;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getRecommend() {
        return recommend;
    }

    public void setRecommend(int recommend) {
        this.recommend = recommend;
    }

    @XmlTransient
    public Collection<Tagsofproducts> getTagsofproductsCollection() {
        return tagsofproductsCollection;
    }

    public void setTagsofproductsCollection(Collection<Tagsofproducts> tagsofproductsCollection) {
        this.tagsofproductsCollection = tagsofproductsCollection;
    }

    public Categories getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Categories categoryId) {
        this.categoryId = categoryId;
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
        if (!(object instanceof Products)) {
            return false;
        }
        Products other = (Products) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "anhtt.dtos.Products[ id=" + id + " ]";
    }

    @XmlTransient
    public Collection<Favorites> getFavoritesCollection() {
        return favoritesCollection;
    }

    public void setFavoritesCollection(Collection<Favorites> favoritesCollection) {
        this.favoritesCollection = favoritesCollection;
    }

    @XmlTransient
    public Collection<Favorites> getFavoritesCollection1() {
        return favoritesCollection1;
    }

    public void setFavoritesCollection1(Collection<Favorites> favoritesCollection1) {
        this.favoritesCollection1 = favoritesCollection1;
    }

    @XmlTransient
    public Collection<Favorites> getFavoritesCollection2() {
        return favoritesCollection2;
    }

    public void setFavoritesCollection2(Collection<Favorites> favoritesCollection2) {
        this.favoritesCollection2 = favoritesCollection2;
    }

}

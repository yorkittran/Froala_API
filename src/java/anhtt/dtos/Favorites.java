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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Table(name = "favorites")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Favorites.findAll", query = "SELECT f FROM Favorites f")
    , @NamedQuery(name = "Favorites.findById", query = "SELECT f FROM Favorites f WHERE f.id = :id")
    , @NamedQuery(name = "Favorites.findByUser", query = "SELECT f FROM Favorites f WHERE f.userEmail = :user")})
public class Favorites implements Serializable {

    @JoinColumn(name = "layer_id", referencedColumnName = "id")
    @ManyToOne
    private Products layerId;
    @JoinColumn(name = "top_id", referencedColumnName = "id")
    @ManyToOne
    private Products topId;
    @JoinColumn(name = "bottom_id", referencedColumnName = "id")
    @ManyToOne
    private Products bottomId;
    @JoinColumn(name = "user_email", referencedColumnName = "email")
    @ManyToOne
    private Users userEmail;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    @Column(name = "id")
    private Integer id;

    public Favorites() {
    }

    public Favorites(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
        if (!(object instanceof Favorites)) {
            return false;
        }
        Favorites other = (Favorites) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "anhtt.dtos.Favorites[ id=" + id + " ]";
    }

    public Products getLayerId() {
        return layerId;
    }

    public void setLayerId(Products layerId) {
        this.layerId = layerId;
    }

    public Products getTopId() {
        return topId;
    }

    public void setTopId(Products topId) {
        this.topId = topId;
    }

    public Products getBottomId() {
        return bottomId;
    }

    public void setBottomId(Products bottomId) {
        this.bottomId = bottomId;
    }

    public Users getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(Users userEmail) {
        this.userEmail = userEmail;
    }
    
}

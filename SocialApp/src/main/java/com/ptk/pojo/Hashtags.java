/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ptk.pojo;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Kien
 */
@Entity
@Table(name = "hashtags")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Hashtags.findAll", query = "SELECT h FROM Hashtags h"),
    @NamedQuery(name = "Hashtags.findById", query = "SELECT h FROM Hashtags h WHERE h.id = :id"),
    @NamedQuery(name = "Hashtags.findByHashtagName", query = "SELECT h FROM Hashtags h WHERE h.hashtagName = :hashtagName")})
public class Hashtags implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "hashtag_name")
    private String hashtagName;
    @ManyToMany(mappedBy = "hashtagsSet")
    private Set<Posts> postsSet;

    public Hashtags() {
    }

    public Hashtags(Integer id) {
        this.id = id;
    }

    public Hashtags(Integer id, String hashtagName) {
        this.id = id;
        this.hashtagName = hashtagName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getHashtagName() {
        return hashtagName;
    }

    public void setHashtagName(String hashtagName) {
        this.hashtagName = hashtagName;
    }

    @XmlTransient
    public Set<Posts> getPostsSet() {
        return postsSet;
    }

    public void setPostsSet(Set<Posts> postsSet) {
        this.postsSet = postsSet;
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
        if (!(object instanceof Hashtags)) {
            return false;
        }
        Hashtags other = (Hashtags) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ptk.pojo.Hashtags[ id=" + id + " ]";
    }
    
}

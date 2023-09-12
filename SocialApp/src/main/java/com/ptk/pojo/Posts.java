/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ptk.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Kien
 */
@Entity
@Table(name = "posts")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Posts.findAll", query = "SELECT p FROM Posts p"),
    @NamedQuery(name = "Posts.findById", query = "SELECT p FROM Posts p WHERE p.id = :id"),
    @NamedQuery(name = "Posts.findByTitle", query = "SELECT p FROM Posts p WHERE p.title = :title"),
    @NamedQuery(name = "Posts.findByImage", query = "SELECT p FROM Posts p WHERE p.image = :image"),
    @NamedQuery(name = "Posts.findByCreatedAt", query = "SELECT p FROM Posts p WHERE p.createdAt = :createdAt"),
    @NamedQuery(name = "Posts.findByUpdatedAt", query = "SELECT p FROM Posts p WHERE p.updatedAt = :updatedAt")})
public class Posts implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "title")
    private String title;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "content")
    private String content;
    @Size(max = 255)
    @Column(name = "image")
    private String image;
    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @Column(name = "updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;
    
    
    
    @JsonIgnore
    @JoinTable(name = "post_hashtags", joinColumns = {
        @JoinColumn(name = "post_id", referencedColumnName = "id")}, inverseJoinColumns = {
        @JoinColumn(name = "hashtag_id", referencedColumnName = "id")})
    @ManyToMany
    private Set<Hashtags> hashtagsSet;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "postId")
    private Set<Reports> reportsSet;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "postId")
    private Set<PostLike> postLikeSet;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "postId")
    private Set<PostReplyLike> postReplyLikeSet;
    
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Users userId;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "postId")
    private Set<PostReply> postReplySet;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "postId")
    private Set<PostComment> postCommentSet;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "postId")
    private Set<Notifications> notificationsSet;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "postId")
    private Set<PostCommentLike> postCommentLikeSet;

    public Posts() {
    }

    public Posts(Integer id) {
        this.id = id;
    }

    public Posts(Integer id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    @XmlTransient
    public Set<Hashtags> getHashtagsSet() {
        return hashtagsSet;
    }

    public void setHashtagsSet(Set<Hashtags> hashtagsSet) {
        this.hashtagsSet = hashtagsSet;
    }

    @XmlTransient
    public Set<Reports> getReportsSet() {
        return reportsSet;
    }

    public void setReportsSet(Set<Reports> reportsSet) {
        this.reportsSet = reportsSet;
    }

    @XmlTransient
    public Set<PostLike> getPostLikeSet() {
        return postLikeSet;
    }

    public void setPostLikeSet(Set<PostLike> postLikeSet) {
        this.postLikeSet = postLikeSet;
    }

    @XmlTransient
    public Set<PostReplyLike> getPostReplyLikeSet() {
        return postReplyLikeSet;
    }

    public void setPostReplyLikeSet(Set<PostReplyLike> postReplyLikeSet) {
        this.postReplyLikeSet = postReplyLikeSet;
    }

    public Users getUserId() {
        return userId;
    }

    public void setUserId(Users userId) {
        this.userId = userId;
    }

    @XmlTransient
    public Set<PostReply> getPostReplySet() {
        return postReplySet;
    }

    public void setPostReplySet(Set<PostReply> postReplySet) {
        this.postReplySet = postReplySet;
    }

    @XmlTransient
    public Set<PostComment> getPostCommentSet() {
        return postCommentSet;
    }

    public void setPostCommentSet(Set<PostComment> postCommentSet) {
        this.postCommentSet = postCommentSet;
    }

    @XmlTransient
    public Set<Notifications> getNotificationsSet() {
        return notificationsSet;
    }

    public void setNotificationsSet(Set<Notifications> notificationsSet) {
        this.notificationsSet = notificationsSet;
    }

    @XmlTransient
    public Set<PostCommentLike> getPostCommentLikeSet() {
        return postCommentLikeSet;
    }

    public void setPostCommentLikeSet(Set<PostCommentLike> postCommentLikeSet) {
        this.postCommentLikeSet = postCommentLikeSet;
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
        if (!(object instanceof Posts)) {
            return false;
        }
        Posts other = (Posts) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ptk.pojo.Posts[ id=" + id + " ]";
    }
    
}

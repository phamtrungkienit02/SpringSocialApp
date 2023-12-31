/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ptk.pojo;

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
import javax.persistence.Lob;
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
@Table(name = "post_reply")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PostReply.findAll", query = "SELECT p FROM PostReply p"),
    @NamedQuery(name = "PostReply.findById", query = "SELECT p FROM PostReply p WHERE p.id = :id"),
    @NamedQuery(name = "PostReply.findByCreatedAt", query = "SELECT p FROM PostReply p WHERE p.createdAt = :createdAt"),
    @NamedQuery(name = "PostReply.findByUpdatedAt", query = "SELECT p FROM PostReply p WHERE p.updatedAt = :updatedAt")})
public class PostReply implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "content")
    private String content;
    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @Column(name = "updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "replyId")
    private Set<PostReplyLike> postReplyLikeSet;
    @JoinColumn(name = "comment_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private PostComment commentId;
    @OneToMany(mappedBy = "replyId")
    private Set<PostReply> postReplySet;
    @JoinColumn(name = "reply_id", referencedColumnName = "id")
    @ManyToOne
    private PostReply replyId;
    @JoinColumn(name = "post_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Posts postId;
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Users userId;

    public PostReply() {
    }

    public PostReply(Integer id) {
        this.id = id;
    }

    public PostReply(Integer id, String content) {
        this.id = id;
        this.content = content;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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
    public Set<PostReplyLike> getPostReplyLikeSet() {
        return postReplyLikeSet;
    }

    public void setPostReplyLikeSet(Set<PostReplyLike> postReplyLikeSet) {
        this.postReplyLikeSet = postReplyLikeSet;
    }

    public PostComment getCommentId() {
        return commentId;
    }

    public void setCommentId(PostComment commentId) {
        this.commentId = commentId;
    }

    @XmlTransient
    public Set<PostReply> getPostReplySet() {
        return postReplySet;
    }

    public void setPostReplySet(Set<PostReply> postReplySet) {
        this.postReplySet = postReplySet;
    }

    public PostReply getReplyId() {
        return replyId;
    }

    public void setReplyId(PostReply replyId) {
        this.replyId = replyId;
    }

    public Posts getPostId() {
        return postId;
    }

    public void setPostId(Posts postId) {
        this.postId = postId;
    }

    public Users getUserId() {
        return userId;
    }

    public void setUserId(Users userId) {
        this.userId = userId;
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
        if (!(object instanceof PostReply)) {
            return false;
        }
        PostReply other = (PostReply) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ptk.pojo.PostReply[ id=" + id + " ]";
    }
    
}

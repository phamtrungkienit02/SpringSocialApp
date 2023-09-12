/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ptk.pojo;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Kien
 */
@Entity
@Table(name = "post_reply_like")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PostReplyLike.findAll", query = "SELECT p FROM PostReplyLike p"),
    @NamedQuery(name = "PostReplyLike.findById", query = "SELECT p FROM PostReplyLike p WHERE p.id = :id"),
    @NamedQuery(name = "PostReplyLike.findByCreatedAt", query = "SELECT p FROM PostReplyLike p WHERE p.createdAt = :createdAt")})
public class PostReplyLike implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @JoinColumn(name = "comment_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private PostComment commentId;
    @JoinColumn(name = "reply_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private PostReply replyId;
    @JoinColumn(name = "post_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Posts postId;
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Users userId;

    public PostReplyLike() {
    }

    public PostReplyLike(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public PostComment getCommentId() {
        return commentId;
    }

    public void setCommentId(PostComment commentId) {
        this.commentId = commentId;
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
        if (!(object instanceof PostReplyLike)) {
            return false;
        }
        PostReplyLike other = (PostReplyLike) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ptk.pojo.PostReplyLike[ id=" + id + " ]";
    }
    
}

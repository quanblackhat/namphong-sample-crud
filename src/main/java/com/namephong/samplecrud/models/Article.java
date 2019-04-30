package com.namephong.samplecrud.models;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "article")
public class Article implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "image")
    private String image;

    @Column(name = "title")
    private String title;

    @Column(name = "header")
    private String header;

    @Column(name = "content")
    private String content;

    @Column(name = "author")
    private String author;

    @Column(name = "date_create")
    private Long dateCreatedTimestamp;

    @Transient
    private Date dateCreated;

    @Transient
    private String url;

    public String getUrl() {
        return "/detail/" + id;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Article() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Long getDateCreatedTimestamp() {
        return dateCreatedTimestamp;
    }

    public void setDateCreatedTimestamp(Long dateCreatedTimestamp) {
        this.dateCreatedTimestamp = dateCreatedTimestamp;
    }

    public Date getDateCreated() {
        if (dateCreatedTimestamp != null) {
            Timestamp ts=new Timestamp(dateCreatedTimestamp*1000);
            Date date=new Date(ts.getTime());
            return date;
        }
        return null;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }
}

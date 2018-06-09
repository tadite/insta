package com.csf.insta.entities;

import javax.persistence.*;

@Entity
public class Image {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name="author_id")
    private User author;


    @Lob
    @Column(name = "bytes", columnDefinition="BLOB")
    private byte[] bytes;

    private String description;


    public Image() {
    }

    public Image(byte[] bytes, String description) {
        this.bytes = bytes;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public byte[] getBytes() {
        return bytes;
    }

    public void setBytes(byte[] bytes) {
        this.bytes = bytes;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

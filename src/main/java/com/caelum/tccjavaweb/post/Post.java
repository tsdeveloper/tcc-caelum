package com.caelum.tccjavaweb.post;

import com.caelum.tccjavaweb.speeche.Speeche;

import javax.persistence.*;
import java.util.Date;

@SuppressWarnings("serial")
@Entity
@Table(name = "posts")
public class Post  implements java.io.Serializable {

	public Post() {
		
	}
	
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String body;
    private Date dateCreated;

    public Post(String title, String body){
        this.title =title;
        this.body = body;
    }

    @ManyToOne
    private Speeche creator;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }


    public void setCreator(Speeche creator) {
        this.creator = creator;
    }
}

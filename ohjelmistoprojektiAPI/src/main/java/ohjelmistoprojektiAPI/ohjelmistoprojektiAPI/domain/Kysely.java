package ohjelmistoprojektiAPI.ohjelmistoprojektiAPI.domain;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Data
@Entity
public class Kysely {

		private @Id @GeneratedValue Long id;
	  private String question;
	  private String content;
	  private String content1;
	  private String content2;
	  private String content3;
	  private String content4;

	  Kysely() {}

	  Kysely(String question, String content) {
	    this.question = question;
	    this.content = content;
	  }
	  public Kysely( String question, String content, String content1) {
			super();
			this.question = question;
			this.content = content;
			this.content1 = content1;
			
		}

	  
	  public Kysely( String question, String content, String content1, String content2) {
			super();
			this.question = question;
			this.content = content;
			this.content1 = content1;
			this.content2 = content2;
			
		}

	  public Kysely( String question, String content, String content1, String content2, String content3) {
			super();
			this.question = question;
			this.content = content;
			this.content1 = content1;
			this.content2 = content2;
			this.content3 = content3;
			
		}


	public Kysely( String question, String content, String content1, String content2, String content3,
			String content4) {
		super();
		this.question = question;
		this.content = content;
		this.content1 = content1;
		this.content2 = content2;
		this.content3 = content3;
		this.content4 = content4;
	}

	public String getContent1() {
		return content1;
	}

	public void setContent1(String content1) {
		this.content1 = content1;
	}

	public String getContent2() {
		return content2;
	}

	public void setContent2(String content2) {
		this.content2 = content2;
	}

	public String getContent3() {
		return content3;
	}

	public void setContent3(String content3) {
		this.content3 = content3;
	}

	public String getContent4() {
		return content4;
	}

	public void setContent4(String content4) {
		this.content4 = content4;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	  
	}


package com.springbook.biz.board;


import java.util.Date;

/* sql의 Date클래스 사용시 XML변환했을때 날짜 안나오는 문제 있음, Util의 Date클래스를 사용하면 그런문제 발생안함 */

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="BOARD3")
public class BoardVO {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="USER_SEQ_GENERATOR") /*USER_SEQ_GENERATOR: 임의로 붙인 이름*/
	@SequenceGenerator(name="USER_SEQ_GENERATOR",sequenceName="BOARD_SEQ", allocationSize=1) /* sequence의 자동증가량은 50씩, allocationSize를 1로 하면 1씩증가 */
	private int seq;
	private String title;
	private String writer;
	private String content;
	@Temporal(TemporalType.DATE)
	private Date regDate = new Date();
	private int cnt;
	@Transient
	private String searchCondition;
	@Transient
	private String searchKeyword;
	@Transient
	private MultipartFile uploadFile;
	private String files;
	/*JSON타입으로 변환할때 필요 없는 항목은 get메소드 위에 @JsonIgnore annotation붙이면 안나옴*/
	//getter/setter
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regdate) {
		this.regDate = regdate;
	}
	public int getCnt() {
		return cnt;
	}
	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
	@JsonIgnore
	public String getSearchCondition() {
		return searchCondition;
	}
	public void setSearchCondition(String searchCondition) {
		this.searchCondition = searchCondition;
	}
	@JsonIgnore 
	public String getSearchKeyword() {
		return searchKeyword;
	}
	public void setSearchKeyword(String searchKeyword) {
		this.searchKeyword = searchKeyword;
	}
	@JsonIgnore
	public MultipartFile getUploadFile() {
		return uploadFile;
	}
	public void setUploadFile(MultipartFile uploadFile) {
		this.uploadFile = uploadFile;
	}
	@JsonIgnore
	public String getFiles() {
		return files;
	}
	public void setFiles(String files) {
		this.files = files;
	}
	//toString()재정의
	@Override
	public String toString() {
		return "BoardVo [seq="+seq+",title="+title+",writer="+writer+",content="+content+",regDate="+regDate+",cnt="+cnt+",files="+files+"]";
	}
	
	
}

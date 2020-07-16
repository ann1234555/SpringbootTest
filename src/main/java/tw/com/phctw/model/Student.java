package tw.com.phctw.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="STUDENT4")
public class Student{
	@Id
	@Column(name = "SID")
	@SequenceGenerator( name = "STD_SEQ", sequenceName = "HIBERNATE_SEQUENCE", allocationSize = 1 ) 
	@GeneratedValue( strategy = GenerationType.SEQUENCE, generator = "STD_SEQ")
	private Long sid;
	
	@Column(name = "SNAME",length = 30, nullable = false)
	private String sname;
	
	@Column(name = "SBDAY")
	private Date sbday;
	
	@Column(name = "SSEX")
	private Integer ssex;
	
	@Column(name = "SMAIL", length = 50, nullable = false)
	private String smail;
	
	@Column(name = "SACC", length = 30, nullable = false)
	private String sacc;
	
	@Column(name = "SPWD", length = 30, nullable = false)
	private String spwd;

	@Column(name = "CONF", length = 10)
	private String conf;
	

	public Student() {
		super();
	}

	

	public Student(String sname, String smail, String sacc, String spwd) {
		super();
		this.sname = sname;
		this.smail = smail;
		this.sacc = sacc;
		this.spwd = spwd;
	}



	public Long getSid() {
		return sid;
	}


	public void setSid(Long sid) {
		this.sid = sid;
	}


	public String getSname() {
		return sname;
	}


	public void setSname(String sname) {
		this.sname = sname;
	}


	public Date getSbday() {
		return sbday;
	}


	public void setSbday(Date sbday) {
		this.sbday = sbday;
	}


	public Integer getSsex() {
		return ssex;
	}


	public void setSsex(Integer ssex) {
		this.ssex = ssex;
	}


	public String getSmail() {
		return smail;
	}


	public void setSmail(String smail) {
		this.smail = smail;
	}


	public String getSacc() {
		return sacc;
	}


	public void setSacc(String sacc) {
		this.sacc = sacc;
	}


	public String getSpwd() {
		return spwd;
	}


	public void setSpwd(String spwd) {
		this.spwd = spwd;
	}


	public String getConf() {
		return conf;
	}


	public void setConf(String conf) {
		this.conf = conf;
	}
	
	@Override
	public String toString() {
		return "Student [sid=" + sid + ", sname=" + sname + ", sbday=" + sbday + ", ssex=" + ssex + ", smail=" + smail
				+ ", sacc=" + sacc + ", spwd=" + spwd + ", conf=" + conf + "]";
	}
	
	
	
	
	
}

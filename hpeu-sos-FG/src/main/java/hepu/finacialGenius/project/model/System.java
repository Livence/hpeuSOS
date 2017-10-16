package hepu.finacialGenius.project.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(catalog="financial_genius",name="system")
public class System {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id; 
	
	private String systemMsg;
	
	private Integer application;
	
	@OneToOne(fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	@PrimaryKeyJoinColumn
	private User user;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getSystemMsg() {
		return systemMsg;
	}

	public void setSystemMsg(String systemMsg) {
		this.systemMsg = systemMsg;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}


	public System() {
		super();
	}

	public System( User user) {
		super();
		this.user = user;
	}

	public Integer getApplication() {
		return application;
	}

	public void setApplication(Integer application) {
		this.application = application;
	}

	@Override
	public String toString() {
		return "System [id=" + id + ", systemMsg=" + systemMsg + ", application=" + application + ", user=" + user
				+ "]";
	}	
	
}

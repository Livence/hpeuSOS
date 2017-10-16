package hepu.finacialGenius.project.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(catalog="financial_genius",name="message")
public class Message {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	private Integer targetId;
	
	private String messges;
	
	private Integer state;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "userid")
	private User user;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getTargetId() {
		return targetId;
	}

	public void setTargetId(Integer targetId) {
		this.targetId = targetId;
	}

	public String getMessges() {
		return messges;
	}

	public void setMessges(String messges) {
		this.messges = messges;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Integer isState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	@Override
	public String toString() {
		return "Message [id=" + id + ", targetId=" + targetId + ", messges=" + messges + ", state=" + state + ", user="
				+ user + "]";
	} 
	
	
}

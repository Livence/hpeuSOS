package hepu.finacialGenius.project.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.stereotype.Component;


@Component
@Entity
@Table(catalog="financial_genius",name="records")
public class Records {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id; 
	
	@Temporal(TemporalType.DATE)
	@Column(name = "tradeDate")
	private Date tradeDate;
	
	private double tradeAccount;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "userid")
	private User user;

	public Records() {
		super();
	}
	
	public Records(Date tradeDate, double tradeAccount, User user) {
		super();
		this.tradeDate = tradeDate;
		this.tradeAccount = tradeAccount;
		this.user = user;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getTradeDate() {
		return tradeDate;
	}

	public void setTradeDate(Date tradeDate) {
		this.tradeDate = tradeDate;
	}

	public double getTradeAccount() {
		return tradeAccount;
	}

	public void setTradeAccount(double tradeAccount) {
		this.tradeAccount = tradeAccount;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Records [id=" + id + ", tradeDate=" + tradeDate + ", tradeAccount=" + tradeAccount + ", user=" + user
				+ "]";
	}
	
}

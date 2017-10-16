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
@Table(catalog="financial_genius",name="card")
public class Card {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	private String cardName;//银行卡的所属银行
	
	private String cardNum;//银行卡账号
	
	private Integer cardPwd;//银行卡密码
	
	private double balance;//银行卡余额

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "userid")
	private User user;//和user表是多对一关系，在card表里生成外键

	public Card() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Card(String cardName, String cardNum, Integer cardPwd, User user) {
		super();
		this.cardName = cardName;
		this.cardNum = cardNum;
		this.cardPwd = cardPwd;
		this.user = user;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getCardNum() {
		return cardNum;
	}

	public void setCardNum(String cardNum) {
		this.cardNum = cardNum;
	}

	public Integer getCardPwd() {
		return cardPwd;
	}

	public void setCardPwd(Integer cardPwd) {
		this.cardPwd = cardPwd;
	}
	
	public String getCardName() {
		return cardName;
	}

	public void setCardName(String cardName) {
		this.cardName = cardName;
	}

	@Override
	public String toString() {
		return "Card [id=" + id + ", cardName=" + cardName + ", cardNum=" + cardNum + ", cardPwd=" + cardPwd
				+ ", balance=" + balance + ", user=" + user + "]";
	}
	
}

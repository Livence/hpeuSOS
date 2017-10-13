package hepu.finacialGenius.project.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(catalog = "financial_genius", name = "user")
public class User {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	private Integer state;
	
	private Integer systemMsg;
	
	private String userName;

	private String password;

	private String IDNumber;
	
	private Long creditScore;
	
	private double userBalance;
	
	private String payWord;

	private String address;
	
	private String profession;
	
	private double income;
	
	private String sex;
	
	@OneToMany(cascade=CascadeType.ALL,fetch = FetchType.EAGER,mappedBy="user")//mapperdBy指定主表是 User 。此处User 写小写 user.
	private Set<Card> cards = new HashSet<Card>();
	
	@OneToMany(cascade=CascadeType.ALL,fetch = FetchType.EAGER,mappedBy="user")//mapperdBy指定主表是 User 。此处User 写小写 user.
	private Set<Records> records = new HashSet<Records>();
	
	@OneToMany(cascade=CascadeType.ALL,fetch = FetchType.EAGER,mappedBy="user")//mapperdBy指定主表是 User 。此处User 写小写 user.
	private Set<Message> messages = new HashSet<Message>();
	
	@OneToOne(fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	@PrimaryKeyJoinColumn
	private System system;
	
	public User() {
		super();
	}
  
	public User(Integer id) {
		super();
		this.id = id;
	}

	public User(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getIDNumber() {
		return IDNumber;
	}

	public void setIDNumber(String iDNumber) {
		IDNumber = iDNumber;
	}

	public double getUserBalance() {
		return userBalance;
	}

	public void setUserBalance(double userBalance) {
		this.userBalance = userBalance;
	}
	
	public Long getCreditScore() {
		return creditScore;
	}

	public void setCreditScore(Long creditScore) {
		this.creditScore = creditScore;
	}

	public Set<Card> getCards() {
		return cards;
	}

	public void setCards(Set<Card> cards) {
		this.cards = cards;
	}    
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Set<Records> getRecords() {
		return records;
	}

	public void setRecords(Set<Records> records) {
		this.records = records;
	}

	public String getPayWord() {
		return payWord;
	}

	public void setPayWord(String payWord) {
		this.payWord = payWord;
	}

	public Integer isState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public Set<Message> getMessages() {
		return messages;
	}

	public void setMessages(Set<Message> messages) {
		this.messages = messages;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getProfession() {
		return profession;
	}

	public void setProfession(String profession) {
		this.profession = profession;
	}

	public double getIncome() {
		return income;
	}

	public void setIncome(double income) {
		this.income = income;
	}

	public String isSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public System getSystem() {
		return system;
	}

	public void setSystem(System system) {
		this.system = system;
	}

	public Integer getSystemMsg() {
		return systemMsg;
	}

	public void setSystemMsg(Integer systemMsg) {
		this.systemMsg = systemMsg;
	}

	public Integer getState() {
		return state;
	}

	public String getSex() {
		return sex;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", state=" + state + ", systemMsg=" + systemMsg + ", userName=" + userName
				+ ", password=" + password + ", IDNumber=" + IDNumber + ", creditScore=" + creditScore
				+ ", userBalance=" + userBalance + ", payWord=" + payWord + ", address=" + address + ", profession="
				+ profession + ", income=" + income + ", sex=" + sex + "]";
	}
}

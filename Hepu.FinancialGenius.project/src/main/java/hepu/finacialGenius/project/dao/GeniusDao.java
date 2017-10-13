package hepu.finacialGenius.project.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import hepu.finacialGenius.project.model.Card;
import hepu.finacialGenius.project.model.Records;
import hepu.finacialGenius.project.model.System;
import hepu.finacialGenius.project.model.User;

@Repository
public class GeniusDao {

    private SessionFactory sessionFactory;

    @Resource(name="mySessionFactory")
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
    //添加用户
    public void addUser(User user){
    	Session session = sessionFactory.getCurrentSession();
    	user.setSystem(new System(user));
    	session.save(user);		
    }

    //查询出所有用户的资料
	@SuppressWarnings("unchecked")
	public List<User> getAll(User user) {
    	Session session = sessionFactory.getCurrentSession();
    	List<User> list = null;
    	String hql = "from User";
    	list = session.createQuery(hql).list();
		return list;
	}
	//查询出当前用户的资料
	@SuppressWarnings("unchecked")
	public List<User> getCurrent(User user) {
		Session session = sessionFactory.getCurrentSession();
    	List<User> list = null;
    	String hql = "from User where id = ?";
    	Query query = session.createQuery(hql);
    	query.setInteger(0, user.getId());
    	list = query.list();
		return list;
	}
	//添加银行卡
	public void addCard(String cardNum, Integer cardPwd, User user,String cardName) {
		Session session = sessionFactory.getCurrentSession();
    	session.save(new Card(cardName, cardNum, cardPwd, user));  			
	}
    //查询当前用户绑定的所有银行卡
	@SuppressWarnings("unchecked")
	public List<Card> queryCard(User user) {
		Session session = sessionFactory.getCurrentSession();
    	List<Card> cards = new ArrayList<>();    	
    	String hql = "from Card  where user = ?";
    	Query query = session.createQuery(hql);
    	query.setInteger(0, user.getId());
    	cards = query.list();  	
		return cards;
	}
    //对目标银行卡的金额进行修改
	public void cardBalance(Integer cardId, double tradeBalance) {
		Session session = sessionFactory.getCurrentSession();
    	String hql = "update Card c set c.balance = c.balance - (?) where c.id=?";
    	Query query = session.createQuery(hql);
    	query.setDouble(0, tradeBalance);
    	query.setInteger(1, cardId);
    	query.executeUpdate();			
	}
	//对当前账户的余额进行修改
	public void userBalance(User user, double tradeBalance) {
		Session session = sessionFactory.getCurrentSession();    	
    	String hql = "update User u set u.userBalance = u.userBalance + (?) where u.id=?";
    	Query query = session.createQuery(hql);
    	query.setDouble(0, tradeBalance);
    	query.setInteger(1, user.getId());
    	query.executeUpdate();
	}
    
	//提现或充值的时候在records表里面生成记录
	public void createRecord(User user, double tradeBalance) {
		Session session = sessionFactory.getCurrentSession();    	
    	session.save(new Records(new Date(), tradeBalance, user));
	}

	//删除指定的银行卡
	public void deleteCard(Integer cardId) {
		Session session = sessionFactory.getCurrentSession();
		String hql = "delete from Card where id = ?" ; 
		Query query = session.createQuery(hql);
		query.setInteger(0, cardId);
		query.executeUpdate();
	}
	
}

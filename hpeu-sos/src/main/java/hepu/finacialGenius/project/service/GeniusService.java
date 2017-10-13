package hepu.finacialGenius.project.service;

import java.util.List;
import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import hepu.finacialGenius.project.dao.GeniusDao;
import hepu.finacialGenius.project.model.Card;
import hepu.finacialGenius.project.model.User;

@Service
public class GeniusService {

	private GeniusDao dao;

	//注入dao
	@Resource(name = "geniusDao")
	public void setDao(GeniusDao dao) {
		this.dao = dao;
	}

	public List<User> getAll(User user) {

		return dao.getAll(user);
	}

	public List<User> getCurrent(User user) {

		return dao.getCurrent(user);
	}

	// 根据返回值判断对数据库的操作是否出错，如果出现异常则会回滚，result的值也会是false.
	public boolean addUser(User user) {
		boolean result = false;
		try {
			dao.addUser(user);
			result = true;
		} catch (Exception e) {
			System.out.println(e);
		}
		return result;
	}

	// 根据返回值判断对数据库的操作是否出错
	public boolean addCard(String cardNum, Integer cardPwd, User user, String cardName) {
		boolean result = false;
		try {
			dao.addCard(cardNum, cardPwd, user, cardName);
			result = true;
		} catch (Exception e) {
			System.out.println(e);
		}
		return result;
	}

	public List<Card> queryCard(User user) {

		return dao.queryCard(user);
	}

	// 根据返回值判断对数据库的操作是否出错
	public boolean cardBalance(Integer cardId, double tradeBalance) {
		boolean result = false;
		try {
			dao.cardBalance(cardId, tradeBalance);
			result = true;
		} catch (Exception e) {
			System.out.println(e);
		}
		return result;
	}

	// 根据返回值判断对数据库的操作是否出错
	public boolean userBalance(User user, double tradeBalance) {
		boolean result = false;
		try {
			dao.userBalance(user, tradeBalance);
			result = true;
		} catch (Exception e) {
			System.out.println(e);
		}
		return result;
	}

	public void createRecord(User user, double tradeBalance) {

		dao.createRecord(user, tradeBalance);
	}

	// 根据返回值判断对数据库的操作是否出错
	public boolean deleteCard(Integer cardId) {
		boolean result = false;
		try {
			dao.deleteCard(cardId);
			result = true;
		} catch (Exception e) {
			System.out.println(e);
		}
		return result;
	}

}

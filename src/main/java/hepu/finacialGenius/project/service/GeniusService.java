package hepu.finacialGenius.project.service;

import java.util.List;
import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import hepu.finacialGenius.project.dao.GeniusDao;
import hepu.finacialGenius.project.model.Adminstor;
import hepu.finacialGenius.project.model.Card;
import hepu.finacialGenius.project.model.Records;
import hepu.finacialGenius.project.model.User;

@Service
public class GeniusService {

	private GeniusDao dao;

	// 注入dao
	@Resource(name = "geniusDao")
	public void setDao(GeniusDao dao) {
		this.dao = dao;
	}

	public List<User> getAll(User user) {

		return dao.getAll(user);
	}
	
	/**
	 * 查询当前用户信息
	 * @param user
	 * @return
	 */
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

	public List<Card> queryCard(Object object) {

		return dao.queryCard(object);
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

	/**
	 * 管理员登录
	 * 
	 * @return
	 */
	public List<Adminstor> adminLogin() {
		List<Adminstor> adminstors = dao.adminLogin();
		return adminstors;
	}
	/**
	 * 管理员功能
	 * 查询所有用户
	 * @return
	 */

	public List<User>  getAllUser() {
	List<User> allUsers=dao.getAllUser();
	return allUsers;
	}
	
	/**
	 * 用户个人资料修改
	 */
	public void personalData(User user) {
		dao.personalData(user);
	}

	/**
	 * 查询资金记录
	 */
	public List<Records> fundRecord(User user) {
		return dao.fundRecord(user);		
	}

	public List<Records> fundRecordShow(int i, int showRecords, String hql) {
		// TODO Auto-generated method stub
		return dao.fundRecordShow(i, showRecords, hql);
	}

	public int freezeUser(int userid) {
		
		return dao.freezeUser(userid);
	}

	public int restore(int userid) {
		
		return dao.restore(userid);
	}

	public List<User> queryUser() {
		List<User> lists = dao.queryUser();
		return lists;
	}

}

package hepu.finacialGenius.project.controller;

import java.util.List;
import javax.annotation.Resource;

import hepu.finacialGenius.project.model.Card;
import hepu.finacialGenius.project.model.User;
import hepu.finacialGenius.project.service.GeniusService;

public class GeniusController {

	private User user;

	private Card card;// 接收不了jsp传过来的值

	private List<Card> cards;

	private GeniusService service;

	private String msg;// 发送给jsp传过来的信息。

	private String cardNum;// 接收jsp传过来的参数。

	private Integer cardPwd;// 接收jsp传过来的参数。

	private Integer cardId;// 接收jsp传过来的参数。

	private double tradeBalance;// 接收jsp传过来的参数。

	private String cardName;// 接收jsp传过来的参数。

	// 用户登录验证
	public String login() {
		List<User> list = service.getAll(user);
		for (User users : list) {
			if (users.getUserName().equals(user.getUserName())) {
				if (users.getPassword().equals(user.getPassword())) {
					user.setId(users.getId());
					user.setUserBalance(users.getUserBalance());
					return "loginSuccess";
				}
			}
		}
		msg = "账号或密码输入有误！";
		return "loginFail";
	}

	// 用户注册处理
	public String register() {
		List<User> list = service.getAll(user);
		for (User users : list) {
			if (user.getUserName().equals(users.getUserName())) {
				msg = "该账号已被注册！";
				return "registerFail";
			}
		}
		boolean result = service.addUser(user);
		if (result == false) {
			msg = "注册失败！";
			return "registerFail";
		}
		return "registerSuccess";
	}

	// 添加银行卡
	public String addCard() {
		boolean result = service.addCard(cardNum, cardPwd, user, cardName);
		if (result == false) {
			msg = "添加失败！";
			return "addCard";
		}
		msg = "添加成功！";
		return "toMain";
	}

	// 账户充值
	public String rechange() {
		// -1代表银行卡余额不足，0代表操作中由于某种原因未成功，1代表操作成功。
		int result = rechangeOrWidraw(cardId, tradeBalance, user);
		if (result == -1) {
			msg = "您的银行卡余额不足，请重新操作！！";
			return "rechangeFail";
		} else if (result == 0) {
			msg = "本次操作失败！！";
			return "rechangeFail";
		}
		msg = "充值成功！！";
		return "rechangeSuccess";
	}

	// 账户提现
	public String withdraw() {
		// -1账户余额不足，0代表操作中由于某种原因未成功，1代表操作成功。
		tradeBalance = -tradeBalance;
		int result = rechangeOrWidraw(cardId, tradeBalance, user);
		if (result == -1) {
			msg = "您的账户余额不足，请重新操作！！";
			return "withdrawFail";
		} else if (result == 0) {
			msg = "本次操作失败！！";
			return "withdrawFail";
		}
		msg = "提现成功！！";
		return "withdrawSuccess";
	}

	// 提现和充值调用的方法
	public int rechangeOrWidraw(Integer cardId, double tradeBalance, User user) {
		// 根据result的值判断对数据库的操作过程中是否出错
		boolean result = false;
		// 如果传入的值是负数则是提现操作
		if (tradeBalance < 0) {
			if (Math.abs(tradeBalance) > user.getUserBalance()) {
				msg = "您的账户余额不足！";
				return -1;
			}
			// 充值操作
		} else {
			// cards是当前登录的用户拥有的所有卡的信息 。
			cards = service.queryCard(user);
			// 通过下面的代码判断选择的卡的余额是否足够。
			for (Card card : cards) {
				if (cardId == card.getId()) {
					if (tradeBalance > card.getBalance()) {
						msg = "您的银行卡余额不足！";
						return -1;
					}
				}
			}
		}
		// 如果账户余额或银行卡余额充足，则执行下面的方法
		try {
			// 充值时银行卡扣钱，提现时加钱
			result = service.cardBalance(cardId, tradeBalance);
			// 充值时账户加钱，提现时减钱
			result = service.userBalance(user, tradeBalance);
			// 生成记录交易记录
			service.createRecord(user, tradeBalance);
			// 让显示的账户余额和数据库里的账户余额同步。
			List<User> list = service.getCurrent(user);
			user.setUserBalance(list.get(0).getUserBalance());
			result = true;
		} catch (Exception e) {
			System.out.println(e);
		}
		if (result == true) {
			return 1;
		}
		return 0;
	}

	// 如果用户绑定过银行卡，直接跳转到充值页面，否则提示用户没有绑定银行卡
	public String toRechange() {
		// 查询用户是否绑定银行卡
		cards = service.queryCard(user);
		if (cards.size() == 0) {
			msg = "请先绑定您的银行卡！";
			return "noCard";
		}
		return "toRechange";
	}

	// 如果用户绑定过银行卡，直接跳转到提现页面，否则提示用户没有绑定银行卡
	public String toWithdraw() {
		// 查询用户是否绑定银行卡
		cards = service.queryCard(user);
		if (cards.size() == 0) {
			msg = "请先绑定您的银行卡！";
			return "noCard";
		}
		return "toWithdraw";
	}

	// 跳转到银行卡添加页面
	public String toAddCard() {

		return "toAddCard";
	}

	// 如果用户没绑定银行卡，进行提示，绑定的话直接跳到银行卡管理界面
	public String toCardManage() {
		cards = service.queryCard(user);
		if (cards.size() == 0) {
			msg = "您的账户未绑定银行卡！";
			return "toAddCard";
		}
		return "toCardManage";
	}

	// 解绑银行卡
	public String deleteCard() {
		boolean result = false;
		result = service.deleteCard(cardId);
		if (result == false) {
			msg = "解绑失败！";
			return "toCardManage";
		}
		msg = "解绑成功！";
		return "toMain";
	}

	// 跳转到用户注册界面
	public String toRegister() {

		return "toRegister";
	}

	// 跳转到用户主页面
	public String toMain() {

		return "toMain";
	}

	// 跳转到常见问题界面
	public String toProblem() {

		return "toProblem";
	}

	// 跳转到消息界面
	public String toNews() {

		return "toNews";
	}

	// 账户注销
	public String toCancel() {

		return "toCancel";
	}

	@Resource(name = "geniusService")
	public void setService(GeniusService service) {
		this.service = service;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
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

	public List<Card> getCards() {
		return cards;
	}

	public void setCards(List<Card> cards) {
		this.cards = cards;
	}

	public double getTradeBalance() {
		return tradeBalance;
	}

	public void setTradeBalance(double tradeBalance) {
		this.tradeBalance = tradeBalance;
	}

	public Integer getCardId() {
		return cardId;
	}

	public void setCardId(Integer cardId) {
		this.cardId = cardId;
	}

	public Card getCard() {
		return card;
	}

	public void setCard(Card card) {
		this.card = card;
	}

}

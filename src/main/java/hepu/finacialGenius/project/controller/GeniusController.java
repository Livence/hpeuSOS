package hepu.finacialGenius.project.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import hepu.finacialGenius.project.model.Adminstor;
import hepu.finacialGenius.project.model.Card;
import hepu.finacialGenius.project.model.Records;
import hepu.finacialGenius.project.model.User;
import hepu.finacialGenius.project.service.GeniusService;

public class GeniusController {

	private User user;

	private Adminstor adminstor;

	private Card card;// 接收不了jsp传过来的值

	private List<Card> cards;

	private GeniusService service;

	private String msg;// 发送给jsp传过来的信息。

	private String cardNum;// 接收jsp传过来的参数。

	private Integer cardPwd;// 接收jsp传过来的参数。

	private Integer cardId;// 接收jsp传过来的参数。

	private double tradeBalance;// 接收jsp传过来的参数。

	private String cardName;// 接收jsp传过来的参数。

	private String prompt;// 因为在main页面有两个{msg}故只能再建这个作为提示

	private List<Records> fundRecords;// 传到资金记录的集合

	private int pages;// 分页传到JSP的总页数

	private int i = 1;// 分页是第几页

	private int previous;// 分页的上一页的值

	private int next;// 分页的下一页的值

	private List<Integer> years;// 资金分析传到JSP的年份

	private String yearAndMonth;// 资金分析传到JSP的年月

	private double yearTotal;// 年收支总计

	private double yearAndMonthTotal;// 月收支总计

	// 获得服务器的session
	HttpServletRequest request = ServletActionContext.getRequest();
	HttpSession session = request.getSession();

	// 注册时用ajax验证用户名是否已经注册
	public void nameJudge() throws IOException {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setHeader("Content-type", "text/html;charset=UTF-8");
		PrintWriter pw = response.getWriter();
		List<User> list = service.getAll(user);
		for (User users : list) {
			if (users.getUserName().equals(user.getUserName())) {
				msg = "*账户名已存在";
				pw.write(msg);
				return;
			}
		}
		msg = "*账户名可用";
		pw.write(msg);
	}

	// 用户个人资料修改
	public String personalData() {
		service.personalData(user);
		return "personalData_success";
	}

	// 用户登录验证
	public String login() {
		// 登陆成功的话把当前用户存入session里
		List<User> list = service.getAll(user);
		for (User users : list) {
			if (users.getUserName().equals(user.getUserName())) {
				if (users.getPassword().equals(user.getPassword())) {
					session.setAttribute("id", users.getId());
					session.setAttribute("userName", users.getUserName());
					session.setAttribute("userBalance", users.getUserBalance());
					user.setId(users.getId());
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
			prompt = "添加失败！";
			return "addCard";
		}
		prompt = "添加成功！";
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
		prompt = "充值成功！！";
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
		prompt = "提现成功！！";
		return "withdrawSuccess";
	}

	// 提现和充值调用的方法
	public int rechangeOrWidraw(Integer cardId, double tradeBalance, User user) {
		// 根据result的值判断对数据库的操作过程中是否出错
		boolean result = false;
		// cards是当前登录的用户拥有的所有卡的信息 。
		cards = service.queryCard(session.getAttribute("id"));
		// 如果传入的值是负数则是提现操作
		double userBalance = (double) session.getAttribute("userBalance");
		if (tradeBalance < 0) {
			if (Math.abs(tradeBalance) > userBalance) {
				msg = "您的账户余额不足！";
				// cards是当前登录的用户拥有的所有卡的信息 。
				return -1;
			}
			// 充值操作
		} else {
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
			session.setAttribute("userBalance", (userBalance + tradeBalance));
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
		cards = service.queryCard(session.getAttribute("id"));
		if (cards.size() == 0) {
			prompt = "请先绑定您的银行卡！";
			return "noCard";
		}
		return "toRechange";
	}

	// 如果用户绑定过银行卡，直接跳转到提现页面，否则提示用户没有绑定银行卡
	public String toWithdraw() {
		// 查询用户是否绑定银行卡
		cards = service.queryCard(session.getAttribute("id"));
		if (cards.size() == 0) {
			prompt = "请先绑定您的银行卡！";
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
		cards = service.queryCard(session.getAttribute("id"));
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
			prompt = "解绑失败！";
			return "toCardManage";
		}
		prompt = "解绑成功！";
		return "toMain";
	}

	/**
	 * 管理员登录
	 * 
	 * @return
	 */
	public String adminLogin() {
		List<Adminstor> adminstors = service.adminLogin();
		for (Adminstor adminstor1 : adminstors) {
			if (adminstor.getAdminstorName().equals(adminstor1.getAdminstorName())) {
				if (adminstor1.getAdminstorPassword().equals(adminstor.getAdminstorPassword())) {
					request.getSession().setAttribute("adminstorName", adminstor1.getAdminstorName());
					return "adminLoginSuccess";
				}
			}
		}
		msg = "账户名或密码错误";
		request.setAttribute("msg", msg);
		return "adminstorLoginFail";

	}

	/**
	 * 冻结用户（管理员功能）
	 * 
	 * @return
	 */
	public String freezeUser() {
		int userid = Integer.parseInt(request.getParameter("userid"));
		int result = service.freezeUser(userid);
		if (result == 0) {
			msg = "该账户已被冻结";
			request.setAttribute("msg", msg);
			return "freezeUserSuccess";
		}
		msg = "冻结成功";
		request.setAttribute("msg", msg);
		return "freezeUserSuccess";

	}

	/**
	 * 恢复用户
	 * 
	 * @return
	 */
	public String restoreUser() {
		int userid = Integer.parseInt(request.getParameter("userid1"));
		int result = service.restore(userid);
		return "restoreSuccess";
	}

	// 跳转到用户管理页面
	public String toUserControl() {
		List<User> lists = service.queryUser();
		request.getSession().setAttribute("lists", lists);
		return "toUserControl";
	}

	// 跳转到消息推送页面
	public String toMessageSend() {
		return "toMessageSend";
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

	// 跳转到找回密码
	public String tofindPassword() {
		return "tofindPassword";
	}

	// 跳转到通过申请找回密码页面
	public String tofindPasswordByApplication() {

		return "tofindPasswordByApplication";
	}

	// 跳转到个人中心
	public String topersonalCenter() {

		return "topersonalCenter";
	}

	// 跳转到个人资料修改
	public String topersonalData() {
		return "topersonalData";
	}

	// 跳转到资金记录查询页面以及通过下面这个函数确定分页的页数
	public String fundRecord() {
		int showRecords = 8;// 定义每页显示多少条记录。
		String hql = "from Records";
		int totalRecords = service.fundRecord(user).size();// 得到查询到的记录的总条数。
		if (totalRecords % showRecords == 0) {
			pages = totalRecords / showRecords;// 确定应该有多少页
		} else {
			pages = totalRecords / showRecords + 1;// 确定应该有多少页
		}
		System.out.println(i);
		next = i + 1;
		previous = i - 1;
		fundRecords = service.fundRecordShow((i - 1), showRecords, hql);
		return "fundRecord";
	}

	// 资金统计
	public String fundAnalysis() {
		years = new ArrayList<Integer>();
		fundRecords = service.fundRecord(user);// 得到查询到的记录的集合数。
		for (Records records : fundRecords) {
			Calendar cal = Calendar.getInstance();
			cal.setTime(records.getTradeDate());
			int year = cal.get(Calendar.YEAR);
			if (years.size() == 0) {
				years.add(year);
			}
			for (Integer item : years) {
				if (year == item) {
					continue;
				} else {
					years.add(year);
				}
			}
			/* double yearTotal = records.getTradeAccount(); */

		}
		System.out.println(years.size());
		return "fundAnalysis";
	}

	// 账户注销
	public String toCancel() {
		HttpServletRequest request = ServletActionContext.getRequest();
		// 销毁session
		request.getSession().invalidate();
		// request.getSession().removeAttribute("user"); //仅销毁对象
		return "toCancel";
	}

	// 跳转到管理员登录界面（管理员功能）
	public String toAdminLogin() {
		return "toAdminLogin";
	}

	// 跳转到用户查询页面（管理员功能）
	public String toAdminUserShow() {
		return "toAdminUserShow";
	}

	// 跳转的管理员主页
	public String toAdminMain() {
		return "toAdminMain";
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

	public String getPrompt() {
		return prompt;
	}

	public void setPrompt(String prompt) {
		this.prompt = prompt;
	}

	public int getPages() {
		return pages;
	}

	public void setPages(int pages) {
		this.pages = pages;
	}

	public int getI() {
		return i;
	}

	public void setI(int i) {
		this.i = i;
	}

	public int getPrevious() {
		return previous;
	}

	public void setPrevious(int previous) {
		this.previous = previous;
	}

	public int getNext() {
		return next;
	}

	public void setNext(int next) {
		this.next = next;
	}

	public List<Records> getFundRecords() {
		return fundRecords;
	}

	public void setFundRecords(List<Records> fundRecords) {
		this.fundRecords = fundRecords;
	}

	public List<Integer> getYears() {
		return years;
	}

	public void setYears(List<Integer> years) {
		this.years = years;
	}

	public String getYearAndMonth() {
		return yearAndMonth;
	}

	public void setYearAndMonth(String yearAndMonth) {
		this.yearAndMonth = yearAndMonth;
	}

	public double getYearTotal() {
		return yearTotal;
	}

	public void setYearTotal(double yearTotal) {
		this.yearTotal = yearTotal;
	}

	public double getYearAndMonthTotal() {
		return yearAndMonthTotal;
	}

	public void setYearAndMonthTotal(double yearAndMonthTotal) {
		this.yearAndMonthTotal = yearAndMonthTotal;
	}

	public Adminstor getAdminstor() {
		return adminstor;
	}

	public void setAdminstor(Adminstor adminstor) {
		this.adminstor = adminstor;
	}

}

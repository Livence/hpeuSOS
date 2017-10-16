package hepu.finacialGenius.project.test;

import javax.annotation.Resource;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import hepu.finacialGenius.project.dao.GeniusDao;

public class GeniusTest {

	private GeniusDao geniusDao;
	
	@Resource(name="geniusDao")
	public void setGeniusDao(GeniusDao geniusDao) {
		this.geniusDao = geniusDao;
	}

	public void test1(){
		geniusDao.addUser(null);
	}


	@Test
	public void geniusTest(){
		@SuppressWarnings("resource")
		ApplicationContext context=new ClassPathXmlApplicationContext("ApplicationContext.xml");
		geniusDao=(GeniusDao) context.getBean("geniusDao");
		test1();
	}
}

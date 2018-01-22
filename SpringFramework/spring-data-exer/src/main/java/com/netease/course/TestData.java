package com.netease.course;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author menglanyingfei
 * @date 2017-8-27
 * MyBatis事务尚未实现
 */
public class TestData {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
		
		// JdbcTemplateDao dao = context.getBean("jdbcTemplateDao", JdbcTemplateDao.class);
        /*
		JdbcTemplateDao dao = context.getBean(JdbcTemplateDao.class);
		dao.resetMoney();
		
		dao.transferMoney("li", "han", 500.0);
		
		List<UserBalance> userBalanceList = dao.userBalanceList();

		for (UserBalance userBalance : userBalanceList) {
			System.out.println(userBalance.getUser() + "-> " + userBalance.getBalance());
		}
		*/

        MybatisDao mybatisDao = (MybatisDao) context.getBean("mybatisDao");
        //System.out.println(mybatisDao.getClass());

        mybatisDao.addMoney(500.0, "han");
        mybatisDao.subMoney(500.0, "li");

        List<UserBalance> userBalanceList = mybatisDao.findAll();

        for (UserBalance userBalance : userBalanceList) {
            System.out.println(userBalance.getUser() + "-> " + userBalance.getBalance());
        }

		((ConfigurableApplicationContext) context).close();
	}

}

package com.wtu.ssm.test;

import com.wtu.ssm.entity.Items;
import com.wtu.ssm.service.ItemsService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Author menglanyingfei
 * Created on 2018.01.23 13:05
 */
public class TestItemsService {
    @Test
    public void testFindItemsByName() {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring/spring-*.xml");

        ItemsService itemsService = (ItemsService) context.getBean("itemsService");
        List<Items> itemsList = itemsService.findItemsByName(null);

        System.out.println(itemsService);
        System.out.println(itemsList);
    }
}

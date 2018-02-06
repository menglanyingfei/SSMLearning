package com.wtu.ssm.test;

import com.wtu.ssm.entity.Items;
import com.wtu.ssm.mapper.ItemsMapper;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Author menglanyingfei
 * Created on 2018.01.23 12:38
 */
public class TestItemsMapper {
    @Test
    public void testFindItemsByName() {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring/spring-mapper.xml");

        ItemsMapper itemsMapper = (ItemsMapper) context.getBean("itemsMapper");
        List<Items> itemsList = itemsMapper.findItemsByName(null);
        System.out.println(itemsMapper.getClass());
        System.out.println(itemsList);
    }
}

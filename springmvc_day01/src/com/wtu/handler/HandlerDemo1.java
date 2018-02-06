package com.wtu.handler;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Author menglanyingfei
 * Created on 2018.01.22 16:12
 */
public class HandlerDemo1 implements Controller {
    @Override
    public ModelAndView handleRequest(HttpServletRequest httpServletRequest,
                                      HttpServletResponse httpServletResponse) throws Exception {
        Items items = new Items();
        items.setId(1);
        items.setName("小米");
        items.setPrice(1500.0);
        items.setCreatetime(new Date());
        items.setDetail("不做评价");

        List<Items> itemsList = new ArrayList<>();
        itemsList.add(items);

        // 创建ModelAndView
        ModelAndView mav = new ModelAndView();
        // 相当于request.setAttribute(name, value);
        mav.addObject("itemsList", itemsList);
        // 设置转发的路径
        mav.setViewName("/jsp/itemsList.jsp");

        return mav;
    }
}


















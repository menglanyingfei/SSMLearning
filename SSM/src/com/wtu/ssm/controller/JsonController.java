package com.wtu.ssm.controller;

import com.wtu.ssm.entity.Items;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Author menglanyingfei
 * Created on 2018.01.29 16:28
 */
@Controller
public class JsonController {

    @RequestMapping("/findItems2.do")
    public Items findItems(Items items) {

        return items;
    }

    @RequestMapping("/findItems3.do")
    @ResponseBody
    public Items findItems2(@RequestBody Items items) {

        return items;
    }
}

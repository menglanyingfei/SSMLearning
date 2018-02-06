package com.wtu.ssm.service;

import com.wtu.ssm.entity.Items;
import com.wtu.ssm.entity.QueryVo;
import com.wtu.ssm.exception.MyException;
import com.wtu.ssm.mapper.ItemsMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Author menglanyingfei
 * Created on 2018.01.23 12:59
 */
@Service(value="itemsService")
public class ItemsServiceImpl implements ItemsService {
    @Resource
    private ItemsMapper itemsMapper;
    // 根据商品id查询
    @Override
    public Items findItemsById(Integer id) throws Exception {
//        if (true) {
//            throw new MyException("其实没啥问题, 我只是想测试一下!");
//        }

//        int i = 10 / 0;
        return itemsMapper.findItemsById(id);
    }

    @Override
    public void updateItems(Items items) {
        itemsMapper.updateItems(items);
    }


    @Override
    public List<Items> findItemsByName(QueryVo queryVo) {
        return itemsMapper.findItemsByName(queryVo);
    }
}

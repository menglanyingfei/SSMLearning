package com.wtu.ssm.mapper;

import com.wtu.ssm.entity.Items;
import com.wtu.ssm.entity.QueryVo;

import java.util.List;

/**
 * Author menglanyingfei
 * Created on 2018.01.23 12:32
 */
public interface ItemsMapper {
    List<Items> findItemsByName(QueryVo queryVo);
    Items findItemsById(Integer id);
    // 提交商品修改信息
    void updateItems(Items items);
}

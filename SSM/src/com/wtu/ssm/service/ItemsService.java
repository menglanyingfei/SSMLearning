package com.wtu.ssm.service;

import com.wtu.ssm.entity.Items;
import com.wtu.ssm.entity.QueryVo;

import java.util.List;

/**业务层接口
 * Created by menglanyingfei on 2018/1/23.
 */
public interface ItemsService {
    // 查询商品信息
    List<Items> findItemsByName(QueryVo queryVo);
    Items findItemsById(Integer id) throws Exception;
    // 修改商品信息
    void updateItems(Items items);
}

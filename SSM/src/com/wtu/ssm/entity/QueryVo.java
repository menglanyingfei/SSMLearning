package com.wtu.ssm.entity;

import java.util.List;

public class QueryVo {
	
	private Items items;

	// 封装List集合, 集合中元素为Items
    List<Items> itemsList;

    public List<Items> getItemsList() {
        return itemsList;
    }

    public void setItemsList(List<Items> itemsList) {
        this.itemsList = itemsList;
    }

    public Items getItems() {
		return items;
	}

	public void setItems(Items items) {
		this.items = items;
	}
}

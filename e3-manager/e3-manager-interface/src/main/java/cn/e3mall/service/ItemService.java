package cn.e3mall.service;

import cn.e3mall.common.pojo.EassyUIDataGridResult;
import cn.e3mall.pojo.TbItem;

public interface ItemService {
	TbItem getTbitemById(long itemId);
	EassyUIDataGridResult getItemList(int page,int rows);
}

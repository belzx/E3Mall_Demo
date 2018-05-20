package cn.e3mall.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.e3mall.pojo.TbItem;
import cn.e3mall.service.ItemService;
@Controller
public class ItemController {
	@Autowired
	private ItemService itemService;
	ItemController(){
		System.out.println(itemService);
		
	}
	
	@RequestMapping("/item/{itemId}")
	@ResponseBody
	public TbItem getItemById(@PathVariable long itemId) {
		System.out.println("begin get");
		TbItem tbitemById = itemService.getTbitemById(itemId);
		
		return tbitemById;
	}

	
}

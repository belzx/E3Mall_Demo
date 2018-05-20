package cn.e3mall.controller;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.e3mall.common.pojo.EassyUIDataGridResult;
import cn.e3mall.pojo.TbItem;
import cn.e3mall.service.ItemService;
/**
 * 页面跳转
 * @author lx
 *
 */
@Controller
public class PageController {
	@Autowired
	private ItemService itemService;
	@RequestMapping("/")
	public String getItemById() {
		
		return "index";
	}
	
	@RequestMapping("/{page}")
	public String showPage(@PathVariable String page) {
		return page;
	}
	@RequestMapping("/item/list")
	@ResponseBody
	public EassyUIDataGridResult getItemList(Integer page , Integer rows) {
		return itemService.getItemList(page, rows);
	}
	
}

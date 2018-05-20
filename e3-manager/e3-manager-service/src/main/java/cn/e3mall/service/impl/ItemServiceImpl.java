package cn.e3mall.service.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.e3mall.common.pojo.EassyUIDataGridResult;
import cn.e3mall.mapper.TbItemMapper;
import cn.e3mall.pojo.TbItem;
import cn.e3mall.pojo.TbItemExample;
import cn.e3mall.pojo.TbItemExample.Criteria;
/**
 * 商品管理service
 * @author lx
 *
 */
@Service
public class ItemServiceImpl implements cn.e3mall.service.ItemService {
	@Autowired
	private TbItemMapper tbItemMapper;
	
	@Override
	public TbItem getTbitemById(long itemId) {
//		TbItem tbitem = tbItemMapper.selectByPrimaryKey(itemId);
		//设置查询条件
		TbItemExample tbItemExample = new TbItemExample();
		Criteria criteria = tbItemExample.createCriteria();
		//设置查询条件
		criteria.andIdEqualTo(itemId);
		//执行查询
		List<TbItem> list = tbItemMapper.selectByExample(tbItemExample);
//		tbItemMapper.deleteByExample(exampleD?)
		if(list != null && list.size()>0) {
			return list.get(0);
		}
		return null;
	}

	@Override
	public EassyUIDataGridResult getItemList(int page, int rows) {
		//设置分页信息
		PageHelper.startPage(page, rows);
		//执行查询
		List<TbItem> list = tbItemMapper.selectByExample(new TbItemExample());
		
		//创建一个返回值对象
		EassyUIDataGridResult result = new EassyUIDataGridResult();
		result.setRows(list);
		//取分页结果
		PageInfo<TbItem> pageInfo = new PageInfo<TbItem>(list);
		//取总数
		result.setTotal(pageInfo.getTotal());
		return result;
	}
//	public static void main(String[] args) {
//		new ItemServiceImpl();
//		System.out.println(11);
//	}

}

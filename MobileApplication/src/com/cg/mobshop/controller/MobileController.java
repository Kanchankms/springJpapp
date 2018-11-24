package com.cg.mobshop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cg.mobshop.dto.Mobiles;
import com.cg.mobshop.service.MobileService;

@Controller
public class MobileController
{
	@Autowired
	MobileService service;			//reference variable of service interface	
	
	//generate getter setter for service
	public MobileService getService()
	{
		return service;
	}
	
	public void setService(MobileService service)
	{
		this.service = service;
	}
	
	@RequestMapping("getmoblist")
	public String showMobileList(Model model)					//whatever data i want to be displayed on jsp page
	{
		List<Mobiles> list = service.getAllMobiles();  			//fetch data from database
		model.addAttribute("list",list);
		return "Home";
	}
	
	@RequestMapping("getUpdatePage")
	public String sendUpdatePage(@RequestParam("mobid") int mobid,Model model)					
	{
		
		Mobiles mobile=service.getMobileDetails(mobid);
		if(mobile==null)
		{
			model.addAttribute("errmsg","invalid mob id"+mobid);
			return "index";
		}
		else{
		model.addAttribute("mobile",mobile);
		
		return "Update";
		}
	}
	
	@RequestMapping("delete")
	public String deleteMobile(@RequestParam("mobid") int mobid, Model model)
	{
		List<Mobiles> list = service.deleteMobile(mobid);
		model.addAttribute("list",list);
		return "Home";
	}
	
	@RequestMapping("updateMobileAction")
	public String updateMobile(@ModelAttribute("mobile") Mobiles mobile,Model model )					
	{
		service.updateMobile(mobile);
		List<Mobiles> list = service.getAllMobiles();  			//fetch data from database
		model.addAttribute("list",list);
		return "Home";
	}
}

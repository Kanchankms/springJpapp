package com.cg.mobshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.mobshop.dao.MobileDao;
import com.cg.mobshop.dto.Mobiles;

@Service
@Transactional
public class MobileServiceImpl implements MobileService
{
	@Autowired
	MobileDao dao;
	@Override
	public List<Mobiles> getAllMobiles()
	{
		
		return dao.getAllMobiles();
	}
	
	
	@Override
	public Mobiles getMobileDetails(int mobid)
	{
		
		return dao.getMobileDetails(mobid);
	}


	@Override
	public int updateMobile(Mobiles mob) {
		
		return dao.updateMobile(mob);
	}


	@Override
	public List<Mobiles> deleteMobile(int mobid) {
		
		return dao.deleteMobile(mobid);
	}

}

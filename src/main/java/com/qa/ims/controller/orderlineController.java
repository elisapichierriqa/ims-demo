package com.qa.ims.controller;

import java.util.List;

import org.apache.log4j.Logger;

import com.qa.ims.persistence.domain.Orderline;
import com.qa.ims.services.CrudServices;
import com.qa.ims.utils.Utils;

public class orderlineController implements CrudController<Orderline>{

	public static final Logger LOGGER = Logger.getLogger(orderlineController.class);
	
	private CrudServices<Orderline> orderlineService;
	
	public orderlineController(CrudServices<Orderline> orderlineService) {
		this.orderlineService = orderlineService;
	}
	

	String getInput() {
		return Utils.getInput();
	}

//Delete item from order
	@Override
	public void delete() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public List<Orderline> readAll() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Orderline create() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Orderline update() {
		// TODO Auto-generated method stub
		return null;
	}


	public CrudServices<Orderline> getOrderlineService() {
		return orderlineService;
	}


	public void setOrderlineService(CrudServices<Orderline> orderlineService) {
		this.orderlineService = orderlineService;
	}
	
}

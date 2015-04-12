package com.china.kidd.server.impl;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import com.china.kidd.api.IWarehouse;
import com.china.kidd.server.annotation.RmiService;

@RmiService(IWarehouse.class)
public class WarehouseImpl implements IWarehouse, Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4540006777335004208L;

	private Map<String, Double> productMap;
	
	public WarehouseImpl()
	{
	}

	@Override
	public String[] list() {
		if (null == this.productMap)
		{
			return new String[]{};
		}
		return this.productMap.keySet().toArray(new String[this.productMap.size()]);
	}

	@Override
	public Double forPrice(String name) {
		if (null == this.productMap) {
			return null;
		}
		return this.productMap.get(name);
	}
	
	@Override
	public void add(String name, double price) {
		if (this.productMap == null) {
			this.productMap = new HashMap<String, Double>();
		}
		this.productMap.put(name, price);
	}
	
	@Override
	public String remove(String name) {
		if (null == this.productMap) {
			return null;
		}
		return name;
	}
	
	@Override
	public void clear() {
		if (null != productMap) {
			this.productMap.clear();
			this.productMap = null;
		}
	}
	
}

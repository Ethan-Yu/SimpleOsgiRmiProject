package com.china.kidd.client;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import com.china.kidd.api.IWarehouse;

import static java.lang.System.out;

public class WarehouseClient {

	private static final int PORT = 916;

	public static void main(String[] args) {
		try {
			Registry registry = LocateRegistry.getRegistry(PORT);
			IWarehouse warehouse = (IWarehouse) registry.lookup("rmi/" + IWarehouse.class.getName());
			warehouse.clear();
			warehouse.add("ipad4", 3699);
			out.println(warehouse.forPrice("ipad4"));
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}

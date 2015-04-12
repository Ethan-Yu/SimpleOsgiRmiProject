package com.china.kidd.server;

import java.io.PrintStream;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

import com.china.kidd.api.IWarehouse;
import com.china.kidd.server.annotation.RmiService;
import com.china.kidd.server.impl.WarehouseImpl;

public class ServerRegister implements BundleActivator {

	private static final int PORT = 916;
	
	private static final PrintStream logger = System.out;

	private static BundleContext context;

	static BundleContext getContext() {
		return context;
	}

	public void start(BundleContext bundleContext) throws Exception {
		ServerRegister.context = bundleContext;
		try {
			IWarehouse warehouse = new WarehouseImpl();
			RmiService rmi = warehouse.getClass().getAnnotation(RmiService.class);
			UnicastRemoteObject.exportObject(warehouse, PORT);
			Registry registry = LocateRegistry.createRegistry(PORT);
			registry.bind("rmi/" + rmi.value().getName(), warehouse);
		} catch (Exception ex) {
			logger.println("register rmi service failed");
			ex.printStackTrace();
		}
	}

	public void stop(BundleContext bundleContext) throws Exception {
		ServerRegister.context = null;
	}

}

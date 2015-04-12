package com.china.kidd.api;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IWarehouse extends Remote{

	String[] list() throws RemoteException;
	
	Double forPrice(String name) throws RemoteException;
	
	void add(String name, double price) throws RemoteException;
	
	String remove(String name) throws RemoteException;
	
	void clear() throws RemoteException;
}

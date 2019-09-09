package com.sync.controller;

import com.sync.abstracts.AbstractObject;
import com.sync.factory.SyncFactory;
import com.sync.services.impl.DataServiceImpl;
import com.sync.utilities.ClassMapper;

public class SyncController {

	public static void main(String[] args) {
		String tableName = "GMLOCA";
		String details = "D65645646546546";
		process(tableName, details);
	}

	public static void process(String tableName, String details) {
		try {
			ClassMapper cls = ClassMapper.getNewInstance();
			Class<?> classObj = Class.forName(cls.getClassName(tableName));
			SyncFactory factory = new SyncFactory(
					new DataServiceImpl((AbstractObject) classObj.newInstance(), details));
			factory.process();
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			System.out.println("Exception: " + e.getMessage());
		}
	}
}

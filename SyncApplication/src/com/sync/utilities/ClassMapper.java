package com.sync.utilities;

import java.util.HashMap;

public class ClassMapper {

	private static HashMap<String, String> classMap = null;

	private static ClassMapper classMapperInstance = null;

	private ClassMapper() {

	}

	public static HashMap<String, String> getClassLoader() {
		return classMap;
	}

	public static ClassMapper getNewInstance() {
		if (null == classMapperInstance) {
			synchronized (ClassMapper.class) {
				if (null == classMapperInstance) {
					classMapperInstance = new ClassMapper();
					loadClass();
				}
			}
		}
		return classMapperInstance;
	}

	private static HashMap<String, String> loadClass() {
		if (null == classMap) {
			classMap = ClassConfigLoader.newInstance();
		}
		return classMap;
	}

	public String getClassName(String tableName) {
		return classMap.get(tableName);
	}
}

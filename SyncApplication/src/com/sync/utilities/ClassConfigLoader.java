package com.sync.utilities;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class ClassConfigLoader {

	private static HashMap<String, String> mapConfig = null;

	private static File fileConfig = new File(Constants.CLASS_CONFIG);

	private ClassConfigLoader() {

	}

	/**
	 * Create Singleton instance of class
	 * 
	 * @return mapConfig
	 */
	public static HashMap<String, String> newInstance() {
		if (null == mapConfig) {
			mapConfig = new HashMap<String, String>();
			readConfiguration();
		}
		return mapConfig;
	}

	/**
	 * Parse class-config.xml and add to hashmap
	 */
	private static void readConfiguration() {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder;
		try {
			builder = factory.newDocumentBuilder();
			Document doc = builder.parse(fileConfig);
			doc.getDocumentElement().normalize();

			NodeList classElement = doc.getElementsByTagName(Constants.CLASS_NAME);
			for (int i = 0; i < classElement.getLength(); i++) {
				Node classElementNode = classElement.item(i);
				if (classElementNode.getNodeType() == Node.ELEMENT_NODE) {
					Element clsElement = (Element) classElementNode;
					String tableName = clsElement.getElementsByTagName(Constants.TABLE_NAME).item(0).getTextContent();
					String classPathName = clsElement.getElementsByTagName(Constants.CLASS_PATH_NAME).item(0)
							.getTextContent();
					mapConfig.put(tableName, classPathName);
				}
			}

		} catch (ParserConfigurationException | SAXException | IOException e) {
			System.out.println("Exception: " + e.getMessage());
		}
	}
}

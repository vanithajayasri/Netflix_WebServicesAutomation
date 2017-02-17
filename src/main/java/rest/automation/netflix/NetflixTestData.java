package rest.automation.netflix;

/*******************************************************************************
 * Copyright (c) 1995, 2015 eBay Inc. All Rights Reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *******************************************************************************/


import java.util.LinkedList;

import org.apache.commons.lang3.StringUtils;

public class NetflixTestData {
	
	private TestObject testObject;
	private LinkedList<ResourceMetaData> resourceMetaData = new LinkedList<ResourceMetaData>();
	
	public TestObject getTestObject() {
		return testObject;
	}
	public void setTestObject(TestObject testObject) {
		this.testObject = testObject;
	}
	public LinkedList<ResourceMetaData> getResourceMetaData() {
		return resourceMetaData;
	}
	public void setResourceMetaData(LinkedList<ResourceMetaData> resourceMetaData) {
		this.resourceMetaData = resourceMetaData;
	}
	
/*	private LinkedList<GiftCardResource> gcResources = new LinkedList<GiftCardResource>();
	private LinkedList<GCTSResourceMetaData> gctsResourceMetadata = new LinkedList<GCTSResourceMetaData>();
	private GCTSRequestResponseStack gctsRequestResponseStack = new GCTSRequestResponseStack();*/
	
	
	
	
	
}


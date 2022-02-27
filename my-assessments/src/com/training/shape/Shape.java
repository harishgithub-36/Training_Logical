package com.training.shape;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public abstract class Shape {
	public abstract String area();

	final Logger shapelogger = LogManager.getLogger(this.getClass());
	public static final String name = "";
}

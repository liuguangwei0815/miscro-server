package com.misco.server.ioc.anno;

public class MathBook implements Book{
	@Override
	public String getBookName() {
		return "数学";
	}
}

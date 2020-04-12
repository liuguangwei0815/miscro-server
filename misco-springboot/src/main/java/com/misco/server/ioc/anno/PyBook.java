/**
 * 
 */
package com.misco.server.ioc.anno;

/**
 * @author liuwei
 *
 */
public class PyBook implements Book{
	@Override
	public String getBookName() {
		return "py-book";
	}
}

package com.misco.server.ioc.anno;

public class Test {
	public static void main(String[] args) {
		JavaBook java = new JavaBook();
		//后面可以是类和接口
		if(java instanceof Book) {
			System.out.println("yesss");
		}
		JavaBook java1 = new JavaBook();
		if(Book.class.isInstance(JavaBook.class)) {
			System.out.println("1");
		}else {
			System.out.println("2");
		}
	}
}

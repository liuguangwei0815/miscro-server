/**
 * 
 */
package com.my.misco.aop.v1;

import org.springframework.stereotype.Component;

/**
 * @author liuwei
 * 需要被aop增强的方法
 */
@Component
public class Caculator {
	public int cacu(int a,int b) {
		return a/b;
	}
}

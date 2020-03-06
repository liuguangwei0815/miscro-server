/**
 * 
 */
package com.misco.server;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author liuwei 需要加载到spring 容器的bean
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
	private String userName;
	private int age;
}

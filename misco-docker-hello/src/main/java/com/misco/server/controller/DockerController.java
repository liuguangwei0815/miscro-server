/**
 * 
 */
package com.misco.server.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liuwei
 *
 */
@RestController
@RequestMapping("/docker")
public class DockerController {

	@GetMapping
	public String test(HttpServletRequest request) {
		return request.getLocalAddr();
	}
	
	
}

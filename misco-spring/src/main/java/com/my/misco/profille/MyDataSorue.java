/**
 * 
 */
package com.my.misco.profille;

import java.beans.PropertyVetoException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.EmbeddedValueResolverAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.util.StringValueResolver;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * @author liuwei 我的数据源
 */
@Profile("test")
@Configuration
@PropertySource("classpath:/datasoure.properties")
@ComponentScan(value = {"com.my.misco.profille"})
public class MyDataSorue implements EmbeddedValueResolverAware {
	private StringValueResolver resolver;
	@Value("${jdbc.user}")
	private String user;
	//默认是default,如果不加标识任何bean都是加载的
	@Profile("default")
	@Bean("defaultDataSource")
	public DataSource dataSource01(@Value("${jdbc.pw}") String password) throws PropertyVetoException {
		ComboPooledDataSource com = new ComboPooledDataSource();
		com.setUser(user);
		com.setPassword(password);
		String driverClass = resolver.resolveStringValue("${jdbc.driverClass}");
		com.setDriverClass(driverClass);
		String jdbcUrl = resolver.resolveStringValue("${jdbc.jdbcUrl}");
		com.setJdbcUrl(jdbcUrl);
		return com;
	}
	@Profile("test")
	@Bean("testDataSource")
	public DataSource dataSource1(@Value("${jdbc.pw}") String password) throws PropertyVetoException {
		ComboPooledDataSource com = new ComboPooledDataSource();
		com.setUser(user);
		com.setPassword(password);
		String driverClass = resolver.resolveStringValue("${jdbc.driverClass}");
		com.setDriverClass(driverClass);
		String jdbcUrl = resolver.resolveStringValue("${jdbc.jdbcUrl}");
		com.setJdbcUrl(jdbcUrl);
		return com;
	}
	@Profile("dev")
	@Bean("devDataSource")
	public DataSource dataSource2(@Value("${jdbc.pw}") String password) throws PropertyVetoException {
		ComboPooledDataSource com = new ComboPooledDataSource();
		com.setUser(user);
		com.setPassword(password);
		String driverClass = resolver.resolveStringValue("${jdbc.driverClass}");
		com.setDriverClass(driverClass);
		String jdbcUrl = resolver.resolveStringValue("${jdbc.jdbcUrl}");
		com.setJdbcUrl(jdbcUrl);
		return com;
	}
	@Profile("prd")
	@Bean("prdDataSource")
	public DataSource dataSource3(@Value("${jdbc.pw}") String password) throws PropertyVetoException {
		ComboPooledDataSource com = new ComboPooledDataSource();
		com.setUser(user);
		com.setPassword(password);
		String driverClass = resolver.resolveStringValue("${jdbc.driverClass}");
		com.setDriverClass(driverClass);
		String jdbcUrl = resolver.resolveStringValue("${jdbc.jdbcUrl}");
		com.setJdbcUrl(jdbcUrl);
		return com;
	}
	@Override
	public void setEmbeddedValueResolver(StringValueResolver resolver) {
		this.resolver = resolver;
	}
}

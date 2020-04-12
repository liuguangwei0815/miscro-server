package com.misco.server;

public class WeatherServivce {

	private WeatherSource weatherSource;

	public WeatherServivce(WeatherSource weatherSource) {
		this.weatherSource = weatherSource;
	}

	// 获取天气
	String getType() {
		return weatherSource.getType();
	}

	// 获取天气的级别
	String getRate() {
		return weatherSource.getRate();
	}
}

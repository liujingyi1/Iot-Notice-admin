package com.rgkCloud.cfg;

import java.util.concurrent.TimeUnit;

import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.cloud.openfeign.FeignAutoConfiguration;
import org.springframework.context.annotation.Configuration;

import feign.Feign;
import okhttp3.ConnectionPool;

@Configuration
@ConditionalOnClass(Feign.class)
@AutoConfigureBefore(FeignAutoConfiguration.class)
public class FeignOkhttpConfig {
	
	public okhttp3.OkHttpClient okHttpClient(){
		return new okhttp3.OkHttpClient.Builder()
				//连接超时
				.connectTimeout(5, TimeUnit.SECONDS)
				//读超时
				.readTimeout(5, TimeUnit.SECONDS)
				//写超时
				.writeTimeout(5, TimeUnit.SECONDS)
				//是否自动重连
				.retryOnConnectionFailure(true)
				//连接池
				.connectionPool(new ConnectionPool(10, 5L, TimeUnit.SECONDS))
				.build();
	}

}

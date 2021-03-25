package com.example.demo.config;

import javax.sql.DataSource;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Profile(value="test")
@Configuration
@EnableTransactionManagement
@EnableConfigurationProperties
@MapperScan("com.example.demo.mapper")
public class MyBatisConfigTest extends MyBatisConfig {

    /**
	 * テスト環境で使用するデータソースです。
	 * @return データソース
	 */
	@ConfigurationProperties(prefix = "spring.datasource")
	@Bean
	public DataSource dataSource() {
	    return DataSourceBuilder.create().build();
	}
    
}

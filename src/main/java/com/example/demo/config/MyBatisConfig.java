package com.example.demo.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternUtils;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

public abstract class MyBatisConfig {
    /**
	 * トランザクションマネージャを取得します。
	 * @param datasource 対象となるデータソース
	 * @return トランザクションマネージャ
	 */
	@Bean
	public PlatformTransactionManager txManager(@Qualifier("dataSource") DataSource datasource) {
		return new DataSourceTransactionManager(datasource);
	}

	/**
	 * MyBatisのSqlSessionFactoryを取得します。
	 * @param dataSource 対象となるデータソース
	 * @return SqlSessionFactory
	 * @throws Exception 例外
	 */
	@Bean
	public SqlSessionFactory sqlSessionFactory(@Qualifier("dataSource") DataSource dataSource) throws Exception {
		ResourcePatternResolver resolver = ResourcePatternUtils.getResourcePatternResolver(new DefaultResourceLoader());

		SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
		Resource resource = resolver.getResource("classpath:/mybatis-config.xml");
		bean.setConfigLocation(resource);
		bean.setDataSource(dataSource);

		return bean.getObject();
	}
}

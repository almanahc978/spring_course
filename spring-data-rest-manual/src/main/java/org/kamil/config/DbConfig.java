package org.kamil.config;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import org.kamil.repository.ProductRepository;

@Configuration
@ComponentScan
@EnableJpaRepositories(basePackageClasses = { ProductRepository.class })
public class DbConfig {

	  @Bean
	    public LocalContainerEntityManagerFactoryBean entityManagerFactory(JpaVendorAdapter adapter, DataSource ds) {
	        LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
	        emf.setPersistenceUnitName("spring-jpa-pu");
	        Map<String, String> properties = new HashMap<>();
	        properties.put("javax.persistence.schema-generation.database.action", "drop-and-create");
	        emf.setJpaPropertyMap(properties);
	        emf.setDataSource(ds);
	        emf.setJpaVendorAdapter(adapter);
	        emf.setPackagesToScan("org.kamil.model");
	        return emf;
	    }

	    @Bean
	    public JpaVendorAdapter createVendorAdapter() {
	        HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
	        adapter.setDatabase(Database.MYSQL);
	        adapter.setGenerateDdl(true);
	        adapter.setShowSql(true);
	        return adapter;
	    }

	    @Bean
	    public DataSource createDS() {
	        BasicDataSource ds = new BasicDataSource();
	        ds.setUrl("jdbc:mysql://localhost:3306/test?useSSL=false");
	        ds.setUsername("root");
	        ds.setPassword("root");
	        ds.setDriverClassName("com.mysql.jdbc.Driver");
	        ds.setInitialSize(5);
	        return ds;
	    }

	    @Bean
	    public PlatformTransactionManager transactionManager(EntityManagerFactory emf) {
	        JpaTransactionManager txManager = new JpaTransactionManager(emf);
	        return txManager;
	    }
}

package com.projeto.sistema;

import javax.sql.DataSource; 

import org.springframework.context.annotation.Bean; 
import org.springframework.context.annotation.Configuration; 
import org.springframework.context.annotation.PropertySource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.datasource.DriverManagerDataSource; 
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
@Configuration 
@PropertySource(value = "file:database-local.properties", ignoreResourceNotFound = true)
public class configuracaoBancoDeDados { 
   @Value("${DB_URL:${spring.datasource.url:jdbc:postgresql://localhost:5432/loja}}")
   private String databaseUrl;
   @Value("${DB_USERNAME:${spring.datasource.username:postgres}}")
   private String databaseUsername;
   @Value("${DB_PASSWORD:${spring.datasource.password:}}")
   private String databasePassword;
   @Bean 
   public DataSource dataSource() { 
	   DriverManagerDataSource dataSource = new DriverManagerDataSource(); 
	   dataSource.setDriverClassName("org.postgresql.Driver"); //declara as configurações de acesso
		dataSource.setUrl(databaseUrl);
		dataSource.setUsername(databaseUsername);
		dataSource.setPassword(databasePassword);
		return dataSource;
	}

   
   @Bean
	public JpaVendorAdapter jpaVendorAdapter() {
	   HibernateJpaVendorAdapter adapter = new  HibernateJpaVendorAdapter();
		adapter.setDatabase(Database.POSTGRESQL); //motorista do banco
		adapter.setShowSql(true); //mostrar no console o sql, é interessante
		adapter.setGenerateDdl(true);
		adapter.setDatabasePlatform("org.hibernate.dialect.PostgreSQLDialect"); 
		adapter.setPrepareConnection(true); 
return adapter; 

   }
}

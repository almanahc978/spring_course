package org.kamil.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configurers.provisioning.JdbcUserDetailsManagerConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.provisioning.JdbcUserDetailsManager;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	public DataSource ds;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		JdbcUserDetailsManagerConfigurer<AuthenticationManagerBuilder> builder = auth.jdbcAuthentication();
		builder.dataSource(ds);
		JdbcUserDetailsManager userDetailsService = builder.getUserDetailsService();
		userDetailsService.setUsersByUsernameQuery("SELECT username,password,enabled FROM accounts WHERE username=?");
		userDetailsService.setAuthoritiesByUsernameQuery("SELECT username,authority FROM roles WHERE username=?");
		userDetailsService.setCreateUserSql("INSERT INTO accounts(username,password,enabled) VALUES(?,?,?)");
		userDetailsService.setCreateAuthoritySql("INSERT INTO roles(username,authority) VALUES(?,?)");

		builder.withUser("admin").password("{noop}AdMin@3").roles("ADMIN");

	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/").permitAll().anyRequest().authenticated().and().formLogin();
	}
}

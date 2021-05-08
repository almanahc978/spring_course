package org.kamil.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/*
 * Uzytkownik moze wyswietlic strone glowna,
 * ale pozostale adresy wymagaja uwierzytelniania
 * poprzez formularz
 * */

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	public void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/").permitAll().anyRequest().authenticated().and().formLogin()
				.loginPage("/loginform").permitAll().loginProcessingUrl("/processlogin").permitAll()
				.usernameParameter("user").passwordParameter("pass").and().logout().logoutUrl("/logmeout")
				.logoutSuccessUrl("/").permitAll();
	}
}

package com.mitocode.jwd.examen.shared.infrastructure.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.mitocode.jwd.examen.usuario.infrastructure.security.UserSecurityService;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@Autowired
	private UserSecurityService userSecurityService;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

//		  auth.inMemoryAuthentication().withUser("user").password(passwordEncoder.
//		  encode("12345")).roles("USER").and()
//		  .withUser("admin").password(passwordEncoder.encode("123")).roles("ADMIN");

		auth.userDetailsService(userSecurityService).passwordEncoder(passwordEncoder);
	}

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

}

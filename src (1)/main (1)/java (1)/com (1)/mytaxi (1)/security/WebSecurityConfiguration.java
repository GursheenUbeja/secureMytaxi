package com.mytaxi.security;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;


import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

	private static final String[] AUTH_WHITELIST = {

			// -- swagger ui
			//"/swagger-resources/**", "/swagger-ui.html", "/v2/api-docs", "/webjars/** , /*" };
			"/swagger-resources/**", "/swagger-ui.html", "/v2/api-docs", "/webjars/** " };

	@Override
	protected void configure(HttpSecurity http) throws Exception {
	
		
		http.cors().and().csrf().disable().authorizeRequests().antMatchers(AUTH_WHITELIST).permitAll()
	.antMatchers(HttpMethod.POST, "/login").permitAll().anyRequest().authenticated().and()
		.addFilterBefore(new JWTLoginFilter("/login", authenticationManager()),
				UsernamePasswordAuthenticationFilter.class)
	.addFilterBefore(new JWTAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);

		
		
		
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// Create a default account
		auth.inMemoryAuthentication().passwordEncoder(NoOpPasswordEncoder.getInstance()).withUser("test")
				.password("test123").roles("USER").and().withUser("test1").password("test123").roles("ADMIN");
	}

}

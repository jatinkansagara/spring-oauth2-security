package com.spring.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.client.JdbcClientDetailsService;
import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;

import com.spring.service.CustomUserDetailsService;
import com.spring.utils.PasswordEncryptDecryptUtils;

@Configuration
@EnableAuthorizationServer
public  class AuthorizationServerConfiguration extends
			AuthorizationServerConfigurerAdapter {
	
		@Autowired
		@Qualifier("authenticationManagerBean")
		private AuthenticationManager authenticationManager;

		@Autowired
		private CustomUserDetailsService userDetailsService;
		
		@Autowired
		DataSource dataSource;

		@Autowired
		NamedParameterJdbcTemplate namedParameterJDBCTemplate;

		@Override
		public void configure(AuthorizationServerEndpointsConfigurer endpoints)
				throws Exception {
			// @formatter:off
			endpoints
				.tokenStore(new JdbcTokenStore(dataSource))
				.authenticationManager(this.authenticationManager)
				.userDetailsService(userDetailsService);
			
			endpoints.pathMapping("/oauth/token", "/v1/oauth/token");
		}
		
		@Override
		public void configure(AuthorizationServerSecurityConfigurer oauthServerSecurityConfig) {
			//oauthServerSecurityConfig.passwordEncoder(new PasswordEncryptDecryptUtils());
		}

		@Override
		public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
			clients.withClientDetails(clientDetailsService());
		}

		/*@Bean
		@Primary
		public DefaultTokenServices tokenServices() {
			DefaultTokenServices tokenServices = new DefaultTokenServices();
			tokenServices.setSupportRefreshToken(true);
			tokenServices.setTokenStore(this.tokenStore);
			return tokenServices;
		}*/
		
		@Bean
		public JdbcClientDetailsService clientDetailsService() {
			return new JdbcClientDetailsService(dataSource);
		}

	}
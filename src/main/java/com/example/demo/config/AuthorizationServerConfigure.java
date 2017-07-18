package com.example.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;

/**
 * Created by addis on 7/18/17.
 */
@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfigure extends AuthorizationServerConfigurerAdapter {

    @Autowired
    private AuthenticationManager authenticationManger;

    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
     security.checkTokenAccess("isAuthenticated()");
    }

    @Override
    public void configure(ClientDetailsServiceConfigurer  clients) throws Exception {
       clients.inMemory().withClient("my-trusted-client")
               .authorizedGrantTypes("client_credential","password")
               .authorities("ROLE_CLIENT","ROLE_TRUSTED_CLIENT")
               .scopes("read","write","trust")
               .resourceIds("oauth2-resource")
               .accessTokenValiditySeconds(500)
               .secret("secret");
    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
       endpoints.authenticationManager(authenticationManger);
    }
}

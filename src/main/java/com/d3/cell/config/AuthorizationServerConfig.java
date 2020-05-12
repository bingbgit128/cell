package com.d3.cell.config;

import com.d3.cell.service.BaseUserDetailService;
import com.d3.cell.service.impl.SysUserServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.web.access.AccessDeniedHandler;

@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {

    @Autowired
    private Environment env;
    private Logger logger = LoggerFactory.getLogger(SysUserServiceImpl.class);

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired(required = false)
    TokenStore inMemoryTokenStore;

    @Autowired
    BaseUserDetailService userDetailsService;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        logger.info(env.getProperty("cell.client_secret"));
        clients.inMemory()
                .withClient(env.getProperty("cell.client_id"))
                .authorizedGrantTypes("password","refresh_token")
                .accessTokenValiditySeconds(Integer.valueOf(env.getProperty("cell.accessTokenValiditySeconds")))
                .scopes("all")
                .secret(passwordEncoder.encode(env.getProperty("cell.client_secret")))
                .refreshTokenValiditySeconds(Integer.valueOf(env.getProperty("cell.refreshTokenValiditySeconds")));


    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints.tokenStore(inMemoryTokenStore)
                .authenticationManager(authenticationManager)
                .userDetailsService(userDetailsService);
    }

    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        security.allowFormAuthenticationForClients()
                .tokenKeyAccess("isAuthenticated()")
                .checkTokenAccess("permitAll()");
    }


}

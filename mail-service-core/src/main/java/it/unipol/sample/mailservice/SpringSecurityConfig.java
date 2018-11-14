/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unipol.sample.mailservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.AuthenticationEntryPoint;

/**
 *
 * @author matt.rossi
 */
@Configuration
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    @Value("${spring.ldap.urls}")
    private String ldapUrls;
    @Value("${spring.ldap.base.dn}")
    private String ldapBaseDn;
    @Value("${spring.ldap.username}")
    private String ldapSecurityPrincipal;
    @Value("${spring.ldap.password}")
    private String ldapPrincipalPassword;
    @Value("${spring.ldap.user.dn.pattern}")
    private String ldapUserDnPattern;
    @Value("${spring.ldap.enabled}")
    private String ldapEnabled;

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .authorizeRequests()
                .anyRequest().fullyAuthenticated()
                .and().csrf().disable().httpBasic();
    }


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        if (Boolean.parseBoolean(ldapEnabled)) {
            auth
                    .ldapAuthentication()
                    .contextSource()
                    .url(ldapUrls + ldapBaseDn)
                    .managerDn(ldapSecurityPrincipal)
                    .managerPassword(ldapPrincipalPassword)
                    .and()
                    .userDnPatterns(ldapUserDnPattern);
        } else {
            auth
                    .inMemoryAuthentication()
                    .withUser("user").password("{noop}reply.01!").roles("USER");
        }
    }

}

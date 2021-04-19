package ru.viktorshiyan.config;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
@AllArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final DataSource dataSource;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .anyRequest().authenticated()
                .and()
                .httpBasic();
    }


    @Override
    public void configure(WebSecurity web) {
        web.ignoring().antMatchers("/")
                .antMatchers("/css/**")
                .antMatchers("/cv/**")
                .antMatchers("/js/**")
                .antMatchers("/images/**")
                .antMatchers("/fonts/**")
                .antMatchers("/message");
    }

    @Override
    public void configure(AuthenticationManagerBuilder auth)
            throws Exception {
        auth.jdbcAuthentication().passwordEncoder(new BCryptPasswordEncoder()).dataSource(dataSource).usersByUsernameQuery(
                "select login, password, 'true' from my_user " +
                        "where login=?").authoritiesByUsernameQuery(
                "select login, authority from my_user " +
                        "where login=?");
    }

}
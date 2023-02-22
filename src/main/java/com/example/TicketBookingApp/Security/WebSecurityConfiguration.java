package com.example.TicketBookingApp.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }


    @Autowired
    private UserDetailsService userDetailsService;

    AuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userDetailsService);
        authenticationProvider.setPasswordEncoder(passwordEncoder());
        return authenticationProvider;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.csrf().disable();
        http.cors().disable();
        http.authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/displaytrains").permitAll()
                .antMatchers("/trainsbyno/{train_no}").permitAll()
                .antMatchers("/addtrain").hasAnyAuthority("ADMIN")
                .antMatchers("/updatetrain/{train_no}").hasAuthority("ADMIN")
                .antMatchers("/deletetrain/{train_no}").hasAuthority("ADMIN")
                .antMatchers("/bookticket").hasAuthority("USER")
                .antMatchers("cancelticket/{ticket_no}").hasAuthority("USER")
                .antMatchers("/displaytickets").hasAnyAuthority("TICKET COLLECTOR","ADMIN")
                .antMatchers("/displayticketbyid/{ticket_id}").hasAnyAuthority("USER","TICKET COLLECTOR")
                .anyRequest().authenticated().and().httpBasic();
    }
}

package services.stock.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import services.stock.util.JWTAuthorizationFilter;


@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig {

    private static final String[] WHITELIST = {
            "/v2/api-docs",
            "**/v2/api-docs",
            "/v3/api-docs",
            "**/v3/api-docs",
            "/swagger-resources",
            "/swagger-resources/**",
            "**/swagger-resources/**",
            "/configuration/ui",
            "/configuration/security",
            "/swagger-ui.html",
            "**/swagger-ui.html",
            "**/swagger-ui.html/**",
            "/swagger-ui.html/**",
            "/webjars/**"
    };

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
         http.csrf().disable()
                .addFilterAfter(new JWTAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class)
                .authorizeRequests()
                .antMatchers(HttpMethod.POST, "/api/user/**").permitAll()
                .antMatchers(HttpMethod.GET, "/api/user/**").permitAll()
                .antMatchers(HttpMethod.POST, WHITELIST).permitAll()
                .antMatchers(HttpMethod.GET, WHITELIST).permitAll()
                /*.antMatchers(HttpMethod.GET, "/**").permitAll()
                .antMatchers(HttpMethod.POST, "/**").permitAll()*/
                 .anyRequest().fullyAuthenticated();

         return http.build();
    }
}

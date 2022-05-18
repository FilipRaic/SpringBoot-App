package hr.tvz.raic.hardwareapp.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@EnableWebSecurity
@EnableGlobalMethodSecurity(
        securedEnabled = true,
        jsr250Enabled = true,
        prePostEnabled = true
)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    private static final Logger log = LoggerFactory.getLogger(SecurityConfiguration.class);

    static final List<String> UNAUTHENTICATED_ENDPOINTS = List.of(
            "/authentication/login/**", "/h2/**"
    );

    private final JwtFilter jwtFilter;

    public SecurityConfiguration(JwtFilter jwtFilter) {
        this.jwtFilter = jwtFilter;
        SecurityContextHolder.setStrategyName(SecurityContextHolder.MODE_INHERITABLETHREADLOCAL);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http = http.cors().and().csrf().disable();
        http = http.headers().frameOptions().disable().and();

        http = http
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and();

        http = http
                .exceptionHandling()
                .authenticationEntryPoint(
                        (request, response, e) -> {
                            log.error("Unauthorized request - {}", e.getMessage());
                            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, e.getMessage());
                        }
                )
                .and();

        http.authorizeRequests()
                .antMatchers("/authentication/login/**").permitAll()
                .anyRequest().authenticated();

        http.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);

        http.authorizeHttpRequests()
                .antMatchers(UNAUTHENTICATED_ENDPOINTS.toArray(new String[0])).permitAll()
                .antMatchers(HttpMethod.GET, "/**").hasAnyRole("ADMIN", "USER")
                .antMatchers(HttpMethod.POST, "/hardware/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.PUT, "/hardware/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.DELETE, "/hardware/**").hasRole("ADMIN");
    }

    @Override
    public void configure(WebSecurity web) {
        web.ignoring()
                .antMatchers(HttpMethod.OPTIONS, "/authenticate/login/**")
                .antMatchers("/h2/**");
    }
}

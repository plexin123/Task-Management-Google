    package com.example.demo.configuration;

    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.context.annotation.Bean;
    import org.springframework.context.annotation.Configuration;
    import org.springframework.http.HttpMethod;
    import org.springframework.security.authentication.AuthenticationManager;
    import org.springframework.security.config.Customizer;
    import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
    import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
    import org.springframework.security.config.annotation.web.builders.HttpSecurity;
    import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
    import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
    import org.springframework.security.core.userdetails.User;
    import org.springframework.security.core.userdetails.UserDetails;
    import org.springframework.security.core.userdetails.UserDetailsService;
    import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
    import org.springframework.security.provisioning.InMemoryUserDetailsManager;
    import org.springframework.security.provisioning.JdbcUserDetailsManager;

    import org.springframework.security.web.SecurityFilterChain;
    import org.springframework.web.cors.CorsConfiguration;
    import org.springframework.web.cors.CorsConfigurationSource;
    import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

    import javax.sql.DataSource;
    import java.time.chrono.JapaneseDate;
    import java.util.Arrays;

    import static org.springframework.security.config.Customizer.withDefaults;

    @Configuration
    @EnableWebSecurity
    public class SecurityConfig{

            @Bean
            public SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
                http
                        .csrf(csrf ->
                                csrf.disable()) //CSRF Cross-Site Request Forgery security measure for POST request
                        .authorizeHttpRequests(authRequest ->authRequest
                                .requestMatchers("/**").permitAll() //HttpMethod.OPTIONS, -> important for authentication
    //                            .requestMatchers("/usuario","/saludo","/").hasRole("ADMIN").anyRequest().authenticated()
                                ) // give permission to specific routes
    //                    .logout(log -> log.logoutSuccessUrl("/").permitAll())
                        .formLogin(withDefaults());
                return http.build();
            }
        @Bean
        public BCryptPasswordEncoder passwordEncoder() throws Exception{
            BCryptPasswordEncoder pep = new BCryptPasswordEncoder();
            return pep;
        }

        @Bean
        public AuthenticationManager authenticationManager(AuthenticationConfiguration auth) throws Exception{
            return auth.getAuthenticationManager();
        }
//        @Bean
//        CorsConfigurationSource corsConfigurationSource() {
//            CorsConfiguration configuration = new CorsConfiguration();
//            configuration.setAllowedOrigins(Arrays.asList("http://localhost:4200"));
//            configuration.setAllowedMethods(Arrays.asList("GET","POST","PUT","DELETE"));
//            UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//            source.registerCorsConfiguration("/**", configuration);
//            return source;
//        }
    //
    //    @Autowired
    //    private JwtTokenProvider jwtTokenProvider;
    //
    //    @Bean
    //    protected void configure(HttpSecurity http) throws Exception {
    //        http.csrf().disable()
    //                .authorizeRequests()
    //                .antMatchers("/public/**").permitAll()
    //                .anyRequest().authenticated()
    //                .and()
    //                .apply(new JwtConfigurer(jwtTokenProvider));
    //    }

    //    @Bean
    //    public UserDetailsService userDetailsService() {
    //        UserDetails user = User.withDefaultPasswordEncoder()
    //                .username("user")
    //                .password("password")
    //                .roles("USER")
    //                .build();
    //        return new InMemoryUserDetailsManager(user);
    //    }
    //    @Autowired
    //    private DataSource dataSource;
    //    @Bean
    //    public JdbcUserDetailsManager jdbcUserDetailsManager() {
    //        JdbcUserDetailsManager manager = new JdbcUserDetailsManager(dataSource);
    //
    //        // Set the SQL queries for user authentication and authorization
    //        manager.setAuthenticationSql("SELECT username, password, enabled FROM user WHERE username = ?");
    //        manager.setAuthoritiesByUsernameQuery("SELECT username, 'ROLE_USER' FROM user WHERE username = ?");
    //        manager.setUsersByUsernameQuery("SELECT username, password, enabled FROM user WHERE username = ?");
    //
    //        return manager;
    //    }

    }

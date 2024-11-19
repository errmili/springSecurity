package com.spring.security.securityConfig;


import com.spring.security.dao.UserRepository;
import com.spring.security.securityConfig.jwt.JwtAuthenticationFilter;
import com.spring.security.securityConfig.jwt.JwtAuthorizationFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter  {

    private UserPrincipalDetailsService userPrincipalDetailsService;
    private UserRepository userRepository;

    public SecurityConfiguration(UserPrincipalDetailsService userPrincipalDetailsService, UserRepository userRepository) {
        this.userPrincipalDetailsService = userPrincipalDetailsService;
        this.userRepository = userRepository;
    }

    @Bean(BeanIds.AUTHENTICATION_MANAGER)
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                //.addFilter(new JwtAuthenticationFilter(authenticationManager()))
                .addFilter(new JwtAuthorizationFilter(authenticationManager(),this.userRepository))
                .authorizeRequests()
                .antMatchers(HttpMethod.POST,"/login").permitAll()
                .antMatchers(HttpMethod.POST,"/signup").permitAll()
                .antMatchers("/api/myadmin").hasRole("ADMIN")
                .antMatchers("/api/myadminmanget").hasAnyRole("ADMIN","MANGER")
                .antMatchers("/api/myadminmangeruser").hasAnyRole("ADMIN","MANGER","USER")
                //.anyRequest().authenticated()
                .anyRequest().authenticated();
    }

    @Bean
    DaoAuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
        daoAuthenticationProvider.setUserDetailsService(userPrincipalDetailsService);
        return daoAuthenticationProvider;
    }

    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
//    @Bean
//    public UserDetailsService userDetailsService() {
////        UserDetails admin = User.withUsername("ahmed")
////                .password(passwordEncoder().encode("ahmed123")) // Indique que le mot de passe est en clair //{noop}
////                .roles("ADMIN")
////                .authorities("ACCESS_BASIC1")
////                .build();
////
////        UserDetails yassir = User.withUsername("yassir")
////                .password(passwordEncoder().encode("yassir123")) // Indique que le mot de passe est en clair //{noop}
////                .roles("MANGER")
////                .build();
////
////        UserDetails user = User.withUsername("karim")
////                .password(passwordEncoder().encode("karim123")) // Indique que le mot de passe est en clair //{noop}
////                .roles("USER")
////                .build();
////
////        return new InMemoryUserDetailsManager(admin,yassir,user);
//
//        // ******************
//
//        UserDetails admin = User.withUsername("ahmed")
//                .password(passwordEncoder().encode("ahmed123")) // Indique que le mot de passe est en clair
//                .authorities("ACCESS_BASIC1", "ROLE_ADMIN") // Ajoute explicitement le rôle et les autorités
//                .build();
//
//        UserDetails manager = User.withUsername("yassir")
//                .password(passwordEncoder().encode("yassir123")) // Indique que le mot de passe est en clair
//                .authorities("ROLE_MANGER") // Ajoute explicitement le rôle avec le préfixe ROLE_
//                .build();
//
//        UserDetails user = User.withUsername("karim")
//                .password(passwordEncoder().encode("karim123")) // Indique que le mot de passe est en clair
//                .authorities("ROLE_USER") // Ajoute explicitement le rôle avec le préfixe ROLE_
//                .build();
//
//        return new InMemoryUserDetailsManager(admin, manager, user);
//    }
//
////    @Bean
////    publi c SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
////        http.authorizeRequests()
////                .antMatchers("*/main").permitAll()
////                //.anyRequest().authenticated()
////                .and()
////                .httpBasic(); // Utilise HTTP Basic pour l'authentification
////
////        return http.build();
////    }
//
//        @Bean
//        public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//            http
//                    .authorizeHttpRequests(auth -> auth
//                            .requestMatchers("/api/main").permitAll() // Remplace `antMatchers()` par `requestMatchers()`
//                                    .requestMatchers("/api/profile").authenticated()
//                                    //.requestMatchers("/api/basic/**").authenticated()
//                                    .requestMatchers("/api/admin/**").hasRole("ADMIN")
//                                    //.requestMatchers("*/admin/myadmin").hasRole("ADMIN")
//                                    .requestMatchers("/api/mange").hasAnyRole("ADMIN","MANGER")
//                            //.anyRequest().authenticated
//                                    .requestMatchers("/api/basic/mybasic").hasAuthority("ACCESS_BASIC1")
//                    )
//                    .requiresChannel(channel ->
//                            channel.anyRequest().requiresSecure() // Forcer HTTPS pour toutes les requêtes
//                    )
//                    .httpBasic(); // Utilise HTTP Basic pour l'authentification
//
//            return http.build();
//        }
//    @Bean
//    DaoAuthenticationProvider authenticationProvider(){
//        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
//        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
//        daoAuthenticationProvider.setUserDetailsService(userPrincipalDetailsService);
//        return daoAuthenticationProvider;
//    }
//
//    @Bean
//    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
//        return authenticationConfiguration.getAuthenticationManager();
//    }
//    @Bean
//    PasswordEncoder passwordEncoder(){
//        return new BCryptPasswordEncoder();
//    }

}

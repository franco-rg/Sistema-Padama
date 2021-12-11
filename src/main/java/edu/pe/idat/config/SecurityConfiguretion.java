package edu.pe.idat.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import edu.pe.idat.service.UserService;


@Configuration
@EnableWebSecurity
public class SecurityConfiguretion extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserService userService;
	
	@Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
	
	@Bean
    public DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
        auth.setUserDetailsService(userService);
        auth.setPasswordEncoder(passwordEncoder());
        return auth;
    }
	
	@Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider());
    }
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/js/**",
	                "/css/**",
	                "/img/**",
	                "/script/**",
	                "/jsweb","/include/**","/css/**","/icons/**","/img/**","/js/**","/layer/**")
		
		.permitAll().antMatchers("/", "/index","/registro").permitAll()
		.antMatchers("/admin","/listar_servicio","/actualizar_categoria","/actualizar_descuento_temporada","/actualizar_descuentos","/actualizar_habitacion",
				"/actuaizar_nivel","actualizar_servicio","/actualizar_temporada","/listar_habitacion"
				,"/listar_nivel","/listar_reserva","/listar_servicio","/listar_temporada","/modificar_descuento_categoria","/modificar_descuento_temporada"
				,"/registrar_nivel","/registrar_habitacion","/registrar_reserva","/registrar_servicio","/registrar_temporada","/registrarcategoria").access("hasRole('ADMIN')")
		
		.antMatchers("/user*").access("hasRole('USER') or hasRole('ADMIN')")
		.anyRequest().authenticated()
		.and()
		.formLogin()
		.loginPage("/login").permitAll()
		.defaultSuccessUrl("/home").failureUrl("/login?error=true")
		.usernameParameter("username").passwordParameter("password")
		.and()
		.logout()
		.invalidateHttpSession(true)
		.clearAuthentication(true)
		.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
		.logoutSuccessUrl("/login?logout")
		.and()
		.exceptionHandling().accessDeniedPage("/403");
	}

}

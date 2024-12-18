package com.spring.security;

import org.apache.catalina.Context;
import org.apache.catalina.connector.Connector;
import org.apache.tomcat.util.descriptor.web.SecurityCollection;
import org.apache.tomcat.util.descriptor.web.SecurityConstraint;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@Configuration
public class SecurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(SecurityApplication.class, args);
	}

//	@Bean
//	public WebServerFactoryCustomizer<TomcatServletWebServerFactory> servletContainerCustomizer() {
//		return factory -> {
//			// Ajoute un connecteur HTTP sur le port 8082 qui redirige vers HTTPS
//			factory.addAdditionalTomcatConnectors(httpToHttpsRedirectConnector());
//		};
//	}

//	@Bean
//    public ServletWebServerFactory servletContainer() {
//        // Enable SSL Trafic
//        TomcatServletWebServerFactory tomcat = new TomcatServletWebServerFactory() {
//            @Override
//            protected void postProcessContext(Context context) {
//                SecurityConstraint securityConstraint = new SecurityConstraint();
//                securityConstraint.setUserConstraint("CONFIDENTIAL");
//                SecurityCollection collection = new SecurityCollection();
//                collection.addPattern("/*");
//                securityConstraint.addCollection(collection);
//                context.addConstraint(securityConstraint);
//            }
//        };
//        // Add HTTP to HTTPS redirect
//        tomcat.addAdditionalTomcatConnectors(httpToHttpsRedirectConnector());
//
//        return tomcat;
//    }

//	private Connector httpToHttpsRedirectConnector() {
//		Connector connector = new Connector(TomcatServletWebServerFactory.DEFAULT_PROTOCOL);
//		connector.setScheme("http");
//		connector.setPort(8080); // Port pour les requêtes HTTP
//		connector.setSecure(false);
//		connector.setRedirectPort(8443); // Redirige vers le port HTTPS
//		return connector;
//	}
}

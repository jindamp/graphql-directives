package com.example.graphql;

import com.example.graphql.resolvers.AuthDirective;
import com.oembedler.moon.graphql.boot.SchemaDirective;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.context.ServletContextAware;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

import javax.servlet.ServletContext;


@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

    @Bean
    public SchemaDirective myCustomDirective() {
        return new SchemaDirective("authDirective", new AuthDirective());
    }
	
}

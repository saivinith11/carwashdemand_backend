package com.apigateway.configuration;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
	public class Config { 
	@Bean
	public RouteLocator myRoutes(RouteLocatorBuilder routeLocatorBuilder)
	{
	return routeLocatorBuilder.routes() 
			.route(p ->p
	             .path("/carwash/*")
	             .uri("http://localhost:8081"))
			.route(p ->p
		             .path("/admin/*")
		             .uri("http://localhost:8082"))
			.route(p ->p
		             .path("/wash/*")
		             .uri("http://localhost:8084"))
			.route(p ->p
		             .path("/order/*")
		             .uri("http://localhost:8085"))
			.route(p ->p
		             .path("/pay/*")
		             .uri("http://localhost:8086"))
			
	        .build();
	        
	/*
	* .route("userId", route -> route .path("/catalog/**") .filters(f ->
	* f.rewritePath("/catalog/(?<RID>.*)", "/${RID}"))
	* .uri("http://localhost:8081") ) .route("programId", route -> route
	* .path("/program/**") .filters(f -> f.rewritePath("/program/(?<RID>.*)",
	* "/${RID}")) .uri("http://localhost:8082") ) .route("programId", route ->
	* route .path("/rating/**") .filters(f -> f.rewritePath("/rating/(?<RID>.*)",
	* "/${RID}")) .uri("http://localhost:8083") )
	*/
	}}





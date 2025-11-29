package com.bank.customerservice.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;

@OpenAPIDefinition(
        info = @Info(
                contact = @Contact(name = "Sadvik Gowda", email = "sadu@gmail.com", url = "xyz.gmail.com"),
                description = "Documentation for customer service",
                title = "Customer service Doc",
                version = "1.0"
        ),

//        Optional
        servers = {
                @Server(description = "LOCAL ENV", url = "http://localhost:8090/bank"),
                @Server(description = "TEST ENV", url = "testenv:8090/bank"),
                @Server(description = "TEST ENV", url = "devenv:8090/bank")
        }
)
public class OpenApiDocConf {
}

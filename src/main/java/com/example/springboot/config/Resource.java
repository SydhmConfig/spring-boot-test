package com.example.springboot.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "resource")
@Data
public class Resource {

    private  String imageServer;

    private  String emailServer;

    public String getImageServer() {
        return imageServer;
    }

    public void setImageServer(String imageServer) {
        this.imageServer = imageServer;
    }

    public String getEmailServe() {
        return emailServer;
    }

    public void setEmailServe(String emailServe) {
        this.emailServer = emailServe;
    }
}

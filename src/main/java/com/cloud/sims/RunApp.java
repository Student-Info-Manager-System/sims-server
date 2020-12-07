package com.cloud.sims;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.Environment;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author Long
 */
@Slf4j
@SpringBootApplication
public class RunApp extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(RunApp.class);
    }

    public static void main(String[] args) throws UnknownHostException {
        ConfigurableApplicationContext application = SpringApplication.run(RunApp.class, args);
        logInfo(application);
    }

    public static void logInfo(ConfigurableApplicationContext application) throws UnknownHostException {
        InetAddress addr = InetAddress.getLocalHost();
        Environment env = application.getEnvironment();
        String ip = InetAddress.getLocalHost().getHostAddress();
        String port = env.getProperty("server.port");
        String path = env.getProperty("server.servlet.context-path");
        log.info("\n----------------------------------------------------------\n\t" +
                "Application Boot is running! Access URLs:\n\t" +
                "Knife4j文档: \thttp://localhost:" + port  + "/doc.html#\n\t" +
                "Swagger文档: \thttp://localhost:" + port  + "/swagger-ui.html#\n\t" +
                "首页: \thttp://localhost:" + port  + "/\n" +
                "----------------------------------------------------------"
        );
    }
}

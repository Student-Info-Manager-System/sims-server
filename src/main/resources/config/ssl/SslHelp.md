
# SpringBoot 配置 HTTPS 证书生成指南

## 生成证书
-  终端执行

```play
keytool -genkeypair -alias hellowood -keyalg RSA -keysize 2048 -storetype PKCS12 -keystore hellowood.p12 -validity 3650
输入密钥库口令:
再次输入新口令:
您的名字与姓氏是什么?
  [Unknown]:  HellWood
您的组织单位名称是什么?
  [Unknown]:  HelloWood
您的组织名称是什么?
  [Unknown]:  HelloWood
您所在的城市或区域名称是什么?
  [Unknown]:  BJ
您所在的省/市/自治区名称是什么?
  [Unknown]:  BJ
该单位的双字母国家/地区代码是什么?
  [Unknown]:  CN
CN=HellWood, OU=HelloWood, O=HelloWood, L=BJ, ST=BJ, C=CN是否正确?
  [否]:  y

```
- 这样就生成了 hellowood.p12这个证书

- 如果已经有一个证书，可以将该证书转换为 PKCS格式

```base
keytool -import -alias hellowood -file hellowood.crt -keystore hellowood.p12
// 或
keytool -importkeystore -srckeystore hellowood.jks -destkeystore hellowood.p12 -deststoretype pkcs12
```

## 配置 HTTPS

- 将 hellowood.p12 添加到(资源路径) resources/下
- application.yml (application.properties) 配置
```yaml
server:
  # SSL config
  ssl:
    key-store: hellowood.p12
    key-store-password: 123456
    key-store-type: PKCS12
    key-alias: hellowood
    enabled: true
```
- 添加接口
```java
@RestController
public class BaseController {
    @GetMapping("/")
    public String root() {
        return "HelloWood";
    }
}
```
- 启动应用，会看到日志中有提示应用使用 HTTPS 启动
```play
 o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat started on port(s): 8080 (https) with context path ''
```

- 访问 http://localhost:8080，会提示需要使用 HTTPS 进行访问
```haml
curl http://localhost:8080/
Bad Request
This combination of host and port requires TLS.
```

- 访问 https://localhost:8080，会成功返回 HelloWood
```haml
curl https://localhost:8080
 HelloWood%
```

## 重定向 HTTP 到 HTTPS
- 修改端口，添加 HTTP 端口 (application.yml/application.properties)
```yaml
server:
  #端口号
  port: 8443
  port.http: 8080
```
- 添加重定向配置 **ConnectorConfig.java**
```java
import org.apache.catalina.Context;
import org.apache.catalina.connector.Connector;
import org.apache.coyote.http11.Http11NioProtocol;
import org.apache.tomcat.util.descriptor.web.SecurityCollection;
import org.apache.tomcat.util.descriptor.web.SecurityConstraint;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConnectorConfig {

    @Value("${server.port.http}")
    private int serverPortHttp;

    @Value("${server.port}")
    private int serverPortHttps;

    @Bean
    public ServletWebServerFactory servletWebServerFactory() {
        TomcatServletWebServerFactory factory = new TomcatServletWebServerFactory() {
            @Override
            protected void postProcessContext(Context context) {
                SecurityConstraint securityConstraint = new SecurityConstraint();
                securityConstraint.setUserConstraint("CONFIDENTIAL");
                SecurityCollection securityCollection = new SecurityCollection();
                securityCollection.addPattern("/*");
                securityConstraint.addCollection(securityCollection);
                context.addConstraint(securityConstraint);
            }
        };
        factory.addAdditionalTomcatConnectors(redirectConnector());
        return factory;
    }

    private Connector redirectConnector() {
        Connector connector = new Connector(Http11NioProtocol.class.getName());
        connector.setScheme("http");
        connector.setPort(serverPortHttp);
        connector.setSecure(false);
        connector.setRedirectPort(serverPortHttps);
        return connector;
    }
}
```

- 再次启动应用，看到日志中有 HTTP 和 HTTPS 的端口信息
```text
o.s.b.w.e.tomcat.TomcatWebServer - Tomcat started on port(s): 8443 (https) 8080 (http) with context path ''
```

- 访问 http://localhost:8080，将会被重定向到https://localhost:8443

- 直接访问 https://localhost:8443正常返回HelloWood




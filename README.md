# Fibonacci-rest
Production grade RESTful web service to return Fibonacci numbers.

# System Requirement
This project is implemented with Java Language. In order to build and run the project, you will need Java SDK 1.8+, and Maven 3.3+. You should check your current Java/Maven installation with the following commands before you begin:

#check java version:

[ec2-user@ip-172-31-31-44 fibonacci-rest]$ java -version

openjdk version "1.8.0_161"
OpenJDK Runtime Environment (build 1.8.0_161-b14)
OpenJDK 64-Bit Server VM (build 25.161-b14, mixed mode)
[ec2-user@ip-172-31-31-44 fibonacci-rest]$

#check maven version:

[ec2-user@ip-172-31-31-44 fibonacci-rest]$ mvn -version
Apache Maven 3.5.3 (3383c37e1f9e9b3bc3df50A50c29c8aff9f295297; 2018-02-24T19:49:05Z)
maven home: /usr/local/apache-maven
Java version: 1.8.0_161, vendor: Oracle Corporation
Java home: /usr/lib/jvm/java-1.8.0-openjdk-1.8.0.161-0.b14.36.amzn1.x86_64/jre
Default locale: en_US, platform encoding: UTF-8
OS name: "linux", version: "4.9.81-35.56.amzn1.x86_64", arch: "amd64", family: "unix"
[ec2-user@ip-172-31-31-44 fibonacci-rest]$

If you are new to Java development, please install Java  SDK and Maven according to the following guide.

- [JDK 8 and JRE 8 Installation Guide](https://docs.oracle.com/javase/8/docs/technotes/guides/install/install_overview.html)
- [Maven Installation Guide](https://maven.apache.org/install.html)

# Fibonacci Service

This project implements a RESTful web service to return fibonacci numbers. The service hosts an endpoint with address http://host:port/fibonacci?num=${n}.
and return the first `n` Fibonacci numbers, starting from 0. For example, if `n` = 10, the following trace shows that the service return the fibonacci number array in the JSON format: 
{ 
   "number": "<number>",
   "array": [<fibonacci numbers>]
}

If `n` is zero or negative number, it will return an error respond in JSON format:

```
{ 
   "errorCode": "<error code>",
   "message": "<error description>"
}
```

# Additional Services

Besides the Fibonacci service mentioned above, this project also implements production-level services which expose different types of information about the running application – health, metrics, info, dump, env etc. They help to make the serive more managable, maintainable, testable, measurable.

Belows are brief descriptions of some additional service. For more information, please refer to: [Production Ready Endpoint](http://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#production-ready-endpoints)

| ID | Description | Sensitive Default |
| :--- | :--- | :--- |
| autoconfig | Displays an auto-configuration report showing all auto-configuration candidates and the reason why they ‘were’ or ‘were not’ applied. | true |
| beans | Displays a complete list of all the Spring beans in your application. | true |
| configprops | Displays a collated list of all configuration properties. | true |
| dump | Performs a thread dump. | true |
| env | Exposes properties of environment.| true |
| health| Shows application health information (when the application is secure, a simple ‘status’ when accessed over an unauthenticated connection or full message details when authenticated).| false |
| info | Displays arbitrary application info.| false |
| metrics | Shows ‘metrics’ information for the current application.| true |
| mappings | Displays a collated list of all @RequestMapping paths.| true |
| shutdown | Allows the application to be gracefully shutdown (not enabled by default).| true |
| trace | Displays trace information (by default the last few HTTP requests).| true |

# Source Codes

- The source code is located in the directory [source code](./src/main/java/org/emc/rubicon/rest). 
- The configuration property file is [configuration property](./src/main/resources/application.properties).
- The testing code is located in the directory [testing code](./src/test/java/org/emc/rubicon/rest/)

# Download, Build and Test The Project Step by Step

Suppose you have installed Java SDK 1.8 and Maven 3.2+, you can build and run the testcases with following commands in the `fibonacci-rest` directory:

```
$ mvn spring-boot:run

INFO] Scanning for projects...
[INFO]
[INFO] -------------------< org.emc.rubicon:fibonacci-rest >-------------------
[INFO] Building Fibonacci Rest Service 1.3.3.RELEASE
[INFO] --------------------------------[ jar ]---------------------------------
[INFO]
[INFO] >>> spring-boot-maven-plugin:1.3.3.RELEASE:run (default-cli) > test-compile @ fibonacci-rest >>>
[INFO]
[INFO] --- maven-resources-plugin:2.6:resources (default-resources) @ fibonacci-rest ---
[INFO] Using 'UTF-8' encoding to copy filtered resources.
[INFO] Copying 1 resource
[INFO] Copying 1 resource
[INFO]
[INFO] --- maven-compiler-plugin:3.1:compile (default-compile) @ fibonacci-rest ---
[INFO] Changes detected - recompiling the module!
[INFO] Compiling 5 source files to /home/ec2-user/fibonacci-rest/target/classes
[INFO]
[INFO] --- maven-resources-plugin:2.6:testResources (default-testResources) @ fibonacci-rest ---
[INFO] Using 'UTF-8' encoding to copy filtered resources.
[INFO] Copying 1 resource
[INFO]
[INFO] --- maven-compiler-plugin:3.1:testCompile (default-testCompile) @ fibonacci-rest ---
[INFO] Nothing to compile - all classes are up to date
[INFO]
[INFO] <<< spring-boot-maven-plugin:1.3.3.RELEASE:run (default-cli) < test-compile @ fibonacci-rest <<<
[INFO]
[INFO]
[INFO] --- spring-boot-maven-plugin:1.3.3.RELEASE:run (default-cli) @ fibonacci-rest ---

  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::        (v1.3.3.RELEASE)

2018-03-18 04:41:23.090  INFO 5843 --- [           main] o.e.r.rest.SampleActuatorApplication     : Starting SampleActuatorApplication on ip-172-31-31-44 with PID 5843 (/home/ec2-user/fibonacci-rest/target/classes started by ec2-user in /home/ec2-user/fibonacci-rest)
2018-03-18 04:41:23.100  INFO 5843 --- [           main] o.e.r.rest.SampleActuatorApplication     : No active profile set, falling back to default profiles: default
2018-03-18 04:41:23.958  INFO 5843 --- [           main] ationConfigEmbeddedWebApplicationContext : Refreshing org.springframework.boot.context.embedded.AnnotationConfigEmbeddedWebApplicationContext@4ab60959: startup date [Sun Mar 18 04:41:23 UTC 2018]; root of context hierarchy
2018-03-18 04:41:25.123  INFO 5843 --- [           main] o.s.b.f.s.DefaultListableBeanFactory     : Overriding bean definition for bean 'beanNameViewResolver' with a different definition: replacing [Root bean: class [null]; scope=; abstract=false; lazyInit=false; autowireMode=3; dependencyCheck=0; autowireCandidate=true; primary=false; factoryBeanName=org.springframework.boot.autoconfigure.web.ErrorMvcAutoConfiguration$WhitelabelErrorViewConfiguration; factoryMethodName=beanNameViewResolver; initMethodName=null; destroyMethodName=(inferred); defined in class path resource [org/springframework/boot/autoconfigure/web/ErrorMvcAutoConfiguration$WhitelabelErrorViewConfiguration.class]] with [Root bean: class [null]; scope=; abstract=false; lazyInit=false; autowireMode=3; dependencyCheck=0; autowireCandidate=true; primary=false; factoryBeanName=org.springframework.boot.autoconfigure.web.WebMvcAutoConfiguration$WebMvcAutoConfigurationAdapter; factoryMethodName=beanNameViewResolver; initMethodName=null; destroyMethodName=(inferred); defined in class path resource [org/springframework/boot/autoconfigure/web/WebMvcAutoConfiguration$WebMvcAutoConfigurationAdapter.class]]
2018-03-18 04:41:25.171  INFO 5843 --- [           main] o.s.b.f.s.DefaultListableBeanFactory     : Overriding bean definition for bean 'ignoredPathsWebSecurityConfigurerAdapter' with a different definition: replacing [Root bean: class [null]; scope=; abstract=false; lazyInit=false; autowireMode=3; dependencyCheck=0; autowireCandidate=true; primary=false; factoryBeanName=org.springframework.boot.autoconfigure.security.SpringBootWebSecurityConfiguration; factoryMethodName=ignoredPathsWebSecurityConfigurerAdapter; initMethodName=null; destroyMethodName=(inferred); defined in class path resource [org/springframework/boot/autoconfigure/security/SpringBootWebSecurityConfiguration.class]] with [Root bean: class [null]; scope=; abstract=false; lazyInit=false; autowireMode=3; dependencyCheck=0; autowireCandidate=true; primary=false; factoryBeanName=org.springframework.boot.actuate.autoconfigure.ManagementWebSecurityAutoConfiguration; factoryMethodName=ignoredPathsWebSecurityConfigurerAdapter; initMethodName=null; destroyMethodName=(inferred); defined in class path resource [org/springframework/boot/actuate/autoconfigure/ManagementWebSecurityAutoConfiguration.class]]
2018-03-18 04:41:26.010  INFO 5843 --- [           main] trationDelegate$BeanPostProcessorChecker : Bean 'org.springframework.transaction.annotation.ProxyTransactionManagementConfiguration' of type [class org.springframework.transaction.annotation.ProxyTransactionManagementConfiguration$$EnhancerBySpringCGLIB$$1c9348a9] is not eligible for getting processed by all BeanPostProcessors (for example: not eligible for auto-proxying)
2018-03-18 04:41:26.649  INFO 5843 --- [           main] s.b.c.e.t.TomcatEmbeddedServletContainer : Tomcat initialized with port(s): 8080 (http)
2018-03-18 04:41:26.666  INFO 5843 --- [           main] o.apache.catalina.core.StandardService   : Starting service Tomcat
2018-03-18 04:41:26.667  INFO 5843 --- [           main] org.apache.catalina.core.StandardEngine  : Starting Servlet Engine: Apache Tomcat/8.0.32
2018-03-18 04:41:26.812  INFO 5843 --- [ost-startStop-1] o.a.c.c.C.[Tomcat].[localhost].[/]       : Initializing Spring embedded WebApplicationContext
2018-03-18 04:41:26.813  INFO 5843 --- [ost-startStop-1] o.s.web.context.ContextLoader            : Root WebApplicationContext: initialization completed in 2865 ms
2018-03-18 04:41:27.499  INFO 5843 --- [ost-startStop-1] o.s.b.c.embedded.FilterRegistrationBean  : Mapping filter: 'metricFilter' to: [/*]
2018-03-18 04:41:27.500  INFO 5843 --- [ost-startStop-1] o.s.b.c.embedded.FilterRegistrationBean  : Mapping filter: 'characterEncodingFilter' to: [/*]
2018-03-18 04:41:27.502  INFO 5843 --- [ost-startStop-1] o.s.b.c.embedded.FilterRegistrationBean  : Mapping filter: 'hiddenHttpMethodFilter' to: [/*]
2018-03-18 04:41:27.503  INFO 5843 --- [ost-startStop-1] o.s.b.c.embedded.FilterRegistrationBean  : Mapping filter: 'httpPutFormContentFilter' to: [/*]
2018-03-18 04:41:27.503  INFO 5843 --- [ost-startStop-1] o.s.b.c.embedded.FilterRegistrationBean  : Mapping filter: 'requestContextFilter' to: [/*]
2018-03-18 04:41:27.504  INFO 5843 --- [ost-startStop-1] .e.DelegatingFilterProxyRegistrationBean : Mapping filter: 'springSecurityFilterChain' to: [/*]
2018-03-18 04:41:27.504  INFO 5843 --- [ost-startStop-1] o.s.b.c.embedded.FilterRegistrationBean  : Mapping filter: 'webRequestLoggingFilter' to: [/*]
2018-03-18 04:41:27.504  INFO 5843 --- [ost-startStop-1] o.s.b.c.embedded.FilterRegistrationBean  : Mapping filter: 'applicationContextIdFilter' to: [/*]
2018-03-18 04:41:27.504  INFO 5843 --- [ost-startStop-1] o.s.b.c.e.ServletRegistrationBean        : Mapping servlet: 'dispatcherServlet' to [/]
2018-03-18 04:41:28.053  INFO 5843 --- [ost-startStop-1] o.s.s.web.DefaultSecurityFilterChain     : Creating filter chain: OrRequestMatcher [requestMatchers=[Ant [pattern='/css/**'], Ant [pattern='/js/**'], Ant [pattern='/images/**'], Ant [pattern='/**/favicon.ico'], Ant [pattern='/error'], org.springframework.boot.actuate.autoconfigure.ManagementWebSecurityAutoConfiguration$LazyEndpointPathRequestMatcher@4c4f68e0]], []
2018-03-18 04:41:28.155  INFO 5843 --- [ost-startStop-1] o.s.s.web.DefaultSecurityFilterChain     : Creating filter chain: org.springframework.boot.autoconfigure.security.SpringBootWebSecurityConfiguration$ApplicationNoWebSecurityConfigurerAdapter$1@55019be8, [org.springframework.security.web.context.request.async.WebAsyncManagerIntegrationFilter@352142f8, org.springframework.security.web.context.SecurityContextPersistenceFilter@284583e5, org.springframework.security.web.header.HeaderWriterFilter@3be5c43f, org.springframework.security.web.csrf.CsrfFilter@4a34ebf0, org.springframework.security.web.authentication.logout.LogoutFilter@7c5f181f, org.springframework.security.web.savedrequest.RequestCacheAwareFilter@642d0aff, org.springframework.security.web.servletapi.SecurityContextHolderAwareRequestFilter@4ec5660c, org.springframework.security.web.authentication.AnonymousAuthenticationFilter@313a3ba3, org.springframework.security.web.session.SessionManagementFilter@12353efb, org.springframework.security.web.access.ExceptionTranslationFilter@181722d2]
2018-03-18 04:41:28.482  INFO 5843 --- [           main] s.w.s.m.m.a.RequestMappingHandlerAdapter : Looking for @ControllerAdvice: org.springframework.boot.context.embedded.AnnotationConfigEmbeddedWebApplicationContext@4ab60959: startup date [Sun Mar 18 04:41:23 UTC 2018]; root of context hierarchy
2018-03-18 04:41:28.595  INFO 5843 --- [           main] s.w.s.m.m.a.RequestMappingHandlerMapping : Mapped "{[/fibonacci],methods=[GET]}" onto public org.emc.rubicon.rest.entity.FibonacciResult org.emc.rubicon.rest.FibonacciController.fibonacci(java.lang.String)
2018-03-18 04:41:28.597  INFO 5843 --- [           main] s.w.s.m.m.a.RequestMappingHandlerMapping : Mapped "{[/error],produces=[text/html]}" onto public org.springframework.web.servlet.ModelAndView org.springframework.boot.autoconfigure.web.BasicErrorController.errorHtml(javax.servlet.http.HttpServletRequest,javax.servlet.http.HttpServletResponse)
2018-03-18 04:41:28.598  INFO 5843 --- [           main] s.w.s.m.m.a.RequestMappingHandlerMapping : Mapped "{[/error]}" onto public org.springframework.http.ResponseEntity<java.util.Map<java.lang.String, java.lang.Object>> org.springframework.boot.autoconfigure.web.BasicErrorController.error(javax.servlet.http.HttpServletRequest)
2018-03-18 04:41:28.650  INFO 5843 --- [           main] o.s.w.s.handler.SimpleUrlHandlerMapping  : Mapped URL path [/webjars/**] onto handler of type [class org.springframework.web.servlet.resource.ResourceHttpRequestHandler]
2018-03-18 04:41:28.650  INFO 5843 --- [           main] o.s.w.s.handler.SimpleUrlHandlerMapping  : Mapped URL path [/**] onto handler of type [class org.springframework.web.servlet.resource.ResourceHttpRequestHandler]
2018-03-18 04:41:28.732  INFO 5843 --- [           main] o.s.w.s.handler.SimpleUrlHandlerMapping  : Mapped URL path [/**/favicon.ico] onto handler of type [class org.springframework.web.servlet.resource.ResourceHttpRequestHandler]
2018-03-18 04:41:30.308  INFO 5843 --- [           main] o.s.b.a.e.mvc.EndpointHandlerMapping     : Mapped "{[/shutdown || /shutdown.json],methods=[POST]}" onto public java.lang.Object org.springframework.boot.actuate.endpoint.mvc.ShutdownMvcEndpoint.invoke()
2018-03-18 04:41:30.314  INFO 5843 --- [           main] o.s.b.a.e.mvc.EndpointHandlerMapping     : Mapped "{[/beans || /beans.json],methods=[GET],produces=[application/json]}" onto public java.lang.Object org.springframework.boot.actuate.endpoint.mvc.EndpointMvcAdapter.invoke()
2018-03-18 04:41:30.315  INFO 5843 --- [           main] o.s.b.a.e.mvc.EndpointHandlerMapping     : Mapped "{[/metrics/{name:.*}],methods=[GET],produces=[application/json]}" onto public java.lang.Object org.springframework.boot.actuate.endpoint.mvc.MetricsMvcEndpoint.value(java.lang.String)
2018-03-18 04:41:30.315  INFO 5843 --- [           main] o.s.b.a.e.mvc.EndpointHandlerMapping     : Mapped "{[/metrics || /metrics.json],methods=[GET],produces=[application/json]}" onto public java.lang.Object org.springframework.boot.actuate.endpoint.mvc.EndpointMvcAdapter.invoke()
2018-03-18 04:41:30.316  INFO 5843 --- [           main] o.s.b.a.e.mvc.EndpointHandlerMapping     : Mapped "{[/mappings || /mappings.json],methods=[GET],produces=[application/json]}" onto public java.lang.Object org.springframework.boot.actuate.endpoint.mvc.EndpointMvcAdapter.invoke()
2018-03-18 04:41:30.318  INFO 5843 --- [           main] o.s.b.a.e.mvc.EndpointHandlerMapping     : Mapped "{[/configprops || /configprops.json],methods=[GET],produces=[application/json]}" onto public java.lang.Object org.springframework.boot.actuate.endpoint.mvc.EndpointMvcAdapter.invoke()
2018-03-18 04:41:30.326  INFO 5843 --- [           main] o.s.b.a.e.mvc.EndpointHandlerMapping     : Mapped "{[/env/{name:.*}],methods=[GET],produces=[application/json]}" onto public java.lang.Object org.springframework.boot.actuate.endpoint.mvc.EnvironmentMvcEndpoint.value(java.lang.String)
2018-03-18 04:41:30.326  INFO 5843 --- [           main] o.s.b.a.e.mvc.EndpointHandlerMapping     : Mapped "{[/env || /env.json],methods=[GET],produces=[application/json]}" onto public java.lang.Object org.springframework.boot.actuate.endpoint.mvc.EndpointMvcAdapter.invoke()
2018-03-18 04:41:30.326  INFO 5843 --- [           main] o.s.b.a.e.mvc.EndpointHandlerMapping     : Mapped "{[/trace || /trace.json],methods=[GET],produces=[application/json]}" onto public java.lang.Object org.springframework.boot.actuate.endpoint.mvc.EndpointMvcAdapter.invoke()
2018-03-18 04:41:30.327  INFO 5843 --- [           main] o.s.b.a.e.mvc.EndpointHandlerMapping     : Mapped "{[/autoconfig || /autoconfig.json],methods=[GET],produces=[application/json]}" onto public java.lang.Object org.springframework.boot.actuate.endpoint.mvc.EndpointMvcAdapter.invoke()
2018-03-18 04:41:30.327  INFO 5843 --- [           main] o.s.b.a.e.mvc.EndpointHandlerMapping     : Mapped "{[/info || /info.json],methods=[GET],produces=[application/json]}" onto public java.lang.Object org.springframework.boot.actuate.endpoint.mvc.EndpointMvcAdapter.invoke()
2018-03-18 04:41:30.328  INFO 5843 --- [           main] o.s.b.a.e.mvc.EndpointHandlerMapping     : Mapped "{[/dump || /dump.json],methods=[GET],produces=[application/json]}" onto public java.lang.Object org.springframework.boot.actuate.endpoint.mvc.EndpointMvcAdapter.invoke()
2018-03-18 04:41:30.328  INFO 5843 --- [           main] o.s.b.a.e.mvc.EndpointHandlerMapping     : Mapped "{[/health || /health.json],produces=[application/json]}" onto public java.lang.Object org.springframework.boot.actuate.endpoint.mvc.HealthMvcEndpoint.invoke(java.security.Principal)
2018-03-18 04:41:30.520  INFO 5843 --- [           main] o.s.j.e.a.AnnotationMBeanExporter        : Registering beans for JMX exposure on startup
2018-03-18 04:41:30.543  INFO 5843 --- [           main] o.s.c.support.DefaultLifecycleProcessor  : Starting beans in phase 0
2018-03-18 04:41:30.950  INFO 5843 --- [           main] s.b.c.e.t.TomcatEmbeddedServletContainer : Tomcat started on port(s): 8080 (http)
2018-03-18 04:41:30.959  INFO 5843 --- [           main] o.e.r.rest.SampleActuatorApplication     : Started SampleActuatorApplication in 8.471 seconds (JVM running for 15.085)
2018-03-18 04:41:55.792  INFO 5843 --- [       Thread-5] ationConfigEmbeddedWebApplicationContext : Closing org.springframework.boot.context.embedded.AnnotationConfigEmbeddedWebApplicationContext@4ab60959: startup date [Sun Mar 18 04:41:23 UTC 2018]; root of context hierarchy
2018-03-18 04:41:55.795  INFO 5843 --- [       Thread-5] o.s.c.support.DefaultLifecycleProcessor  : Stopping beans in phase 0
2018-03-18 04:41:55.800  INFO 5843 --- [       Thread-5] o.s.j.e.a.AnnotationMBeanExporter        : Unregistering JMX-exposed beans on shutdown
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time: 38.009 s
[INFO] Finished at: 2018-03-18T04:41:55Z
[INFO] ------------------------------------------------------------------------
[ec2-user@ip-172-31-31-44 fibonacci-rest]$

```

URL:  Give your output of Fibonacci

http://ec2-34-214-81-112.us-west-2.compute.amazonaws.com:8080/fibonacci?num=20


URL: Give you error message for input of any negative value

http://ec2-34-214-81-112.us-west-2.compute.amazonaws.com:8080/fibonacci?num=-23


# Interactive Testing

After execute the following commands under the `fibonacci-rest` directory, an application server will start up and host all the services at the address localhost:8080.
You can do interactive testing with CLI tool `curl`. 

```
$ mvn spring-boot:run
```

## Example output

Here are some example testing output:

- Call Fibonacci Service

```
$ curl localhost:8080/fibonacci?num=10 | json_pp
  % Total    % Received % Xferd  Average Speed   Time    Time     Time  Current
                                 Dload  Upload   Total   Spent    Left  Speed
100    68    0    68    0     0   2597      0 --:--:-- --:--:-- --:--:--  2615
{
   "array" : [
      "0",
      "1",
      "1",
      "2",
      "3",
      "5",
      "8",
      "13",
      "21",
      "34"
   ],
   "number" : "10"
}
```

```
$ curl localhost:8080/fibonacci?num=-10 | json_pp
  % Total    % Received % Xferd  Average Speed   Time    Time     Time  Current
                                 Dload  Upload   Total   Spent    Left  Speed
100    49  100    49    0     0   1633      0 --:--:-- --:--:-- --:--:--  1633
{
   "errorCode" : "400",
   "message" : "Wrong input: -10"
}
```


- Show Basic Information 

```
$ curl localhost:8080/info | json_pp
  % Total    % Received % Xferd  Average Speed   Time    Time     Time  Current
                                 Dload  Upload   Total   Spent    Left  Speed
100   113    0   113    0     0  11576      0 --:--:-- --:--:-- --:--:-- 12555
{
   "group" : "org.emc.rubicon",
   "version" : "1.3.3.RELEASE",
   "artifact" : "fibonacci-rest",
   "name" : "Fibonacci Rest Service"
}
```

- Show all available RESTful services

```
$ curl localhost:8080/mappings | json_pp
  % Total    % Received % Xferd  Average Speed   Time    Time     Time  Current
                                 Dload  Upload   Total   Spent    Left  Speed
100  3709    0  3709    0     0   354k      0 --:--:-- --:--:-- --:--:--  402k
{
   "{[/shutdown || /shutdown.json],methods=[POST]}" : {
      "bean" : "endpointHandlerMapping",
      "method" : "public java.lang.Object org.springframework.boot.actuate.endpoint.mvc.ShutdownMvcEndpoint.invoke()"
   },
   "{[/dump || /dump.json],methods=[GET],produces=[application/json]}" : {
      "bean" : "endpointHandlerMapping",
      "method" : "public java.lang.Object org.springframework.boot.actuate.endpoint.mvc.EndpointMvcAdapter.invoke()"
   },
   "{[/error],produces=[text/html]}" : {
      "bean" : "requestMappingHandlerMapping",
      "method" : "public org.springframework.web.servlet.ModelAndView org.springframework.boot.autoconfigure.web.BasicErrorController.errorHtml(javax.servlet.http.HttpServletRequest,javax.servlet.http.HttpServletResponse)"
   },
   "/**/favicon.ico" : {
      "bean" : "faviconHandlerMapping"
   },
   "{[/metrics/{name:.*}],methods=[GET],produces=[application/json]}" : {
      "bean" : "endpointHandlerMapping",
      "method" : "public java.lang.Object org.springframework.boot.actuate.endpoint.mvc.MetricsMvcEndpoint.value(java.lang.String)"
   },
   "{[/trace || /trace.json],methods=[GET],produces=[application/json]}" : {
      "bean" : "endpointHandlerMapping",
      "method" : "public java.lang.Object org.springframework.boot.actuate.endpoint.mvc.EndpointMvcAdapter.invoke()"
   },
   "{[/fibonacci],methods=[GET]}" : {
      "bean" : "requestMappingHandlerMapping",
      "method" : "public org.emc.rubicon.rest.entity.FibonacciResult org.emc.rubicon.rest.FibonacciController.fibonacci(java.lang.String)"
   },
   "{[/mappings || /mappings.json],methods=[GET],produces=[application/json]}" : {
      "bean" : "endpointHandlerMapping",
      "method" : "public java.lang.Object org.springframework.boot.actuate.endpoint.mvc.EndpointMvcAdapter.invoke()"
   },
   "{[/autoconfig || /autoconfig.json],methods=[GET],produces=[application/json]}" : {
      "bean" : "endpointHandlerMapping",
      "method" : "public java.lang.Object org.springframework.boot.actuate.endpoint.mvc.EndpointMvcAdapter.invoke()"
   },
   "{[/env || /env.json],methods=[GET],produces=[application/json]}" : {
      "bean" : "endpointHandlerMapping",
      "method" : "public java.lang.Object org.springframework.boot.actuate.endpoint.mvc.EndpointMvcAdapter.invoke()"
   },
   "{[/info || /info.json],methods=[GET],produces=[application/json]}" : {
      "bean" : "endpointHandlerMapping",
      "method" : "public java.lang.Object org.springframework.boot.actuate.endpoint.mvc.EndpointMvcAdapter.invoke()"
   },
   "{[/beans || /beans.json],methods=[GET],produces=[application/json]}" : {
      "bean" : "endpointHandlerMapping",
      "method" : "public java.lang.Object org.springframework.boot.actuate.endpoint.mvc.EndpointMvcAdapter.invoke()"
   },
   "{[/metrics || /metrics.json],methods=[GET],produces=[application/json]}" : {
      "bean" : "endpointHandlerMapping",
      "method" : "public java.lang.Object org.springframework.boot.actuate.endpoint.mvc.EndpointMvcAdapter.invoke()"
   },
   "/webjars/**" : {
      "bean" : "resourceHandlerMapping"
   },
   "{[/error]}" : {
      "bean" : "requestMappingHandlerMapping",
      "method" : "public org.springframework.http.ResponseEntity<java.util.Map<java.lang.String, java.lang.Object>> org.springframework.boot.autoconfigure.web.BasicErrorController.error(javax.servlet.http.HttpServletRequest)"
   },
   "{[/env/{name:.*}],methods=[GET],produces=[application/json]}" : {
      "bean" : "endpointHandlerMapping",
      "method" : "public java.lang.Object org.springframework.boot.actuate.endpoint.mvc.EnvironmentMvcEndpoint.value(java.lang.String)"
   },
   "/**" : {
      "bean" : "resourceHandlerMapping"
   },
   "{[/configprops || /configprops.json],methods=[GET],produces=[application/json]}" : {
      "bean" : "endpointHandlerMapping",
      "method" : "public java.lang.Object org.springframework.boot.actuate.endpoint.mvc.EndpointMvcAdapter.invoke()"
   },
   "{[/health || /health.json],produces=[application/json]}" : {
      "bean" : "endpointHandlerMapping",
      "method" : "public java.lang.Object org.springframework.boot.actuate.endpoint.mvc.HealthMvcEndpoint.invoke(java.security.Principal)"
   }
}
```

- Test Health Service

```
$ curl localhost:8080/health | json_pp
  % Total    % Received % Xferd  Average Speed   Time    Time     Time  Current
                                 Dload  Upload   Total   Spent    Left  Speed
100   225    0   225    0     0   7947      0 --:--:-- --:--:-- --:--:--  8035
{
   "db" : {
      "database" : "H2",
      "hello" : 1,
      "status" : "UP"
   },
   "sampleActuatorApplication" : {
      "Restful Service" : "Fibonacci",
      "status" : "UP"
   },
   "status" : "UP",
   "diskSpace" : {
      "threshold" : 10485760,
      "free" : 58018865152,
      "status" : "UP",
      "total" : 129443520512
   }
}
```


- Show Metrics

```
$ curl localhost:8080/metrics | json_pp
  % Total    % Received % Xferd  Average Speed   Time    Time     Time  Current
                                 Dload  Upload   Total   Spent    Left  Speed
100  1275    0  1275    0     0   111k      0 --:--:-- --:--:-- --:--:--  113k
{
   "gauge.response.star-star" : 3,
   "heap" : 466432,
   "counter.status.200.metrics" : 1,
   "heap.used" : 85968,
   "counter.status.404.star-star" : 4,
   "counter.status.200.mappings" : 2,
   "uptime" : 1711310,
   "gauge.response.metrics" : 11,
   "nonheap.used" : 87888,
   "threads.totalStarted" : 56,
   "datasource.primary.active" : 0,
   "gauge.response.env" : 9,
   "mem.free" : 349231,
   "httpsessions.active" : 0,
   "threads.peak" : 25,
   "gauge.response.fibonacci" : 22,
   "heap.committed" : 435200,
   "counter.status.200.fibonacci" : 1,
   "counter.status.200.beans" : 1,
   "httpsessions.max" : -1,
   "gc.ps_scavenge.time" : 257,
   "systemload.average" : 2.31982421875,
   "datasource.primary.usage" : 0,
   "gc.ps_marksweep.time" : 617,
   "mem" : 523088,
   "nonheap.init" : 2496,
   "gc.ps_scavenge.count" : 11,
   "counter.status.400.fibonacci" : 1,
   "heap.init" : 262144,
   "nonheap.committed" : 89624,
   "gauge.response.autoconfig" : 14,
   "gauge.response.configprops" : 633,
   "threads.daemon" : 20,
   "instance.uptime" : 1699136,
   "processors" : 4,
   "counter.status.200.env" : 1,
   "gauge.response.trace" : 12,
   "counter.status.200.health" : 3,
   "classes" : 11258,
   "gauge.response.mappings" : 3,
   "gc.ps_marksweep.count" : 3,
   "counter.status.200.autoconfig" : 1,
   "threads" : 24,
   "nonheap" : 0,
   "classes.unloaded" : 0,
   "counter.status.200.trace" : 1,
   "counter.status.200.configprops" : 1,
   "gauge.response.health" : 15,
   "classes.loaded" : 11258,
   "gauge.response.beans" : 23
}
```



# FibAppServer

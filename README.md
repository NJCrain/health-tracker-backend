# Health Tracker Backend
This is a Spring boot application that handles the backend functionality for the [Health Tracker App](https://github.com/NJCrain/health-tracker)

# Attributions
## Security - 
  * [Secure a Spring Boot REST API With JSON Web Token + Reference to Angular Integration](https://medium.com/@nydiarra/secure-a-spring-boot-rest-api-with-json-web-token-reference-to-angular-integration-e57a25806c50) - Used for:
    * [SecurityConfig](src/main/java/com/njcrain/healthtrackerbackend/SecurityConfig.java)
    * [AuthorizationServerConfig](src/main/java/com/njcrain/healthtrackerbackend/AuthorizationServerConfig.java)
    * [ResourceServerConfig](src/main/java/com/njcrain/healthtrackerbackend/ResourceServerConfig.java)
    
  * [springboot-jwt](https://github.com/nydiarra/springboot-jwt) - Used For:
    * [AppRole](src/main/java/com/njcrain/healthtrackerbackend/AppRole.java)
    * [UserDetailsServiceImpl](src/main/java/com/njcrain/healthtrackerbackend/UserDetailsServiceImpl.java)
    * [AppUser](src/main/java/com/njcrain/healthtrackerbackend/AppUser.java)
    
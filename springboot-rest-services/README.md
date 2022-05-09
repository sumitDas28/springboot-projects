# Building REST APIs with Spring Boot

This example demostrates Building REST services with Spring Boot

## Spring Boot REST APIs Features
- Return correct HTTP status codes
- Implement Exception Handling
- Implement Request Bean Validation
- Implementing HATEOS for REST services
- Internationalization
- Content Negotiation
- OpenAPI Documentation
    - Swagger UI : `http://localhost:8080/swagger-ui/index.html`
    - OpenAPI JSON : `http://localhost:8080/v3/api-docs`
- Monitoring APIs with Spring Boot Actuator
    - Actuator URLs: `http://localhost:8080/actuator`
    - Example check health `http://localhost:8080/actuator/health`
    - Expose all Actuator endpoints `management.endpoints.web.exposure.include=*`
- Visualizing APIs with HAL explorer
    - Helps to explore APIs supporting HATEOS
    - URL `http://localhost:8080/explorer/index.html#uri=/`
- Expose IDs using RepositoryRestConfigurer
- Static Filtering
- Dynamic Filtering
- Versioning REST APIs
    - URI Versioning Ex. twitter
    - Custom Header Versioning Ex. Microsoft
    - Media Type Versioning (Content Negotiation or Accept header) Ex: Github
    - Query parameter Versioning Ex. Amazon
    - Factors to decide versioning approach
        - URI Pollution
        - Misuse of HTTP Headers
        - Caching
        - Can we execute request on browser
        - API documentation
    - No perfect solution
- Spring Security Basic Authentication
- Spring Data JPA & H2 Database
    - H2 Console: `http://localhost:8080/h2-console`
- Richardson Maturity Model
    - Level 0 : Expose SOAP web services in REST style
    - Level 1: Expose Resources with proper URI
    - Level 2: Level 1 + HTTP Methods
    - Level 3: Level 2 + HATEOS Data + Next Possible actions

## REST Webservices Design Best Practices

- Consumer first
- Create good documentation
- Make best use of HTTP
    - Request Methods
    - Response status codes
- No secure info in URI
- Use Plurals
    - Example: Use /employees to /employees
- Use Noun for Resources
- Good examples of APIs: Stripe, Twilio, Dropbox, Github, Twitter
    
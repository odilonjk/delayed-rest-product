# Delayed Rest Product

[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)
 
Sometimes I need a REST (HTTP) service just to run requests with some amount of delay, usually when I'm doing some tests of new asynchronous implementations.
To solve that, I made this very simple project.

This project can be run on Docker containers as many as needed easily.

---

### This project uses

* JDK 8
* Quarkus 1.0
* Maven 3.6

---

### Running from terminal in dev mode

```
mvn quarkus:dev
```

---

### Running from container (Docker)

There's a generated documentation in `/src/main/docker` where is explained how to run the project on container using JVM or compiled as native.

---

### Using the API

`http://localhost:8080/product/{product_name}` will return a JSON filled with the name passed by parameter and a randomly generated price.

`http://localhost:8080/product/{product_name}/delayed/{time}` will return the same JSON as explained above, but the request will be delayed for the amount of time passed as parameter.


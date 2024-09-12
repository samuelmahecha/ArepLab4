## Taller de de modularización con virtualización e Introducción a Docker

### Overview

This project involves developing a web application that interacts with a REST service and a MongoDB database using a Round Robin load balancing algorithm. The application consists of a MongoDB instance running in a Docker container on an EC2 virtual machine and a REST service that handles data storage and retrieval. Additionally, a web application is implemented with a client that interacts with the REST service.
### Key Features

**MongoDB Service**: Running in a Docker container on an EC2 instance.

**REST Service (LogService)**:

  * Receives a text string.
  * Stores the string in MongoDB.
  * Responds with a JSON object containing the 10 most recent stored strings and their storage dates.
  * Implements a Round Robin load balancing algorithm across three instances.
    
**Web Application (APP-LB-RoundRobin)**:
  * A web client that allows users to submit messages via a text field and a button.
  * The client updates the screen with JSON responses returned by the REST service.
    
### Components

- **SimpleHttpServer**: The core server class responsible for handling HTTP requests, routing them to the appropriate service methods, and serving static files.
- **HelloService**: A sample service class annotated with @RestController, which includes various endpoints for testing.
- **RequestDetails**: A helper class used to parse HTTP requests, extract the path, and query parameters.
- **Custom Annotations**:
    * @RestController: Marks a class as a controller for handling web requests. 
    * @GetMapping: Maps HTTP GET requests to methods.
    * @RequestParam: Binds query parameters to method parameters.

## Project Setup

This guide outlines the steps to set up and run your project.

**Prerequisites**

Before proceeding, ensure you have the following software installed on your system:

* **Java** (version 1.8.0 or higher): Download and install Java from the official website: https://www.oracle.com/java/technologies/downloads/
    * Verify your installation by running:
        ```bash
        mvn -version
        ```
      You should see output similar to:

        ```
        Apache Maven 3.x.x (unique identifier)
        Maven home: /path/to/maven
        Java version: 1.8.0, vendor: Oracle Corporation
        Java home: /path/to/java/jdk1.8.0.jdk/Contents/Home
        ...
        ```
* **Git:** Install Git by following the instructions on the official Git website: https://git-scm.com/downloads
    * Verify your installation by running:
        ```bash
        git --version
        ```
      This should output your Git version, for example:

        ```
        git version 2.34.1
        ```

**Installing the Project**

1. **Clone the Repository:**
    ```bash
    https://github.com/samuelmahecha/Arep4Lab.git
    ```
2. **Navigate to the Project Directory:**
    ```bash
    cd Arep4Lab
    ```

**Building the Project**

1. **Compile and Package:**
    * Run the following command to build the project using Maven:
        ```bash
        mvn package
        ```
    * This will compile your code and create a JAR file in the `target` directory. You should see output similar to:

        ```
        [INFO] Building jar:(https://github.com/samuelmahecha/Lab4Arep.git-1.0-SNAPSHOT.jar
        [INFO] BUILD SUCCESS
        ```

# Project Setup

## Prerequisites

Before proceeding, ensure you have the following software installed on your system:

* **Java** (version 1.8.0 or higher): Download and install from the official website [here](https://www.java.com/en/download/).
* **Git**: Install following instructions on the [Git official site](https://git-scm.com/book/en/v2/Getting-Started-Installing-Git).
* **Docker**: For running MongoDB and load balancer.

## Setting Up the Environment

1. **Install and Configure MongoDB on Docker**
   * **Download and start MongoDB in Docker**:

   ```bash
   docker pull mongo:3.6.1
   docker run -d -p 27017:27017 --name mongodb mongo:3.6.1
    
## Dependencies
- **Maven**: The project uses Maven to manage dependencies and build the project.
- **JUnit 4**: The project uses JUnit 4 for unit testing.

---------


### Usability Test and video ###
      


https://github.com/user-attachments/assets/c6da89bd-1d83-4031-9ad8-224b39fdb949


![image](https://github.com/user-attachments/assets/5434498d-757b-4e83-ba7b-d3e6a8c9435b)




### Interaction Flow

***Request Handling***:

* SimpleHttpServer listens for incoming HTTP requests on a specified port (e.g., 34001). When a request is received, the server parses the request to determine the path and query parameters.

* For requests targeting the /log endpoint, the server forwards the request to the appropriate instance of the LogService using Round Robin load balancing. This ensures that each request is handled by one of the three LogService instances in a rotating manner.

* For static file requests (e.g., HTML, CSS, JavaScript), the server reads the file from the resources directory and serves it to the client.
  
### Relationships Between Classes

***SimpleHttpServer and HelloService**:

* SimpleHttpServer interacts with LogService by using Round Robin load balancing to distribute incoming requests among multiple LogService instances. The server forwards POST requests to LogService for processing.

* RequestDetails is used by SimpleHttpServer to parse incoming HTTP requests, extract path and query parameters, and manage the request routing.

* The Web Client sends user-submitted messages to LogService and updates the display with the JSON responses received. It uses AJAX or Fetch API to communicate with the REST service and handle updates asynchronously.
----------

## Generating Project Documentation

1. **Generate the Site**
    - Run the following command to generate the site documentation:
      ```sh
      mvn site
      ```

2. **Add Javadoc Plugin for Documentation**
    - Add the Javadoc plugin to the `reporting` section of the `pom.xml`:
      ```xml
      <project>
        ...
        <reporting>
          <plugins>
            <plugin>
              <groupId>org.apache.maven.plugins</groupId>
              <artifactId>maven-javadoc-plugin</artifactId>
              <version>2.10.1</version>
              <configuration>
                ...
              </configuration>
            </plugin>
          </plugins>
        </reporting>
        ...
      </project>
      ```

    - To generate Javadoc as an independent element, add the plugin in the `build` section of the `pom.xml`:
      ```xml
      <project>
        ...
        <build>
          <plugins>
            <plugin>
              <groupId>org.apache.maven.plugins</groupId>
              <artifactId>maven-javadoc-plugin</artifactId>
              <version>2.10.1</version>
              <configuration>
                ...
              </configuration>
            </plugin>
          </plugins>
        </build>
        ...
      </project>
      ```

3. **Generate Javadoc Commands**
    - Use the following commands to generate Javadocs:
      ```sh
      mvn javadoc:javadoc
      mvn javadoc:jar
      mvn javadoc:aggregate
      mvn javadoc:aggregate-jar
      mvn javadoc:test-javadoc
      mvn javadoc:test-jar
      mvn javadoc:test-aggregate
      mvn javadoc:test-aggregate-jar
      ```

---------

## License
This project is licensed under the MIT License - see the [LICENSE](LICENSE.txt) file for details.

----------
## Author
Jose Samuel Mahecha Alarcon - @samuelmahecha

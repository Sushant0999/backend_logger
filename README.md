# Backend Logger

## Overview
Backend Logger is a Spring Boot project designed for logging various backend events and messages. This project utilizes Spring Boot, Logback, and Thymeleaf for logging and displaying results in a web application. The logs are configured to be stored in files, and the application provides a basic UI to view the logs.

## Features
- **Log requests and system events:** Capture important events and requests in your backend system.
- **Display logs on a web interface using Thymeleaf:** Easily view logs through a user-friendly web interface.
- **Customize log file configuration:** Modify logging settings via `application.properties` or `logback-spring.xml` for flexible configuration.
- **Pass a `.txt` file path for external logging:** Easily log data from external files by specifying the file path.

## Prerequisites
Before you begin, ensure you have met the following requirements:
- **Java 11+**: Ensure you have Java installed on your system.
- **Maven**: This project uses Maven for dependency management.
- **Spring Boot**: Familiarity with Spring Boot will be helpful.

## How to Use

### 1. Clone the Repository
Clone the project repository using the following command:

```bash
git clone https://github.com/Sushant0999/backend_logger.git
```
2. Open the Project
Open the project in your preferred Integrated Development Environment (IDE) such as IntelliJ IDEA, Eclipse, etc. Ensure that Maven is installed and all dependencies are resolved.

3. Pass the .txt File Path
To specify a .txt file path for logging purposes, modify the application.properties file by adding the following line:

properties
```
logger.file.path=/path/to/your/logfile.txt
```
Make sure the specified file exists and has the necessary read/write permissions.

4. Configure Logging (Optional)
You can modify the logging configuration by editing src/main/resources/application.properties or logback-spring.xml according to your requirements. The default configuration logs information to a file in the /logs directory.

5. Run the Application
You can run the application using either Maven or from within your IDE:

Using Maven
```
mvn spring-boot:run
```
Running the Compiled JAR First, compile the project, then run the JAR file:

```
java -jar target/backend_logger.jar
```
6. Access the Application
Open your web browser and navigate to http://localhost:9191/logs to access the application interface.

7. View the Logs
Logs will be generated in the specified .txt file or in the default logging location. You can view the logs in real-time through the application's interface or by checking the log files directly.

License
This project is licensed under the MIT License. See the LICENSE file for details.

Contributing
If you would like to contribute to this project, please fork the repository and submit a pull request. For major changes, please open an issue first to discuss what you would like to change.

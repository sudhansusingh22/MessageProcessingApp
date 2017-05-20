## Message Processing Application 

#### Assumptions:
* Input data from source is provided in XML format.

#### Maven Project:
* Java 1.8

### Dependencies:
* `Log4j`

### How to Run:
* `cd .\message-processor`
* `mvn clean`
* `mvn compile` 
* `mvn package`
* `mvn exec:java -Dexec.mainClass="com.jpm.msg.prc.app.App"`

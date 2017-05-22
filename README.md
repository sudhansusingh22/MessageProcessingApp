## Message Processing Application 

### Assumptions:
* Input data from source is provided in XML format.

### Maven Project:
* Java 1.8
* JUnit 4

### Dependencies:
* `Log4j`

### How to Run:
* Step 1: Navigate to project directory-  
```
cd .\message-processor
```
* Step 2: Perform a clean-  `mvn clean`
```
C:\Users\sud\workspace\message-processor>mvn clean
[INFO] Scanning for projects...
[INFO]
[INFO] ------------------------------------------------------------------------
[INFO] Building msg.prc 0.0.1
[INFO] ------------------------------------------------------------------------
[INFO]
[INFO] --- maven-clean-plugin:2.5:clean (default-clean) @ msg.prc ---
[INFO] Deleting C:\Users\sud\workspace\message-processor\target
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time: 0.387 s
[INFO] Finished at: 2017-05-20T13:32:18-04:00
[INFO] Final Memory: 6M/121M
[INFO] ------------------------------------------------------------------------

C:\Users\sud\workspace\message-processor>
```
* Step 3: Compile the source files- `mvn compile` 
```
C:\Users\sud\workspace\message-processor>mvn compile
[INFO] Scanning for projects...
[INFO]
[INFO] ------------------------------------------------------------------------
[INFO] Building msg.prc 0.0.1
[INFO] ------------------------------------------------------------------------
[INFO]
[INFO] --- maven-resources-plugin:2.6:resources (default-resources) @ msg.prc ---
[INFO] Using 'UTF-8' encoding to copy filtered resources.
[INFO] Copying 5 resources
[INFO]
[INFO] --- maven-compiler-plugin:3.6.1:compile (default-compile) @ msg.prc ---
[INFO] Changes detected - recompiling the module!
[INFO] Compiling 11 source files to C:\Users\sud\workspace\message-processor\target\classes
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time: 2.391 s
[INFO] Finished at: 2017-05-20T13:36:18-04:00
[INFO] Final Memory: 14M/211M
[INFO] ------------------------------------------------------------------------

C:\Users\sud\workspace\message-processor>
```
* Step 4: Create source `Jar`- `mvn package`
```
C:\Users\sud\workspace\message-processor>mvn package
[INFO] Scanning for projects...
[INFO]
[INFO] ------------------------------------------------------------------------
[INFO] Building msg.prc 0.0.1
[INFO] ------------------------------------------------------------------------
[INFO]
[INFO] --- maven-resources-plugin:2.6:resources (default-resources) @ msg.prc ---
[INFO] Using 'UTF-8' encoding to copy filtered resources.
[INFO] Copying 5 resources
[INFO]
[INFO] --- maven-compiler-plugin:3.6.1:compile (default-compile) @ msg.prc ---
[INFO] Nothing to compile - all classes are up to date
[INFO]
[INFO] --- maven-resources-plugin:2.6:testResources (default-testResources) @ msg.prc ---
[INFO] Using 'UTF-8' encoding to copy filtered resources.
[INFO] skip non existing resourceDirectory C:\Users\sud\workspace\message-processor\src\test\resources
[INFO]
[INFO] --- maven-compiler-plugin:3.6.1:testCompile (default-testCompile) @ msg.prc ---
[INFO] Changes detected - recompiling the module!
[INFO] Compiling 3 source files to C:\Users\sud\workspace\message-processor\target\test-classes
[INFO]
[INFO] --- maven-surefire-plugin:2.4.3:test (default-test) @ msg.prc ---
[INFO] Surefire report directory: C:\Users\sud\workspace\message-processor\target\surefire-reports

-------------------------------------------------------
 T E S T S
-------------------------------------------------------
Running com.jpm.msg.prc.MessageTest
Tests run: 3, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.134 sec
Running com.jpm.msg.prc.DataControllerTest
41.75
Tests run: 3, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.03 sec
Running com.jpm.msg.prc.AppTest
Tests run: 1, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.009 sec

Results :

Tests run: 7, Failures: 0, Errors: 0, Skipped: 0

[INFO]
[INFO] --- maven-jar-plugin:2.4:jar (default-jar) @ msg.prc ---
[INFO] Building jar: C:\Users\sud\workspace\message-processor\target\msg.prc-0.0.1.jar
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time: 3.728 s
[INFO] Finished at: 2017-05-20T13:36:51-04:00
[INFO] Final Memory: 15M/162M
[INFO] ------------------------------------------------------------------------

C:\Users\sud\workspace\message-processor>
```
* Step 5: Execute the App-
```
mvn exec:java -Dexec.mainClass="com.jpm.msg.prc.app.App"

```
* Step 6: Test the App- `mvn test`
```
-------------------------------------------------------
 T E S T S
-------------------------------------------------------
Running com.jpm.msg.prc.MessageTest
Tests run: 4, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.146 sec
Running com.jpm.msg.prc.DataControllerTest
Tests run: 3, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.025 sec
Running com.jpm.msg.prc.AppTest
Tests run: 1, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.009 sec

Results :

Tests run: 8, Failures: 0, Errors: 0, Skipped: 0

[INFO] ------------------------------------------------------------------------
```


### Sample Output:
```
>>> Report after 10 sales: 

 ******************************************* 
|       Product Name|       Price|  Quantity|
|*******************|************|**********|
|             BANANA|       83.25|        25|
|              APPLE|       31.01|         2|
|             CHERRY|        6.20|         1|
|          PINEAPPLE|      106.80|        12|
|              MANGO|     1657.30|        65|
|-------------------|------------|----------|
|              Total|     1884.56|       105|
 ------------------------------------------- 

>>> Report after 20 sales: 

 ******************************************* 
|       Product Name|       Price|  Quantity|
|*******************|************|**********|
|             BANANA|     -139.00|        25|
|              APPLE|       11.55|         3|
|             CHERRY|     23.8640|         1|
|          PINEAPPLE|     1292.02|        75|
|              MANGO|     1708.98|        84|
|-------------------|------------|----------|
|              Total|   2897.4140|       188|
 ------------------------------------------- 

>>> Report after 30 sales: 

 ******************************************* 
|       Product Name|       Price|  Quantity|
|*******************|************|**********|
|             BANANA|      677.56|        47|
|             ORANGE|      255.13|        31|
|              APPLE|      280.85|        24|
|             CHERRY|     23.8640|         1|
|          PINEAPPLE|     1292.02|        75|
|              MANGO|     1728.37|        86|
|-------------------|------------|----------|
|              Total|   4257.7940|       264|
 ------------------------------------------- 

>>> Report after 40 sales: 

 ******************************************* 
|       Product Name|       Price|  Quantity|
|*******************|************|**********|
|             BANANA|      844.41|        47|
|             ORANGE|    848.0185|        54|
|              APPLE|      -70.25|        25|
|             CHERRY|   67.373440|         1|
|          PINEAPPLE|     1338.22|        81|
|              MANGO|     1728.37|        86|
|-------------------|------------|----------|
|              Total| 4756.141940|       294|
 ------------------------------------------- 

>>> Report after 50 sales: 

 ******************************************* 
|       Product Name|       Price|  Quantity|
|*******************|************|**********|
|             BANANA|   7289.7300|        47|
|             ORANGE|    217.7585|        67|
|              APPLE|     -177.35|        27|
|             CHERRY|   44.173440|         1|
|          PINEAPPLE|     1810.90|       124|
|              MANGO|     1728.37|        86|
|-------------------|------------|----------|
|              Total|10913.581940|       352|
 ------------------------------------------- 

>>> 50 Messages processed! Adjustment Report:

 ********************************************************************************************* 
|    Product Name|       Operation|       Price|  Quantity|   Previous Amount|      New Amount|
|****************|****************|************|**********|******************|****************|
|          BANANA|             ADD|       11.89|         0|                 0|               0|
|           MANGO|             ADD|         2.3|         0|                 0|               0|
|           APPLE|             ADD|         3.1|         2|             24.81|           31.01|
|           APPLE|        SUBTRACT|       11.39|         2|             31.01|            8.23|
|          CHERRY|        MULTIPLY|        7.27|         1|              6.20|         45.0740|
|          ORANGE|        MULTIPLY|       16.00|         0|                 0|               0|
|          BANANA|        SUBTRACT|       11.22|        25|             83.25|         -197.25|
|          CHERRY|        SUBTRACT|       21.21|         1|           45.0740|         23.8640|
|          BANANA|             ADD|        2.33|        25|           -197.25|         -139.00|
|           APPLE|             ADD|        1.21|        23|            247.17|          275.00|
|          BANANA|             ADD|       13.32|        47|             51.52|          677.56|
|          ORANGE|        SUBTRACT|        3.97|        31|            378.20|          255.13|
|           APPLE|        SUBTRACT|        9.35|        24|            280.85|           56.45|
|          CHERRY|        MULTIPLY|        3.21|         1|           23.8640|       76.603440|
|          BANANA|             ADD|        3.55|        47|            677.56|          844.41|
|          ORANGE|        SUBTRACT|        1.39|        54|            421.19|          346.13|
|          ORANGE|        MULTIPLY|        2.45|        54|            346.13|        848.0185|
|           APPLE|        SUBTRACT|        5.25|        25|             61.00|          -70.25|
|          CHERRY|        SUBTRACT|        9.23|         1|         76.603440|       67.373440|
|          BANANA|             ADD|        1.47|        47|            844.41|          913.50|
|          ORANGE|        SUBTRACT|        9.89|        67|          880.3885|        217.7585|
|          BANANA|        MULTIPLY|        7.98|        47|            913.50|       7289.7300|
|           APPLE|        SUBTRACT|        5.15|        27|            -38.30|         -177.35|
|          CHERRY|        SUBTRACT|        23.2|         1|         67.373440|       44.173440|
 --------------------------------------------------------------------------------------------- 

>>> Exiting the System! 
>>> Goodbye!!
```

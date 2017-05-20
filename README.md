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

### Sample Output:
```
>>> Report after 10 sales: 

 ******************************************* 
|       Product Name|       Price|  Quantity|
|*******************|************|**********|
|             BANANA|       83.25|        25|
|              APPLE|     1163.81|        34|
|             CHERRY|        6.20|         1|
|         STRAWBERRY|      106.80|        12|
|              MANGO|      623.70|        33|
|-------------------|------------|----------|
|              Total|     1983.76|       105|
 ------------------------------------------- 

>>> Report after 20 sales: 

 ******************************************* 
|       Product Name|       Price|  Quantity|
|*******************|************|**********|
|             BANANA|      141.50|        25|
|              APPLE|      398.39|        35|
|             CHERRY|     23.8640|         1|
|         STRAWBERRY|     1343.70|        94|
|              MANGO|      623.70|        33|
|-------------------|------------|----------|
|              Total|   2531.1540|       188|
 ------------------------------------------- 

>>> Report after 30 sales: 

 ******************************************* 
|       Product Name|       Price|  Quantity|
|*******************|************|**********|
|             BANANA|      958.06|        47|
|              APPLE|      718.96|        57|
|             CHERRY|     31.9140|         2|
|         STRAWBERRY|     1343.70|        94|
|              PEACH|      255.13|        31|
|              MANGO|      623.70|        33|
|-------------------|------------|----------|
|              Total|   3931.4640|       264|
 ------------------------------------------- 

>>> Report after 40 sales: 

 ******************************************* 
|       Product Name|       Price|  Quantity|
|*******************|************|**********|
|             BANANA|     1124.91|        47|
|              APPLE|     -113.94|        58|
|             CHERRY|   83.983940|         2|
|         STRAWBERRY|     1389.90|       100|
|              PEACH|    848.0185|        54|
|              MANGO|      623.70|        33|
|-------------------|------------|----------|
|              Total| 3956.572440|       294|
 ------------------------------------------- 

>>> Report after 50 sales: 

 ******************************************* 
|       Product Name|       Price|  Quantity|
|*******************|************|**********|
|             BANANA|     1194.00|        47|
|              APPLE|     -390.99|        60|
|             CHERRY|   37.583940|         2|
|         STRAWBERRY|     1862.58|       143|
|              PEACH| 1737.712830|        67|
|              MANGO|      623.70|        33|
|-------------------|------------|----------|
|              Total| 5064.586770|       352|
 ------------------------------------------- 

>>> 50 Messages processed! Adjustment Report:

 ********************************************************************************************* 
|    Product Name|       Operation|       Price|  Quantity|   Previous Amount|      New Amount|
|****************|****************|************|**********|******************|****************|
|          BANANA|             ADD|       11.89|         0|                 0|               0|
|           MANGO|             ADD|         2.3|         0|                 0|               0|
|           APPLE|             ADD|         3.1|        34|           1058.41|         1163.81|
|           APPLE|        SUBTRACT|       11.39|        34|           1163.81|          776.55|
|          CHERRY|        MULTIPLY|        7.27|         1|              6.20|         45.0740|
|           PEACH|        MULTIPLY|       16.00|         0|                 0|               0|
|           APPLE|        SUBTRACT|       11.22|        34|            776.55|          395.07|
|          CHERRY|        SUBTRACT|       21.21|         1|           45.0740|         23.8640|
|          BANANA|             ADD|        2.33|        25|             83.25|          141.50|
|           APPLE|             ADD|        1.21|        56|            645.35|          713.11|
|          BANANA|             ADD|       13.32|        47|            332.02|          958.06|
|           PEACH|        SUBTRACT|        3.97|        31|            378.20|          255.13|
|           APPLE|        SUBTRACT|        9.35|        57|            718.96|          186.01|
|          CHERRY|        MULTIPLY|        3.21|         2|           31.9140|      102.443940|
|          BANANA|             ADD|        3.55|        47|            958.06|         1124.91|
|           PEACH|        SUBTRACT|        1.39|        54|            421.19|          346.13|
|           PEACH|        MULTIPLY|        2.45|        54|            346.13|        848.0185|
|           APPLE|        SUBTRACT|        5.25|        58|            190.56|         -113.94|
|          CHERRY|        SUBTRACT|        9.23|         2|        102.443940|       83.983940|
|          BANANA|             ADD|        1.47|        47|           1124.91|         1194.00|
|           PEACH|        SUBTRACT|        9.89|        67|          880.3885|        217.7585|
|           PEACH|        MULTIPLY|        7.98|        67|          217.7585|     1737.712830|
|           APPLE|        SUBTRACT|        5.15|        60|            -81.99|         -390.99|
|          CHERRY|        SUBTRACT|        23.2|         2|         83.983940|       37.583940|
 --------------------------------------------------------------------------------------------- 

>>> Exiting the System! 
>>> Goodbye!!
```

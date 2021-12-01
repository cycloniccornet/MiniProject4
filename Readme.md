#Assignment 4 - Software Integreation
## Business Process Modelling and Automation using camunda
A bank has automated the business process of giving loans to private clients.


###Camunda model:

![process diagram.bpmn](src\main\resources\process.PNG)

This project runs the process.bpmn on localhost:8080.
When the process is going the user recives multiple forms to request a loan.
Depending on how the process is going the user will recive an error or a new form page.

If the users income is less than 1000 Dollars, the user is declined for a loan.
When requesting a loan the user gets a loan procentage and an amount. If the loan requestet is above 123456789 the code will throw an error and the user will see this error


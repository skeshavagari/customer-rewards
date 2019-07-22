# customer-rewards

#DB:
This application uses an in memory H2 database.
LocalHost Url for the H2 database console
http://localhost:8080/h2-console

JDBC URL: jdbc:h2:mem:sarika
USER NAME: sa
Password:

#
This application exposes rest end point to create a customer record and returns the customer number.
LocalHost Url: This is a HTTP POST call
http://localhost:8080/customer/createCustomer?firstName=Sarika&lastName=Keshavagari&phoneNumber=123456


#
This application exposes a rest end point to add rewards to a customer for their purchase amount.

LocalHost Url: This is a HTTP POST call
http://localhost:8080/customerreward/addrewards?customerId=1&purchaseAmount=150


#
This application exposes a rest end point to get the total rewards earned by a customer.

LocalHost Url: This is a HTTP GET call
http://localhost:8080/customerreward/getTotalRewardsByCustomerId?customerId=1

#This application exposes a rest end point to get the total rewards earned by a customer in a given month. Assuming the data exists only for the year of 2019. We can extend logic to cover the year if required. This end  point accepts the corresponding numeric value for a month.

LocalHost Url: This is a HTTP Get call
http://localhost:8080/customerreward/getTotalRewardsByCustomerIdAndMonth?customerId=1&month=4


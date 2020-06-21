Feature: HouseJoy Booking flow
 
	 @Test
Scenario Outline: User book the car cleaning service
	Given user go to the CarJoy website
	And user perform the login
	And user validates the successful login
	When user go to "<service>" section
	Then user validate the "<service>" section is opened successfully
	Then user select car quantity as "<noOfCars>" 
	Then user add service to the cart and validate the "<noOfCars>" services is added successfully in cart
	Then user choose the address as "<address>" for service
	And user schedule the service after "<noOfDays>" days and at "<time>"
	Then user validate the order summary page
	Then user book the order and validate order confirmation page
	Then user cancel the order 
	Examples:
	|service|noOfCars|address|noOfDays|time|
	|car service|1|existing address|3|afternoon|
@database
Feature: FourStay db testing

Background:
		Given I am on the fourstay login dialog

Scenario Outline: Verify user information
		When I am entering "<email>" and "<password>"
		And I click login button
		And I click edit profile
		And I capture first name,last name,email,phone number
		And I connect database and capture first name,last name,email,phone number
		Then verify the info from UI and Database are the same
		
		Examples:
		| email                 | password |
		| sking@testmail.com    | password |
		| dlorentz@testmail.com | password |
	#	| daustin@testmail.com  | password |
	#	| isciarra@testmail.com | password |	
	#	| imikkili@testmail.com | password |
	#	| jnayer@testmail.com	| password |
	#	| shiggins@testmail.com | password |
	#	| acabrio@testmail.com  | password |
	#	| rperkins@testmail.com | password |
	#	| doconnel@testmail.com | password |
	

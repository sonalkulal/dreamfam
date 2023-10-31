Feature: Scenarios mentioned in this file will test the search component for different products

Scenario: Verify search results for Top
	Given Application is launched completely
	When User searches Top in search component
	Then All results must contain Top word in the product title
	


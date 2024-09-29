Feature: Homepage functionality
@sanity
Scenario: Validation of title of page
Given I am at the landing page
Then page title should contains "Shopping"

@functional
Scenario: verify cart icon 
Given I am at the landing page
Then cart icon should get display

@regression
Scenario: checkout amazon miniTV
Given I am at the landing page
When I clicked on MiniTV icon
Then MiniTV homepage should open
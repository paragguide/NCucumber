Feature: Amazon Project
  I want to use this template for testing amazon.com website
  
  @amazon @uid
  Scenario: tesing userid is valid
    Given I execute testname "UidTest" open "chrome" with url "https://www.amazon.in" and create report "Login"
    And click on signin link
    When I enter valid userid "paragguide@yahoo.co.in"
    And click continue button
    Then I validate the userid
  
  @amazon @pwd  
  Scenario: testing password  
    Given userid is valid
    When i enter password "RMinfotech12#&&"
    Then i should login
  
  @amazon @product  
  Scenario Outline: Product search
    Given i am loggedin
    When i search for product <product> in range <price>
    Then i should get results  
    
  Examples: 
  |  product | price |
  | Shirt | 500 |
  | Pant | 1500 |
  | Tie | 300 |

  
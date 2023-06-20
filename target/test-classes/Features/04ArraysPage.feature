@array
Feature: User launch dsalgo application and test Array page

  Background: The user is logged in to DS Algo portal
    Given The user is on Signin page of DS Algo portal
    When The user enter valid "username" and "dsalgo123"
    And The user click on login button
    Then The user redirected to homepage

  @TS_array_02
  Scenario: The user is able to navigate to "ARRAY" Data Structure Page
    Given The user is on the "home page" after logged in
    When The user select Array item from the drop down menu
    Then The user be directed to "Array" Data Structure Page

  @TS_array_03
  Scenario: The user is able to navigate to Arrays in Python page
    Given The user is on the "Array page" after logged in
    When The user clicks Arrays in Python link
    Then The user should be redirected to "Arrays in Python" page

  @TS_array_04
  Scenario: The user is able to navigate to a page having an tryEditor from Arrays in Python page
    Given The user is on the "Arrays in Python page" after logged in
    When The user clicks "Try Here" button on "Arrays in Python" page
    Then The user should be redirected to a page having an tryEditor with a Run button to test

  @TS_array_05
  Scenario Outline: The user is able run code in tryEditor for Arrays in Python page
    Given The user is in a page having an tryEditor with a Run button to test
    When The user enter valid python code in tryEditor from sheet "<Sheetname>" and <RowNumber>
    And The user clicks on run button
    Then The user should be presented with Run result

    Examples: 
      | Sheetname  | RowNumber |
      | pythonCode |         0 |

  @TS_array_06
  Scenario Outline: The user is presented with error message for code with invalid syntax in tryEditor for Arrays in Python page
    Given The user is in a page having an tryEditor with a Run button to test
    When The user enter python code with invalid syntax in tryEditor from sheet "<Sheetname>" and <RowNumber>
    And The user clicks on run button
    Then The user should be presented with error message as "NameError: name 'hello' is not defined on line 1"

    Examples: 
      | Sheetname  | RowNumber |
      | pythonCode |         1 |


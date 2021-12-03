Feature: Herekuapp test

  @outline
  Scenario Outline: Test 5 links of herekuapp
    Given user navigate to HerekuApp home page
    When user clicks on "<link>"
    Then user should see "<page header>"
    Examples:
      | link            | page header     |
      | File Download   | File Downloader |
      | Hovers          | Hovers          |
      | Redirect Link   | Redirection     |
      | Frames          | Frames          |
      | Forgot Password | Forgot Password |


    @datatable
  Scenario:Validate checkbox test and checkbox statuses
    When user navigates to Checkboxes page
    Then user should see checkboxed as follows:
      | checkbox1Text   | checkbox 1 |
      | checkbox2Text   | checkbox 2 |
      | checkBox1Status | unchecked  |
      | checkBox2Status | checked    |



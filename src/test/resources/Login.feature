Feature: Launch Google application

  @test
  Scenario: Launch Google
    Given the user launches demoblaze application
    Then count the number of items having price 790

    @test1
    Scenario: To test dropdown
      Given the user launches dropdown application
      Then test dropdown

      @test2
      Scenario: To practice actions class
        Given the user launches dropdown application
        Then do right click and mouse hover

        @test3
        Scenario: To print all links on page
          Given the user launches dropdown application
          Then print all links from the page

  @test4
  Scenario: To print all links on page
    Given the user launches demoblaze application
    Then the user prints all links starting with s

    @test4
    Scenario : To navigate to toolsqa and hover
      Given the user launches toolsqa
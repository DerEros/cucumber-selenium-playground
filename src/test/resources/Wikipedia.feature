Feature: Wikipedia Website
    Some UI tests on the Wikipedia Website

    Scenario: Open the entry page
        Given a browser window
        When navigating to "https://wikipedia.org"
        Then the page title is "Wikipedia"

    Scenario: Open the entry page
        Given a browser window
        When navigating to "https://google.com"
        Then the page title is "Wikipedia"

    Scenario: Create new distribution elements if needed
        Given a browser on page "http://foo.bar"
        When navigating to menu item "PT/Status"
        And open last item in section "Status : 40"
        And open tab 2 with URL "http://bar.foo"
        And in tab 2 create element and fill in demo data "xyz"
        And in tab 2 click buttom "Speichern"
        And refresh page
        Then field "Fachbereich" contains "foobar"
        And field "Fachabteilung" contains "barfoo"

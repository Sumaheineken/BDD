Feature: Create Vendor Features Test
  Background: Verifying Create Vendor scenarios
  Scenario: Create Vendor and submit Global Request
    Given Login as LDR Vendor
    Then select option to create vendor
#    And disable local data
#    And disable bank data
#    Then fill Vendor Global data and validate
#    And verify Duplicate check and submit Global request
#    Then perform Process Information check
#    And close session current user
#    Then User opened the browser and url "<browser>"
#    When Login as GDA direct environment
#    Then search for RequestID
#    And GDA open RequestID and perform validate and Duplicate check and Approve Global Request
#    Then perform Process Information check
#    And verify GlobalID

  Scenario Outline: Create Vendor and submit Global Request
    Given Login as LDR Vendor<LDRVendor>, <Password>
    Then Create Material using global data
    And Store the request Id
    And go to process information and check for the approvals
    When GDA approves the global data
    And go to process information and check for the approvals
    Then check the global id
    Examples:
      |LDRVendor |
      |MDVM_BE01_LDR|

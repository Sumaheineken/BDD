Feature: Create Material Features Test
  Background: Verifying Create Material scenarios

  Scenario Outline: Create Vendor and submit Global Request
    Given Login as LDR Vendor<LDRVendor>, <Password>
    Then Create Material using global data <Description>,<MaterialGroup>,<GrossWeightBaseUoM>,<UnitofWeight>,<BaseUoM>,<NetWeightBaseUoM>
    And Store the request Id
    And go to process information and check for the approvals
    When GDA approves the global data
    And go to process information and check for the approvals
    Then check the global id
    Examples:
      |LDRVendor    |Password  |Description                       |MaterialGroup|GrossWeightBaseUoM|UnitofWeight|BaseUoM|NetWeightBaseUoM|
      |MDVM_BE01_LDR|Heineken01|Lens Niet Verlicht 82mm MAES 2016 |CMG0472       |200.000          |G           |PC     |200.000         |

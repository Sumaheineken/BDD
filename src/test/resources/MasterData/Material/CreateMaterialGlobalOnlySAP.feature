#Author:

@tag
Feature: Create Material

  Scenario Outline: Create Material Global Only SAP
    Given User logged in as Local Data Requester <MDMM_Opcos_LDR>
    When User wants to create material for material type "Production | Raw material, ingredient or processing aid" in SAP
    Then Material should be created for material type in SAP
    And user perform process information check
    Then User logged in as Global Data Administrator <MDM_GDA>
    And GDA review and approve the request
    And user perform process information check

  Examples:
    | MDMM_Opcos_LDR     | MDM_GDA |
    | MDMM_BE01_LDR      | MDM_GDA |

  Scenario Outline: Create Material Save as Draft SAP
    Given User logged in as Local Data Requester <MDMM_Opcos_LDR>
    When User wants to create material for material type "Production | Raw material, ingredient or processing aid" in SAP
    Then Material should be saved as draft for material type in SAP
    And user perform process information check
      #Then LDR logged in with <MDMM_Opcos_LDR> and submit the saved draft material
    Then LDR logged in with <MDMM_Opcos_LDR> and resubmit the request
    And user perform process information check
    Then User logged in as Global Data Administrator <MDM_GDA>
    And GDA review and approve the request
    And user perform process information check

  Examples:
    | MDMM_Opcos_LDR | MDM_GDA  |
    | MDMM_BE01_LDR  | MDM_GDA  |

  Scenario Outline: Create Material with Questionnaire only Global with Rejections and approve SAP
    Given User logged in as Local Data Requester <MDMM_Opcos_LDR>
    When User wants to create material for material type "Production | Raw material, ingredient or processing aid" in SAP
    Then Material should be created for material type in SAP
    And user perform process information check
    Then User logged in as Global Data Administrator <MDM_GDA>
    And GDA review and reject the request
    And user perform process information check
    Then LDR logged in with <MDMM_Opcos_LDR> and resubmit the request
    And user perform process information check
    Then User logged in as Global Data Administrator <MDM_GDA>
    And GDA review and approve the request
    And user perform process information check

  Examples:
    | MDMM_Opcos_LDR | MDM_GDA  |
    | MDMM_BE01_LDR  | MDM_GDA  |

  Scenario Outline: Create Material with Questionnaire only Global with Rejections and Discard
    Given User logged in as Local Data Requester <MDMM_Opcos_LDR>
    When User wants to create material for material type "Production | Raw material, ingredient or processing aid" in SAP
    Then Material should be created for material type in SAP
    And user perform process information check
    Then User logged in as Global Data Administrator <MDM_GDA>
    And GDA review and reject the request
    And user perform process information check
    Then LDR logged in with <MDMM_Opcos_LDR> and discard the request
    And user perform process information check
  Examples:
    | MDMM_Opcos_LDR | MDM_GDA  |
    | MDMM_BE01_LDR  | MDM_GDA  |

$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/java/jamie/CucumberProject/featureFiles/Interview.feature");
formatter.feature({
  "line": 1,
  "name": "Interview Test",
  "description": "",
  "id": "interview-test",
  "keyword": "Feature"
});
formatter.before({
  "duration": 4745409100,
  "status": "passed"
});
formatter.scenario({
  "line": 4,
  "name": "Test for interview",
  "description": "",
  "id": "interview-test;test-for-interview",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 3,
      "name": "@jm"
    }
  ]
});
formatter.step({
  "line": 5,
  "name": "the user has logged into the application",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "the air emissions module is selected",
  "keyword": "And "
});
formatter.step({
  "line": 7,
  "name": "a new record is created",
  "keyword": "When "
});
formatter.step({
  "line": 8,
  "name": "the record is deleted",
  "keyword": "And "
});
formatter.step({
  "line": 9,
  "name": "the deletion is verified and the user logs out",
  "keyword": "Then "
});
formatter.match({
  "location": "Steps.userHasLoggedIntoApplication()"
});
formatter.result({
  "duration": 6235343500,
  "status": "passed"
});
formatter.match({
  "location": "Steps.airEmissionsModuleIsSelected()"
});
formatter.result({
  "duration": 3082316500,
  "status": "passed"
});
formatter.match({
  "location": "Steps.newRecordIsCreated()"
});
formatter.result({
  "duration": 5279630900,
  "status": "passed"
});
formatter.match({
  "location": "Steps.recordIsDeleted()"
});
formatter.result({
  "duration": 6438987300,
  "status": "passed"
});
formatter.match({
  "location": "Steps.deletionIsVerifiedAndUserLogsOut()"
});
formatter.result({
  "duration": 3326101700,
  "status": "passed"
});
formatter.after({
  "duration": 2308695400,
  "status": "passed"
});
});
#!/usr/bin/bash

###################################################################################################
#     This is extracting the values for each test suite description.                              #
#     Each grep command extracts the numeric value following the specific                         #
#     label using a positive lookbehind (\K) and the \d+ pattern to match one or more digits.     #
#     The captured values are then assigned to separate variables                                 #
#     The columns printed is based on summary.txt file into the serenity report                   #
#     The columns printed is based on summary.txt file into the serenity report                   #
###################################################################################################

TEST_RESULTS_LOCATION="${1:-/home/runner/work/test-base-metrics/test-base-metrics/target/site/serenity}"
TEST_RESULTS_STRING=$(cat "${TEST_RESULTS_LOCATION}/summary.txt")
# Extract and store the numeric values in separate variables
#echo "TEST_CASES=$(echo "$TEST_RESULTS_STRING" | grep -oP 'Test Cases:\s+\K\d+')"
#echo "PASSED=$(echo "$TEST_RESULTS_STRING" | grep -oP 'Passed:\s+\K\d+')"
#echo "FAILED=$(echo "$TEST_RESULTS_STRING" | grep -oP 'Failed:\s+\K\d+')"
#echo "FAILED_WITH_ERRORS=$(echo "$TEST_RESULTS_STRING" | grep -oP 'Failed with errors:\s+\K\d+')"
#echo "COMPROMISED=$(echo "$TEST_RESULTS_STRING" | grep -oP 'Compromised:\s+\K\d+')"
#echo "PENDING=$(echo "$TEST_RESULTS_STRING" | grep -oP 'Pending:\s+\K\d+')"
#echo "IGNORED=$(echo "$TEST_RESULTS_STRING" | grep -oP 'Ignored:\s+\K\d+')"
#echo "SKIPPED=$(echo "$TEST_RESULTS_STRING" | grep -oP 'Skipped:\s+\K\d+')"

cat <<EOF | curl --data-binary @- ${PUSHGATEWAY_URL}/metrics/job/github_actions
github_actions_test_cases $(echo "$TEST_RESULTS_STRING" | grep -oP 'Test Cases:\s+\K\d+')
github_actions_passed $(echo "$TEST_RESULTS_STRING" | grep -oP 'Passed:\s+\K\d+')
github_actions_failed $(echo "$TEST_RESULTS_STRING" | grep -oP 'Failed:\s+\K\d+')
github_actions_failed_with_errors $(echo "$TEST_RESULTS_STRING" | grep -oP 'Failed with errors:\s+\K\d+')
github_actions_compromised $(echo "$TEST_RESULTS_STRING" | grep -oP 'Compromised:\s+\K\d+')
github_actions_pending $(echo "$TEST_RESULTS_STRING" | grep -oP 'Pending:\s+\K\d+')
github_actions_ignored $(echo "$TEST_RESULTS_STRING" | grep -oP 'Ignored:\s+\K\d+')
github_actions_skipped $(echo "$TEST_RESULTS_STRING" | grep -oP 'Skipped:\s+\K\d+')
EOF


CURRENT_DATE=$(date +'%Y%m%d_%H%M%S')
aws s3 cp ${TEST_RESULTS_LOCATION} s3://automation-temp-report/${CURRENT_DATE}/ --recursive

REPORT_URL="https://automation-temp-report.s3.eu-north-1.amazonaws.com/${CURRENT_DATE}/index.html"
echo "Click the following link to the report: "

# Create the link reference
echo -e "\e]8;;${REPORT_URL}\a Test results\e]8;;\a"

#Send report to slack channel
curl -X POST -H "Content-type: application/json" --data "{\"text\":\"The process has been finished. Report: https://automation-temp-report.s3.eu-north-1.amazonaws.com/${CURRENT_DATE}/index.html\"}" ${WEBHOOK_URL}

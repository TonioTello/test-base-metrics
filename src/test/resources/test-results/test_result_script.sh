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
echo "TEST_CASES=$(echo "$TEST_RESULTS_STRING" | grep -oP 'Test Cases:\s+\K\d+')"
echo "PASSED=$(echo "$TEST_RESULTS_STRING" | grep -oP 'Passed:\s+\K\d+')"
echo "FAILED=$(echo "$TEST_RESULTS_STRING" | grep -oP 'Failed:\s+\K\d+')"
echo "FAILED_WITH_ERRORS=$(echo "$TEST_RESULTS_STRING" | grep -oP 'Failed with errors:\s+\K\d+')"
echo "COMPROMISED=$(echo "$TEST_RESULTS_STRING" | grep -oP 'Compromised:\s+\K\d+')"
echo "PENDING=$(echo "$TEST_RESULTS_STRING" | grep -oP 'Pending:\s+\K\d+')"
echo "IGNORED=$(echo "$TEST_RESULTS_STRING" | grep -oP 'Ignored:\s+\K\d+')"
echo "SKIPPED=$(echo "$TEST_RESULTS_STRING" | grep -oP 'Skipped:\s+\K\d+')"

aws s3 cp TEST_RESULTS_LOCATION s3://automation-temp-report/$(date +'%Y%m%d_%H%M%S')/ --recursive

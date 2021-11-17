Feature: Login into Application

Scenario Outline: Positive test validation login
Given Initialize browser with chrome
And Navigate to "http://qaclickacademy.com/" site
And Click on Login link in home page to land on Secure sign in Page
When User enters <username> and <password> and logs in
Then Verify that user is successfully logged in
And close Browser

Examples:
|username									|password						|
|test99@gmail.com					|123456							|
|test199@gmail.com				|1123456						|
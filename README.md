JUnit Automation Test Suite
Project Overview
This project is a JUnit-based automation test suite designed to test various functionalities of a web application. It leverages Selenium WebDriver for browser interactions and includes test cases for common web components such as alerts, file uploads, sliders, and more.

Features
Automated Testing: Covers key web elements and interactions using JUnit and Selenium.
Modular Design: Each test case is organized into individual classes for maintainability.
Reusable Components: Common setup and teardown processes are handled in a BaseTest class.

Test Coverage
Test Class	Description
AlertsTest	Tests JavaScript alerts and dialogs.
AutoCompleteTest	Validates autocomplete fields.
BaseTest	Provides setup and teardown for all test cases.
DatepickerTest	Tests date picker functionality.
DragAndDropTest	Validates drag-and-drop operations.
FileDownloadTest	Verifies file download processes.
FileUploadTest	Ensures correct file upload functionality.
FramesTest	Handles interactions within frames or iframes.
RegistrationTest	Tests user registration workflows.
ResizableTest	Validates resizable element behavior.
SelectableTest	Tests the selection of items from lists.
SliderTest	Verifies slider component behavior.
WebTableTest	Tests operations on web tables (e.g., sorting, filtering).
WindowsTest	Handles multiple browser windows or tabs.
Prerequisites
Java Development Kit (JDK) 8 or higher
Maven (for dependency management and builds)
Selenium WebDriver
A modern web browser (e.g., Chrome, Firefox)

package com.nopcommerce.qa.utility;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.nopcommerce.qa.Enum.TimeUnits;

public class JSEUtility {

	// Execute JavaScript code
    public static void executeJavaScript(WebDriver driver, String script) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript(script);
    }

    // Execute JavaScript code with arguments
    public static void executeJavaScript(WebDriver driver, String script, Object args) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript(script, args);
    }

    // Scroll to the top of the page
    public static void scrollToTop(WebDriver driver) {
        executeJavaScript(driver, "window.scrollTo(0, 0)");
    }

    // Scroll to the bottom of the page
    public static void scrollToBottom(WebDriver driver) {
        executeJavaScript(driver, "window.scrollTo(0, document.body.scrollHeight)");
    }

    // Highlight an element using JavaScript and after few seconds change it again to normal Position
    public static void highlightElement(WebDriver driver, WebElement element) {
        executeJavaScript(driver, "arguments[0].style.border='3px solid red'", element);
        waitForSeconds(driver, TimeUnits.KEEP_HIGHLIGHTED);
     //   executeJavaScript(driver, "arguments[0].style.border=''", element);
    }

    // Get the page title using JavaScript
    public static String getPageTitle(WebDriver driver) {
       JavascriptExecutor js=(JavascriptExecutor)driver;
        return (String)js.executeScript("return document.title;");
    }

    // Wait for a specific duration using JavaScript
    public static void waitForSeconds(WebDriver driver, int seconds) {
        executeJavaScript(driver, "var date = new Date(); var start = date.getTime(); " +
                "var end = start; while(end < start + " + (seconds * 1000) + ") {end = new Date().getTime();}");
    }
    // click on WebElement using javaScript Executor
    public static void clickWithJavaScript(WebDriver driver, WebElement element) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].click();", element);
    }

    // Add more static utility methods as needed for your specific testing requirements
}
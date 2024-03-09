package com.nopcommerce.qa.utility;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Dd {

	// Method to select an option by visible text
	public static void selectByVisibleText(WebElement dropdown, String visibleText) {
		Select select = new Select(dropdown);
		select.selectByVisibleText(visibleText);
	}

	// Method to select an option by value attribute
	public static void selectByValue(WebElement dropdown, String value) {
		Select select = new Select(dropdown);
		select.selectByValue(value);
	}

	// Method to select an option by index
	public static void selectByIndex(WebElement dropdown, int index) {
		Select select = new Select(dropdown);
		select.selectByIndex(index);
	}

	// Method to get the selected option text
	public static String getSelectedOptionText(WebElement dropdown) {
		Select select = new Select(dropdown);
		WebElement selectedOption = select.getFirstSelectedOption();
		return selectedOption.getText();
	}

	// Method to get all options from the dropdown
	public static java.util.List<WebElement> getAllOptions(WebElement dropdown) {
		Select select = new Select(dropdown);
		return select.getOptions();
	}

	// Method to check if a specific option is present in the dropdown
	public static boolean isOptionPresent(WebElement dropdown, String optionText) {
		for (WebElement option : getAllOptions(dropdown)) {
			if (option.getText().equals(optionText)) {
				return true;
			}
		}
		return false;
	}

	
	
}

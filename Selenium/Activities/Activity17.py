from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.firefox.service import Service as FirefoxService
from webdriver_manager.firefox import GeckoDriverManager
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support.select import Select

service = FirefoxService(GeckoDriverManager().install())

# Start the Driver
with webdriver.Firefox(service=service) as driver:
    wait = WebDriverWait(driver, 10)

    driver.get("https://v1.training-support.net/selenium/selects")
    print("Page title is: ", driver.title)

    dropdown_element = driver.find_element(By.TAG_NAME, 'select')
    dropdown_object = Select(dropdown_element)

    # Select Element By Visible Text
    dropdown_object.select_by_visible_text("Option 2")
    print("Selected option",dropdown_object.first_selected_option.text)

    # Select Element By Index
    dropdown_object.select_by_index(3)
    print("Selected option",dropdown_object.first_selected_option.text)

    # Select Element By Value
    dropdown_object.select_by_value("4")
    print("Selected option",dropdown_object.first_selected_option.text)

    # Get all options inside the select as a list
    all_options = dropdown_object.options
    for option in all_options:
        print("Selected option All",option.text)
 
    driver.close()
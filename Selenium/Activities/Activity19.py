from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.firefox.service import Service as FirefoxService
from webdriver_manager.firefox import GeckoDriverManager
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions

service = FirefoxService(GeckoDriverManager().install())

# Start the Driver
with webdriver.Firefox(service=service) as driver:
    wait = WebDriverWait(driver, 10)

    driver.get("https://v1.training-support.net/selenium/javascript-alerts")
    # Print the title of the page
    print("Page title is: ", driver.title)

    confirm_alert = driver.find_element(By.ID,"confirm")
    confirm_alert.click()

    alert = driver.switch_to.alert

    print(alert.text)

    alert.accept()

    # alert.dismiss()

    driver.close()


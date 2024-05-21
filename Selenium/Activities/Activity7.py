from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.firefox.service import Service as FirefoxService
from webdriver_manager.firefox import GeckoDriverManager
from selenium.webdriver.common.action_chains import ActionChains
from selenium.webdriver.common.keys import Keys
from selenium.webdriver.support.ui import WebDriverWait
  
service = FirefoxService(GeckoDriverManager().install())

# Start the Driver
# Set up the Firefox Driver with WebDriverManger
service = FirefoxService(GeckoDriverManager().install())

# Start the Driver
with webdriver.Firefox(service=service) as driver:
    # Declare actions variable
    actions = ActionChains(driver)

    # Navigate to the URL
    driver.get("https://v1.training-support.net/selenium/drag-drop")
    print("Page title is: ", driver.title)

    dropBall = driver.find_element(By.ID,"draggable")
    dropzone1 = driver.find_element(By.ID,"droppable")
    dropzone2 = driver.find_element(By.ID,"dropzone2")

    actions = ActionChains(driver)

    #1. Move ball to dropzone1
    actions.drag_and_drop(dropBall,dropzone1).perform()

    #2.Verify
    if(dropzone1.text.find("Dropped")):
        print("Ball entered Dropzone1")

    #3. Move ball to dropzone
    actions.drag_and_drop(dropBall,dropzone2).perform()

    #4.Verify
    if(dropzone1.text.find("Dropped")):
        print("Ball entered Dropzone2")

    driver.close()
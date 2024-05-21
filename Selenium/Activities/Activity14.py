from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.firefox.service import Service as FirefoxService
from webdriver_manager.firefox import GeckoDriverManager

service = FirefoxService(GeckoDriverManager().install())

# Start the Driver
with webdriver.Firefox(service=service) as driver:
    driver.get("https://v1.training-support.net/selenium/tables")
    print("Home title is: ", driver.title)

    cols = driver.find_elements(By.XPATH,"//table[@id='sortableTable']/thead/tr/th")
    print("Number of columns: " ,len(cols))

    rows = driver.find_elements(By.XPATH,"//table[contains(@id, 'sortableTable')]/tbody/tr")
    print("Number of rows: " ,len(rows));

    secondRowSecondData =  driver.find_element(By.XPATH,"//table[contains(@id,'sortableTable')]/tbody/tr[2]/td[2]")
    print("Second row second data: ",secondRowSecondData.text)

    driver.find_element(By.XPATH,"//table[@id='sortableTable']/thead/tr/th[1]").click()

    secondRowSecondData =  driver.find_element(By.XPATH,"//table[contains(@id,'sortableTable')]/tbody/tr[2]/td[2]")
    print("Second row second data: ",secondRowSecondData.text)

    footerRowData = driver.find_elements(By.XPATH,"//table[@id='sortableTable']/tfoot/tr/th")
    for cell in footerRowData:
        print("Footer Row Data: ",cell.text)


    driver.close();

   
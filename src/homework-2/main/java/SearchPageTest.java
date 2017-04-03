import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class SearchPageTest
{

    public static void main(String[] args) throws InterruptedException
    {
        ChromeDriverManager.getInstance().setup();
        WebDriver chromeDriver = new ChromeDriver();
        chromeDriver.get("http://bing.com");

        WebElement searchField = chromeDriver.findElement(By.className("b_searchbox"));
        searchField.sendKeys("Automation");

        searchField.submit();
        System.out.println(chromeDriver.getTitle());
        List<WebElement> webElements = chromeDriver.findElements(By.cssSelector("h2"));
        webElements.remove(webElements.size()-1);
        webElements.remove(webElements.size()-1);
        for (WebElement item : webElements) {
            System.out.println(item.getText());
        }
        chromeDriver.close();
    }
}

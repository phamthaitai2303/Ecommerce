package Tests;

import Actions.Action_Manage_Login;
import Objects.User;
import Pages.Page_Manage_Login;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertTrue;

public class TC_Manage_Login {

    WebDriver driver = null;
    private String url = "http://103.95.199.151/mobilevn/";
    private String username = "123@gmail.com";
    private String password = "abcdef";
    User user = null;

    @Before
    public void setUp() {
        System.setProperty("webdriver.edge.driver", "./src/Drives/MicrosoftWebDriver.exe");
        driver = new EdgeDriver();
        //System.setProperty("webdriver.chrome.driver", "./src/Drives/chromedriver.exe");
        //driver = new ChromeDriver();
        driver.get(url);
        System.out.println(driver.getTitle());
        user = new User();
        user.setUsername(username);
        user.setPassword(password);
    }

    @Test
    public void TC_Manage_Login_01() {
        try {
            // Call method click_Homepage_Login.
            Action_Manage_Login.click_Homepage_Login(driver);
            // Wait 0.2 second to load Login pop-up.
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // Check these controls such as Username, Password fields
        // and Loin button are displayed.
        Action_Manage_Login.checkDisplayedControls(driver);
    }

    @Test
    public void TC_Manage_Login_02() {
        // Call method check empty data.
        Action_Manage_Login.checkEmptyData(driver, "Email hoặc Số điện thoại không được để trống", "Mật khẩu không được để trống");
    }
}

package Actions;

import Pages.Page_Manage_Login;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Action_Manage_Login {
    public static void click_Homepage_Login(WebDriver driver) {
        driver.findElement(By.xpath(Page_Manage_Login.btn_Homepage_Login)).click();
    }

    private static boolean isUsernameFieldsDisplayed(WebDriver driver) {
        boolean usernameFieldResult = driver.findElement(By.xpath(Page_Manage_Login.txt_LoginPopup_Password)).isDisplayed();
        try {
            assertTrue("There isn't Username field.", usernameFieldResult);
            return true;
        } catch (AssertionError assertionError) {
            assertionError.printStackTrace();
        }
        return false;
    }

    private static boolean isPasswordFieldsDisplayed(WebDriver driver) {
        boolean passwordFieldResult = driver.findElement(By.xpath(Page_Manage_Login.txt_LoginPopup_Password)).isDisplayed();
        try {
            assertTrue("There isn't Password field.", passwordFieldResult);
            return true;
        } catch (AssertionError assertionError) {
            assertionError.printStackTrace();
        }
        return false;
    }

    private static boolean isLoginButtonDisplayed(WebDriver driver) {
        boolean loginButtonResult = driver.findElement(By.xpath(Page_Manage_Login.btn_LoginPopup_Login)).isDisplayed();
        try {
            assertTrue("There isn't Login button.", loginButtonResult);
            return true;
        } catch (AssertionError assertionError) {
            assertionError.printStackTrace();
        }
        return false;
    }

    public static void checkDisplayedControls(WebDriver driver) {
        if (isUsernameFieldsDisplayed(driver) && isPasswordFieldsDisplayed(driver) && isLoginButtonDisplayed(driver))
            System.out.println("There are Username, Password fields and Login button on Login popup!!!");
        else {
            System.out.println("There aren't Username or Password fields or Login button on Login popup!!!");
        }
    }

    public static void checkEmptyData(WebDriver driver, String expectedUsernameMessage, String expectedPasswordMessage) {
        click_LoginPopup_Login(driver);

        String actualUsernameMessage = driver.findElement(By.xpath(Page_Manage_Login.lbl_LoginPopup_UsernameEmpty)).getText();
        String actualPasswordMessage = driver.findElement(By.xpath(Page_Manage_Login.lbl_LoginPopup_PasswordEmpty)).getText();
        try {
            assertEquals("Expected username message is incorrect!!!", expectedUsernameMessage, actualUsernameMessage);
            assertEquals("Expected password message is incorrect!!!", expectedPasswordMessage, actualPasswordMessage);
            System.out.println("Checking validation messages passed!!!");
        } catch (AssertionError assertionError) {
            assertionError.printStackTrace();
        }
    }

    public static void enter_LoginPopup_UsernameAndPassword(WebDriver driver, String username, String password) {
        driver.findElement(By.xpath(Page_Manage_Login.txt_LoginPopup_Username)).clear();
        driver.findElement(By.xpath(Page_Manage_Login.txt_LoginPopup_Username)).sendKeys(username);
        driver.findElement(By.xpath(Page_Manage_Login.txt_LoginPopup_Password)).clear();
        driver.findElement(By.xpath(Page_Manage_Login.txt_LoginPopup_Password)).sendKeys(password);
    }

    public static void click_LoginPopup_Login(WebDriver driver) {
        driver.findElement(By.xpath(Page_Manage_Login.btn_LoginPopup_Login)).click();
    }
}

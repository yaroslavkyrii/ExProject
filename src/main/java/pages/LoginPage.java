package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

    @FindBy(xpath = ".//div[@class='header-bottom__right-icon']//i[@class='icon icon-user-big']")
    private WebElement userIcon;
    @FindBy(xpath = ".//form[@action='https://avic.ua/authorization']//input[@class='validate']")
    private WebElement loginField;
    @FindBy(xpath = ".//input[@class='validate show-password']")
    private WebElement passwordField;
    @FindBy(xpath = ".//button[@class='button-reset main-btn submit main-btn--green']")
    private WebElement signInButton;
    @FindBy(xpath = ".//div[text()=' Неверные данные авторизации.  ']")
    private WebElement invalidAuthorizationMessage;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void clickOnUserIcon(){
        userIcon.click();
    }

    public void clickOnLoginField(){
        loginField.clear();
    }

    public void fillLoginField(){
        loginField.sendKeys("380932714113");
        System.out.println("LogIn was inputted into LoginInput");
    }
    public void fillLoginFieldWithInvalidValue(){
        loginField.sendKeys("980932714113");
        System.out.println("Invalid LogIn was inputted into LoginInput");
    }

    public void clickOnPasswordField(){
        passwordField.clear();
    }

    public void fillPasswordField(){
        passwordField.sendKeys("123456qwerty");
        System.out.println("Password was inputted into InputPass");
    }
    public void fillPasswordFieldWithInvalidValue(){
        passwordField.sendKeys("123456");
        System.out.println("Invalid Password was inputted into InputPass");
    }

    public void clickOnSignIn(){
        signInButton.click();
        System.out.println("Button SignIn was clicked");
    }

    public boolean isInvalidAuthorizationMessage(){
        return invalidAuthorizationMessage.isDisplayed();
    }
}
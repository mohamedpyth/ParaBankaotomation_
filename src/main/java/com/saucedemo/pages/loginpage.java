package com.saucedemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class loginpage extends BasePage  {
    private By usernamefield=By.id("user-name");
    private By passwordfield=By.id("password");
    private By loginButton=By.id("login-button");
    private By errormassage=By.xpath("#login_button_container h3");

    public  void setUsername(String username){
        set(usernamefield ,username);
    }
    public  void setpsword(String password){
        set(passwordfield,password);
    }
    public ProductPage clicklogin(){
        click(loginButton);
        return new ProductPage();
    }
    public ProductPage logInApplication(String username,String password){
        setUsername(username);
        setpsword(password);
        return click(loginButton);

    }
    public String geterrormassage(){
        return  find(errormassage).getText();
    }
}

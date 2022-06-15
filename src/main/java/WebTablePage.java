import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeSuite;

import java.util.ArrayList;
import java.util.List;

public class WebTablePage extends BasePage {
    protected By btn_add = By.id("addNewRecordButton");
    private By tableRow = By.className("rt-tr-group");

    //These locators below can be in different page class, since the Registration form can be tested as a separate component
    private By txt_firstName = By.id("firstName");
    private By txt_lastName = By.id("lastName");
    private By txt_email = By.id("userEmail");
    private By txt_age = By.id("age");
    private By txt_salary = By.id("salary");
    private By txt_department = By.id("department");
    private By btn_submit = By.id("submit");

    public WebTablePage(WebDriver driver) {
        super(driver);
    }

    public void clickOnAddButton() {
        click(btn_add);
    }

    public void setFirstName(String name) {
        writeText(txt_firstName, name);
    }

    public void setLastName(String lastName) {
        writeText(txt_lastName, lastName);
    }

    public void setEmail(String email) {
        writeText(txt_email, email);
    }

    public void setAge(String age) {
        writeText(txt_age, age);
    }

    public void setSalary(String salary) {
        writeText(txt_salary, salary);
    }

    public void setDepartment(String department) {
        writeText(txt_department, department);
    }

    public void clickSubmitButton() {
        click(btn_submit);
    }

//    public void tableOfUsers(){
//        waitVisibility ( table );
//        ArrayList<String> elements = new ArrayList<> ();
//        List<WebElement> elements = driver.findElements ( table );
//        for (WebElement e:elements){
//            String name = e.findElement ( By.xpath ( "//div[text()='First Name']" ) ).getText ();
//            elements.add ( name );
//            String salary = e.findElement ( By.xpath ( "//div[text()='Salary']" ) );
//            elements.add ( salary );
//        }
//
//    }


}


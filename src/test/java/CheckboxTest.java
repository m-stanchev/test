import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckboxTest extends BaseTest {

    /**
     * Click checkbox1 and verify it is checked
     * <p>
     * Test steps:
     * 1. Navigate to  https://the-internet.herokuapp.com/checkboxes
     * 2. Click on checkbox1
     * Expected result:
     * 2. Verify checkbox1 is checked
     */

    @Test
    public void clickCheckbox1() {
        print ( "1.Navigate to  https://the-internet.herokuapp.com/checkboxes" );
        driver.navigate ().to ( Strings.CHECKBOX_URL );
        print ( "2.Click on checkbox1" );
        checkboxPage.checkbox1Click ();
        print ( "3.Verify checkbox1 is checked" );
        Assert.assertTrue ( checkboxPage.isChecked ( checkboxPage.checkbox1 ), "It is not selected" );


    }

    /**
     * Click checkbox2 and verify it is NOT checked
     * <p>
     * Test steps:
     * 1. Navigate to  https://the-internet.herokuapp.com/checkboxes
     * 2. Click on checkbox2 to uncheck it
     * Expected result:
     * 2. Verify checkbox2 is NOT checked
     */

    @Test(priority = 5,groups = "Regression")
    public void uncheckCheckbox2() {
        print ( "1. Navigate to  https://the-internet.herokuapp.com/checkboxes" );
        driver.navigate ().to ( Strings.CHECKBOX_URL );
        print ( "2. Click on checkbox2 to uncheck it" );
        checkboxPage.checkbox2Click ();
        print ( "2.Verify checkbox2 is NOT checked" );
        Assert.assertTrue ( checkboxPage.isUnhecked ( checkboxPage.checkbox2 ), "It is not unchecked" );
    }
}

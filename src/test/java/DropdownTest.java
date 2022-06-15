import org.testng.Assert;
import org.testng.annotations.Test;

public class DropdownTest extends BaseTest {

    /**
     * Choose option1 from dropdown menu
     * <p>
     * Test steps:
     * 1. Navigate to  https://the-internet.herokuapp.com/dropdown
     * 2. Click on dropdown menu
     * 3. Click Option1
     * Expected result:
     * 3. Verify Option1 is chosen
     */

    @Test
    public void chooseFromDropdownOption1() {
        print ( "1. Navigate to  https://the-internet.herokuapp.com/dropdown" );
        driver.navigate ().to ( Strings.DROPDOWN_URL );
        print ( "2. Click on dropdown menu" );
        dropdownPage.dropdownClick ();
        print ( "3. Click Option1" );
        dropdownPage.option1Select ();
        print ( "3. Verify Option1 is chosen" );
        Assert.assertTrue ( dropdownPage.selectedOptions.isDisplayed () );
        //assert isElementPresent ( dropdownPage.selectedOptions ) : "Error. Option is not selected.";
    }

    /**
     * Choose option2 from dropdown menu with Select option
     * <p>
     * Test steps:
     * 1. Navigate to  https://the-internet.herokuapp.com/dropdown
     * 2. With Select option choose Option2
     * Expected result:
     * 3. Verify Option2 is chosen
     */


    @Test
    public void chooseFromDropdownOption2() {
        print ( "1. Navigate to  https://the-internet.herokuapp.com/dropdown" );
        driver.navigate ().to ( Strings.DROPDOWN_URL );
        print ( "2. With Select option choose Option2" );
        dropdownPage.selectFromDropdown ();
        print ( "3. Verify Option2 is chosen" );
        Assert.assertTrue ( dropdownPage.selectedOptions.isDisplayed () );
        //assert isElementPresent ( dropdownPage.selectedOptions ) : "Error. Option is not selected.";
    }
}

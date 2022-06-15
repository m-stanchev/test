import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class AddRemoveElementsTest extends BaseTest {

    /**
     * Add element
     * Test Steps:
     * 1.Navigate to https://the-internet.herokuapp.com/add_remove_elements/
     * 2.Add an element
     * Expected result:
     * 2.Button delete is now shown on the page
     */

    @Test(priority = 5, groups = "Regression")
    public void addElement() {
        print ( "1.Navigate to https://the-internet.herokuapp.com/add_remove_elements/" );
        driver.navigate ().to ( Strings.ADD_REMOVE_URL );
        // AddRemoveElementsPage addRemoveElementsPage = new AddRemoveElementsPage ( driver );
        print ( "2.Add an element" );
        addRemoveElementsPage.addElement ();
        print ( "2.Button delete is now shown on the page" );
        assert isElementPresent ( addRemoveElementsPage.deleteButton ) : "Error. Delete button is not shown";

    }

    /**
     * Add element
     * Test Steps:
     * 1.Navigate to https://the-internet.herokuapp.com/add_remove_elements/
     * 2.Add an element
     * 3. Delete an element
     * Expected result:
     * 2.Button delete is now shown on the page
     * 3. Button delete is not present on page
     */
    @Test(priority = 4, groups = "Regression", dependsOnMethods = {"addElement"})
    public void removeElement() throws IOException {
        print ( "1.Navigate to https://the-internet.herokuapp.com/add_remove_elements/" );
        driver.navigate ().to ( Strings.ADD_REMOVE_URL );
        print ( "2.Add an element" );
        addRemoveElementsPage.addElement ();
        print ( "3. Delete an element" );
        addRemoveElementsPage.removeElement ();
        print ( "3. Button delete is not present on page" );
        Assert.assertEquals ( false, addRemoveElementsPage.equals ( addRemoveElementsPage.deleteButton ) );
        addRemoveElementsPage.takeSs ( driver );
    }
}

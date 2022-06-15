import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class WebTableTest extends BaseTest {
    /**
     * Edit data in table
     * 1. Navigate to https://demoqa.com/webtables
     * 2. Click on edit button of the first user
     * 3. Clear field salary
     * 4. Type new salary
     * 5. Click submit
     * Expected result
     * 5. Value in table is the same as typed value in step 4
     */

    @Test
    public void addNewUserSecondTest() {
        driver.get("https://demoqa.com/webtables");
        webTablePage.clickOnAddButton();
        webTablePage.setFirstName("Jovana");
        webTablePage.setLastName("Pripunic");
        webTablePage.setEmail("jovana.pripunic@testemail");
        webTablePage.setAge("25");
        webTablePage.setSalary("25000");
        webTablePage.setDepartment("QA");
        webTablePage.clickSubmitButton();
    }

}

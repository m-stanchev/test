import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class DynamicControlsTest extends BaseTest {


    /**
     * Remove and add checkbox test
     * Test steps:
     * 1. Navigate to https://the-internet.herokuapp.com/dynamic_controls
     * 2. Click remove button
     * 3.Click Add button
     * <p>
     * Expected result:
     * 2. Checkbox is not shown
     * 2a. Message is shown "It's gone!"
     * 3. Message is shown "It's back!"
     * 3a. Take screenshot of message "It's back!"
     */

    @Test
    public void addCheckboxTest() throws IOException {
        print ( "Navigate to https://the-internet.herokuapp.com/dynamic_controls" );
        driver.navigate ().to ( Strings.DYNAMIC_CONTROLS );
        print ( "Click remove button" );
        dynamicControlsPage.removeAddButtonClick ();
        print ( "2. Checkbox is not shown" );
        Assert.assertEquals ( false, dynamicControlsPage.equals ( dynamicControlsPage.checkbox ) );
        waitForElement ( dynamicControlsPage.itsGoneMsg );
        print ( "2a. Message is shown \"It's gone!\"" );
        Assert.assertTrue ( dynamicControlsPage.itsGoneMsg.getText ().contains ( "It's gone!" ),
                "Notification message is not shown." );
        print ( "3.Click Add button" );
        dynamicControlsPage.removeAddButtonClick ();
        waitForElement ( dynamicControlsPage.checkbox );
        print ( "3. Message is shown \"It's back!\"" );
        Assert.assertTrue ( dynamicControlsPage.itsGoneMsg.getText ().contains ( "It's back!" ),
                "Notification message is not shown." );
        print ( "Take screenshot of message 'It's back!'" );
        dynamicControlsPage.captureButton ();

    }

    /**
     * Enable and disable input field test
     * Test steps:
     * 1. Navigate to https://the-internet.herokuapp.com/dynamic_controls
     * 2. Click enable button
     * 3.Click disable button
     * <p>
     * Expected result:
     * 2. Message is shown "It's enabled!"
     * 3. Message is shown "It's disabled!"
     */

    @Test
    public void disableInputField() throws IOException {
        print ( "Navigate to https://the-internet.herokuapp.com/dynamic_controls" );
        driver.navigate ().to ( Strings.DYNAMIC_CONTROLS );
        print ( "2. Click enable button" );
        dynamicControlsPage.enableButtonClick ();
        waitForElement ( dynamicControlsPage.itsGoneMsg );
        print ( "2. Message is shown \"It's enabled!\"" );
        Assert.assertTrue ( dynamicControlsPage.itsGoneMsg.getText ().contains ( "It's enabled!" ),
                "Notification message is not shown." );
        dynamicControlsPage.typeSomeText ();
        print ( "3.Click disable button" );
        dynamicControlsPage.enableButtonClick ();
        //why we need wait
        dynamicControlsPage.takeSs ( driver );
        waitForElement ( dynamicControlsPage.itsGoneMsg );
        print ( "3. Message is shown \"It's disabled!\"" );
        Assert.assertTrue ( dynamicControlsPage.itsGoneMsg.getText ().contains ( "It's disabled!" ),
                "Notification message is not shown." );


    }
}

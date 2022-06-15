import org.testng.Assert;
import org.testng.annotations.Test;

public class DragAndDropTest extends BaseTest {
    /**
     * Drag and drop A to B
     * Test steps:
     * 1. Navigate to https://the-internet.herokuapp.com/drag_and_drop
     * 2. Drag colimnA to columnB
     * Expected result
     * 2. Verify that column A is on the spot of column B
     */

    @Test
    public void dragAndDropAtoB() throws Exception {
        print ( "1. Navigate to https://the-internet.herokuapp.com/drag_and_drop" );
        driver.navigate ().to ( Strings.DRAG_AND_DROP_URL );
        print ( "2. Drag colimnA to columnB" );
        dragAndDropPage.dragAndDropJS ( dragAndDropPage.columnA, dragAndDropPage.columnB, driver );
        print ( "2. Verify that column A is on the spot of column B" );
        Assert.assertTrue ( dragAndDropPage.columnB.getText ().equals ( "A" ) );
    }
}

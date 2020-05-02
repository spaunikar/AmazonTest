package Actions;

import BaseUtility.MobileBaseUtility;
import io.appium.java_client.TouchAction;
import org.openqa.selenium.Dimension;

import static io.appium.java_client.touch.offset.PointOption.point;

public class Action extends MobileBaseUtility {

    /*
    ----> swipe function is used to swipe at all directions based on the co-ordinates passed to it
     */
    public static void swipe(int startx, int starty, int endx, int endy) {

        TouchAction test = new TouchAction(driver);
        //mention the X,Y offset and start and end points
        test.press(point(startx, starty)).moveTo(point(startx, starty)).perform();
    }

    /*
    ---->this function used to swipe vertically based on percentage
     */
    public static void verticalSwipe(double startpercentage, double endpercentage) {

        Dimension size = driver.manage().window().getSize();
        int width = (int) (size.width / 2);
        int startpoint = (int) (size.getHeight() * startpercentage);
        int endpoint = (int) (size.getHeight() * endpercentage);

        TouchAction test = new TouchAction(driver);

        test.press(point(width, startpoint)).moveTo(point(width, startpoint)).perform();


    }

    /*
    ---->this function used to swipe horizontally based on percentage
     */
    public static void horizontalSwipe(double startpercentage, double endpercentage) {

        Dimension size = driver.manage().window().getSize();
        int Height = (int) (size.height / 2);
        int startpoint = (int) (size.getHeight() * startpercentage);
        int endpoint = (int) (size.getHeight() * endpercentage);

        TouchAction test = new TouchAction(driver);

        test.press(point(startpoint, Height)).moveTo(point(endpoint, Height)).perform();


    }


}

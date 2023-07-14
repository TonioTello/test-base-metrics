package starter.utils;

import org.junit.Assert;

 public class InternalAction {

    public InternalAction() {
    }
    public void logError(String message, Exception e) {
        try {
            String logMessage = message + " : " + e.toString().substring(e.toString().indexOf("org.openqa.selenium"), e.toString().indexOf("(Session info")).replaceAll("\n", "");
            Assert.assertTrue(logMessage, false);

        }catch (Exception ee){
            Assert.assertTrue(message, false);
        }
    }
}

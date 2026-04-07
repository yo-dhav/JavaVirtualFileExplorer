package browtest;
import java.awt.Desktop;
import java.net.URI;

public class browtest {
    public static void main(String[] args) {
        try {
            if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
                Desktop.getDesktop().browse(new URI("http://localhost:8123"));
                System.out.println("Browser should now be open.");
            } else {
                System.out.println("Desktop or browse not supported.");
            }
        } catch (Exception e) {
            System.out.println("Failed to open browser: " + e.getMessage());
        }
    }
}




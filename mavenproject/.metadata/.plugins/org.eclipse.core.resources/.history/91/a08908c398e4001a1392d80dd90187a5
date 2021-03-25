package TesttForDataToWrite;
import java.awt.Desktop;
import java.net.URI;
import java.net.URL;  
public class OpenBrowser {

	public void openBrowser()   
	{  
		try
        {
            URI uri = new URL(getURL()).toURI();
            Desktop desktop = Desktop.isDesktopSupported() ? Desktop.getDesktop() : null;
            if (desktop != null && desktop.isSupported(Desktop.Action.BROWSE))
                desktop.browse(uri);
        }
    catch (Exception e)
        {
            /*
             *  I know this is bad practice 
             *  but we don't want to do anything clever for a specific error
             */
            e.printStackTrace();


        }
		
}
	public static String getURL() {
		return "http://fd719fe8ca31.ngrok.io";
	}
}

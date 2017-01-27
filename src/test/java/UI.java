import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import ui.pages.GooglePage;
import ui.utils.TestListener;


@Listeners(TestListener.class)
public class UI {
    @Test
    public void test(){
        GooglePage googlePage = new GooglePage();
        googlePage.openPage();
    }

}

import com.meteorite.base.Keywords;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class Step {
	Keywords k=new Keywords();
	@Given("open chrome browser")
	public void OpenChrome() {
		
		k.openBrowser(null);
	}
	
	@When("launch application url")
	public void LaunchappUrl() {
		k.launchUrl("https://www.myntra.com");
	}

}

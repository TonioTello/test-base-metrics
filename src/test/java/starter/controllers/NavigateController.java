package starter.controllers;

import net.serenitybdd.core.environment.EnvironmentSpecificConfiguration;
import net.serenitybdd.core.steps.UIInteractions;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.util.EnvironmentVariables;
import org.junit.Assert;

public class NavigateController extends UIInteractions {

    EnvironmentVariables environmentVariables;

    @Step("Navigate to Appmoto home page")
    public void toTheAppmotoHomePage() {
        String app_url = EnvironmentSpecificConfiguration.from(environmentVariables).getProperty("app.url") ;
        openUrl(app_url);
    }

    @Step("Navigate to New Company Page")
    public void toTheAppmotoNewCompanyPage() {
        String url = "https://appmotoqa-dev.lean-tech.io/new-company";
        openUrl(url);
    }

    @Step("Navigate to New Dealer CompanyPage")
    public void toNewDealerCompanyPage() {
        String url = "https://appmotoqa-dev.lean-tech.io/new-company?type=dealer";
        openUrl(url);
    }
    @Step("Navigate to Lender Company Page")
    public void toNewLenderCompanyPage() {
        String url = "https://appmotoqa-dev.lean-tech.io/new-company?type=lender";
        openUrl(url);
    }

    @Step("Navigate to This Url")
    public void toThisUrlPage( String url) {
        if(url.contains("http")){
            openUrl(url);
        }else{
            Assert.assertTrue("The URL is either empty or invalid", false);
        }
    }
}
package ServiceNSW.stepdefinitions;

import ServiceNSW.pages.HomePage;
import ServiceNSW.pages.SearchResultPage;
import ServiceNSW.pages.ServiceCenterPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SearchServiceStepDef {
    HomePage homePage;
    SearchResultPage searchResultPage;
    ServiceCenterPage serviceCenterPage;
    @Given("I already on home page")
    public void iAlreadyOnHomePage(){
        homePage.open();
    }

    @And("I input {string} on search service field")
    public void inputOnSearchServiceField(String service) {
        homePage.inputService(service);
    }

    @And("I click search service button")
    public void iClickSearchServiceButton() {
        homePage.clickSearchServiceButton();
    }

    @Then("should be directed to search result page {string}")
    public void shouldBeDirectedToSearchResultPage(String service) {
        String url = "https://www.service.nsw.gov.au/search-results?q="+service;
        String processCode = url.replaceAll(" ","+").trim();
        assertEquals(processCode, searchResultPage.getUrl());
    }

    @When("I click Find Location button")
    public void iClickFindLocationButton() {
        searchResultPage.clickFindLocationButton();
    }

    @Then("should be directed to Service Center page")
    public void shouldBeDirectedToServiceCenterPage() {
        serviceCenterPage.getUrl();
    }

    @When("I input {string} on search location field")
    public void iInputOnSearchLocationField(String loc) {
        serviceCenterPage.inputLocation(loc);
    }

    @And("I click search location button")
    public void iClickSearchLocationButton() {
        serviceCenterPage.clickSearchLocationButton();
    }

    @Then("search result for location should be appear")
    public void searchResultForLocationShouldBeAppear() {
        assertTrue("Marrickville Service Centre", serviceCenterPage.getLocationResult());
    }
}

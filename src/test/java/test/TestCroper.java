package test;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.ResultPage;
import utils.Driver;

public class TestCroper{
    private HomePage home;
    private ResultPage result;

    @Test(priority = 1)
    public void searchTest(){
        this.home = new HomePage(new Driver().getDriver());
        this.result=home.loadFirstPage();
        String resultSearch = this.result.searchWord();
        System.out.println(resultSearch);
        System.out.println("");
        this.home.close();
    }

    @Test(priority = 2)
    public void checkMenu(){
        this.home = new HomePage(new Driver().getDriver());
        home.menuItemsCheck();
        System.out.println("");
        this.home.close();


    }

    @Test (priority = 3)
    public void checkCarousel(){
        this.home = new HomePage(new Driver().getDriver());
        home.itemsCarousel();
        this.home.close();
    }
}

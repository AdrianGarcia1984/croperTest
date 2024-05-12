package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class ResultPage extends BasePage{

    public ResultPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(partialLinkText = "Filtro")
    private WebElement resultWord;


    public String searchWord (){
        String result= this.getTextFromElement(resultWord);
        System.out.println(driver.getCurrentUrl());
        if (result.toLowerCase().contains("filtro")||driver.getCurrentUrl().contains("filtro")){
            return "el elemento tiene el nombre filtro de aceite";
        }else {
            return "no se encontro ningun elemento";
        }

    }

}

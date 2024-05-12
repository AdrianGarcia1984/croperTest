package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class carouselItems extends BasePage{
    public carouselItems(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath=("/html/body/cp-root/cp-layout/main/div/cp-home/cp-carousel[1]/section/div/cp-carousel-slide[1]/a"))
    private WebElement Item1;
    @FindBy(xpath=("/html/body/cp-root/cp-layout/main/div/cp-home/cp-carousel[1]/section/div/cp-carousel-slide[2]/a"))
    private WebElement Item2;
    @FindBy(xpath=("/html/body/cp-root/cp-layout/main/div/cp-home/cp-carousel[1]/section/div/cp-carousel-slide[3]/a"))
    private WebElement Item3;
    @FindBy(xpath=("/html/body/cp-root/cp-layout/main/div/cp-home/cp-carousel[1]/section/div/cp-carousel-slide[4]/a"))
    private WebElement Item4;
    @FindBy(xpath=("/html/body/cp-root/cp-layout/main/div/cp-home/cp-carousel[1]/section/div/cp-carousel-slide[5]/a"))
    private WebElement Item5;
    @FindBy(xpath=("/html/body/cp-root/cp-layout/main/div/cp-home/cp-carousel[1]/section/div/cp-carousel-slide[6]/a"))
    private WebElement Item6;
    @FindBy(xpath=("/html/body/cp-root/cp-layout/main/div/cp-home/cp-carousel[1]/section/div/cp-carousel-slide[7]/a"))
    private WebElement Item7;

    public WebElement Items (int i) {
        switch (i) {
            case 1:
                return Item1;
            case 2:
                return Item2;
            case 3:
                return Item3;
            case 4:
                return Item4;
            case 5:
                return Item5;
            case 6:
                return Item6;
            case 7:
                return Item7;
        }
        return null;
    }




}

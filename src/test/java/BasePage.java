import com.thoughtworks.gauge.Step;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Random;


public class BasePage  extends BaseTest {
    WebDriverWait wait;

    public MobileElement findElement(By by){
        return appiumDriver.findElement(by);
    }


    public void clickElement(By by) {
        findElement(by).click();
    }

    public void assertion(By by){
        Assert.assertTrue(appiumDriver.findElement(by).isDisplayed());
    }

    public void sendKeys(By by, String value){
        appiumDriver.findElement(by).sendKeys(value);
    }

    public void scrollDown() {
        int startx = 707, starty = 2580, endx = 725, endy = 490;
        TouchAction touchAction = new TouchAction(appiumDriver);
        touchAction.longPress(PointOption.point(startx, starty)).moveTo(PointOption.point(endx, endy)).release().perform();
    }
    public void wait(int i, By by){
        wait = new WebDriverWait(appiumDriver,i);
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    @Step("Uygulamanın açıldığı kontrol edilir.")
    public void isOpen(){
        wait(5,By.id("com.ozdilek.ozdilekteyim:id/iv_storeTopLogo"));
        assertion(By.id("com.ozdilek.ozdilekteyim:id/iv_storeTopLogo"));
        logger.info("Uygulama açık");
    }
    @Step("Alışverişe başla butonuna tıklanır.")
    public void startShop(){
        wait(5,By.id("com.ozdilek.ozdilekteyim:id/tv_startShoppingStore"));
        clickElement(By.id("com.ozdilek.ozdilekteyim:id/tv_startShoppingStore"));
        logger.info("Alışverişe başla butonuna tıklandı.");
    }
    @Step("Alışveriş sayfasının açıldığı doğrulanır.")
    public void isThisShoppingPage(){
        wait(5,By.id("com.ozdilek.ozdilekteyim:id/nav_categories"));
        assertion(By.id("com.ozdilek.ozdilekteyim:id/nav_categories"));
        logger.info("Alışveriş sayfası açıldı.");
    }
    @Step("Kategoriler sayfası açılır.")
    public void categories(){
        wait(5,By.id("com.ozdilek.ozdilekteyim:id/nav_categories"));
        clickElement(By.id("com.ozdilek.ozdilekteyim:id/nav_categories"));
        logger.info("Kategoriler sayfası açıldı.");
    }
    @Step("Kategoriler sayfasının açıldığı doğrulanır.")
    public void isThisCategoriesPage(){
        wait(5,By.xpath("(//*[@resource-id='com.ozdilek.ozdilekteyim:id/relLayCategoriesItem'])[2]"));
        assertion(By.xpath("(//*[@resource-id='com.ozdilek.ozdilekteyim:id/relLayCategoriesItem'])[2]"));
        logger.info("Kategoriler sayfasının açıldığı doğrulandı.");
    }
    @Step("Menüden Kadın seçeneğine tıklanır.")
    public void clickCategoriesWomen(){
        wait(5,By.xpath("(//*[@resource-id='com.ozdilek.ozdilekteyim:id/relLayCategoriesItem'])[2]"));
        clickElement(By.xpath("(//*[@resource-id='com.ozdilek.ozdilekteyim:id/relLayCategoriesItem'])[2]"));
        logger.info("Menüden kadın seçeneğine tıklandı.");
    }
    @Step("Pantolon kategorisi açılır.")
    public void clickPants(){
        wait(5,By.xpath("(//*[@resource-id='com.ozdilek.ozdilekteyim:id/relLayCategoriesItem'])[14]"));
        clickElement(By.xpath("(//*[@resource-id='com.ozdilek.ozdilekteyim:id/relLayCategoriesItem'])[14]"));
        logger.info("Pantolon kategorisi açıldı.");
    }
    @Step("Sayfanın aşağısına scroll yapılır.")
    public void scrollTwoTimes(){
        scrollDown();
    }
    @Step("Ürünlerden rastgele bir ürün seçilir.")
    public void randomProduct(){
        List<MobileElement> elements = appiumDriver.findElements(By.xpath("//*[@resource-id='com.ozdilek.ozdilekteyim:id/imageView']"));
        Random random = new Random();
        int randomInt = random.nextInt(elements.size());
        elements.get(randomInt).click();
    }
    @Step("Ürün detay sayfasının açıldığı kontrol edilir.")
    public void isThisProductDetailPage(){
        wait(5,By.id("com.ozdilek.ozdilekteyim:id/imgInstallmentAtt"));
        assertion(By.id("com.ozdilek.ozdilekteyim:id/imgInstallmentAtt"));
        logger.info("Ürün görüntülendi.");
    }
    @Step("Favoriler butonuna tıklanır.")
    public void addFavorite(){
        wait(5,By.id("com.ozdilek.ozdilekteyim:id/imgFav"));
        clickElement(By.id("com.ozdilek.ozdilekteyim:id/imgFav"));
        logger.info("Favoriler butonuna tıklandı.");
    }
    @Step("Giriş yapma sayfasının açıldığı doğrulanır.")
    public void isThisLoginPage(){
        wait(5,By.id("com.ozdilek.ozdilekteyim:id/btnLogin"));
        assertion(By.id("com.ozdilek.ozdilekteyim:id/btnLogin"));
        logger.info("Giriş sayfası açıldı.");
    }
    @Step("Kullanıcı adı alanına <name> bilgisi verilir.")
    public void sendUserName(String name){
        wait(5,By.id("com.ozdilek.ozdilekteyim:id/etEposta"));
        clickElement(By.id("com.ozdilek.ozdilekteyim:id/etEposta"));
        sendKeys(By.id("com.ozdilek.ozdilekteyim:id/etEposta"),name);
        logger.info("Kullanıcı adı alanına text bilgisi verildi.");
    }
    @Step("Password alanına <password> yazılır.")
    public void sendPassword(String password){
        wait(5,By.id("com.ozdilek.ozdilekteyim:id/etPassword"));
        clickElement(By.id("com.ozdilek.ozdilekteyim:id/etPassword"));
        sendKeys(By.id("com.ozdilek.ozdilekteyim:id/etPassword"),password);
        logger.info("Password alanına şifre girildi.");
    }
    @Step("Geri butonuna <deger> kere tıklanır.")
    public void tapBack(String deger){
        int i = 0;
        while (i< Integer.parseInt(deger)){
            wait(5,By.id("com.ozdilek.ozdilekteyim:id/ivBack"));
            clickElement(By.id("com.ozdilek.ozdilekteyim:id/ivBack"));
            logger.info("Geri butonuna tıklandı.");
            i++;
        }
    }
    @Step("Seçilen ürün sepete eklenir.")
    public void addToCart(){
        wait(5,By.id("com.ozdilek.ozdilekteyim:id/relLayAddCartBtn"));
        clickElement(By.id("com.ozdilek.ozdilekteyim:id/relLayAddCartBtn"));
        logger.info("Sepete ekle butonuna tıklandı.");
    }





/*
    @Step("<int> saniye kadar bekle")
    public void waitForSecond(int second) throws InterruptedException {
        Thread.sleep(1000 + second);

    }

    @Step("<id> li sayfa görünür mü?")
    public void pageControl(String id){
        MobileElement element = appiumDriver.findElement(By.id(id));
        if (element.isDisplayed()){
            System.out.println("Giriş yaptınız");
        }else{
            System.out.println("Yanlış sayfadasınız.");
        }
    }

    @Step("<id> elementin sayfada görünür olduğunu kontrol et ve tıkla")
    public void findElementAndClick(String id) {
        MobileElement element = appiumDriver.findElement(By.id(id));
        if (element.isDisplayed()) {
            element.click();
        } else {
            System.out.println("Element görünür olmalıdır.");
        }
    }

    @Step("Sayfayı aşağı doğru kaydır")
    public void swipeUp() {
        final int ANIMATION_TIME = 200;
        final int PRESS_TIME = 200;
        int edgeBorder = 10;
        Dimension dims = appiumDriver.manage().window().getSize();
        System.out.println("Telefon Ekran Boyutu " + dims);
        PointOption pointOptionStart = PointOption.point(dims.width / 2, dims.height / 2);
        System.out.println("Başlangıç noktası " + pointOptionStart);
        PointOption pointOptionEnd = PointOption.point(dims.width / 2, dims.height / 4);
        System.out.println("Bitiş noktası " + pointOptionEnd);

        try {
            (new TouchAction(appiumDriver)).press(pointOptionStart)
                     .waitAction(WaitOptions.waitOptions(Duration.ofMillis(PRESS_TIME)))
                     .moveTo(pointOptionEnd).release().perform();
        } catch (Exception e) {
            System.err.println("swipeScreen(): TouchAction FAILED\n" + e.getMessage());
            return;
        }

        try {
            Thread.sleep(ANIMATION_TIME);
        } catch (InterruptedException var8) {
        }
    }

    @Step("Xpath'i <xpath> olanı bul ve tıkla")
    public void xpathAndClick(String xpath){
        MobileElement element = appiumDriver.findElement(By.xpath(xpath));
        element.click();
    }
    @Step("Idsi <id> olanı bul ve tıkla")
    public void idAndClick(String id){
       MobileElement element= appiumDriver.findElement(By.id(id));
       element.click();
    }*/
}

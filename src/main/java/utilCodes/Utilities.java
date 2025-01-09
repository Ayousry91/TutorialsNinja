package utilCodes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.Random;

public class Utilities {

    public   String generateRandomString() {
        int length = 4;
        String characters = "abcdefghijklmnopqrstuvwxyz";
        StringBuilder randomString = new StringBuilder();
        Random rnd = new Random();
        while (randomString.length() < length) {
            int index = (int) (rnd.nextFloat() * characters.length());
            randomString.append(characters.charAt(index));
        }

        return randomString.toString();
    }

//    public String generateRandomPhoneNumber() {
//        // Generate a random phone number (you can customize as needed)
//        return "1234567890";
//    }

    public static String generateRandomPhoneNumber() {

        StringBuilder phoneNumber = new StringBuilder();
        Random random = new Random();
        // Ensure the phone number starts with a non-zero digit
        phoneNumber.append(random.nextInt(9) + 1);
        // Generate the remaining 9 digits
        for (int i = 0; i < 9; i++) {phoneNumber.append(random.nextInt(10));}
        return phoneNumber.toString();
    }
    public String generateRandomEmail() {
        return generateRandomString() + "@Testawy.com";
    }

    public void HoverAndSelectRandom(){
        // Locate a list of elements to select from
       // WebDriver driver  = new ChromeDriver();
//        List<WebElement> elementsToSelect = driver.findElements(By.xpath("(//div/button)[1]"));

        // Generate a random index within the range of elements
        Random random = new Random();
        int randomIndex = random.nextInt(2);

        // Click on the randomly selected element
//        elementsToSelect.get(randomIndex).click();

        // Other actions after selecting a random element
    }

    public static int generateRandomInt(int max){
        Random rand = new Random();
        return rand.nextInt(max)+1;
    }


}

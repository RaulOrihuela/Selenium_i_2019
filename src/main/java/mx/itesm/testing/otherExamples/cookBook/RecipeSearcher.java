package mx.itesm.testing.otherExamples.cookBook;

import mx.itesm.testing.util.drivers.EnhancedWebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class RecipeSearcher {
    public static ArrayList<String> searchNewRecipes(EnhancedWebDriver driver){
        ArrayList<String> recipes = new ArrayList<>();
        driver.get("https://www.superama.com.mx/recetas/categoria/comida-mexicana/135");

        List<WebElement> recipeLinks = driver.findDynamicElements(By.xpath("//*[@id=\"recetasPorCategoria\"]/a"));
        if (recipeLinks!=null){
            for (WebElement link : recipeLinks) {
                //if (!singletonMap.hasKey(link.getText()))
                recipes.add((link.getAttribute("href")));
            }
        }

        return recipes;
    }
    public static ArrayList<Recipe> learnNewRecipes(EnhancedWebDriver driver, ArrayList<String> recipes) {
        ArrayList<Recipe> result = new ArrayList<>();
        for (String recipeLink : recipes) {
            result.add(analyzeNewRecipe(driver, recipeLink));
        }
        return result;
    }
    public static Recipe analyzeNewRecipe(EnhancedWebDriver driver, String url){
        Recipe recipe = new Recipe();
        driver.get(url);
        recipe.setName(getField(driver, By.id("nombreReceta")));
        recipe.setDifficulty(removePrefix(getField(driver, By.id("dificultadReceta")),"Dificultad:\n"));
        recipe.setPortions(removePrefix(getField(driver, By.id("porcionesReceta")),"Porciones:\n"));
        recipe.setPreparationTime(removePrefix(getField(driver, By.id("tiempoReceta")),"Tiempo:\n"));
        recipe.setSteps(getSteps(driver, By.xpath("//*[@id=\"procedimiento\"]/li")));
        recipe.setIngredients(getIngredients(driver, By.xpath("//*[@id=\"ingredientes\"]/li")));
        WebElement image = driver.findDynamicElement(By.id("imgReceta"));
        if (image != null) recipe.setImageLink(image.getAttribute("src"));
        return recipe;
    }

    private static String getField(EnhancedWebDriver driver, By locator){
        String result = "";
        WebElement temp = driver.findDynamicElement(locator);
        if (temp!=null) result += temp.getText();
        return result;
    }
    private static String getSteps(EnhancedWebDriver driver, By locator){
        String stepsText = "";
        List<WebElement> steps = driver.findDynamicElements(locator);
        if (steps!=null){
            int stepCounter = 0;
            for (WebElement step : steps) {
                stepCounter++;
                stepsText += (stepCounter + "\t" + step.getText() + "\n");
            }
        }
        return stepsText;
    }
    private static ArrayList<String> getIngredients(EnhancedWebDriver driver, By locator){
        ArrayList<String> result = new ArrayList<>();
        List<WebElement> ingredients = driver.findDynamicElements(locator);
        if (ingredients!=null){
            for (WebElement ingredient : ingredients) result.add(ingredient.getText());
        }
        return result;
    }
    public static String removePrefix(String input, String exclude){
        return input.substring(input.indexOf(exclude)+exclude.length());
    }
}

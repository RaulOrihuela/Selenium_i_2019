package mx.itesm.testing.otherExamples.cookBook;

import java.io.Serializable;
import java.util.ArrayList;

public class Recipe implements Serializable {
    private String name, difficulty, portions, preparationTime, steps, imageLink;
    private ArrayList<String> ingredients;

    public Recipe(
            String name,
            String difficulty,
            String portions,
            String preparationTime,
            String steps,
            String imageLink,
            ArrayList<String> ingredients
    ) {
        this.name = name;
        this.difficulty = difficulty;
        this.portions = portions;
        this.preparationTime = preparationTime;
        this.steps = steps;
        this.imageLink = imageLink;
        this.ingredients = ingredients;
    }

    public Recipe() { }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public String getPortions() {
        return portions;
    }

    public void setPortions(String portions) {
        this.portions = portions;
    }

    public String getPreparationTime() {
        return preparationTime;
    }

    public void setPreparationTime(String preparationTime) {
        this.preparationTime = preparationTime;
    }

    public String getSteps() {
        return steps;
    }

    public void setSteps(String steps) {
        this.steps = steps;
    }

    public String getImageLink() {
        return imageLink;
    }

    public void setImageLink(String imageLink) {
        this.imageLink = imageLink;
    }

    public ArrayList<String> getIngredients() {
        return ingredients;
    }

    public void setIngredients(ArrayList<String> ingredients) {
        this.ingredients = ingredients;
    }

    @Override
    public String toString() {
        return "Recipe{" +
                "name='" + name + '\'' +
                ", difficulty='" + difficulty + '\'' +
                ", portions='" + portions + '\'' +
                ", preparationTime='" + preparationTime + '\'' +
                ", steps='" + steps + '\'' +
                ", imageLink='" + imageLink + '\'' +
                ", ingredients=" + ingredients +
                '}';
    }
}

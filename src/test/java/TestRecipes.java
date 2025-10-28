import org.example.RecipeFormat;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class TestRecipes {

    @Test
    void getIngredient(){
        RecipeFormat format = new RecipeFormat();
        boolean testRecipe = format.IngredientsTest1("Curry");
        Assertions.assertTrue(testRecipe);
    }

    @Test
    void getMeasure(){
        RecipeFormat format = new RecipeFormat();
        boolean testRecipe = format.IngredientsTest2("Curry");
        Assertions.assertTrue(testRecipe);
    }
}

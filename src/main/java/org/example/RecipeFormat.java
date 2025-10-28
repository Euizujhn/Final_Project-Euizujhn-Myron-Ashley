package org.example;

import org.json.simple.JSONObject;

import java.util.ArrayList;

public class RecipeFormat extends RecipeAPI {
    public static void main(String[] args) {
        System.out.println(IngredientsGUI("Salad"));
    }

    //public static String Instructions(String FoodKey){
    //  try {
    //    JSONObject FoodInformation = getFoodInfo(FoodKey);
    //  String instructions = (String) FoodInformation.get("strInstructions");
    //return instructions;
    //} catch (Exception e) {
    //  e.printStackTrace();
    //}
    //return null;
    //}

    public static String Ingredients(String FoodKey){
        try {
            JSONObject FoodIngredients = getFoodInfo(FoodKey);
            String empty = "";

            for (int i = 1; i <= 20; i++){
                String List = (String) FoodIngredients.get("strIngredient" + i);
                String Measure = (String) FoodIngredients.get("strMeasure" + i);
                String combine =  List + ": " + Measure;
                System.out.println(combine);
                if (List.equals(empty)){
                    return combine;
                }
            }

        } catch (Exception e) {
            // e.printStackTrace();
        }
        return null;
    }

    public static String IngredientsGUI(String FoodKey){
        try{
            JSONObject FoodIngredients = getFoodInfo(FoodKey);
            String empty = "";
            ArrayList<String> IngredientList = new ArrayList<>();
            for (int i = 1; i <= 20; i++) {
                String List = (String) FoodIngredients.get("strIngredient" + i);
                String Measure = (String) FoodIngredients.get("strMeasure" + i);
                String combine =  List + ": " + Measure + "\n";
                IngredientList.add(combine);
                if (List.equals(empty)){
                    return FoodKey + "\n" + String.valueOf(IngredientList);
                }
            }
        } catch (Exception e) {
            String empty = "Recipe is not within the API";
            return empty;
        }
        return null;
    }

    public static boolean IngredientsTest1(String FoodKey){
        try {
            JSONObject FoodIngredients = getFoodInfo(FoodKey);
            String List = (String) FoodIngredients.get("strIngredient" + 1);
            if (List.equals("Potatoes")){
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            System.err.println("Wrong");
            return false;
        }
    }

    public static boolean IngredientsTest2(String FoodKey){
        try {
            JSONObject FoodIngredients = getFoodInfo(FoodKey);
            String List = (String) FoodIngredients.get("strMeasure" + 1);
            if (List.equals("225g new")){
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            System.err.println("Wrong");
            return false;
        }
    }
}

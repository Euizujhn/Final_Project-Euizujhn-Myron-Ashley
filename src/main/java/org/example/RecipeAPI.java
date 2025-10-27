package org.example;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;


public class RecipeAPI {



    public static JSONObject getFoodInfo(String food){
        food = food.replaceAll(" ", "_");
        String urlString = "https://www.themealdb.com/api/json/v1/1/search.php?s=" + food;

        try {
            HttpURLConnection apiConnection = fetchApiResponse(urlString);

            if (apiConnection.getResponseCode() != 200) {
                System.err.println("Error: Cannot connect to API");
                return null;
            }

            String jsonResponse = readApiResponse(apiConnection);

            JSONParser parser = new JSONParser();
            JSONObject resultsJSONobj = (JSONObject) parser.parse(jsonResponse);

            JSONArray MealDescription = (JSONArray) resultsJSONobj.get("meals");
            //NEED TO RETURN
            // strMeal, strCategory, strArea, strIngredients with strMeasure, & strInstructions
            //System.out.println((JSONObject) MealDescription.getFirst());

            return (JSONObject) MealDescription.getFirst();

        } catch (Exception e) {
            System.err.println("Food is not within Meal DataBase");
           // e.printStackTrace();
        }
        return null;
    }



    private static String readApiResponse(HttpURLConnection apiConnection) {
        try{
            StringBuilder resultJson = new StringBuilder();
            Scanner input = new Scanner(apiConnection.getInputStream());
            while (input.hasNext()) {
                resultJson.append(input.nextLine());
            }
            input.close();
            return resultJson.toString();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }



    private static HttpURLConnection fetchApiResponse(String urlString){
        try{
            URL url = new URL(urlString);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestProperty("User-Agent", "RecipeAPI/0.1 (ej.wade@bsu.edu)");
            connection.setRequestMethod("GET");
            return connection;
        }

        catch(IOException e){
            e.printStackTrace();
        }
        return null;
    }
}


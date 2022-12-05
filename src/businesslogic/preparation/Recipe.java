package businesslogic.preparation;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import persistence.PersistenceManager;
import persistence.ResultHandler;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class Recipe extends Procedure {
    protected boolean published;

    public Recipe() {

    }

    public Recipe(String title) {
        this.id = 0;
        this.title = title;
        all.put(id,this);
    }

    // STATIC METHODS FOR PERSISTENCE

    public static Recipe loadRecipeById(int id) {
        if (all.containsKey(id))
            return (Recipe) all.get(id);
        Recipe rec = new Recipe();
        String query = "SELECT * FROM Instructions WHERE id = " + id;
        PersistenceManager.executeQuery(query, new ResultHandler() {
            @Override
            public void handle(ResultSet rs) throws SQLException {
                    rec.title = rs.getString("title");
                    rec.id = id;
                    all.put(rec.id, rec);
            }
        });
        return rec;
    }

    public static ObservableList<Recipe> getAllRecipes() {
        ArrayList<Recipe> recipes = new ArrayList<>();

        for (Procedure procedure : all.values()){
            if(procedure instanceof Recipe)
                recipes.add((Recipe) procedure);
        }
        return FXCollections.observableArrayList(recipes);
    }


    public void unpublishProcedure(Procedure procedure) {

    }









}

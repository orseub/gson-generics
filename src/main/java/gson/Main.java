package gson;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import gson.models.BaseObject;
import gson.models.MainObject;
import gson.models.ItemObject;

import java.lang.reflect.Type;

public class Main {
    public static void main(String[] args) {
        String jsonString = "{\"id\":1,\"data\":{\"name\":\"itemname\"},\"clazz\":\"Item\"}";
        // Just skipping over the part where the clazz string gets mapped to a class for brevity.
        Class<?> clazz = ItemObject.class;

        Type collectionType = TypeToken.getParameterized(MainObject.class, clazz).getType();

        Gson gson = new Gson().newBuilder().setPrettyPrinting().create();
        MainObject<BaseObject<?>> mainObject = gson.fromJson(jsonString, collectionType);

        System.out.println(gson.toJson(mainObject)); // Should output the original input 'jsonString'
    }
}

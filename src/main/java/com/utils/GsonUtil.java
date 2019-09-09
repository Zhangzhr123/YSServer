package com.utils;

import com.google.gson.*;
import java.lang.reflect.Type;
import java.util.Date;

/**
 * Created by ZZR on 2019/06/10
 */
public class GsonUtil {

    private static Gson gson;
    public static Gson getGson(){
        if(gson == null){
            GsonBuilder builder = new GsonBuilder();
            // Register an adapter to manage the date types as long values
            builder.registerTypeAdapter(Date.class, new JsonDeserializer<Date>() {
                public Date deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
                    return new Date(json.getAsJsonPrimitive().getAsLong());
                }
            });
            builder.registerTypeAdapter(Date.class, new JsonSerializer<Date>() {
                public JsonElement serialize(Date src, Type typeOfSrc, JsonSerializationContext context) {
                    return new JsonPrimitive(src.getTime());
                }
            });
            gson = builder.create();
        }
        return gson;
    }

}

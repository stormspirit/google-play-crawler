package com.akdeniz.googleplaycrawler.output;

import com.google.gson.Gson;

/**
 * Created by ryan on 10/26/14.
 */
public class JsonConverter {
    public static Gson gson = new Gson();

    public static String toJson(Object object)
    {
        return gson.toJson(object);
    }
}

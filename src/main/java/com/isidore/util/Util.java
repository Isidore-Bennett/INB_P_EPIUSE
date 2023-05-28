package com.isidore.util;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.isidore.constant.MethodType;
import jakarta.servlet.http.HttpServletResponse;
import org.eclipse.jetty.http.MimeTypes;

import java.io.Reader;
import java.util.List;

public class Util {

    public static String objectToJson(Object o) {
        return new Gson().toJson(o);
    }

    public static <T> List<T> jsonToObject(Reader reader, Class<T> clazz) {
        return new Gson().fromJson(reader, TypeToken.getParameterized(List.class, clazz).getType());
    }

    public static void setHeaders(HttpServletResponse response, MethodType methodType) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", methodType.name());
        response.setHeader("Access-Control-Allow-Headers", "Content-Type");
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
    }

    public static void setHeaders(HttpServletResponse response, MethodType methodType, MimeTypes.Type mimeType) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", methodType.name());
        response.setHeader("Access-Control-Allow-Headers", mimeType.toString());
        response.setContentType("text/plain");
        response.setCharacterEncoding("UTF-8");
    }
}

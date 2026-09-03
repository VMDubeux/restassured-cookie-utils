package io.github.VMDubeux.restassured;

import io.restassured.RestAssured;
import io.restassured.http.Cookie;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class CookieMap {
    private final Map<String, String> cookiesMap = new LinkedHashMap<>();

    public void add(Cookie cookie) {
        cookiesMap.put(cookie.getName(), cookie.getValue());
    }

    public Map<String, String> getCookies() {
        return Collections.unmodifiableMap(cookiesMap);
    }

    public String getKey(Cookie cookie) {
        String key = cookie.getName();

        if (!cookiesMap.containsKey(key)) {
            System.err.println("Erro: o cookie '" + key + "' não existe no cookiesMap.");
            return null;
        }

        return key;
    }

    public String getValue(Cookie cookie) {
        String value = cookie.getValue();
        if (!cookiesMap.containsValue(value)) {
            System.err.println("Erro: o value " + value + " não existe no cookiesMap.");
            return null;
        }

        return value;
    }
}

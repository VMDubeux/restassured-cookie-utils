package io.github.VMDubeux.restassured;

import io.restassured.http.Cookie;
import io.restassured.http.Cookies;

import java.util.*;
import java.util.stream.Collectors;

public class CookieManagement {

    public enum Attribute {
        NAME, VALUE, DOMAIN, PATH, COMMENT
    }

    private final List<IdentifiedCookie> cookiesManager = new ArrayList<>();

    /**
     * Builds your Cookie from scratch.
     * <p>
     * @param key     The name or key of the cookie.
     * @param value   The value stored in the cookie.
     * @param domain  The domain for which the cookie is valid.
     * @param path    The URL path for which the cookie is valid.
     * @param comment The purpose or description of the cookie.
     */
    public void create(String key, String value, String domain, String path, String comment) {
        Cookie.Builder builder = new Cookie.Builder(key, value);

        if (domain != null && !domain.isEmpty()) {
            builder.setDomain(domain);
        }
        if (path != null && !path.isEmpty()) {
            builder.setPath(path);
        }
        if (comment != null && !comment.isEmpty()) {
            builder.setComment(comment);
        }

        add(builder.build());
    }

    public void create(String key, String value) {
        create(key, value, null);
    }

    public void create(String key, String value, String domain) {
        create(key, value, domain, null);
    }

    public void create(String key, String value, String domain, String path) {
        create(key, value, domain, path, null);
    }

    /**
     * Adds a cookie to the list.
     * <p>
     * NOTE: Call this method only if the cookie was not created using the
     * {@link #create(String, String, String, String, String)} method.
     * <p>
     * @param cookie The cookie to be added to the list.
     */
    public void add(Cookie cookie) {

        boolean match = cookiesManager
                .stream()
                .noneMatch
                        (item ->
                                item.getCookie().getName().equalsIgnoreCase(cookie.getName()) &&
                                        item.getCookie().getDomain().equalsIgnoreCase(cookie.getDomain()) &&
                                        item.getCookie().getPath().equalsIgnoreCase(cookie.getPath()));

        if (match) {
            if (cookiesManager.isEmpty()) {
                System.out.print("\n[Checking] First List's Cookie: ");
            } else {
                System.out.print("\n[Checking] Another Cookie: ");
                System.out.print("\n(Verified) Non-Conflicted Name: " + cookie.getName());
                System.out.print("\n(Verified) Non-Conflicted Domain: " + cookie.getDomain());
                System.out.print("\n(Verified) Non-Conflicted Path: " + cookie.getPath());
            }

            cookiesManager.add(new IdentifiedCookie(cookie));
            System.out.print("\nAdded cookie: [" + cookie + "]\n");
        } else {
            throw new IllegalArgumentException("\nDuplicate cookie detected. " +
                    "\nThe cookie is already present in the list.\n");
        }
    }

    /**
     * Deletes a specific cookie.
     * <p>
     * @param cookie The cookie to be removed.
     */
    public void delete(Cookie cookie) {
        cookiesManager.removeIf(item -> Objects.equals(item.getCookie(),cookie));
    }

    /**
     * Retrieves the specific attribute value from a Cookie Object.
     * <p>
     * @param cookie Target Cookie Object.
     * @param attribute Target Attribute: {@link Attribute#NAME}, {@link Attribute#VALUE}, {@link Attribute#DOMAIN}, {@link  Attribute#PATH}, {@link Attribute#COMMENT}.
     * @return Selected attribute value in String format.
     */
    public String getAttribute(Cookie cookie, Attribute attribute) {
        if (cookie == null || attribute == null) {
            throw new IllegalArgumentException("[WARNING] Missing Cookie Object or Attribute");
        }

        String value = switch (attribute) {
            case NAME -> cookie.getName();
            case VALUE -> cookie.getValue();
            case DOMAIN -> cookie.getDomain();
            case PATH -> cookie.getPath();
            case COMMENT -> cookie.getComment();
        };

        System.out.print("\nAttribute " + attribute + ": " + value + "\n");

        return value;
    }

    /**
     * Retrieves the updated list of cookies.
     * <p>
     * @return The IDs and names of all cookies currently in the list in String format.
     */
    public String reviewList() {
        if (cookiesManager.isEmpty()) {
            return null;
        }
        return cookiesManager.stream()
                .map(item -> "[" +
                        item.getId() + " : " +
                        item.getCookie()
                                .getName() + "]")
                .collect(Collectors
                        .joining("\n",
                                "\nUpdated Cookie List:\n",
                                "\n"));
    }

    /**
     * Passes the updated list of cookies.
     * <p>
     * @return All cookies currently on the list in Cookies format, including all their attributes.
     */
    public Cookies useList (){
        List<Cookie> cookie = cookiesManager
                .stream()
                .map(IdentifiedCookie::getCookie)
                .collect(Collectors.toList());
        return new Cookies(cookie);
    }
}

class IdentifiedCookie {
    private final String id;
    private final Cookie cookie;

    public IdentifiedCookie(Cookie cookie) {
        this.id = UUID.randomUUID()
                .toString()
                .replace("-", "");
        this.cookie = cookie;
    }

    public Cookie getCookie() {
        return cookie;
    }

    public String getId() {
        return id;
    }
}

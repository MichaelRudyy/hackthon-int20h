package io.powersurfers.util;

import lombok.Builder;

import java.net.MalformedURLException;
import java.net.URL;

@Builder
public class SectionsRestUrlBuilder {
    private final static String sectionRestUrl = "/api/section" + "/";

    public static String get(String id) {
        return sectionRestUrl + id;
    }
}

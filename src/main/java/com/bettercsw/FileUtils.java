package com.bettercsw;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;

import java.net.URLConnection;

public class FileUtils {

    private static final Logger LOG = LoggerFactory.getLogger(FileUtils.class);


    public static String getExt(String fileName) {
        return fileName.substring(fileName.lastIndexOf(".") + 1);
    }

    public static String getMime(String fileName) {
        return URLConnection.guessContentTypeFromName(fileName);
    }

    public static MediaType getMediaType(String fileName) {
        String mime = getMime(fileName);
        LOG.info("mime:" + mime);

        return MediaType.valueOf(mime);
    }

    public static MediaType getMediaTypeVideo(String fileName) {
        String mime = getMime(fileName);
        LOG.info("mime:" + mime);
        return MediaType.valueOf(mime);
    }

}

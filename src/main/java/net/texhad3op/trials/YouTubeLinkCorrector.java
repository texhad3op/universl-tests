package net.texhad3op.trials;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by jurij on 1/20/17.
 */
public class YouTubeLinkCorrector {

    private static String NORMAL_YOUTUBE_URL = "https://www.youtube.com/embed/";
    private static String HTTPS = "https://";
    private static Pattern embedPattern = Pattern.compile(NORMAL_YOUTUBE_URL + "[A-Za-z0-9_-]*");

    private static Pattern watchPattern = Pattern.compile("https://www.youtube.com/watch[?]v=[A-Za-z0-9_-]*");
    private static Pattern cutWatchPattern = Pattern.compile("https://www.youtube.com/watch[?]v=(.+?)$");
    private static Pattern shortWatchPattern = Pattern.compile("https://youtu.be/[A-Za-z0-9_-]*");
    private static Pattern cutShortWatchPattern = Pattern.compile("https://youtu.be/(.+?)$");

    private static Pattern standardHTTPSPattern = Pattern.compile("https://.*$");
    private static Pattern standardHTTPPattern = Pattern.compile("http://.*$");
    private static Pattern cutStandardHTTPPattern = Pattern.compile("http://(.+?)$");




    public static String correctYouTubeLink(String url) {

        if (embedPattern.matcher(url).matches()) return url;
        String ret = changeIfMatch(url, watchPattern, cutWatchPattern, NORMAL_YOUTUBE_URL);
        if (null != ret) {
            return ret;
        } else {
            return changeIfMatch(url, shortWatchPattern, cutShortWatchPattern, NORMAL_YOUTUBE_URL);
        }
    }

    private static String changeIfMatch(String in, Pattern pattern, Pattern cutPattern, String retVal) {
        if (pattern.matcher(in).matches()) {
            final Matcher matcher = cutPattern.matcher(in);
            if (matcher.find()) {
                return retVal + matcher.group(1);
            }
        }
        return null;
    }

    public static String correctLink(String url) {
        if (url.startsWith("/")) return url;
        if (standardHTTPSPattern.matcher(url).matches())
            return url;
        return changeIfMatch(url, standardHTTPPattern, cutStandardHTTPPattern, HTTPS);
    }


}

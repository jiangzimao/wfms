package org.jqiaofu.wfms.web.util;

public interface UrlMatcher {
	
	Object compile(String urlPattern);

    boolean pathMatchesUrl(Object compiledUrlPattern, String url);

    /** Returns the path which matches every URL */
    String getUniversalMatchPattern();

    /**
     * Returns true if the matcher expects the URL to be converted to lower case before
     * calling {@link #pathMatchesUrl(Object, String)}.
     */
    boolean requiresLowerCaseUrl();
}

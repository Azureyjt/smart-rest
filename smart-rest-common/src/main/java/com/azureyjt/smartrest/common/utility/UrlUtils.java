/**
 * The MIT License
 * Copyright (c) 2014-2016 Ilkka Seppälä
 * <p>
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * <p>
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 * <p>
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package com.azureyjt.smartrest.common.utility;

import org.apache.commons.lang3.StringUtils;

/**
 * Provide utilities to handle url.
 */
public class UrlUtils {

    /**
     * Check if the provided uri is base uri without query filter.
     *
     * @param uri Uri.
     * @return {@code true} if the provided uri is basic.
     */
    public static boolean isBaseUri(final String uri) {
        String result = uri;
        String[] contents = result.split("/");
        String param = contents[contents.length - 1];
        boolean isNumberic = StringUtils.isNumeric(param);
        return !isNumberic;
    }

    /**
     * Get base uri of the provided uri.
     *
     * @param uri Uri.
     * @return Base uri.
     */
    public static String getBaseUri(final String uri) {
        String result = uri;
        if (!isBaseUri(result)) {
            result = StringUtils.strip(result, "/");
            result = StringUtils.strip(result, "/" + getIdentity(result));
        } else {
            result = StringUtils.strip(result, "/");
        }
        return result;
    }

    /**
     * Get identity part of the provided uri.
     *
     * @param uri Uri.
     * @return Identity value.
     */
    public static String getIdentity(final String uri) {
        String result = uri;
        if (isBaseUri(result)) {
            result = "";
        } else {
            String[] contents = result.split("/");
            result = contents[contents.length - 1];
        }
        return result;
    }

}

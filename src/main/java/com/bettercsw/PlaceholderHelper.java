/*
 * Copyright 2021 Apollo Authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */
package com.bettercsw;


import org.apache.commons.lang3.StringUtils;


import java.util.Stack;

/**
 * Placeholder helper functions.
 *
 * @author csw
 */
public class PlaceholderHelper {

    private static final String PLACEHOLDER_PREFIX = "${";
    private static final String PLACEHOLDER_SUFFIX = "}";
    private static final String VALUE_SEPARATOR = ":";
    private static final String SIMPLE_PLACEHOLDER_PREFIX = "{";

    /**
     * Extract keys from placeholder, e.g.
     * <ul>
     * <li>${some.key} => "some.key"</li>
     * <li>${some.key:${some.other.key:100}} => "some.key", "some.other.key"</li>
     * <li>${${some.key}} => "some.key"</li>
     * <li>${${some.key:other.key}} => "some.key"</li>
     * <li>${${some.key}:${another.key}} => "some.key", "another.key"</li>
     * </ul>
     */
    public static String extractPlaceholderKeys(String propertyString) {

        if (StringUtils.isBlank(propertyString) || (!isNormalizedPlaceholder(propertyString))) {
            return "";
        }

        Stack<String> stack = new Stack<>();
        stack.push(propertyString);

        while (!stack.isEmpty()) {
            String strVal = stack.pop();
            int startIndex = strVal.indexOf(PLACEHOLDER_PREFIX);
            if (startIndex == -1) {
                return strVal;
            }
            int endIndex = findPlaceholderEndIndex(strVal, startIndex);
            if (endIndex == -1) {
                // invalid placeholder?
                continue;
            }

            String placeholderCandidate = strVal.substring(startIndex + PLACEHOLDER_PREFIX.length(), endIndex);
            // ${some.key:other.key}
            if (placeholderCandidate.startsWith(PLACEHOLDER_PREFIX)) {
                stack.push(placeholderCandidate);
            } else {
                // some.key:${some.other.key:100}
                int separatorIndex = placeholderCandidate.indexOf(VALUE_SEPARATOR);

                if (separatorIndex == -1) {
                    stack.push(placeholderCandidate);
                } else {
                    stack.push(placeholderCandidate.substring(0, separatorIndex));
                    //         String defaultValuePart =
                    //                 normalizeToPlaceholder(placeholderCandidate.substring(separatorIndex + VALUE_SEPARATOR.length()));
                    //         if (org.apache.commons.lang3.StringUtils.isNotBlank(defaultValuePart)) {
                    //             stack.push(defaultValuePart);
                    //         }
                }
            }
            //${some.key}:${another.key}
            // if (endIndex + PLACEHOLDER_SUFFIX.length() < strVal.length() - 1) {
            //     String remainingPart = normalizeToPlaceholder(strVal.substring(endIndex + PLACEHOLDER_SUFFIX.length()));
            //     if (StringUtils.isNotBlank(remainingPart)) {
            //         stack.push(remainingPart);
            //     }
            // }

        }
        return "";
    }

    private static boolean isNormalizedPlaceholder(String propertyString) {
        return propertyString.startsWith(PLACEHOLDER_PREFIX) && propertyString.contains(PLACEHOLDER_SUFFIX);
    }

    private static String normalizeToPlaceholder(String strVal) {
        int startIndex = strVal.indexOf(PLACEHOLDER_PREFIX);
        if (startIndex == -1) {
            return null;
        }
        int endIndex = strVal.lastIndexOf(PLACEHOLDER_SUFFIX);
        if (endIndex == -1) {
            return null;
        }

        return strVal.substring(startIndex, endIndex + PLACEHOLDER_SUFFIX.length());
    }

    private static int findPlaceholderEndIndex(CharSequence buf, int startIndex) {
        int index = startIndex + PLACEHOLDER_PREFIX.length();
        int withinNestedPlaceholder = 0;
        while (index < buf.length()) {
            if (org.springframework.util.StringUtils.substringMatch(buf, index, PLACEHOLDER_SUFFIX)) {
                if (withinNestedPlaceholder > 0) {
                    withinNestedPlaceholder--;
                    index = index + PLACEHOLDER_SUFFIX.length();
                } else {
                    return index;
                }
            } else if (org.springframework.util.StringUtils.substringMatch(buf, index, SIMPLE_PLACEHOLDER_PREFIX)) {
                withinNestedPlaceholder++;
                index = index + SIMPLE_PLACEHOLDER_PREFIX.length();
            } else {
                index++;
            }
        }
        return -1;
    }


}

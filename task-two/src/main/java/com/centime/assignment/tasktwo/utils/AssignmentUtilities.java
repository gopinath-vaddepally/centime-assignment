package com.centime.assignment.tasktwo.utils;

import org.slf4j.helpers.MessageFormatter;

/**
 * @author gvaddepally on 04/07/20
 */
public class AssignmentUtilities {

    public static String msg(String msg, Object... args) {
        return MessageFormatter.arrayFormat(msg, args).getMessage();
    }
}

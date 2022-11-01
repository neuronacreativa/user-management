package org.nc.usermanagement.infrastructure.rest.exception;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UserManagementException extends Exception {

    private final String code;
    private final Object content;
    private String message;

    public UserManagementException(Object content, MessageSource messageSource, String code, Object[] args) {
        this.content = content;
        this.message = getMessage(messageSource, code, args);
        this.code = code;
    }

    public UserManagementException() {
        this.code = "ko";
        this.content = null;
        this.message = null;
    }

    public UserManagementException(Exception e) {
        this.code = "ko";
        this.content = null;
        this.message = e.getMessage();
    }

    public UserManagementException(String code) {
        this.content = null;
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public Object getContent() {
        return content;
    }

    @Override
    public String getMessage() {
        return message;
    }

    private String getMessage(MessageSource messageSource, String code, Object[] args) {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        String dateStr = df.format(new Date(System.currentTimeMillis()));
        try {
            return "[" + dateStr + "] - ".concat(InetAddress.getLocalHost().getHostName() + " - ").concat(messageSource.getMessage(code, args, LocaleContextHolder.getLocale()));
        } catch (UnknownHostException e) {
            e.printStackTrace();
            return "[" + dateStr + "] - ".concat(messageSource.getMessage(code, args, LocaleContextHolder.getLocale()));
        }
    }
}

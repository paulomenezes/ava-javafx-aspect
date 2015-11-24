package com.ufrpe.ava.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by paulomenezes on 22/11/15.
 */
public class Funcoes {
    private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

    public static boolean validarCPF(String cpf) {
        return true;
    }

    public static boolean validarEmail(String email) {
        if ((email == null) || (email.trim().length() == 0))
            return false;

        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
}

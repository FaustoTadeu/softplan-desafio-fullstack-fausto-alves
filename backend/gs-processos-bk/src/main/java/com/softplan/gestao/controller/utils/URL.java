package com.softplan.gestao.controller.utils;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;

public class URL {

    public static List<Integer> decodeIntList(String s) {
        String vet[] = s.split(",");
        List <Integer> list = new ArrayList<>();
        for (String id : vet) {
            list.add(Integer.parseInt(id));
        }
        return list;
    }

    public static String decodeString (String s) {
        try {
            return URLDecoder.decode(s, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            return "";
        }
    }
}

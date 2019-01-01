package com.sayhellostream.util;

public class IdObfuscator {

    private static final int MIN_LENGTH = 10;
    private static String salt = "NinoHanselO1234";


    public static String enc( Long id ) {

        HashIds hashIds = new HashIds( salt, MIN_LENGTH );
        return hashIds.encrypt( id );
    }

    public static Long dec( String obfuscatedId ) {

        HashIds hashIds = new HashIds( salt, MIN_LENGTH );
        long[] ids = hashIds.decrypt( obfuscatedId );

        if ( ids.length > 0 ) {
            return obfuscatedId == null ? null : ids[0];
        }

        return null;
    }
}

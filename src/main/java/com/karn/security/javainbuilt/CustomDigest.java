package com.karn.security.javainbuilt;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Formatter;

public class CustomDigest {

    /**
     * JavaScript equivalent
     *
     * async function digestMessage(message) {
     *   const msgUint8 = new TextEncoder().encode(message); // encode as (utf-8) Uint8Array
     *   const hashBuffer = await window.crypto.subtle.digest("SHA-256", msgUint8); // hash the message
     *   const hashArray = Array.from(new Uint8Array(hashBuffer)); // convert buffer to byte array
     *   const hashHex = hashArray
     *     .map((b) => b.toString(16).padStart(2, "0"))
     *     .join(""); // convert bytes to hex string
     *   return hashHex;
     * }
     *
     * digestMessage("ashishkrkarn@gmail.com").then((digestHex) => console.log(digestHex));
     *
     *
     *
     *
     * */
    public static String digestMessage(String message) throws NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] hash = digest.digest(message.getBytes(StandardCharsets.UTF_8));
        return bytesToHex(hash);
    }

//    private static String bytesToBase64String(byte[] hash) {
//        return Arrays.toString(Base64.getEncoder().encode(hash));
//    }


    private static String bytesToHex(byte[] bytes) {
        Formatter formatter = new Formatter();
        for (byte b : bytes) {
            formatter.format("%02x", b);
        }
        String hexString = formatter.toString();
        formatter.close();
        return hexString;
    }

    public static void main(String[] args) throws NoSuchAlgorithmException {
        String text = "ashishkrkarn@gmail.com";
        String digestHex = digestMessage(text);
        System.out.println(digestHex);
    }
}

package com.karn.security.javainbuilt;


import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.Signature;
import java.security.SignatureException;
import java.util.Arrays;
import java.util.Base64;

public class JavaSecurityDemo {

    public static void main(String[] args) throws Exception{

        usingAESEncryptionWithIV();
        usingHashing();
        usingRSA();//DOESN'T WORK FOR LARGER INPUTS. ASYMMETRIC ENCRYPTION CAN'T BE USED FOR LARGE DATA

        usingDigitalSignature();

    }

    private static void usingDigitalSignature() throws NoSuchAlgorithmException, InvalidKeyException, SignatureException {
        KeyPairGenerator pairGenerator = KeyPairGenerator.getInstance("RSA");
        pairGenerator.initialize(1024);
        KeyPair keyPair = pairGenerator.genKeyPair();

        //add data with private key
        Signature sender = Signature.getInstance("SHA256WithRSA");//hashing with SHA256 and asymmetric encryption with RSA
        sender.initSign(keyPair.getPrivate());
        byte[] inputData = "Ashish".getBytes();
        sender.update(inputData);
        //get sign
        byte[] sign = sender.sign();
//        sign[0]=4;

        //add data with public key
        Signature receiver  =  Signature.getInstance("SHA256WithRSA");
        receiver.initVerify(keyPair.getPublic());
        receiver.update(inputData);

        boolean verify = receiver.verify(sign);
        System.out.println("verify "+verify);
    }


    /**
     * AES/CBC/NoPadding (128)
     * AES/CBC/PKCS5Padding (128)
     * AES/ECB/NoPadding (128)
     * AES/ECB/PKCS5Padding (128)
     * AES/GCM/NoPadding (128)
     * DESede/CBC/NoPadding (168)
     * DESede/CBC/PKCS5Padding (168)
     * DESede/ECB/NoPadding (168)
     * DESede/ECB/PKCS5Padding (168)
     * RSA/ECB/PKCS1Padding (1024, 2048)
     * RSA/ECB/OAEPWithSHA-1AndMGF1Padding (1024, 2048)
     * RSA/ECB/OAEPWithSHA-256AndMGF1Padding (1024, 2048)
     * */

    private static void usingAESEncryptionWithIV() throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException, InvalidAlgorithmParameterException, InvalidKeyException {
        //Make key
        KeyGenerator generator = KeyGenerator.getInstance("AES");
        generator.init(192);
        SecretKey secretKey = generator.generateKey();
        String encodedKey = new String(Base64.getEncoder().encode(secretKey.getEncoded()));
        System.out.println("key :: "+ encodedKey);

        //get IV
        SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG");
        byte[] random = new byte[16];
        secureRandom.nextBytes(random);
        IvParameterSpec ivSpec = new IvParameterSpec(random);
        System.out.println("iVspec"+new String(random));

        byte[] input = "Devoxx!!".repeat(16).getBytes();
        System.out.println("Actual    = "+ new String(input));

        //encryption without iv
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        byte[] bytes = cipher.doFinal(input);
        System.out.println("Encrypted = "+ Arrays.toString(bytes));//notice there is pattern in output

        //encryption with iv
        Cipher cipherIV = Cipher.getInstance("AES/CBC/PKCS5Padding"); //NOT RECOMMENDED cbc but other's don't support this IVSpec
        cipherIV.init(Cipher.ENCRYPT_MODE, secretKey, ivSpec);
        byte[] bytesIV = cipherIV.doFinal(input);
        System.out.println("Encrypted = "+  Arrays.toString(bytesIV));

        cipherIV.init(Cipher.DECRYPT_MODE, secretKey, ivSpec);
        String original = new String(cipherIV.doFinal(bytesIV));
        System.out.println("Original = "+  original);
    }

    private static void usingHashing() throws NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");//SHA-1 // MD5 don't use MD5 as it was hacked
        byte[] digested = digest.digest("Ashish".getBytes());
        byte[] digested2 = digest.digest("Ashish".getBytes());
        byte[] digested3 = digest.digest("Ashisj".getBytes());//small change changes the output completely
        System.out.println(new String(digested));
        System.out.println(new String(digested2));//same value every time
        System.out.println(new String(digested3));
    }

    private static void usingRSA() throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        KeyPairGenerator kpg = KeyPairGenerator.getInstance("RSA");
        kpg.initialize(3072);
        KeyPair keyPair = kpg.generateKeyPair();
        PrivateKey aPrivate = keyPair.getPrivate();
        PublicKey aPublic = keyPair.getPublic();
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.ENCRYPT_MODE, aPrivate);

        byte[] arr = "Ashish".getBytes();
        byte[] bytes = cipher.doFinal(arr);
        System.out.println(new String(bytes));

        Cipher cipher2 = Cipher.getInstance("RSA");//we can do re init on old instance also
        cipher2.init(Cipher.DECRYPT_MODE, aPublic);
        byte[] bytes1 = cipher2.doFinal(bytes);
        System.out.println(new String(bytes1));
    }
}

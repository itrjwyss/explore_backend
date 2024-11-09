package com.giocondalabs.utils;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import java.rmi.UnexpectedException;
import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.jboss.logging.Logger;

@ApplicationScoped
public class Crypto {

    @ConfigProperty(name = "application.secret")
    String password;

    @Inject
    Logger logger;

    private SecretKey getKeyFromPassword() {
        return new SecretKeySpec(password.getBytes(), "AES");
    }

    public String encrypt(String input) throws UnexpectedException {
        try {
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.ENCRYPT_MODE, getKeyFromPassword());
            return Base64.getEncoder().encodeToString(cipher.doFinal(input.getBytes()));
        } catch (Exception e) {
            logger.error(e.getMessage());
            e.printStackTrace();
            throw new UnexpectedException("");
        }
    }

    public String decrypt(String cipherText) throws UnexpectedException {
        try {
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.DECRYPT_MODE, getKeyFromPassword());
            return new String(cipher.doFinal(Base64.getDecoder().decode(cipherText)));
        } catch (Exception e) {
            logger.error(e.getMessage());
            e.printStackTrace();
            throw new UnexpectedException("");
        }
    }
}

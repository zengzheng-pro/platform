package com.platform.core.util;

import com.auth0.jwt.JWTSigner;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.JWTVerifyException;
import org.apache.commons.collections4.MapUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class JWTUtils implements Serializable {
    private static final Logger log = LoggerFactory.getLogger(JWTUtils.class);
    private static final long serialVersionUID = 7640141043291365235L;

//    private static final String SECRET = "!@#$%^12345@$%^&*ertyuERTYUIfghjVBNGH";
    private static final String SECRET = "!@#$%12345@$%&*zengzheng";
    private static final String BODY = "body";

    public JWTUtils() {
    }

    public static String sign(Map<String, Object> object, int expirySeconds) {
        JWTSigner signer = new JWTSigner(SECRET);
        Map<String, Object> claims = new HashMap();
        claims.put("body", object);
        JWTSigner.Options options = new JWTSigner.Options();
        options.setExpirySeconds(expirySeconds);
        return signer.sign(claims, options);
    }

    public static Map<String, Object> unsign(String token){
        JWTVerifier verifier = new JWTVerifier(SECRET);
        Map claims = null;

//        try {
//            claims = verifier.verify(token);
//        } catch (NoSuchAlgorithmException var4) {
//            log.error("NoSuchAlgorithmException", var4);
//        } catch (InvalidKeyException var5) {
//            log.error("InvalidKeyException", var5);
//        } catch (IOException var6) {
//            log.error("IOException", var6);
//        } catch (SignatureException var7) {
//            log.error("SignatureException", var7);
//        } catch (JWTExpiredException var8) {
//            throw var8;
//        } catch (JWTVerifyException var9) {
//            throw new CommonException("product.error.00001", new Object[0]);
//        } catch (Exception var10) {
//            throw new CommonException(var10);
//        }

        try {
            claims = verifier.verify(token);
        } catch (Exception var10) {
            return claims;
        }
        return MapUtils.getMap(claims, "body");
    }
}

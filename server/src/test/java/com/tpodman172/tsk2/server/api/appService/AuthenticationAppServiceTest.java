package com.tpodman172.tsk2.server.api.appService;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.security.KeyFactory;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.KeySpec;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class AuthenticationAppServiceTest {
    private static String testTempPrivateKey =
            "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCrAHwti7mUCdBw" +
            "GZa6GHKIlLRUfeVnGUB4bcv8S2vMAusmBVJKLUy5yzSv+Jy+h9cXbpKtbfYrlByq" +
            "kdKIDD/eZZuJBk67491HdFDXsIWOKi51N8W86av2jLZmnpJYmR/CEyrGzBZi9wAc" +
            "QTIku0pTvZwg200dgI1wRVDjEA1dD28Oqq37R+PD0+U7ignjmWKNmKVfaH1TdO/N" +
            "5/NGv/8aN40wVmiGzV/4thXa8z3fpUXx2u1bw4QMgjjCIBFEzo9KgSUnwk8wlXne" +
            "0DGyQ7jBQDSjE9TV0Www3JvtZuA42O2oJQqYYpSeBR++4drCO3HGXAzeZDnU0qp0" +
            "oAkuN66bAgMBAAECggEAaT5oLuPy+IC9z3CAStKnExZqkiHV4YkyG6x/wixtEOeu" +
            "7/yQc+TDdwnwyGj7l2wlXl+IWML3okSLDBOpfmADow3oFwJRzOPmGYcmBkm3ORMO" +
            "+sezpJwwYRKjZC8uJOdBG4IObsHG+WvJnpolkWPP0BA/mh0+reyjoDiZGtaTUvUd" +
            "sWUBlvpDeHGTaxoa+rt8RrvjQPNmKg7qWaTttMAAhOPy90qUEr+v98hXDYwWU1mm" +
            "1NAz9rXEEiKtYBHOojy3q12U10X1N3LDdus5SRr2edlSOrSfugvJUK8JkHkS7i/l" +
            "snFd+0VtDjogxIob9Mq7WIiBfYcrtRYWozqZDAXm8QKBgQDfKZxk302d6n6qnhBK" +
            "r50QHoejA2NcHj+xBnfoCZK3ev8s4EJz5PpHHGLlqcE+oOgMsYUSk6Zy3T6+wvQ2" +
            "MnGtVx6fgIOhqz0DTRIPIkdC7E/sfRPoNzooz7Lw3L+1xL/lCEEwSjf4V5E29P30" +
            "dEcNrMNwkpk16SQYMO5y1NxjCQKBgQDEKgQkt3HM1eSEJtfm3ZOkuCSaHRFg3sHR" +
            "pDk+NmgZwqU03FvbT/8Jwi4rC6v/NeeMslmRpcXBRanHMe6mDmZxCjGeSuzGZ38Y" +
            "0nNmTNxAsNuqsht0RDCDB3EH08n+qJs4jcT3YE2a2XAta09xmw7gInuPlUdpd/Ew" +
            "iKATGUQ5gwKBgQC43I5qXTS9uO++xHs4cytHnBK97eOT/pbCPVp8w9le1qulcAx8" +
            "VtUgrRobp7il+cLgKPnUPq1mf3InsfV9I+JZNk7u0BW6idBb+K8aDEo93OYEQESK" +
            "W515CzzvG95PY7GWt3TQ3NpqhZeMj/wDUYM+h7vKeBYku4Gj7HzKcRwziQKBgH4n" +
            "U0DVpN8Jk4uVe3Xie8gMEKX4GawFtfn/tjyXOr2OWzaynHRfbvI0qgJO4E8huIbY" +
            "UBgF1zbjeTs8lnC+hA0gdCaLotg5yRgKh+J7fY4w7yRIpLVSASzTBVL2Vkpq3mAx" +
            "dEFu8pmqSqU7BP1Xrepg4rvFUga29yqyQtflgOXHAoGAa2AwX7of0wcn+AqE3Nic" +
            "j6quKdsqUGrSoXxGz0/GuxhXe93CYKu2/S9zO1hzjat8DVpYI0XUc7y7iHA9LyYq" +
            "nftJ8Y3Nmw6GPEDWZrfK7xUGVPKRz8EQMFaQH8oRKA/5jYsO041DpMuSN4g3CA+G" +
            "F/5XzY1TTxA/uqdvJRncbSk=";

    private static String testTempPublicKey =
            "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAqwB8LYu5lAnQcBmWuhhy" +
            "iJS0VH3lZxlAeG3L/EtrzALrJgVSSi1Mucs0r/icvofXF26SrW32K5QcqpHSiAw/" +
            "3mWbiQZOu+PdR3RQ17CFjioudTfFvOmr9oy2Zp6SWJkfwhMqxswWYvcAHEEyJLtK" +
            "U72cINtNHYCNcEVQ4xANXQ9vDqqt+0fjw9PlO4oJ45lijZilX2h9U3TvzefzRr//" +
            "GjeNMFZohs1f+LYV2vM936VF8drtW8OEDII4wiARRM6PSoElJ8JPMJV53tAxskO4" +
            "wUA0oxPU1dFsMNyb7WbgONjtqCUKmGKUngUfvuHawjtxxlwM3mQ51NKqdKAJLjeu" +
            "mwIDAQAB";

    @Test
    void jwtLibrarySample() throws Exception {
        final BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        System.out.println(bCryptPasswordEncoder.encode("password"));
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        // private key was generated by the following command. pkcs8
        // openssl genpkey -out rsakey.pem -algorithm RSA -pkeyopt rsa_keygen_bits:2048
        KeySpec privateKeySpec = new PKCS8EncodedKeySpec(Base64.getDecoder().decode(testTempPrivateKey));
        RSAPrivateKey rsaPrivateKey = (RSAPrivateKey) keyFactory.generatePrivate(privateKeySpec);
        // public key was generated by the following command
        // openssl rsa -in rsakey.pem -pubout -out rsapublickey.pem
        KeySpec publicKeySpec = new X509EncodedKeySpec(Base64.getDecoder().decode(testTempPublicKey));
        RSAPublicKey rsaPublicKey = (RSAPublicKey) keyFactory.generatePublic(publicKeySpec);
        try {
            Algorithm algorithm = Algorithm.RSA256(null, rsaPrivateKey);
            String token = JWT.create()
                    .withIssuer("tsk2")
                    .sign(algorithm);
            Algorithm algorithm2 = Algorithm.RSA256(rsaPublicKey, null);
            JWTVerifier verifier = JWT.require(algorithm2)
                    .withIssuer("tsk2")
                    .build();
            DecodedJWT jwt = verifier.verify(token);
            assertThat(jwt.getIssuer()).isEqualTo("tsk2");
        } catch (JWTCreationException exception) {
            //Invalid Signing configuration / Couldn't convert Claims.
        }
    }
}
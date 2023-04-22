package com.deblabs.pos;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import io.jsonwebtoken.*;

public class Test {
    public static String secret  = "Ab98cd76@";
    public static void main(String[] args) throws InterruptedException {
        String token = generateTokenFromUsername("test");
        TimeUnit.SECONDS.sleep(10);
        String formatted  = "Bearer "+token;
        System.out.println(formatted.substring(7));
        System.out.println(validateJwtToken(token));
    }


    public static String generateTokenFromUsername(String username) {   
        return Jwts.builder()
            .setSubject(username)
            .setIssuedAt(new Date())
            .setExpiration(new Date((new Date()).getTime() + 86400000))
            .signWith(SignatureAlgorithm.HS512, secret)
            .compact();
      }


    public static boolean validateJwtToken(String authToken) {
        try {
          Jwts.parser().setSigningKey(secret).parseClaimsJws(authToken);
          return true;
        } catch (SignatureException e) {
          System.out.println("Invalid JWT signature: {}"+e.getMessage());
        } catch (MalformedJwtException e) {
            System.out.println("Invalid JWT token: {}"+ e.getMessage());
        } catch (ExpiredJwtException e) {
            System.out.println("JWT token is expired: {}"+ e.getMessage());
        } catch (UnsupportedJwtException e) {
            System.out.println("JWT token is unsupported: {}"+ e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println("JWT claims string is empty: {}"+ e.getMessage());
        }
    
        return false;
      }
}

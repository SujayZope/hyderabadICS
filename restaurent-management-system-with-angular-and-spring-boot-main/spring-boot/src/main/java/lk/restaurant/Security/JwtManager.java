package lk.restaurant.Security;


import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;

import javax.crypto.SecretKey;
import java.util.Calendar;
import java.util.Date;

public class JwtManager {

    public String signJWS(String username, String lastLogoutTime, String password, String userType)  {
        Date issued = new Date();
        Date expiration;
        Calendar c = Calendar.getInstance();
        c.setTime(issued);
        c.add(Calendar.DATE, 1);
        expiration = c.getTime();

        SecretKey secretKey = Keys.hmacShaKeyFor((lastLogoutTime + password + ApplicationConstants.SECRET).getBytes());

        return Jwts.builder()
                .setIssuer("CommercialTechnologyPlus")
                .setSubject(username)
                .setIssuedAt(issued)
                .setExpiration(expiration)
                .claim("userType", userType)
                .claim("expire",String.valueOf(expiration))
                .signWith(secretKey, SignatureAlgorithm.HS256)
                .compact();
    }

    public Jws<Claims> verifyJWS(String jws, String lastLogoutTime, String password) {
        SecretKey secretKey = Keys.hmacShaKeyFor((lastLogoutTime + password + ApplicationConstants.SECRET).getBytes());

        try {
            return Jwts.parser().setSigningKey(secretKey).parseClaimsJws(jws);
        } catch (JwtException e) {
            return null;
        }
    }

}

package hu.unideb.inf.kaloriaszamlalo.service.impl;

import hu.unideb.inf.kaloriaszamlalo.service.JwtAuthService;
import hu.unideb.inf.kaloriaszamlalo.service.UserService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Service
public class JwtAuthServiceImpl implements JwtAuthService {

    @Autowired
    UserService userService;

    @Override
    public String extractUsername(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    @Override
    public String generateToken(UserDetails userDetails) {//(UserDetails ud, Map<String, Obj> publicClaims
        //claims == public/private claim
        Map<String, Object> claims = new HashMap<>();
        //minden jogosultság külön claim
        userDetails.getAuthorities().forEach(authority -> claims.put(authority.getAuthority(), authority));

        return Jwts.builder()
                .claims(claims)
                .subject(userDetails.getUsername())
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis()+300000))
                .signWith(getSigningKey())
                .compact();
    }

    @Override
    public boolean validateToken(String token, UserDetails userDetails) {
        final String username = extractUsername(token);
        return (username.equals(userDetails.getUsername())) && !isTokenExpired(token);
    }

    private boolean isTokenExpired(String token) {
        Date d = extractClaim(token, Claims::getExpiration);
        return d.before(new Date());
    }

    private <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = Jwts.parser()
                .verifyWith(getSigningKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();

        return claimsResolver.apply(claims);
    }

    private SecretKey getSigningKey() {
        byte[] keyBytes = Decoders.BASE64.decode("8uz98uzzgtz7gtftz7gtzt6derdesrtf6tzfrtzt6gfz67tfz67fz67fcrtz6fr7z6t67ztgfz6tgfz67gtfzt6gzt6t6t6t6i6");
        SecretKey key = Keys.hmacShaKeyFor(keyBytes);
        return key;
    }
}

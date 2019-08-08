package jwt;

import io.jsonwebtoken.*;
import org.json.JSONObject;

import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JwtFactory {
    private static final Key KEY = new SecretKeySpec("chencong".getBytes(), SignatureAlgorithm.HS512.getJcaName());

    public static String getJwt(int userId,String password) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("user_id", userId);
        map.put("password",password);

        Calendar calendar=Calendar.getInstance();
        Date startDate=calendar.getTime();
        calendar.add(Calendar.MINUTE,1);
        Date expireDate=calendar.getTime();
        String compactJws = Jwts.builder()
                .setClaims(map)
                .signWith(SignatureAlgorithm.HS512, KEY)
                .setIssuedAt(startDate)
                .setExpiration(expireDate)

                .compact();
        return compactJws;
    }

    public static JwtBean parseJwt(String jwt) throws JwtException{
        JwtBean jwtBean = new JwtBean();
        Jws<Claims> claimsJws = Jwts.parser().setSigningKey(KEY)
                .parseClaimsJws(jwt);
        JwsHeader header = claimsJws.getHeader();
        Claims claims = claimsJws.getBody();

        jwtBean.setHeader(header);
        jwtBean.setBody(claims);
        return jwtBean;
    }

    public static void main(String[] args) {

        JwtBean jwtBean= null;
        try {
            jwtBean = JwtFactory.parseJwt(JwtFactory.getJwt(1,"chen"));
            System.out.println(jwtBean.getHeader());
            System.out.println(jwtBean.getBody());
        } catch (JwtException e) {
            e.printStackTrace();
        }
    }
}

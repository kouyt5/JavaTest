package jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwsHeader;

public class JwtBean {
    private JwsHeader header;
    private Claims body;

    public JwtBean(){}
    public JwtBean(JwsHeader header, Claims body) {
        this.header = header;
        this.body = body;
    }

    public JwsHeader getHeader() {
        return header;
    }

    public void setHeader(JwsHeader header) {
        this.header = header;
    }

    public Claims getBody() {
        return body;
    }

    public void setBody(Claims body) {
        this.body = body;
    }
}

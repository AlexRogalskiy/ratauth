package ru.ratauth.entities;

import lombok.*;

import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * @author mgorelikov
 * @since 01/11/15
 */
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthzEntry {
  private String id;
  private String authCode;
  private Long codeTTL;
  private Date created;
  private String refreshToken;
  private Long refreshTokenTTL;//created together with authCode
  private @Singular("scope") Set<String> scopes;
  private String relyingParty;//identifier
  private String identityProvider;//identifier
  private @Singular Set<String> resourceServers;//identifiers
  private String baseJWT;//base jwt
  private @Singular List<Token> tokens;

  public Long codeExpiresIn() {
    return created.getTime() + codeTTL;
  }
  public Long refreshTokenExpiresIn() {
    return created.getTime() + refreshTokenTTL;
  }
}
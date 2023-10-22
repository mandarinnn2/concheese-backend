package net.concheese.server.user.model;

import java.util.Map;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@Builder
@RequiredArgsConstructor
public class OAuthAttributes {

  private final Map<String, Object> attributes;
  private final String nameAttributeKey;
  private final String id;
  private final String name;
  private final String picture;

  public static OAuthAttributes of(String registrationId, String userNameAttributeName,
      Map<String, Object> attributes) {
    OAuthAttributes oAuthAttributes;
    if (registrationId.equals("naver")) {
      oAuthAttributes = ofNaver(userNameAttributeName, attributes);
    } else {
      throw new RuntimeException("unknown oauth registration");
    }
    return oAuthAttributes;
  }

  private static OAuthAttributes ofNaver(String userNameAttributeName,
      Map<String, Object> attributes) {
    Map<String, Object> response = (Map<String, Object>) attributes.get(userNameAttributeName);

    return OAuthAttributes.builder().id((String) response.get("id")).attributes(attributes)
        .nameAttributeKey(userNameAttributeName).build();
  }

  public User toEntity() {
    return User.builder().id(id).role(UserRole.GUEST).build();
  }
}
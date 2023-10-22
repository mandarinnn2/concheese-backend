package net.concheese.server.user.model;

import java.io.Serializable;
import lombok.Getter;

@Getter
public class UserSession implements Serializable {

  private final String id;

  public UserSession(User user) {
    this.id = user.getId();
  }

}

package net.concheese.server.user.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Builder
@RequiredArgsConstructor
@AllArgsConstructor
@Getter
@Entity
@Table(name = "users")
public class User implements Serializable {

  @Id
  private String id;

  @Column(nullable = false)
  @Enumerated(EnumType.STRING)
  private UserRole role;

  public User update(UserRole role) {
    this.role = role;
    return this;
  }

  public String getRoleKey() {
    return this.role.getKey();
  }

}

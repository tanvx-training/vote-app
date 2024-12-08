package dev.tanvx.auth_service.infrastructure.util;

import dev.tanvx.auth_service.application.model.UserContext;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Component
public class AuthenticationUtil {

  private static final String HEADER_USER_ID = "X-User-Id";

  private static final String HEADER_USER_ROLES = "X-User-Roles";

  public static UserContext getUserContext(HttpServletRequest request) {

    String userId = request.getHeader(HEADER_USER_ID);

    String rolesHeader = request.getHeader(HEADER_USER_ROLES);
    List<String> roles = Objects.nonNull(rolesHeader)
        ? Arrays.asList(rolesHeader.split(",")) : List.of();

    return UserContext.builder()
        .userId(userId)
        .roles(roles)
        .build();
  }
}
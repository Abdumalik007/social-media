package malik.social.com.role;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum Permission {
    USER_CREATE("user:create"),
    USER_READ("user:read"),
    USER_UPDATE("user:update"),
    USER_DELETE("user:delete");

    private final String permission;
}

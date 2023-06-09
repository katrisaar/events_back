package ee.valiit.events.business.enums;

import lombok.Getter;

@Getter
public enum UserRoleType {
    ADMIN("admin"),
    CUSTOMER("customer");

    private final String typeName;

    UserRoleType(String typeName) {
        this.typeName = typeName;
    }
}

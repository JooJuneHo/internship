package user.dto;

import lombok.AllArgsConstructor;
import user.entity.UserRoleEnum;

@AllArgsConstructor
public class AuthorityDto {
    private UserRoleEnum authorityName;
}

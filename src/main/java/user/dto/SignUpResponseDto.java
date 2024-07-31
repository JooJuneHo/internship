package user.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import user.entity.UserRoleEnum;

import java.util.List;

@Getter
@AllArgsConstructor
public class SignUpResponseDto {
    private String username;
    private String password;
    private List<AuthorityDto> authorities;
}

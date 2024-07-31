package user.dto;

import lombok.Getter;

@Getter
public class SignUpRequestDto {
    private String username;
    private String password;
    private String nickname;

    private boolean admin = false;
    private String adminToken = "";
}

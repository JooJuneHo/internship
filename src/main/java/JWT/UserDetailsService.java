package JWT;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import user.entity.User;
import user.entity.UserRoleEnum;

@Service
@RequiredArgsConstructor
public class UserDetailsService {
    public UserDetails getUser(Long userId, String username, String nickname, UserRoleEnum role)
            throws UsernameNotFoundException {
        User user = new User(userId, username, nickname, role);
        return new UserDetailsImpl(user);
    }
}
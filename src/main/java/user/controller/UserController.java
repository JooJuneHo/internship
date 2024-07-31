package user.controller;

import JWT.JwtUtil;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import user.dto.SignRequestDto;
import user.dto.SignResponseDto;
import user.dto.SignUpRequestDto;
import user.dto.SignUpResponseDto;
import user.entity.User;
import user.service.UserService;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final JwtUtil jwtUtil;

    @PostMapping("/signup")
    public ResponseEntity<SignUpResponseDto> signup(@RequestBody SignUpRequestDto requestDto){
        SignUpResponseDto responseDto = userService.signup(requestDto);
        return ResponseEntity.ok().body(responseDto);
    }

    @PostMapping("/sign")
    public ResponseEntity<SignResponseDto> sign(@RequestBody SignRequestDto requestDto, HttpServletResponse response){
        User signedUser = userService.sign(requestDto);
        String token = jwtUtil.createToken(signedUser.getUserId(), signedUser.getUsername(), signedUser.getNickname(), signedUser.getRole());
        response.setHeader(JwtUtil.AUTHORIZATION_HEADER, token);
        SignResponseDto responseDto = new SignResponseDto(token);
        return ResponseEntity.ok().body(responseDto);
    }
}

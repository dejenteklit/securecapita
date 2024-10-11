package com.dejen.securecapita.resource;

import com.dejen.securecapita.domain.HttpResponse;
import com.dejen.securecapita.domain.User;
import com.dejen.securecapita.dto.UserDTO;
import com.dejen.securecapita.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Map;

import static java.time.LocalDateTime.now;
import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping(path = "/user")
@RequiredArgsConstructor
public class UserResource {
private final UserService userService;
@PostMapping("/register")
    public ResponseEntity<HttpResponse> saveUser(@RequestBody @Valid User user) {
    UserDTO userDto = userService.createUser(user);
    return ResponseEntity.created(getUrl()).body(
            HttpResponse.builder()
                    .timestamp(now().toString())
                    .data(Map.of("User",userDto))// we don't need to return to the user in front end
                    .message(("User created"))
                    .status(CREATED)
                    .statusCode(CREATED.value())
                    .build());
}
    private URI getUrl() {
        return URI.create(ServletUriComponentsBuilder.fromCurrentContextPath() // corrected method
                .path("/user/get/<userId>" ).toUriString());
    }
}

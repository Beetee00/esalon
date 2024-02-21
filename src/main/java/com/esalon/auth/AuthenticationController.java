package com.esalon.auth;

import com.esalon.auth.request.AuthenticationRequest;
import com.esalon.auth.request.RegisterRequest;
import com.esalon.auth.responses.AuthenticationResponse;
import com.esalon.auth.responses.RegistrationResponse;
import com.esalon.config.RunTimeExceptionPlaceHolder;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/salon/auth")
@RequiredArgsConstructor
public class AuthenticationController {
  private final AuthenticationService service;

  @PostMapping("/register")
  public ResponseEntity<RegistrationResponse> register(
      @RequestBody RegisterRequest request
  ) throws RunTimeExceptionPlaceHolder{
    return ResponseEntity.ok(service.register(request));
  }
  @PostMapping("/authenticate")
  public ResponseEntity<AuthenticationResponse> authenticate(
      @RequestBody AuthenticationRequest request
  ) throws RunTimeExceptionPlaceHolder {
    return ResponseEntity.ok(service.authenticate(request));
  }
}

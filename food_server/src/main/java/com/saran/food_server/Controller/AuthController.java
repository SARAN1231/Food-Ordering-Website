package com.saran.food_server.Controller;

import com.saran.food_server.Config.JwtProvider;
import com.saran.food_server.Models.Cart;
import com.saran.food_server.Models.USER_ROLE;
import com.saran.food_server.Models.Users;
import com.saran.food_server.Repository.CartRepository;
import com.saran.food_server.Repository.UserRepository;
import com.saran.food_server.Responses.AuthResponse;
import com.saran.food_server.Service.CustomerUserDetailsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.Authenticator;
import java.util.Collection;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtProvider jwtProvider;
    private final CustomerUserDetailsService customerUserDetailsService;
    private final CartRepository cartRepository;

    public AuthController(UserRepository userRepository, PasswordEncoder passwordEncoder, JwtProvider jwtProvider, CustomerUserDetailsService customerUserDetailsService, CartRepository cartRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtProvider = jwtProvider;
        this.customerUserDetailsService = customerUserDetailsService;
        this.cartRepository = cartRepository;
    }

    @PostMapping("signup")
    public ResponseEntity<AuthResponse> CreateUserHandler(@RequestBody Users user)  throws Exception{
        Users isEmailexists = userRepository.findByEmail(user.getEmail());

        if (isEmailexists != null) {
            throw  new Exception("Email is already registered with another account");
        }
        Users createdUser = new Users();
        createdUser.setFullName(user.getFullName());
        createdUser.setEmail(user.getEmail());
        createdUser.setPassword(passwordEncoder.encode(user.getPassword()));
        createdUser.setRole(user.getRole());
        Users SavedUser = userRepository.save(createdUser);

        Cart cart = new Cart();
        cart.setCustomer(SavedUser);
        cartRepository.save(cart);

        Authentication authentication = new UsernamePasswordAuthenticationToken(user.getEmail(), user.getPassword()); // authentication object
        SecurityContextHolder.getContext().setAuthentication(authentication); // storing authentication object in security context for whole application access;

        String jwtToken = jwtProvider.generateToken(authentication);

        AuthResponse authResponse = new AuthResponse();
        authResponse.setMessage("Registration successful");
        authResponse.setJwt(jwtToken);
        authResponse.setRole(SavedUser.getRole());

        return new ResponseEntity<>(authResponse, HttpStatus.CREATED);


    }

    @PostMapping("signin")
    public ResponseEntity<AuthResponse> LoginHandler(@RequestBody Users user)  throws Exception{
        String username = user.getEmail();
        String password = user.getPassword();
        Authentication authentication = authenticate(username, password);
        // get the role  from authentication to send in response
        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
        String role = authorities.isEmpty() ? null : authorities.iterator().next().getAuthority();

        String jwt = jwtProvider.generateToken(authentication);
        AuthResponse authResponse = new AuthResponse();
        authResponse.setMessage("Login successful");
        authResponse.setRole(USER_ROLE.valueOf(role)); // bocoz role in USER_ROLE format
        authResponse.setJwt(jwt);
        return new ResponseEntity<>(authResponse, HttpStatus.OK);

    }

    private Authentication authenticate(String username, String password) {
        UserDetails userDetails = customerUserDetailsService.loadUserByUsername(username);

        if(userDetails == null) throw new BadCredentialsException("Invalid username....");

        if(!passwordEncoder.matches(password, userDetails.getPassword())) {
            throw new BadCredentialsException("Invalid password....");
        }
        return new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
    }

}

@RestController
@RequestMapping("/auth")
@Tag(name = "Auth")
public class AuthController {

    private final UserServiceImpl userService;
    private final JwtTokenProvider jwtTokenProvider;

    public AuthController(UserServiceImpl userService,
                          JwtTokenProvider jwtTokenProvider) {
        this.userService = userService;
        this.jwtTokenProvider = jwtTokenProvider;
    }

    @PostMapping("/register")
    public User register(@RequestBody RegisterRequest request) {
        User user = new User(null, request.getName(),
                request.getEmail(), request.getPassword(), "RESIDENT");
        return userService.register(user);
    }

    @PostMapping("/login")
    public LoginResponse login(@RequestBody LoginRequest request) {
        User user = userService.findByEmail(request.getEmail());
        String token = jwtTokenProvider.generateToken(null, user.getId(),
                user.getEmail(), user.getRole());
        return new LoginResponse(token);
    }
}

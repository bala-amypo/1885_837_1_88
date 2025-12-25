@Service
public class UserServiceImpl implements UserService {

    private final UserRepository repo;
    private final PasswordEncoder encoder;

    public UserServiceImpl(UserRepository r,PasswordEncoder e){
        this.repo=r; this.encoder=e;
    }

    public User register(User u){
        if(repo.existsByEmail(u.getEmail()))
            throw new BadRequestException("Duplicate email");

        u.setPassword(encoder.encode(u.getPassword()));
        return repo.save(u);
    }
}

package malik.social.com.service.impl;

import lombok.RequiredArgsConstructor;
import malik.social.com.dto.UserDto;
import malik.social.com.entity.User;
import malik.social.com.mapper.UserMapper;
import malik.social.com.repository.UserRepository;
import malik.social.com.role.Role;
import malik.social.com.service.main.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    public static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserMapper userMapper;

    @Override
    public void register(UserDto userDto) {
        User user = userMapper.toEntity(userDto);
        System.out.println(user);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole(Role.USER);
        System.out.println(user);
        userRepository.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findUserByEmail(username);
        if(user == null)
            throw new UsernameNotFoundException("Invalid username or password!");
        return user;
    }


}

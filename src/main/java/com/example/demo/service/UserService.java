    package com.example.demo.service;

    import com.example.demo.entity.User;
    import com.example.demo.repository.UserRepository;
    import org.checkerframework.checker.units.qual.A;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.security.core.GrantedAuthority;
    import org.springframework.security.core.authority.SimpleGrantedAuthority;
    import org.springframework.security.core.userdetails.UserDetails;
    import org.springframework.security.core.userdetails.UserDetailsService;
    import org.springframework.security.core.userdetails.UsernameNotFoundException;
    import org.springframework.security.crypto.password.PasswordEncoder;
    import org.springframework.stereotype.Service;
    import org.springframework.web.servlet.view.ResourceBundleViewResolver;

    import java.util.ArrayList;
    import java.util.List;
    @Service
    public class UserService implements UserDetailsService  {
        @Autowired
        UserRepository userRepository;
        @Autowired
        PasswordEncoder passwordEncoder;

        @Override
        public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
            User user = userRepository.findByUsername(username);
            if (user == null) {
                throw new UsernameNotFoundException("UserNotFound " + username);

            }
            List<GrantedAuthority> roles = new ArrayList<>();
            if ("ADMIN".equals(user.getRole())) { // compare strings using method .equal
                roles.add(new SimpleGrantedAuthority(user.getRole()));
            } else
                roles.add(new SimpleGrantedAuthority(user.getRole()));

            UserDetails userDetails = new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), roles);
            return userDetails;
        }
        public User RegisterUser(String username, String password, String role){
        try {
            if (userRepository.findByUsername(username) != null) {
                throw new RuntimeException("Username is already taken");
            }
            String encryptedPassord = passwordEncoder.encode(password);
            User user = new User();
            user.setUsername(username);
            user.setPassword(encryptedPassord);
            user.setRole(role);
            return userRepository.save(user);
        }
        catch(Exception e){
            throw new RuntimeException("Error during registration"+ e);
        }
        }

            public User insert(User user){
                return userRepository.save(user);

            }
            public User findByUserName(String user){
                return userRepository.findByUsername(user);
            }


    //    @Override
    //    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    //        return null;
    //    }
    }


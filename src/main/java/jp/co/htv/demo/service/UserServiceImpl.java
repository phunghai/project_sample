package jp.co.htv.demo.service;

import java.util.Arrays;
import java.util.HashSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import jp.co.htv.demo.dto.user.UserCreateDto;
import jp.co.htv.demo.dto.user.UserUpdateDto;
import jp.co.htv.demo.entity.Authority;
import jp.co.htv.demo.entity.User;
import jp.co.htv.demo.repository.AuthorityResository;
import jp.co.htv.demo.repository.UserRepository;
import jp.co.htv.demo.repository.specs.SearchCriteria;
import jp.co.htv.demo.repository.specs.SearchOperation;
import jp.co.htv.demo.repository.specs.UserSpecification;

/**
 * User Service Implement Class.
 * @author hainp
 *
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AuthorityResository authorityRespository;

    @Autowired
    private BCryptPasswordEncoder encoder;

    @Override
    public User findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public void saveUser(UserCreateDto userDto) {
        User userEntity = new User();
        userEntity.setPassword(encoder.encode(userDto.getPassword()));
        userEntity.setEnabled(true);
        userEntity.setName(userDto.getName());
        userEntity.setEmail(userDto.getEmail());

        Authority userAuthority = authorityRespository.findByAuthority("ROLE_ADMIN");
        userEntity.setAuthority(new HashSet<Authority>(Arrays.asList(userAuthority)));
        userRepository.save(userEntity);
    }

    @Override
    public User findUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
    }

    @Override
    public void deleteUser(User user) {
        userRepository.delete(user);
    }
    
    @Override
    public Page<User> findPaginatedByNameOrEmail(String name, String email, Pageable pageable) {
        UserSpecification userSpecification = new UserSpecification();
        userSpecification.add(new SearchCriteria("name", name, SearchOperation.MATCH));
        userSpecification.add(new SearchCriteria("email", email, SearchOperation.MATCH));
        // search name like %a%
        return userRepository.findAll(userSpecification, pageable);
    }

    @Override
    public int updateUser(UserUpdateDto userDto) {
        if (userDto.getPassword() != null) {
            String encodePassword = encoder.encode(userDto.getPassword());
            userRepository.updateUserNameAndPassword(userDto.getId(), 
                    userDto.getName(), encodePassword);
        } else {
            userRepository.updateUserName(userDto.getId(), userDto.getName());
        }
        return 0;
    }

}

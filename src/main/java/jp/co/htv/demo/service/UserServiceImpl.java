package jp.co.htv.demo.service;

import java.util.Arrays;
import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

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
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public User findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public void saveUser(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setEnabled(true);

        Authority userAuthority = authorityRespository.findByAuthority("ROLE_ADMIN");
        user.setAuthority(new HashSet<Authority>(Arrays.asList(userAuthority)));
        userRepository.save(user);
    }

    @Override
    public Iterable<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findUserById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
    }

    @Override
    public void deleteUser(User user) {
        userRepository.delete(user);
    }

    @Override
    public int updateUser(Long id, String name) {
        userRepository.updateUserName(id, name);
        return 0;
    }

    @Override
    public Page<User> findPaginatedByNameOrEmail(String name, String email, Pageable pageable) {
        UserSpecification userSpecification = new UserSpecification();
        userSpecification.add(new SearchCriteria("name", name, SearchOperation.MATCH));
        userSpecification.add(new SearchCriteria("email", email, SearchOperation.MATCH));
        // search name like %a%
        return userRepository.findAll(userSpecification, pageable);
    }

}

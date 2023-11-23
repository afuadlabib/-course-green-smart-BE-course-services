package com.smartgreen.course.services;

import com.smartgreen.course.exceptions.UnAuthorizeException;
import com.smartgreen.course.models.body.AuthResponse;
import com.smartgreen.course.models.entity.User;
import com.smartgreen.course.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;
import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    JwtService jwtService;
    @Autowired
    MongoTemplate mongoTemplate;

    public AuthResponse<?> register(User user)throws NoSuchAlgorithmException {
        user.setPassword(BCrypt.hashpw(user.getPassword(), BCrypt.gensalt()));
        User userCreated = userRepository.save(user);
        return AuthResponse.builder()
                .statusCode(HttpStatus.CREATED.value())
                .data(userCreated)
                .token(jwtService.generateToken(user.getId()))
                .build();

    }
    public AuthResponse<?> Login(User user) throws UnAuthorizeException{
        Query query = new Query();
        query.addCriteria(Criteria.where("email").is(user.getEmail()));
        List<User> users = mongoTemplate.find(query, User.class);
        System.out.println(users);
        User u = users.getFirst();

        if(BCrypt.checkpw(user.getPassword(), u.getPassword() )){
            return AuthResponse.builder()
                    .token(jwtService.generateToken(u.getId()))
                    .statusCode(HttpStatus.OK.value())
                    .data(u)
                    .build();
        }else {
            throw new UnAuthorizeException("Username or password wrong");
        }

    }
}

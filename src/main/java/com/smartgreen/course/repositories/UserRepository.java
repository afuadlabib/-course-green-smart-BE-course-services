package com.smartgreen.course.repositories;

        import com.smartgreen.course.models.entity.User;
        import org.springframework.data.mongodb.repository.MongoRepository;
        import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends MongoRepository<User, String> {
}

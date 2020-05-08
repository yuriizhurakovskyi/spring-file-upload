package ua.yurii.zhurakovskyi.springfileupload.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ua.yurii.zhurakovskyi.springfileupload.domain.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, String> {

}

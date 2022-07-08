package uz.nt.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import uz.nt.project.entity.Student;
import uz.nt.project.helpers.StudentImpl;

import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

    Optional<Student> findByName(String name);

    @Query(value = "select s.name Name, u.name UnivercityName, f.name FakultetName, g.name GroupName from Student s " +
            "join Groups g on s.group_id = g.id " +
            "join Fakultet f on g.fakultet_id = f.id " +
            "join Univercity u on f.univercity_id = u.id " +
            "where s.name = ?1", nativeQuery = true)
    StudentImpl findStudentInfo(String name);
}

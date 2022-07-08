package uz.nt.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import uz.nt.project.entity.Mark;
import uz.nt.project.helpers.SubjectImpl;

import java.util.List;

@Repository
public interface MarkRepository extends JpaRepository<Mark, Integer> {
    @Query("select sb from Subject sb " +
            "join Mark ma on ma.subject.id = sb.id " +
            "join Student st on ma.student.id = st.id " +
            "where st.id = ?1")
    List<SubjectImpl> getStudentSubjects(Integer id);
}

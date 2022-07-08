package uz.nt.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import uz.nt.project.entity.Group;
import uz.nt.project.helpers.GroupImpl;

import java.util.List;

@Repository
public interface GroupRepository extends JpaRepository<Group, Integer> {
    @Query("select g from Group g where g.fakultetId.id = ?1")
    boolean findByFakultetId(Integer id);

    @Query(value = "select s.name Name, su.name Subject, sum(m.mark) / count(m.mark) SredniyBall from Student s " +
            "left join Mark m on m.student_id = s.id " +
            "left join Subject su on m.subject_id = su.id " +
            "where group_id = ?1 " +
            "group by su.name, s.name " +
            "order by sredniyBall desc nulls last", nativeQuery = true)
    List<GroupImpl> getSredniyBallWithGroupId(Integer id);

}

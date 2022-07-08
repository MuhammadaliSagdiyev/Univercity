package uz.nt.project.repository;

import jakarta.persistence.NamedNativeQueries;
import jakarta.persistence.NamedNativeQuery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import uz.nt.project.entity.Fakultet;
import uz.nt.project.helpers.FakultetImpl;

import java.util.List;

@Repository
public interface FakultetRepository extends JpaRepository<Fakultet, Integer> {
    @Query("select g.name as name, count(g) as countGroups from Fakultet f " +
            "join Group g on g.fakultetId.id = f.id " +
            "join Student s on s.groupId.id = g.id " +
            "where f.id = ?1 " +
            "group by g.name")
    List<FakultetImpl> getGroupCount(Integer fakultetId);
}

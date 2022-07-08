package uz.nt.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.nt.project.entity.Univercity;

@Repository
public interface UnivercityRepository extends JpaRepository<Univercity, Integer> {
}

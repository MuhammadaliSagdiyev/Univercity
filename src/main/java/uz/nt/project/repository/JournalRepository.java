package uz.nt.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.nt.project.entity.Journal;

@Repository
public interface JournalRepository extends JpaRepository<Journal, Integer> {
}

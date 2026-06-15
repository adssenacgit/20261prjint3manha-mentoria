package br.com.johnny.mentoria.repository;

import br.com.johnny.mentoria.entity.Mentor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MentorRepository extends JpaRepository<Mentor, Integer> {
}

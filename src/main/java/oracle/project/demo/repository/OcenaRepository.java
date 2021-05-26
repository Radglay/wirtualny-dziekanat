package oracle.project.demo.repository;

import oracle.project.demo.model.Ocena;
import org.hibernate.engine.jdbc.cursor.internal.RefCursorSupportInitiator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.awt.*;
import java.sql.ResultSet;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

public interface OcenaRepository extends JpaRepository<Ocena, Long> {

    @Query("select o from Ocena o where o.waga_oceny = :waga")
    Ocena findByWaga_oceny(Long waga);

    @Modifying
    @Transactional
    @Query("update Ocena o set o.waga_oceny = :waga, o.wartosc = :wartosc where o.id_oceny = :id")
    void update(@Param("waga") int waga, @Param("wartosc") String wartosc ,@Param("id") Long id);


}

package org.sid.Repository;
import org.sid.entities.Structure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface StructureRepository extends  JpaRepository<Structure, Long> {
     @Autowired
	@Query(" select s from Structure s where s.nom like :x")
	public Page<Structure> chercher(@Param("x")String mc,Pageable pageable );
}

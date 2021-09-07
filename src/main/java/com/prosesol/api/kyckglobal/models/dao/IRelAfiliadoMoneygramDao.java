package com.prosesol.api.kyckglobal.models.dao;

import com.prosesol.api.kyckglobal.models.RelAfiliadoMoneygram;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface IRelAfiliadoMoneygramDao extends CrudRepository<RelAfiliadoMoneygram, Long> {

    @Query("select ram from RelAfiliadoMoneygram ram where ram.afiliado.id = :id")
    public RelAfiliadoMoneygram getAfiliadoMoneygramByAfiliado(@Param("id") Long id);

}

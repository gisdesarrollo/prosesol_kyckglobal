package com.prosesol.api.kyckglobal.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.prosesol.api.kyckglobal.models.Afiliado;

@Repository
public class AfiliadoRepository {

	@PersistenceContext
	public EntityManager em;

	@Transactional
	public void insertRelAfiliadosPagos(Afiliado afiliado, Long idPago){
		em.createNativeQuery("insert into rel_afiliados_pagos values(?,?)")
				.setParameter(1, afiliado.getId())
				.setParameter(2, idPago)
				.executeUpdate();
	}
}

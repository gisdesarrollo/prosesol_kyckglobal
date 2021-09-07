package com.prosesol.api.kyckglobal.services;

import com.prosesol.api.kyckglobal.models.RelAfiliadoMoneygram;
import com.prosesol.api.kyckglobal.models.dao.IRelAfiliadoMoneygramDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RelAfiliadoMoneygramServiceImpl implements IRelAfiliadoMoneygramService{

    @Autowired
    private IRelAfiliadoMoneygramDao relAfiliadoMoneygramDao;

    @Override
    public RelAfiliadoMoneygram getAfiliadoMoneygramByAfiliado(Long id) {
        return relAfiliadoMoneygramDao.getAfiliadoMoneygramByAfiliado(id);
    }
}

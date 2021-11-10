package com.prosesol.api.kyckglobal.services;

import com.prosesol.api.kyckglobal.models.Pago;
import com.prosesol.api.kyckglobal.models.dao.IPagoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IPagoServiceImpl implements IPagoService{

    @Autowired
    private IPagoDao pagoDao;

    @Override
    public void save(Pago pago) {
        pagoDao.save(pago);
    }
}

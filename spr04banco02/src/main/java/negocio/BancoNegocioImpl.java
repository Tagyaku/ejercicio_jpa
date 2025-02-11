package negocio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import persistencia.BancoDao;

@Service("bancoNegocio")
public class BancoNegocioImpl implements BancoNegocio {

	
    private BancoDao bancoDao;
    
    @Autowired
    public BancoNegocioImpl(BancoDao bancoDao) {
    	this.bancoDao=bancoDao;
    }

    
    public void setBancoDao(BancoDao bancoDao) {
        this.bancoDao = bancoDao;
    }

    @Override
    public void transferencia(long dni1, long dni2, double cantidad) {
        bancoDao.actualizaSaldo(dni1, cantidad);
        bancoDao.actualizaSaldo(dni2, -cantidad);
    }

    public BancoDao getBancoDao() {
        return bancoDao;
    }
}

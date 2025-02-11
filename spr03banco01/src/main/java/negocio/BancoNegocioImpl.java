package negocio;

import persistencia.BancoDao;

public class BancoNegocioImpl implements BancoNegocio {

    private BancoDao bancoDao;

    public BancoNegocioImpl() {}

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

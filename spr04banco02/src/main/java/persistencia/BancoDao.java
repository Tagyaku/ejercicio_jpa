package persistencia;

import org.springframework.stereotype.Repository;


public interface BancoDao {
	public void actualizaSaldo(long dni, double incrementoSaldo);
}

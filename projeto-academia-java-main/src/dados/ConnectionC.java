package dados;
import java.sql.SQLException;

import negocio.Pessoa;

public class ConnectionC {

	public static void main(String[] args) throws SQLException {
		
		Pessoa pessoa = new Pessoa("Raquel", "36348652145", 22);
		RepositorioPessoasDAO repDao = new RepositorioPessoasDAO();
		
		repDao.adiciona(pessoa);
		
	}
}
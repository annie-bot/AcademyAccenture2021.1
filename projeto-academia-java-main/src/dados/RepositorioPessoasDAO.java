package dados;

import java.sql.*;
import java.util.*;
import negocio.Pessoa;

public class RepositorioPessoasDAO {
	private Connection con = null;

	public RepositorioPessoasDAO() {
		this.con = ConexaoBd.getConnection();
	}

	public void adiciona(Pessoa pessoa) {
		String sql = "INSERT INTO pessoa (nome, cpf, idade) VALUES (?,?,?)";
		System.out.println(sql);

		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, pessoa.getNome());
			stmt.setString(2, pessoa.getCpf());
			stmt.setInt(3, pessoa.getIdade());
			stmt.execute();
			stmt.close();

			System.out.println("Gravado!");
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public List<Pessoa> getLista() {
		List<Pessoa> pessoas = new ArrayList<Pessoa>();
		String sql = "SELECT* FROM pessoa";
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Pessoa pessoa = new Pessoa(rs.getString("nome"), rs.getString("cpf"), rs.getInt("idade"));
				pessoas.add(pessoa);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return pessoas;
	}

	public void remover(String cpf) {

		try {
			// Create a statement

			// Prepare a statement to insert a record
			String sql = "DELETE FROM Pessoa WHERE cpf=?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, cpf);
			stmt.execute();
			stmt.close();
			System.out.println("Removido!");
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}
}


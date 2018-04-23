package exercicio2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Pais {
	private int id;
	private String nome;
	private long populacao;
	private double area;
	
	
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}
	
	public Pais(int id, String nome, long populacao, double area) {
		this.id =  id;
		this.nome = nome;
		this.populacao = populacao;
		this.area = area;
	}

	//Conexão com bd
	
	public Connection obtemConexao() throws SQLException {
		return DriverManager.getConnection("jdbc:mysql://localhost/atividade1?user=root");
	}
	public void criar() {
		String sqlInsert = "INSERT INTO pais(nome, populacao, area) VALUES (?, ?, ?)";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = obtemConexao();
				
		PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
			stm.setString(1, getNome());
			stm.setLong(2, getPopulacao());
			stm.setDouble(3, getArea());
			stm.execute();
			String sqlQuery = "SELECT LAST_INSERT_ID()";
			
			try(PreparedStatement stm2 = conn.prepareStatement(sqlQuery);
					
			ResultSet rs = stm2.executeQuery();) {
				if(rs.next()){
					setId(rs.getInt(1));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void atualizar() {
		String sqlUpdate = "UPDATE pais SET nome=?, populacao=?, area=? WHERE id=?";
		try (Connection conn = obtemConexao();
		PreparedStatement stm = conn.prepareStatement(sqlUpdate);) {
			stm.setString(1, getNome());
			stm.setLong(2, getPopulacao());
			stm.setDouble(3, getArea());
			stm.setInt(4, getId());
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void excluir() {
		String sqlDelete = "DELETE FROM pais WHERE id = ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = obtemConexao();
		
		PreparedStatement stm = conn.prepareStatement(sqlDelete);) {
			stm.setInt(1, getId());
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void carregar() {
		String sqlSelect = "SELECT nome FROM pais WHERE pais.id = ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = obtemConexao();
		PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setInt(1, getId());
			try (ResultSet rs = stm.executeQuery();) {
				if (rs.next()) {
					setNome(rs.getString("nome"));
					setPopulacao(rs.getLong(556345345));
					setArea(rs.getDouble(1293912));
				} else {
					setId(-1);
					setNome(null);
					setPopulacao(0);
					setArea(0);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
	}
	
	//metodos
	public ArrayList<Pais> vetPaises(){

		String sqlQuery = "SELECT id, nome, populacao, area FROM pais ORDER BY populacao LIMIT 3";

		try (Connection conn = obtemConexao();
			PreparedStatement stm = conn.prepareStatement(sqlQuery);){
			
			ArrayList<Pais> lista = new ArrayList<Pais>();
		
			try(ResultSet rs = stm.executeQuery();) {
				while(rs.next()){
					int id = rs.getInt("id");
					String nome = rs.getString("nome");					
					Long populacao = rs.getLong("populacao");
					double area = rs.getDouble("area");
					Pais paisSelected = new Pais(id, nome, populacao, area);
					
					lista.add(paisSelected);
				}
				return lista;				
			}
			} catch (SQLException e) {
				e.printStackTrace();
			}
	
		return null;
	}
	
	
	public String maiorPopulacao() {
		String sqlQuery = "SELECT nome, populacao FROM pais ORDER BY populacao DESC LIMIT 1";

		try (Connection conn = obtemConexao();
			PreparedStatement stm = conn.prepareStatement(sqlQuery);){
			
			try(ResultSet rs = stm.executeQuery();) {
				if(rs.next()){
					String nome = rs.getString("nome");
					String populacao = rs.getString("populacao");
					return nome + ": "+ populacao;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	
		return null;
	}
	
	
	public String menorArea() {
		String sqlQuery = "SELECT nome, area FROM pais ORDER BY area LIMIT 1";

		try (Connection conn = obtemConexao();
			PreparedStatement stm = conn.prepareStatement(sqlQuery);){
			
			try(ResultSet rs = stm.executeQuery();) {
				if(rs.next()){
					String nome = rs.getString("nome");
					String area = rs.getString("area");

					return nome + ": "+ area;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	
		return null;
	}
	
//gets e sets	
		
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public long getPopulacao() {
		return populacao;
	}

	public void setPopulacao(long populacao) {
		this.populacao = populacao;
	}

	public double getArea() {
		return area;
	}

	public void setArea(double area) {
		this.area = area;
	}

	
	

}


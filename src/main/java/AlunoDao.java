import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AlunoDao {

    public List<Aluno> list() {
        List<Aluno> alunos = new ArrayList<>();

        Connection con = ConnectionFactory.getConnection();

        try {
            PreparedStatement stmt = con.prepareStatement("SELECT * FROM aluno");
            ResultSet rs = stmt.executeQuery();

            while(rs.next()) {
                Aluno aluno = new Aluno();
                aluno.setId(rs.getInt("id"));
                aluno.setNome(rs.getString("nome"));
                aluno.setIdade(rs.getInt("idade"));
                aluno.setEstado(rs.getString("estado"));

                alunos.add(aluno);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return alunos;
    }

    public Aluno getById(Integer id) {
        Aluno aluno = new Aluno();

        Connection con = ConnectionFactory.getConnection();

        try {
            PreparedStatement stmt = con.prepareStatement("SELECT * FROM aluno WHERE id = ?");
            stmt.setInt(1, id);

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                aluno.setId(rs.getInt("id"));
                aluno.setNome(rs.getString("nome"));
                aluno.setIdade(rs.getInt("idade"));
                aluno.setEstado(rs.getString("estado"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return aluno;
    }

    public void create(Aluno aluno) {
        Connection con = ConnectionFactory.getConnection();

        try {
            PreparedStatement stmt = con.prepareStatement("INSERT INTO aluno(nome, idade, estado) VALUES(?, ?, ?)");
            stmt.setString(1, aluno.getNome());
            stmt.setInt(2, aluno.getIdade());
            stmt.setString(3, aluno.getEstado());

            stmt.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void update(Aluno aluno) {
        Connection con = ConnectionFactory.getConnection();

        try {
            PreparedStatement stmt = con.prepareStatement("UPDATE aluno SET nome = ?, idade = ?, estado = ? WHERE id = ?");
            stmt.setString(1, aluno.getNome());
            stmt.setInt(2, aluno.getIdade());
            stmt.setString(3, aluno.getEstado());
            stmt.setInt(4, aluno.getId());

            stmt.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void delete(Integer id) {
        Connection con = ConnectionFactory.getConnection();

        try {
            PreparedStatement stmt = con.prepareStatement("DELETE FROM aluno WHERE id = ?");
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}

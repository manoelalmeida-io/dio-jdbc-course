import java.util.List;

public class QueryExecution {

    public static void main(String[] args) {
        AlunoDao alunoDao = new AlunoDao();

        List<Aluno> alunos = alunoDao.list();
        alunos.stream().forEach(System.out::println);

        System.out.println("=".repeat(50));

        Aluno aluno = alunoDao.getById(3);
        System.out.println(aluno);

        System.out.println("=".repeat(50));

        alunoDao.create(new Aluno("Manoel", 19, "SP"));
        alunoDao.list().stream().forEach(System.out::println);

        //alunoDao.delete(5);
        alunoDao.update(new Aluno(6, "Manoel", 20, "SP"));
        System.out.println(alunoDao.getById(6));
    }
}

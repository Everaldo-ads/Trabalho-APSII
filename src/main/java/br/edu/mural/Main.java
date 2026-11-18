package br.edu.mural;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
        Professor professor = new Professor();
        Map<String, Aluno> alunos = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);

        try (Scanner entrada = new Scanner(System.in)) {
            System.out.println("Mural da turma");
            while (true) {
                System.out.println("""

                        1 - Inscrever aluno
                        2 - Publicar atividade
                        3 - Excluir atividade
                        4 - Publicar nota de um aluno
                        5 - Consultar pendências e notas
                        6 - Excluir aluno
                        0 - Sair""");
                String opcao = ler(entrada, "Opção");
                if (opcao == null || opcao.equals("0")) return;

                switch (opcao) {
                    case "1" -> {
                        String nome = ler(entrada, "Nome do aluno");
                        if (nome == null) return;
                        Aluno aluno = alunos.computeIfAbsent(nome, Aluno::new);
                        System.out.println(professor.inscrever(aluno) ? "Aluno inscrito." : "Aluno já inscrito.");
                    }
                    case "2", "3" -> {
                        String titulo = ler(entrada, "Título da atividade");
                        if (titulo == null) return;
                        if (opcao.equals("2")) {
                            System.out.println(professor.publicarAtividade(titulo)
                                    ? "Atividade publicada." : "Essa atividade já está publicada.");
                        } else {
                            System.out.println(professor.cancelarAtividade(titulo)
                                    ? "Atividade excluída." : "Atividade não encontrada.");
                        }
                    }
                    case "4", "5", "6" -> {
                        String nome = ler(entrada, "Nome do aluno");
                        if (nome == null) return;
                        Aluno aluno = alunos.get(nome);
                        if (aluno == null) {
                            System.out.println("Aluno não encontrado.");
                            continue;
                        }
                        switch (opcao) {
                            case "4" -> lancarNota(entrada, professor, aluno);
                            case "5" -> aluno.mostrarSituacao();
                            case "6" -> {
                                professor.cancelarInscricao(aluno);
                                alunos.remove(nome);
                                System.out.println("Aluno excluído.");
                            }
                        }
                    }
                    default -> System.out.println("Opção inválida.");
                }
            }
        }
    }

    private static void lancarNota(Scanner entrada, Professor professor, Aluno aluno) {
        String titulo = ler(entrada, "Título da atividade");
        if (titulo == null) return;
        String valor = ler(entrada, "Nota de 0 a 10");
        if (valor == null) return;
        try {
            double nota = Double.parseDouble(valor.replace(',', '.'));
            if (!Double.isFinite(nota) || nota < 0 || nota > 10) {
                System.out.println("A nota deve ser um número de 0 a 10.");
                return;
            }
            System.out.println(professor.publicarNota(aluno, titulo, nota) ? "Nota publicada."
                    : "Confira se o aluno está inscrito e se a atividade está publicada.");
        } catch (NumberFormatException e) {
            System.out.println("A nota deve ser um número de 0 a 10.");
        }
    }

    private static String ler(Scanner entrada, String campo) {
        System.out.print(campo + ": ");
        while (entrada.hasNextLine()) {
            String texto = entrada.nextLine().trim();
            if (!texto.isEmpty()) return texto;
            System.out.print("Preencha o campo. " + campo + ": ");
        }
        return null;
    }
}

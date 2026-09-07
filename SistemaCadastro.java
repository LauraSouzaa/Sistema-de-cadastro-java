SistemaCadastro() {
    System.out.println("\033[H\033[2J");
    System.out.flush();
}

String mensagemMenu() {
    String mensagemDoMenu = """
            ===== SISTEMA =====
            1. Cadastrar
            2. Sair
            """;
    return mensagemDoMenu;
}

void main() {
    LimparTela();
    boolean executando = true;
    while (executando) {
        IO.println(mensagemMenu());
        String opcaoStr = IO.readln("Escolha uma opção: ");
        int opcao;
        try {
            opcao = Integer.valueOf(opcaoStr);
            if (opcao !=1 && opcao != 2) {
                IO.println();
                IO.println("Opção inválida!");
                IO.println();
                continue;
            }
        } catch (NumberFormatException erro) {
            IO.println();
            IO.println("Digite apenas números!");
            IO.println();
            continue;
        }
        switch (opcao) {
            case 1:
                String nomeCliente = IO.readln("Digite seu nome completo: ");
                if (nomeCliente.trim().isEmpty()) { //trim() tira espaços do começo e do fim.
                    IO.println("O campo não pode estar vazio.");
                    continue;
                }
                String idadeStr = IO.readln("Digite sua idade com números: ");
                char genero = ' ';
                int idade;
                try {
                    idade = Integer.valueOf(idadeStr);
                    if (idade <= 0) {
                        IO.println();
                        IO.println("A idade deve ser maior que zero.");
                        IO.println();
                        continue;
                    }
                    String generoStr = IO.readln("Informe seu gênero: Masculino | Feminino | Não informar: ");
                    if (generoStr.trim().isEmpty()) {
                    IO.println("O campo não pode estar vazio.");
                    continue;
                    }
                    genero = generoStr.trim().charAt(0);
                    if (genero != 'f' && genero != 'F' && genero != 'm' && genero != 'M' && genero != 'n'
                            && genero != 'N') {
                        IO.println();
                        IO.println("Digite um valor válido!");
                        IO.println();
                        continue;
                    }
                    IO.println();
                    IO.println("Cadastro realizado!");
                    IO.println();
                } catch (NumberFormatException erro) {
                    IO.println();
                    IO.println("Digite apenas números!");
                    IO.println();
                    continue;
                }
                IO.println("Nome: " + nomeCliente);
                IO.println("Idade: " + idade);

                switch (genero) {
                    case 'm':
                    case 'M':
                        IO.println("Gênero Masculino.");
                        IO.println();                
                        break;
                    
                    case 'F':
                    case 'f':
                        IO.println("Gênero Feminino.");
                        IO.println();
                        break;

                    case 'N':
                    case 'n':
                        IO.println("Gênero não informado.");
                        IO.println();
                        break;
                }
            break;
            case 2:
                IO.println("Saindo...");
                executando = false;
                break;
        }

    }
}

/* MELHORIAS FUTURAS:

[✓] Mostrar o gênero por extenso (Masculino, Feminino, Não informado)

[ ] Limpar a tela depois de cada operação

[ ] Colocar uma pausa: "Pressione ENTER para continuar..."

[ ] Guardar os cadastros para não perder os dados

[ ] Permitir cadastrar vários clientes

[ ] Criar uma opção para visualizar os clientes cadastrados

[ ] Melhorar a validação do nome

[ ] Organizar melhor o código em métodos

[ ] Criar uma classe Cliente

*/
void LimparTela() {
    System.out.print("\033[H\033[2J");
    System.out.flush();
}
void main() {
    LimparTela();
    String nomeUsuario = IO.readln("Digite o seu nome: ");
    char genero=' ';
    try {
        String generoStr =IO.readln("Informe seu gênero: M para masculino | F para feminino | N para não informar ");
        genero = generoStr.charAt(0);

        if (genero != 'M' && genero != 'm' && genero != 'F' && genero != 'f' && genero != 'N'&&  genero !='n'){
            throw new Exception();
    }
    } catch (Exception erro) {
        IO.println("Informe um valor válido.");
        return;
    }
    String alturaStr = IO.readln("Digite a sua altura: ");
    String pesoStr = IO.readln("Digite seu peso; ");
    
    double altura = Double.valueOf(alturaStr);
    double peso = Double.valueOf(pesoStr);

    double imc = peso / (altura*altura);
     String classificação = ""; 
    switch (genero) {

        case 'M', 'm':
            if (imc >=20 && imc<=24.9 )
                classificação = "Normal";
            else if (imc>=25 && imc<=29.9)
                classificação = "Obesidade Leve";
            else if (imc >=30 && imc <=39.9)
                classificação = "Obesidade Moderada";
            else if (imc >=40)
                classificação = "Obesidade Mórbida";
            else
                classificação = "Abaixo do Normal";
            break;

        case 'F', 'f', 'N','n':
            if (imc >=19 && imc<=23.9)
                classificação = "Normal";

            else if (imc>=24 && imc<=28.9)
                classificação = "Obesidade Leve";

            else if (imc >=29 && imc <=38.9)
                classificação = "Obesidade Moderada";

            else if (imc >=39)
                classificação = "Obesidade Mórbida";
            else
                classificação = "Abaixo do Normal";
            break;
    
        default:
            IO.println("Ocorreu um erro");
            break;
        }
    IO.println("Nome: " + nomeUsuario);
    IO.println("Gênero: " + genero);
    IO.println("IMC: " + imc);
    IO.println("Classificação: " + classificação);
}   







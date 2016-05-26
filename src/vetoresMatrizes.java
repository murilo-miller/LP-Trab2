import java.util.Locale;
import java.util.Scanner;

public class vetoresMatrizes {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		sc.useLocale(Locale.ENGLISH);
		Locale.setDefault(new Locale("en", "US"));

		// Declaraçoes
		String nome[], tel[];
		int maior120 = 0,  posicao=0,qtdcli, t1 = 0, t2 = 0, minut1 = 0, media1 = 0, i, tipo[], min, minutos[], excedente[];
		double t2perc = 0, posicao2=100000000,receitatot = 0, vltotcont, vlass, valorconta[], prec, precos[][];

		// Controle de cliente (quantidade)
		System.out.print("Quantos clientes você deseja digitar? ");
		qtdcli = sc.nextInt();

		// alocação dos vetores
		nome = new String[qtdcli];
		tel = new String[qtdcli];
		tipo = new int[qtdcli];
		minutos = new int[qtdcli];
		valorconta = new double[qtdcli];
		excedente = new int[qtdcli];

		// Tabela de preços
		System.out.println();

		// Alocação das matrizes
		precos = new double[3][2];

		// Preenchimento da matriz
		for (i = 0; i <= 2; i++) {
			System.out.print("Digite o valor da assinatura do tipo " + i + ": ");
			precos[i][0] = sc.nextDouble();
			System.out.print("Digite o valor do minuto excedente para o tipo " + i + ": ");
			precos[i][1] = sc.nextDouble();
		}
		System.out.println();
		// Preenchimento dos dados dos vetores
		for (i = 0; i < qtdcli; i++) {
			System.out.print("Digite o nome do cliente: ");
			sc.nextLine();
			nome[i] = sc.nextLine();
			System.out.println("Digite o telefone do cliente: ");
			tel[i] = sc.next();
			System.out.println("Digite o tipo da conta do cliente: ");
			tipo[i] = sc.nextInt();
			while (tipo[i] > 2) {
				System.out.print("Digite um tipo valido, o limite é entre 0 e " + "2" + ": ");
				tipo[i] = sc.nextInt();
			}
			System.out.print("Digite a quantidade de minutos: ");
			minutos[i] = sc.nextInt();
			System.out.println();
			System.out.println();
			while (minutos[i] < 0) {
				System.out.print("Os minutos devem ser positivos digite novamente: ");
				minutos[i] = sc.nextInt();
			}
			if (tipo[i] == 1) {
				t1 = t1 + 1;
				minut1 = minut1 + minutos[i];
			} else if (tipo[i] == 2) {
				t2 = t2 + 1;
				t2perc = 100 / qtdcli * t2;
			}
			media1 = minut1 / t1;
			if (minutos[i] > 120) {
				maior120 = maior120 + 1;
			}
		}
		for (i = 0; i < qtdcli; i++) {
			if (minutos[i] < 91) {
				// Calculo da conta
				valorconta[i] = precos[tipo[i]][0];
				// Acumulador da receita total
				receitatot = receitatot + valorconta[i];
				// Nome e telefone de quem nao consumiu excedentes
				excedente[i] = 1;
			} else {
				// Calculo da conta
				valorconta[i] = precos[tipo[i]][0] + ((minutos[i] - 90) * precos[tipo[i]][1]);
				// Acumulador da receita total
				receitatot = receitatot + valorconta[i];

			}
		}
		
		for (i=0;i<qtdcli;i++){
			if (valorconta[i] < posicao2){
				posicao = i;
				posicao2 = valorconta[i];
			}
			
			
			
		}

		System.out.println("Nome\t\t|Telefone\t|Tipo\t|Minutos|Valor Da Conta\t|");
		for (i = 0; i < qtdcli; i++) {
			System.out.println(
					nome[i] + "\t|" + tel[i] + "\t|" + tipo[i] + "\t|" + minutos[i] + "\t|" + valorconta[i] + "\t\t|");
		}
		System.out.println();
		System.out.println("A receita total da empresa é de: " + receitatot);
		System.out.println("A conta mais barata foi a do cliente: "+nome[posicao]);
		System.out.println("A media dos minutos dos clientes tipo 1 é: " + media1);
		System.out.println("Os cliente que não consumiram minutos excedentes foram: ");
		for (i = 0; i < qtdcli; i++) {
			if (excedente[i] == 1)
				System.out.println(nome[i] + ", " + tel[1]);
		}
		System.out.println("Quantos clientes consumiram acima de 120 minutos: " + maior120);
		System.out.println(
				"A porcentagem de clientes que possuem conta tipo 2, em relação ao total de clientesé de: " + t2perc+"%");
		sc.close();

	}

}

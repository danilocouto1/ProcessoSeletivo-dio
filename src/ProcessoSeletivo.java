import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class ProcessoSeletivo {

	public static void main(String[] args) {

		imprimirSelecionados();
	}

	static void entrandoEmContato(String candidato) {

		int tentativasRealizadas = 1;
		boolean continuarTentando = true;
		boolean atendeu = false;
		do {
			atendeu = atender();
			continuarTentando = !atendeu;
			if (continuarTentando)
				tentativasRealizadas++;
			else
				System.out.println("CONTATO REALIZADO COM SUCESSO");

		} while (continuarTentando && tentativasRealizadas < 3);

		if (atendeu)
			System.out.println("CONSEGUIMOS CONTATO COM " + candidato + " NA " + tentativasRealizadas + " TENTATIVA");
		else
			System.out.println("NÃO CONSEGUIMOS CONTATO COM " + candidato + ", NÚMERO MAXIMO TENTATIVAS "
					+ tentativasRealizadas + " REALIZADA");

	}

	static boolean atender() {
		return new Random().nextInt(3) == 1;
	}

	static void imprimirSelecionados() {
		String[] candidatos = { "FELIPE", "MÁRCIA", "JULIA", "PAULO", "AUGUSTO" };
		System.out.println("Imprimir a lista de  candidatos  e o indice do elemento.");

		for (int i = 0; i < candidatos.length; i++) {
			System.out.println("O candidato " + candidatos[i] + " aprovado esta no indice  " + (i + 1) + " da lista");
		}

		System.out.println("Forma abreviada de interacao for each");
		for (String candidato : candidatos) {
			System.out.println("O candidato selecionado foi " + candidato);
		}
	}

	static double valorPretensao() {
		return ThreadLocalRandom.current().nextDouble(1800, 2200);
	}

	static void candidatosSelecionados() {

		String[] candidatos = { "FELIPE", "MÁRCIA", "JULIA", "PAULO", "AUGUSTO", "MÔNICA", "FABRÍCIO", "MIRELA",
				"DANIELA", "JORGE" };
		double salarioBase = 2000.00;
		int candidatosSelecionado = 0;
		int candidatoAtual = 0;

		while (candidatosSelecionado < 5 && candidatoAtual < candidatos.length) {
			String candidato = candidatos[candidatoAtual];
			double pretensao = valorPretensao();

			System.out.println("O candidadato " + candidato + " fez a seguinte pretensao salarial: " + pretensao);
			if (salarioBase >= pretensao) {
				System.out.println("O candidadato " + candidato + " foi selecionado para a vaga");
				candidatosSelecionado++;
			}
			candidatoAtual++;
		}
	}

	static void analisarCandidato(double pretensao) {
		double salarioBase = 2000.00;

		if (salarioBase > pretensao) {
			System.out.println("Ligar para o candidato!");
		} else if (salarioBase == pretensao) {
			System.out.println("Ligar para o candidato! Fazer contra-proposta.");
		} else {
			System.out.println("Aguardar demais candidadotos!");
		}
	}
}

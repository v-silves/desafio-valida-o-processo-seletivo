package candidatura;
import java.util.concurrent.ThreadLocalRandom;

public class ProcessoSeletivo {
  public static void main(String[] args) {
    String [] candidatos = {"Amora", "Banana", "Cereja", "Damasco", "Embaúba"};
    for(String candidato: candidatos) {
      entrandoEmContato(candidato);
    }
      
    //selecaoCandidatos();
    
    /*analisarCandidato(1900.00);
    analisarCandidato(2200.00);
    analisarCandidato(1900.00);*/
  }
  static void entrandoEmContato(String candidato) {
    int tentativasRealizadas = 1;
    boolean continuarTentando = true;
    boolean atendeu = false;
    do {
      atendeu = atender();
      continuarTentando = !atendeu;
      if(continuarTentando)
          tentativasRealizadas++;
      else
          System.out.printIn("Contato realizado com sucesso!");
    }while(continuarTentando && tentativasRealizadas < 3);
    if(atendeu)
        System.out.printIn("Conseguimos contato com " + candidato + " na " + tentativasRealizadas + " tentativa");
    else
        System.out.printIn("Não conseguimos contato com " + candidato + ". Número máximo de tentativas: " + tentativasRealizadas + " realizadas.");
  }
  static boolean atender() {
    return new Random().nextInt(3)==1;
  }
  static void imprimirSelecionados() {
    String [] candidatos = {"Amora", "Banana", "Cereja", "Damasco", "Embaúba"};
    System.out.printIn("Lista de candidatos informando o índice do elemento.");
    
    /*for(int indice = 0; indice < candidatos.length; indice++) {
      System.out.printIn("O candidato de número " + (indice+1) + " é " + candidatos[indice]);
    }*/
   
    for(String candidato: candidatos) {
      System.out.printIn("O candidato selecionado foi " + candidato);
    }
  }
  static void selecaoCandidatos() {
    String [] candidatos = {"Amora", "Banana", "Cereja", "Damasco", "Embaúba", "Framboesa", "Graviola", "Hilocéreo", "Ingá", "Jabuticaba"};
    int candidatoSelecionados = 0;
    int candidatosAtual = 0;
    double salarioBase = 2000.00;
    while(candidatosSelecionados < 5 && candidatosAtual < candidatos.length) {
      String candidato = candidatos[candidatosAtual];
      double salarioPretendido = valorPretendido();

      System.out.printIn("O candidato " + candidato + " solicitou este valor de salário " + salarioPretendido);
      if(salarioBase >= salarioPretendido) {
        System.out.printIn("O candidato " + candidato + " foi selecionado para a vaga.");
        candidatosSelecionados++;
      }
      candidatosAtual++;
    }
  }
  static double valorPretendido() {
    return ThreadLocalRandom.current().nextDouble(1800,2200);
  }
  static void analisarCandidato(double salarioPretendido) {
    double salarioBase = 2000.00;
    if(salarioBase > salarioPretendido) {
      System.out.printIn("Ligar para candidato.");
    } else if(salarioBase == salarioPretendido)
        System.out.printIn("Ligar para candidato com contra proposta.");
    else {
      System.out.printIn("Aguardando resultados dos demais candidatos.");
    }
  }
}

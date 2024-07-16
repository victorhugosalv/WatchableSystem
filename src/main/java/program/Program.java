package program;

import entities.Filme;
import entities.Serie;
import entities.Watchable;
import exception.WatchableException;

import models.WatchableSystem;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;


public class Program {
    public static void main(String[] args) throws WatchableException {
        Locale.setDefault(Locale.US);
        Scanner input = new Scanner(System.in);

        DateTimeFormatter fmt1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        WatchableSystem system = new WatchableSystem();
        boolean sair = true;
        while (sair) {
            try {

                Thread.sleep(1000);
                System.out.println("---------------------------------------------------------------------------------------------------------------");

                System.out.println("""
                        1) Adicionar um Assistível;\s
                        2) Remover um Assistível pelo Nome;\s
                        3) Listar Assistíveis;\s
                        4) Pesquisar um assistível pelo nome;\s
                        5) Sair;\s
                        """);

                System.out.print("Digite uma opção: ");
                int indice = input.nextInt();
                input.nextLine();
                System.out.println("---------------------------------------------------------------------------------------------------------------");

                switch (indice) {
                    case (1):

                        List<String> validation = Arrays.asList("Filme", "Série", "Serie");

                        System.out.print("Digite o tipo do conteúdo(Filme/Série): ");
                        String tipo = input.nextLine();

                        try {
                            if (!validation.contains(tipo))
                                throw new WatchableException("Não estamos aceitando outro tipo além de Filme e Série!");
                        } catch (WatchableException e){
                            System.err.println(e.getMessage());
                            break;
                        }


                        System.out.print("Digite o nome do " + tipo + ": ");
                        String nome = input.nextLine();

                        System.out.print("Digite o tempo de duraçâo: ");
                        double duracao = input.nextDouble();
                        input.nextLine();

                        System.out.print("Digite a data de lançamento(dd/MM/yyyy): ");
                        LocalDate date = LocalDate.parse(input.nextLine(), fmt1);

                        System.out.print("Digite a sinopse do " + tipo + " : ");
                        String sinopse = input.nextLine();

                        if (tipo.equalsIgnoreCase("Filme")) {
                            System.out.print("Digite o nome do diretor do Filme: ");
                            String diretor = input.nextLine();

                            system.cadastraWatchable(new Filme(tipo, nome, duracao, date, sinopse, diretor));
                            break;
                        }
                            System.out.print("Quantidade de Episódios da Série: ");
                            int episodios = input.nextInt();
                            input.nextLine();

                            system.cadastraWatchable(new Serie(tipo, nome, duracao, date, sinopse, episodios));
                        break;

                    case (2):

                        List<Watchable> watchs = system.listaWatchables();
                        if (watchs.isEmpty()) break;
                        watchs.stream().sorted(Comparator.comparing(Watchable::getDataDeLancamento)).forEach(System.out::println);

                        System.out.println("Digite o nome do conteúdo que deseja remover: ");
                        String nomeRemovivel = input.nextLine();

                        system.removeWatchablePorNome(nomeRemovivel);

                        break;

                    case (3):

                        system.listaWatchables().forEach(System.out::println);
                        break;

                    case (4):

                        System.out.print("Digite o nome do assistível: ");
                        String nomePesquisado = input.nextLine();

                        System.out.println();

                        Watchable watchable4 = system.pesquisaWatchablePeloNome(nomePesquisado);

                        if(watchable4 == null){
                            break;
                        }

                        System.out.println(watchable4);

                        break;

                    case (5):

                        sair = false;
                        System.out.println("Você saiu do programa!");
                        break;
                }

        } catch (RuntimeException e){
                System.err.println("Digitou o dado errado, digite novamente!");
                input.nextLine();
            }
            catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

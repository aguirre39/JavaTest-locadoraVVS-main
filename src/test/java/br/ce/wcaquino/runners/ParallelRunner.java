package br.ce.wcaquino.runners;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.junit.runners.BlockJUnit4ClassRunner;
import org.junit.runners.model.InitializationError;
import org.junit.runners.model.RunnerScheduler;

// Classe runner para executar os testes em paralelo
public class ParallelRunner extends BlockJUnit4ClassRunner {

    public ParallelRunner(Class<?> klass) throws InitializationError {
        super(klass);
        setScheduler(new ThreadPoll());
    }

    // Classe interna para gerenciar a execução dos testes em threads
    private static class ThreadPoll implements RunnerScheduler {
        private ExecutorService executor;

        public ThreadPoll() {
            // Cria um pool de threads com 5 threads
            executor = Executors.newFixedThreadPool(5);
        }

        // Método que agenda a execução de um teste em uma thread do pool
        public void schedule(Runnable run) {
            executor.submit(run);
        }

        // Método que finaliza a execução dos testes e aguarda a finalização das threads do pool
        public void finished() {
            executor.shutdown();
            try {
                executor.awaitTermination(10, TimeUnit.MINUTES);
            } catch (InterruptedException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }
        }

    }

}
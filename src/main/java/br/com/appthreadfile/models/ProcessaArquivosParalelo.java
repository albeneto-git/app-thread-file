package br.com.appthreadfile.models;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import lombok.Getter;

public class ProcessaArquivosParalelo {

	@Getter
	public List<String> linhasArquivo  = new ArrayList<>();
	
	public void run() throws InterruptedException, ExecutionException {
		
		// Retornando valores das tasks
		
		@SuppressWarnings("static-access")
		CompletableFuture<List<String>> task1 = new CompletableFuture<String>().supplyAsync(()->{
			GerenciaorDeArquivos gerFile = new GerenciaorDeArquivos();
			List<String> linhasArquivoList = gerFile.lerArquivo("c:\\temp\\despesas20250601.csv");
			return linhasArquivoList;
		});
		@SuppressWarnings("static-access")
		CompletableFuture<List<String>> task2 = new CompletableFuture<String>().supplyAsync(()->{
			GerenciaorDeArquivos gerFile = new GerenciaorDeArquivos();
			List<String> linhasArquivoList = gerFile.lerArquivo("c:\\temp\\despesas20250602.csv");
			return linhasArquivoList;
		});
		@SuppressWarnings("static-access")
		CompletableFuture<List<String>> task3 = new CompletableFuture<String>().supplyAsync(()->{
			GerenciaorDeArquivos gerFile = new GerenciaorDeArquivos();
			List<String> linhasArquivoList = gerFile.lerArquivo("c:\\temp\\despesas20250603.csv");
			return linhasArquivoList;
		});
		
		CompletableFuture<Void> allTasks = CompletableFuture.allOf(task1, task2, task3);
		allTasks.thenRun(()->{
			try {
				this.linhasArquivo.addAll(task1.get());
				this.linhasArquivo.addAll(task2.get());
				this.linhasArquivo.addAll(task3.get());
			} catch (InterruptedException | ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		
//		if(!linhasArquivo.isEmpty()) {
//			System.out.println("************ Arquivos lidos. Total de linhas: " + linhasArquivo.size() + " ************");
//		}
		
		
		// Sem retornar valores
//		CompletableFuture task1 = CompletableFuture.runAsync(()->{
//			GerenciaorDeArquivos gerFile = new GerenciaorDeArquivos();
//			gerFile.lerArquivo("c:\\temp\\despesas20250601.csv");
//		});
//		
//		CompletableFuture task2 = CompletableFuture.runAsync(()->{
//			GerenciaorDeArquivos gerFile = new GerenciaorDeArquivos();
//			gerFile.lerArquivo("c:\\temp\\despesas20250602.csv");
//		});
//		
//		CompletableFuture task3 = CompletableFuture.runAsync(()->{
//			GerenciaorDeArquivos gerFile = new GerenciaorDeArquivos();
//			gerFile.lerArquivo("c:\\temp\\despesas20250603.csv");
//		});
//		
//		CompletableFuture<Void> allTasks = CompletableFuture.allOf(task1, task2, task3);
//		allTasks.join();
		
	}
	
}

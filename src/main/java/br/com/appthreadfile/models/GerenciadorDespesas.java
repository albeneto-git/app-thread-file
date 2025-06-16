package br.com.appthreadfile.models;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import com.google.common.collect.Lists;

import br.com.appthreadfile.converter.ConversorDespesas;

public class GerenciadorDespesas {
	
	private List<String> linhasArquivo  = new ArrayList<>();
	private List<Despesa> despesas  = new ArrayList<>();

	public GerenciadorDespesas(List<String> linhasArquivo) {
		this.linhasArquivo = linhasArquivo;
	}
	
	public void run() {
		if(!linhasArquivo.isEmpty()) {
			
			List<List<String>> arquivoLists = Lists.partition(this.linhasArquivo, 4);
			
			@SuppressWarnings("static-access")
			CompletableFuture<List<Despesa>> convert1 = new CompletableFuture<Despesa>().supplyAsync(()->{
				ConversorDespesas convertDespesas = new ConversorDespesas(arquivoLists.get(0));
				List<Despesa> despesasConvertidas = new ArrayList<>();
				try {
					despesasConvertidas = convertDespesas.converter();
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return despesasConvertidas;
			});
			@SuppressWarnings("static-access")
			CompletableFuture<List<Despesa>> convert2 = new CompletableFuture<Despesa>().supplyAsync(()->{
				ConversorDespesas convertDespesas = new ConversorDespesas(arquivoLists.get(1));
				List<Despesa> despesasConvertidas = new ArrayList<>();
				try {
					despesasConvertidas = convertDespesas.converter();
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return despesasConvertidas;
			});
			@SuppressWarnings("static-access")
			CompletableFuture<List<Despesa>> convert3 = new CompletableFuture<Despesa>().supplyAsync(()->{
				ConversorDespesas convertDespesas = new ConversorDespesas(arquivoLists.get(2));
				List<Despesa> despesasConvertidas = new ArrayList<>();
				try {
					despesasConvertidas = convertDespesas.converter();
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return despesasConvertidas;
			});
			
			CompletableFuture<Void> allTasks = CompletableFuture.allOf(convert1, convert2, convert3);
			allTasks.thenRun(()->{
				try {
					this.despesas.addAll(convert1.get());
					this.despesas.addAll(convert2.get());
					this.despesas.addAll(convert3.get());
				} catch (InterruptedException | ExecutionException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			});
			
		}
	}
	
	public List<Despesa> getDespesas(){
		return this.despesas;
	}
	
	public void save(List<Despesa> despesas) {
		
	}
}

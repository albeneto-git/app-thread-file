package br.com.appthreadfile.principal;

import java.util.concurrent.ExecutionException;

import br.com.appthreadfile.models.GerenciadorDespesas;
import br.com.appthreadfile.models.ProcessaArquivosParalelo;

public class AppThreadFile {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ProcessaArquivosParalelo processaAsync = new ProcessaArquivosParalelo();
		processaAsync.run();
		GerenciadorDespesas gerenciadorDespesas = new GerenciadorDespesas(processaAsync.getLinhasArquivo());
		gerenciadorDespesas.run();
		System.out.println(" *************** Despesas Convertidas: " + gerenciadorDespesas.getDespesas().size());
		
	}

}

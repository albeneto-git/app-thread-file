package br.com.appthreadfile.models;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class GerenciaorDeArquivos {

	public List<String> lerArquivo(final String path) {
		List<String> linhas = new ArrayList<>();
		try (BufferedReader br = new BufferedReader(new FileReader(path))){
			String linha = br.readLine();
			while (!Objects.isNull(linha)) {
				linhas.add(linha);
				linha = br.readLine();
			}
		} catch (Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}
		return linhas;
	}
}

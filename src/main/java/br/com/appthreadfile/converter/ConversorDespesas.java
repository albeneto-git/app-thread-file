package br.com.appthreadfile.converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.com.appthreadfile.models.Despesa;

public class ConversorDespesas {
	
	private List<String> linhasArquivo  = new ArrayList<>();

	public ConversorDespesas(final List<String> linhasArquivo) {
		this.linhasArquivo = linhasArquivo;
	}

	
	public List<Despesa> converter() throws ParseException{
		
		List<Despesa> despesas  = new ArrayList<>();
		
		if(!this.linhasArquivo.isEmpty()) {
			for (String linha : linhasArquivo) {
				String[] registro = linha.split(";" );
				Despesa despesa = new Despesa(null, getData(registro[0]), registro[1], getValor(registro[2]));
				despesas.add(despesa);
			}
		}
		return despesas;
	}
	
	private Date getData(final String dataDespesa) throws ParseException {
		SimpleDateFormat  formatter = new SimpleDateFormat("dd/MM/yyyy");
		return formatter.parse(dataDespesa);
	}
	
	private Double getValor(final String valorDespesa) {
		return Double.valueOf(valorDespesa);
	}
}

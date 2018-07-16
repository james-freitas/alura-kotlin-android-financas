package br.com.alura.financask.model

import br.com.alura.financask.R.color.receita
import java.math.BigDecimal

class Resumo (private val transacoes: List<Transacao>) {

    val receita get() = somaPor(Tipo.RECEITA)

    val despesa get() = somaPor(Tipo.DESPESA)

    private fun somaPor(tipo: Tipo) : BigDecimal {
        val somaDeTransacoesPeloTipo =  transacoes
                .filter { it.tipo == tipo }
                .sumByDouble { it.valor.toDouble() }
        return BigDecimal(somaDeTransacoesPeloTipo)
    }

    val total get() = receita.subtract(despesa)

}
package br.com.boltenergy.desafio.services

import br.com.boltenergy.desafio.model.Usina
import br.com.boltenergy.desafio.repository.UsinaRepository

class UsinaService(
    private val repository: UsinaRepository
) {
    fun salvarTodos(dados: List<Map<String, String>>) {
        val usinas = dados.map { mapToUsina(it) }
        repository.saveAll(usinas)
    }

    private fun mapToUsina(map: Map<String, String>): Usina {
        return Usina(
            codigo = map["codigo"] ?: "",
            nome = map["nome"] ?: "",
            uf = map["uf"] ?: "",
            fonte = map["fonte"] ?: "",
            potencia = map["potencia"]?.toDoubleOrNull() ?: 0.0,
            empresa = map["empresa"] ?: ""
        )
    }
}
package br.com.boltenergy.desafio.services

import br.com.boltenergy.desafio.model.Usina
import br.com.boltenergy.desafio.repository.UsinaRepository
import org.springframework.data.domain.PageRequest
import org.springframework.stereotype.Service

@Service
class UsinaService(
    private val repository: UsinaRepository
) {
    fun salvarTodos(dados: List<Map<String, String>>) {
        val usinas = dados.map { mapToUsina(it) }.filterNotNull()
        repository.saveAll(usinas)
        println("🔥 Inseridos ${usinas.size} registros no banco com sucesso")
    }

    private fun mapToUsina(map: Map<String, String>): Usina? {
        val codigo = map["codigo"]?.takeIf { it.isNotBlank() } ?: return null
        val nome = map["nome"]?.takeIf { it.isNotBlank() } ?: return null
        val uf = map["uf"]?.takeIf { it.isNotBlank() } ?: return null
        val fonte = map["fonte"]?.takeIf { it.isNotBlank() } ?: return null
        val empresa = map["empresa"]?.takeIf { it.isNotBlank() } ?: return null
        val potencia = map["potencia"]
            ?.replace(",", ".")
            ?.toDoubleOrNull()
            ?.takeIf { it > 0 }
            ?: return null

        return Usina(
            codigo = codigo,
            nome = nome,
            uf = uf,
            fonte = fonte,
            potencia = potencia,
            empresa = empresa
        )
    }

    fun buscarTop5MaisPotentes(): List<Usina> {
        return repository.findTop5ByPotenciaDesc(PageRequest.of(0, 5))
    }

    fun estaVazio(): Boolean = repository.count() == 0L
}
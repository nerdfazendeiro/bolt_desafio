package br.com.boltenergy.desafio.services

import org.springframework.stereotype.Service
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.URL

@Service
class CsvDownloaderService {
    private val csvUrl = URL("https://dadosabertos.aneel.gov.br/dataset/57e4b8b5-a5db-40e6-9901-27ca629d0477/resource/4a615df8-4c25-48fa-bbea-873a36a79518/download/ralie-usina.csv")

    fun baixarCsv(limit: Int = 100): List<Map<String, String>> {
        val reader = BufferedReader(InputStreamReader(csvUrl.openStream(), Charsets.ISO_8859_1))
        val header = reader.readLine()?.split(";")?.map { it.trim('"') } ?: return emptyList()

        val codigoIdx = header.indexOf("CodCEG")
        val ufIdx = header.indexOf("SigUFPrincipal")
        val origemIdx = header.indexOf("DscOrigemCombustivel")
        val nomeIdx = header.indexOf("NomEmpreendimento")
        val potenciaIdx = header.indexOf("MdaPotenciaOutorgadaKw")
        val empresaIdx = header.indexOf("NomEmpresaConexao")

        return reader.lineSequence()
            .mapNotNull { linha ->
                val colunas = linha.split(";")
                try {
                    mapOf(
                        "codigo" to colunas[codigoIdx],
                        "nome" to colunas[nomeIdx],
                        "uf" to colunas[ufIdx],
                        "fonte" to colunas[origemIdx],
                        "potencia" to colunas[potenciaIdx].replace(",", "."),
                        "empresa" to colunas[empresaIdx]
                    )
                } catch (e: Exception) {
                    null
                }
            }.toList()
    }
}
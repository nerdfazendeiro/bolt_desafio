package br.com.boltenergy.desafio.scheduler

import br.com.boltenergy.desafio.services.CsvDownloaderService
import br.com.boltenergy.desafio.services.UsinaService
import jakarta.annotation.PostConstruct
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component

@Component
class CsvScheduler(
    private val downloader: CsvDownloaderService,
    private val usinaService: UsinaService
) {

    @Scheduled(cron = "0 0 0 16 * *")
    fun baixarPeriodicamente() {
        val dados = downloader.baixarCsv()
        println(dados)
        println("Job rodou com ${dados.size} registros")
    }

    @PostConstruct
    fun init() {
        if (usinaService.estaVazio()) {
            println("⚙️ Banco vazio. Rodando carga inicial...")
            val dados = downloader.baixarCsv()
            usinaService.salvarTodos(dados)
        } else {
            println("✅ Banco já possui dados. Ignorando carga inicial.")
        }
    }
}
package br.com.boltenergy.desafio.scheduler

import br.com.boltenergy.desafio.services.CsvDownloaderService
import jakarta.annotation.PostConstruct
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component

@Component
class CsvScheduler(private val downloader: CsvDownloaderService) {

    @Scheduled(cron = "0 0 0 16 * *")
    fun baixarPeriodicamente() {
        val dados = downloader.baixarCsv()
        println(dados)
        println("Job rodou com ${dados.size} registros")
    }

    @PostConstruct
    fun init() {
        println("Execução inicial do job na startup")
        baixarPeriodicamente()
    }
}
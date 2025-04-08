package br.com.boltenergy.desafio.controller

import br.com.boltenergy.desafio.model.Usina
import br.com.boltenergy.desafio.services.UsinaService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/usinas")
class UsinaController(
    private val service: UsinaService
) {
    @GetMapping("/top5")
    fun buscarTop5(): ResponseEntity<List<Usina>> {
        val top5 = service.buscarTop5MaisPotentes()
        return ResponseEntity.ok(top5)
    }
}

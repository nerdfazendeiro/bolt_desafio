package br.com.boltenergy.desafio.repository

import br.com.boltenergy.desafio.model.Usina
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.domain.Pageable

interface UsinaRepository : JpaRepository<Usina, Long>{
    @Query("SELECT u FROM Usina u ORDER BY u.potencia DESC")
    fun findTop5ByPotenciaDesc(pageable: Pageable): List<Usina>
}
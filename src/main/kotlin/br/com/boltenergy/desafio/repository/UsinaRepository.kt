package br.com.boltenergy.desafio.repository

import br.com.boltenergy.desafio.model.Usina
import org.springframework.data.jpa.repository.JpaRepository

interface UsinaRepository : JpaRepository<Usina, Long>
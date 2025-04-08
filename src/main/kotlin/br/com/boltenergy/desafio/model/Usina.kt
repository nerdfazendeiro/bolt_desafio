package br.com.boltenergy.desafio.model

import jakarta.persistence.*

@Entity
@Table(name = "usinas")
data class Usina(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @Column(nullable = false)
    val codigo: String,

    @Column(nullable = false)
    val nome: String,

    @Column(nullable = false)
    val uf: String,

    @Column(nullable = false)
    val fonte: String,

    @Column(nullable = false)
    val potencia: Double,

    @Column(nullable = false)
    val empresa: String
)
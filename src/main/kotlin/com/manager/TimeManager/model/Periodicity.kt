package com.manager.TimeManager.model

import com.fasterxml.jackson.annotation.JsonIgnore
import javax.persistence.*
import javax.validation.constraints.Positive

@Entity
class Periodicity(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Int? = null,

        @field:Positive
        val frequency: Int? = null,

        @field:Positive
        val repeats: Int? = null,

        @OneToOne
        @JoinColumn
        @JsonIgnore
        var task: Task? = null
)
package com.manager.TimeManager.model

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonProperty
import java.util.*
import javax.persistence.*
import javax.validation.constraints.Positive
import javax.validation.constraints.PositiveOrZero

@Entity
@Table(name = "notifications")
class Notification(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Int? = null,

        @field:Positive
        @Column(name = "hours_before", nullable = false)
        @JsonProperty("hours_before")
        val hoursBefore: Int? = null,

        @OneToOne
        @JoinColumn
        @JsonIgnore
        var task: Task? = null
)
package com.manager.TimeManager.model

import com.fasterxml.jackson.annotation.JsonIgnore
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "notifications")
class Notification(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Int,

        @Column(name = "hours_before", nullable = false)
        val hoursBefore: Int,

        @OneToOne
        @JoinColumn
        @JsonIgnore
        val task: Task
)
package com.manager.TimeManager.model

import java.util.Date
import javax.persistence.*

@Entity
@Table(name = "tasks")
class Task (
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        val id: Int,

        @Column(name = "start_date", nullable = false)
        var startDate: Date,

        @Column(name = "end_date", nullable = false)
        val endDate: Date,

        @Column
        var body: String? = null,

        @Column(nullable = false)
        var priority: Int,

        @ManyToOne
        @JoinColumn
        var user: AppUser
)
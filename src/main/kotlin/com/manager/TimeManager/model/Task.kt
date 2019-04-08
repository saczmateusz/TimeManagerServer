package com.manager.TimeManager.model

import com.fasterxml.jackson.annotation.JsonIgnore
import com.manager.TimeManager.facade.AuthFacade
import org.springframework.format.annotation.DateTimeFormat
import java.util.Date
import javax.persistence.*

@Entity
@Table(name = "tasks")
class Task (
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Int? = null,

        @Column(name = "start_date", nullable = false)
        @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
        val startDate: Date,

        @Column(name = "end_date", nullable = false)
        @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
        val endDate: Date,

        @Column
        var body: String? = null,

        @Column(nullable = false)
        var priority: Int,

        @ManyToOne
        @JoinColumn
        @JsonIgnore
        var user: AppUser = AuthFacade.user(),

        @OneToOne(mappedBy = "task")
        var notification: Notification? = null
)
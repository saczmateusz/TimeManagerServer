package com.manager.TimeManager.model

import com.fasterxml.jackson.annotation.JsonFormat
import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonProperty
import com.manager.TimeManager.facade.AuthFacade
import org.springframework.format.annotation.DateTimeFormat
import java.util.Date
import javax.persistence.*
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull
import javax.validation.constraints.PositiveOrZero

@Entity
@Table(name = "tasks")
class Task (
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Int? = null,

        @Column(name = "start_date", nullable = false)
        @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
        @JsonProperty("start_date")
        val startDate: Date? = null,

        @Column(name = "end_date", nullable = false)
        @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
        @JsonProperty("end_date")
        val endDate: Date? = null,

        var body: String? = null,

        @field:PositiveOrZero
        @Column(nullable = false)
        var priority: Int? = null,

        var isArchived: Boolean? = false,

        @ManyToOne
        @JoinColumn
        @JsonIgnore
        var user: AppUser? = null,

        @OneToOne(mappedBy = "task")
        val notification: Notification? = null,

        /* XDDD */
        var hasNotification: Boolean? = null,

        @OneToOne(mappedBy = "task")
        val periodicity: Periodicity? = null
)
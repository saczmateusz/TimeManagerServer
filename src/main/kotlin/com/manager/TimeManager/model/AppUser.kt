package com.manager.TimeManager.model

import com.fasterxml.jackson.annotation.JsonIgnore
import javax.persistence.*
import javax.validation.constraints.NotBlank

@Entity
@Table(name = "users")
class AppUser(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Int? = null,

        @Column(nullable = false, unique = true, length = 46)
        val username: String,

        @Column(nullable = false)
        @JsonIgnore
        var password: String,

        @Column(nullable = false, unique = true, length = 46)
        val email: String,

        @OneToMany(mappedBy = "user")
        val tasks: List<Task>? = null
)
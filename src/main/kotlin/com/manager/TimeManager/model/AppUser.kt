package com.manager.TimeManager.model

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonProperty
import javax.persistence.*
import javax.validation.constraints.Email
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotEmpty

@Entity
@Table(name = "users")
class AppUser(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Int? = null,

        @field:NotBlank
        @Column(nullable = false, unique = true, length = 46)
        val username: String? = null,

        @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
        @field:NotBlank
        @Column(nullable = false)
        var password: String? = null,

        @field:NotBlank
        @field:Email
        @Column(nullable = false, unique = true, length = 46)
        val email: String? = null,

        @OneToMany(mappedBy = "user")
        var tasks: List<Task>? = null
)
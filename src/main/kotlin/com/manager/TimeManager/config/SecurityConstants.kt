package com.manager.TimeManager.config

class SecurityConstants {
    companion object {
        val SECRET : String = "vTufDtwwpmmT3RxoWuHU"
        val TOKEN_PREFIX : String = "Bearer "
        val HEADER_STRING : String = "Authorization"
        val EXPIRATION_TIME : Long = 864_000_000L //1 day
    }

}
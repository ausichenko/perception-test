package com.ausichenko.test.perception.data.repository

interface Repository {

    fun isFirstStart(): Boolean
    fun setNonFirstStart()
}
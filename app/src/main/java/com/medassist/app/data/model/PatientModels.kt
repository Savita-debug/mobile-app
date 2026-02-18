package com.medassist.app.data.model

import com.google.gson.annotations.SerializedName

data class Patient(
    val id: Int,
    val user: PatientUser,
    val age: Int?,
    @SerializedName("medical_conditions")
    val medicalConditions: String?,
    @SerializedName("adherence_rate")
    val adherenceRate: Double?,
    val caretaker: Int?
)

data class PatientUser(
    val id: Int,
    val name: String,
    val email: String
)

data class CreatePatientRequest(
    @SerializedName("user_email")
    val userEmail: String,
    val age: Int,
    @SerializedName("medical_conditions")
    val medicalConditions: String
)

package com.example.kevin_araneda_20250307_trabajosemana7

import com.google.gson.annotations.SerializedName
// data class que representa la estructura de como se mostraran los datos en pantalla obtenidos desde la api
data class Farmacia(
    @SerializedName("local_id") val localId: String,
    @SerializedName("local_nombre") val localNombre: String,
    @SerializedName("comuna_nombre") val comunaNombre: String,
    @SerializedName("local_direccion") val localDireccion: String,
    @SerializedName("funcionamiento_hora_apertura") val funcionamientoHoraApertura: String,
    @SerializedName("funcionamiento_hora_cierre") val funcionamientoHoraCierre: String
)
package com.example.kevin_araneda_20250307_trabajosemana7

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class FarmaciaAdapter(private val farmacias: List<Farmacia>) :
    RecyclerView.Adapter<FarmaciaAdapter.FarmaciaViewHolder>() {
    // Campo que contiene todas las vistas para cada item de la lista creada
    class FarmaciaViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val nombre: TextView = view.findViewById(R.id.tvNombre)
        val comuna: TextView = view.findViewById(R.id.tvComuna)
        val direccion: TextView = view.findViewById(R.id.tvDireccion)
        val horario: TextView = view.findViewById(R.id.tvHorario)
    }

    //Crea una nueva lista para un item en el reciclerview

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FarmaciaViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_farmacia, parent, false)
        return FarmaciaViewHolder(view)
    }
// enlaza los datos de una farmacia a las vistas correspondientes
    override fun onBindViewHolder(holder: FarmaciaViewHolder, position: Int) {
        val farmacia = farmacias[position]
        holder.nombre.text = farmacia.localNombre
        holder.comuna.text = "Comuna: ${farmacia.comunaNombre}"
        holder.direccion.text = "Dirección: ${farmacia.localDireccion}"
        holder.horario.text = "Horario: ${farmacia.funcionamientoHoraApertura} - ${farmacia.funcionamientoHoraCierre}"
    }
 //Devuelve la cantidad del total de elemtos en la lista de farmacias
    override fun getItemCount(): Int = farmacias.size
}

package com.example.ejercicionavigationcomponentkotlin.fragmentos

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.ejercicionavigationcomponentkotlin.R
import com.example.ejercicionavigationcomponentkotlin.databinding.FragmentFinalBinding

//Creamos la clase FinalFragmento que extiende de Fragment que representa una interfaz particular
// que se ejecuta dentro de un Activity
class FinalFragment : Fragment() {
    //Creamos el binding que nos sirve para la vinculacion de vista
    private lateinit var binding: FragmentFinalBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    //Método llamado para que el fragmento cree una instancia de su vista de interfaz de usuario
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //Estas lineas hace que se nos vincule las vistas con el fragmento
        binding = FragmentFinalBinding.inflate(layoutInflater, container, false)
        // Inflate the layout for this fragment
        return binding.root
    }

    //Método que se llama justo después que el anterior, haya regresado, pero antes de que se haya
    //restaurado cualquier estado guardado en la vista
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //Definimos un escuchador mediante el método setOnClickListener que esta asociado al boton
        //con su vista, cuando se pulsa el botón, navegamos a un destino desde el gráfico de
        //navegación actual
        binding.btVolverInicio.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_finalFragment_to_inicioFragment)
        }
    }
}
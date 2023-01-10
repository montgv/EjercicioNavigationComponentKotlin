package com.example.ejercicionavigationcomponentkotlin.fragmentos

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.example.ejercicionavigationcomponentkotlin.R
import com.example.ejercicionavigationcomponentkotlin.databinding.FragmentInicioBinding

//Creamos la clase InicioFragmento que extiende de Fragment que representa una interfaz particular
// que se ejecuta dentro de un Activity
class InicioFragment : Fragment() {
    //Creamos el binding que nos sirve para la vinculacion de vista
    private lateinit var binding: FragmentInicioBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
    //Método llamado para que el fragmento cree una instancia de su vista de interfaz de usuario
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //Estas lineas hace que se nos vincule las vistas con el fragmento
        binding = FragmentInicioBinding.inflate(layoutInflater, container, false)
        // Inflate the layout for this fragment
        return binding.root
    }

    //Método que se llama justo después que el anterior, haya regresado, pero antes de que se haya
    //restaurado cualquier estado guardado en la vista
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //Declaramos estas dos variables que van a guardar información
        var texto = ""
        var numero = 0

        //Declaramos la variable para que encuentre ese componente en la vista
        val navController = Navigation.findNavController(view)

        //Definimos un escuchador mediante el método setOnClickListener que esta asociado al boton
        //con su vista, cuando se pulsa el botón, comento línea a línea
        binding.btSegundaPantalla.setOnClickListener {
            //Si los dos editText en la vista están vacíos, nos muestra un aviso con el texto
            //introducido, sino lo que hace es guardar en las dos variables anteriores los
            //editText de la vista
            if (binding.edTexto.text.toString().isEmpty() || binding.edNumero.text.toString().isEmpty()) {
                Toast.makeText(context, "Debes introducir valores en todos los campos", Toast.LENGTH_SHORT).show()
            } else {
                texto = binding.edTexto.text.toString()
                numero = binding.edNumero.text.toString().toInt()

                //Creamos un objeto de tipo Bundle en el que guardamos el objeto persona que queremos
                //mandar a la siguiente fragmento
                val bundle = Bundle()
                bundle.putString("texto", texto)
                bundle.putInt("numero", numero)

                //Navegamos a un destino desde el gráfico de navegación actual y mandando el bundle
                navController.navigate(R.id.action_inicioFragment_to_segundoFragment, bundle)
            }
        }
    }
}
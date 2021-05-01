package com.example.pruebaindividual2m4rodolfoparada
//Rodolfo Parada
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import android.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.pruebaindividual2m4rodolfoparada.databinding.ActivityMainBinding
import org.jetbrains.anko.alert
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
class MainActivity : AppCompatActivity() {
    //variables
    lateinit var vistaimagen: RecyclerView
    //lateinit var ivDog:ImageView
    //lateinit var imagenesCachorro:List<String>
    lateinit var AnimalAdapter: AnimalZAdapter
    // lateinit var Buscador:SearchView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Buscador = findViewById(R.id.Lupa)
        vistaimagen = findViewById(R.id.RecyclerVista) as RecyclerView
        //  Buscador.setOnQueryTextListener(this)
      // hace que se ejecute el metodo
        MostrarImagenPerro()
    }

    private fun initCharacter(puppies: AnimalZResponse) {

        AnimalAdapter = AnimalZAdapter(puppies.images)
        vistaimagen.setHasFixedSize(true)
        vistaimagen.layoutManager = LinearLayoutManager(this)
        vistaimagen.adapter = AnimalAdapter
    }

    // este metodo carga la imagen de la api
    private fun MostrarImagenPerro() {
        doAsync {
            val call = getRetrofit().create(APIService::class.java).getConexionConApi("dalmatian/images")
                .execute()
            val puppies = call.body() as AnimalZResponse
            uiThread {
                initCharacter(puppies)
            }
        }
    }
    //obtiene la informacion de la api
    private fun getRetrofit(): Retrofit {
        return Retrofit.Builder().baseUrl("https://dog.ceo/api/breed/").addConverterFactory(GsonConverterFactory.create()).build()
    }
}


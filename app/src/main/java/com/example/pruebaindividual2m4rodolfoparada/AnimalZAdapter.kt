package com.example.pruebaindividual2m4rodolfoparada
//Rodolfo Parada
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

// sincroniza las imagenes con el recyclervoew
class AnimalZAdapter (val images: List<String>) : RecyclerView.Adapter<AnimalZAdapter.ViewHolder>() {
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = images[position]
        holder.bind(item)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ViewHolder(layoutInflater.inflate(R.layout.item_dog, parent, false))
    }

    override fun getItemCount(): Int {
        return images.size
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bind(image: String) {
            var idPerro = itemView.findViewById(R.id.imagenes1) as ImageView
            idPerro.fromUrl(image)
        }

        fun ImageView.fromUrl(url:String){
            Picasso.get().load(url).into(this)
        }
    }
}


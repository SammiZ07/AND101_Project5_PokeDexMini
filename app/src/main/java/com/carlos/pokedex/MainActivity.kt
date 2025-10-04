package com.carlos.pokedex

import android.os.Bundle
import android.view.inputmethod.EditorInfo
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.carlos.pokedex.databinding.ActivityMainBinding
import com.codepath.asynchttpclient.AsyncHttpClient
import com.codepath.asynchttpclient.callback.JsonHttpResponseHandler
import okhttp3.Headers
import org.json.JSONObject
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val client = AsyncHttpClient()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        fetchPokemon(Random.nextInt(1, 898))


        binding.btnRandom.setOnClickListener {
            val id = Random.nextInt(1, 898)
            fetchPokemon(id)
        }


        binding.btnSearch.setOnClickListener {
            val q = binding.etQuery.text.toString().trim()
            if (q.isNotEmpty()) fetchPokemon(q)
        }

        binding.etQuery.setOnEditorActionListener { _, actionId, _ ->
            if (actionId == EditorInfo.IME_ACTION_DONE) {
                val q = binding.etQuery.text.toString().trim()
                if (q.isNotEmpty()) fetchPokemon(q)
                true
            } else false
        }
    }

    private fun fetchPokemon(query: Any) {
        setStatus(true, "Loading…")
        val url = "https://pokeapi.co/api/v2/pokemon/$query"

        client.get(url, object : JsonHttpResponseHandler() {
            override fun onSuccess(statusCode: Int, headers: Headers, json: JSON) {
                val obj = json.jsonObject
                bindPokemon(obj)
                setStatus(false, "")
            }

            override fun onFailure(
                statusCode: Int,
                headers: Headers?,
                response: String?,
                throwable: Throwable?
            ) {
                setStatus(true, "Error $statusCode. Try another name/ID.")
            }
        })
    }

    private fun bindPokemon(obj: JSONObject) {
        val name = obj.getString("name").replaceFirstChar { it.uppercase() }

        val sprites = obj.getJSONObject("sprites")
        val imgUrl = sprites.optString("front_default", "")

        val typesArr = obj.getJSONArray("types")
        val typesList = buildList {
            for (i in 0 until typesArr.length()) {
                val typeName = typesArr.getJSONObject(i)
                    .getJSONObject("type")
                    .getString("name")
                add(typeName.replaceFirstChar { it.uppercase() })
            }
        }
        val types = typesList.joinToString(", ")

        val heightMeters = obj.getInt("height") / 10.0
        val weightKg = obj.getInt("weight") / 10.0

        binding.tvName.text = "Name: $name"
        binding.tvTypes.text = "Type(s): $types"
        binding.tvStats.text = "Height: %,.1f m   Weight: %,.1f kg".format(heightMeters, weightKg)

        if (imgUrl.isNotEmpty()) {
            Glide.with(this)
                .load(imgUrl)
                .into(binding.ivSprite)
        } else {
            binding.ivSprite.setImageDrawable(null)
        }
    }

    private fun setStatus(visible: Boolean, text: String) {
        binding.tvStatus.text = text
        binding.tvStatus.visibility = if (visible && text.isNotEmpty()) android.view.View.VISIBLE
        else android.view.View.GONE
    }
}

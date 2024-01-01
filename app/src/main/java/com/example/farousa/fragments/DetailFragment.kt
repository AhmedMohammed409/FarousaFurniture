package com.example.farousa.fragments

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.example.farousa.databinding.FragmentDetailBinding

class DetailFragment : Fragment() {
    private lateinit var binding: FragmentDetailBinding
    private val args:DetailFragmentArgs by navArgs()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding=FragmentDetailBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.productName.text = args.DataClass.name
        binding.productFullDescription.text = args.DataClass.longDescription
        binding.productPrice.text = args.DataClass.price
        binding.imageview.setImageResource(args.DataClass.imageId)

        binding.btnVirtual.setOnClickListener {
            createModel(
                args.DataClass.modelURL.toString(),
                args.DataClass.name.toString()
            )

        }

    }
    private fun createModel(modelURL: String, name: String) {
        val sceneViewerIntent = Intent(Intent.ACTION_VIEW)
        val intentUri =
            Uri.parse("https://arvr.google.com/scene-viewer/1.0").buildUpon()
                .appendQueryParameter("file", modelURL)
                .appendQueryParameter("mode", "ar_only")
                .appendQueryParameter("resizable", "false")
                .appendQueryParameter("title", name)
                .build()
        sceneViewerIntent.data = intentUri
        sceneViewerIntent.setPackage("com.google.ar.core")
        startActivity(sceneViewerIntent)
    }

}
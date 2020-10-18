package ru.alexnimas.imagesearchapp.ui.gallery

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import ru.alexnimas.imagesearchapp.R
import ru.alexnimas.imagesearchapp.data.adapters.UnsplashPhotoAdapter
import ru.alexnimas.imagesearchapp.databinding.FragmentGalleryBinding

@AndroidEntryPoint
class GalleryFragment : Fragment(R.layout.fragment_gallery) {

    private val viewModel by viewModels<GalleryViewModel>()

    private var binding: FragmentGalleryBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentGalleryBinding.bind(view)

        val adapter = UnsplashPhotoAdapter()

        binding?.apply {
            rvGallery.setHasFixedSize(true)
            rvGallery.adapter = adapter
        }

        viewModel.photos.observe(viewLifecycleOwner) { data ->
            adapter.submitData(viewLifecycleOwner.lifecycle, data)
        }
    }

    override fun onDestroyView() {
        binding = null
        super.onDestroyView()
    }
}
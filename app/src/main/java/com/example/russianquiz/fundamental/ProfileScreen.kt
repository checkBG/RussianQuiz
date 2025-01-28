package com.example.russianquiz.fundamental

import android.annotation.SuppressLint
import android.app.Activity
import android.graphics.Bitmap
import android.graphics.ImageDecoder
import android.os.Build
import android.provider.MediaStore
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.canhub.cropper.CropImageContract
import com.canhub.cropper.CropImageContractOptions
import com.canhub.cropper.CropImageOptions
import com.canhub.cropper.CropImageView
import com.example.russianquiz.R

@Composable
fun ProfileScreen(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier.fillMaxSize(),
    ) {
        SinglePicker(
            modifier = Modifier
                .align(alignment = Alignment.TopCenter)
                .offset(0.dp, 30.dp),
        )
    }
}

@SuppressLint("ContextCastToActivity")
@Composable
fun SinglePicker(
    modifier: Modifier = Modifier,
    size: Dp = 200.dp
) {
    var bitmap: Bitmap? by remember { mutableStateOf(null) }
    val context = LocalContext.current as Activity

    val interactionSource = remember { MutableInteractionSource() }
//    var selectedImageUri by remember { mutableStateOf<Uri?>(null) }

    val photoPickerLauncher = rememberLauncherForActivityResult(
        contract = CropImageContract(),
        onResult = { result ->
            if (result.isSuccessful) {
                result.uriContent?.let {
                    bitmap = if (Build.VERSION.SDK_INT < 28) {
                        MediaStore.Images
                            .Media.getBitmap(context.contentResolver, it)
                    } else {
                        val source = ImageDecoder
                            .createSource(context.contentResolver, it)
                        ImageDecoder.decodeBitmap(source)
                    }
                }
            }
        }
    )

    Box(
        modifier = modifier
            .size(size)
            .clip(shape = RoundedCornerShape(100))
            .clickable(
                interactionSource = interactionSource,
                indication = null,
            ) {
                val cropOptions = CropImageContractOptions(
                    null,
                    CropImageOptions(
                        imageSourceIncludeCamera = false,
                        cropShape = CropImageView.CropShape.RECTANGLE_VERTICAL_ONLY
                    )
                )
                photoPickerLauncher.launch(cropOptions)
            },
        contentAlignment = Alignment.Center
    ) {
        AnimatedVisibility(
            visible = bitmap == null,
            exit = slideOutHorizontally(targetOffsetX = { it }) + fadeOut(),
        ) {
            Image(
                painter = painterResource(id = R.drawable.profile_icon),
                contentDescription = "choose a photo",
                colorFilter = ColorFilter.tint(color = Color.White),
                modifier = Modifier
                    .size(size)
                    .clip(shape = RoundedCornerShape(100))
                    .background(color = Color(0x30FFFFFF)),
            )
        }
        AnimatedVisibility(
            visible = bitmap != null,
            enter = slideInHorizontally(initialOffsetX = { -it }) + fadeIn(),
        ) {
            bitmap?.let {
                Image(
                    bitmap = it.asImageBitmap(),
                    contentDescription = "the selected photo",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.size(size)
                )
            }
        }
    }
}
package com.example.russianquiz.fundamental

import android.annotation.SuppressLint
import android.app.Activity
import android.graphics.ImageDecoder
import android.os.Build
import android.provider.MediaStore
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.annotation.StringRes
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.canhub.cropper.CropImageContract
import com.canhub.cropper.CropImageContractOptions
import com.canhub.cropper.CropImageOptions
import com.canhub.cropper.CropImageView
import com.example.russianquiz.R
import com.example.russianquiz.model.MainViewModel
import com.example.russianquiz.model.Profile
import com.example.russianquiz.model.localizedString

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun ProfileScreen(
    modifier: Modifier = Modifier,
    widthSize: WindowWidthSizeClass,
    mainViewModel: MainViewModel,
) {
    val screenHeightPx = LocalConfiguration.current.screenHeightDp.dp
    val settingsData by mainViewModel.settingsData.collectAsState()
    val profile: Profile = settingsData.profile

    val maxWidth = when (widthSize) {
        WindowWidthSizeClass.Compact -> 0.9f
        WindowWidthSizeClass.Medium -> 0.6f
        WindowWidthSizeClass.Expanded -> 0.45f
        else -> 0.9f
    }
    val maxItemsInEachRow = when (widthSize) {
        WindowWidthSizeClass.Compact -> 1
        WindowWidthSizeClass.Medium -> 1
        WindowWidthSizeClass.Expanded -> 2
        else -> 1
    }

    val percentage = try {
        (profile.rightAnswers / profile.solvedQuestions.toFloat() * 100).toInt()
    } catch (e: Exception) {
        0
    }
    val favouriteLevel = mainViewModel.getFavouriteLevel()


    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(screenHeightPx * 0.03f))

        SinglePicker(
            modifier = Modifier,
            mainViewModel = mainViewModel
        )

        Spacer(modifier = Modifier.height(screenHeightPx * 0.03f))

        FlowRow(
            maxItemsInEachRow = maxItemsInEachRow,
            horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier.fillMaxSize()
        ) {
            Column {
                HorizontalDivider(
                    thickness = 0.75.dp,
                    color = Color.White,
                    modifier = Modifier.fillMaxWidth(maxWidth)
                )

                ProfileStatusColumn(
                    parameterOfStatus = R.string.total_solved_questions,
                    currentStatusParameter = profile.solvedQuestions,
                    maxWidth = maxWidth,
                )

                HorizontalDivider(
                    thickness = 1.5.dp,
                    color = Color.White,
                    modifier = Modifier.fillMaxWidth(maxWidth)
                )
            }

            Column {
                HorizontalDivider(
                    thickness = 0.75.dp,
                    color = Color.White,
                    modifier = Modifier.fillMaxWidth(maxWidth)
                )

                ProfileStatusColumn(
                    parameterOfStatus = R.string.solved_correct,
                    currentStatusParameter = profile.rightAnswers,
                    maxWidth = maxWidth
                )
                HorizontalDivider(
                    thickness = 1.5.dp,
                    color = Color.White,
                    modifier = Modifier.fillMaxWidth(maxWidth)
                )
            }

            Column {
                ProfileStatusColumn(
                    parameterOfStatus = R.string.correct_rate,
                    currentStatusParameter = "$percentage%",
                    maxWidth = maxWidth
                )

                HorizontalDivider(
                    thickness = 1.5.dp,
                    color = Color.White,
                    modifier = Modifier.fillMaxWidth(maxWidth)
                )
            }

            Column {
                ProfileStatusColumn(
                    parameterOfStatus = R.string.favorite_level,
                    currentStatusParameter = favouriteLevel,
                    maxWidth = maxWidth
                )

                HorizontalDivider(
                    thickness = 1.5.dp,
                    color = Color.White,
                    modifier = Modifier.fillMaxWidth(maxWidth)
                )
            }
        }
    }
}

@Composable
fun ProfileStatusColumn(
    modifier: Modifier = Modifier,
    @StringRes parameterOfStatus: Int,
    maxWidth: Float,
    currentStatusParameter: Int,
) {
    Column(
        modifier = modifier
            .fillMaxWidth(maxWidth)
            .padding(top = 10.dp, bottom = 10.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = localizedString(id = parameterOfStatus),
            fontSize = 30.sp,
            color = Color.White,
        )

        Spacer(modifier = Modifier.height(5.dp))

        Text(
            text = currentStatusParameter.toString(),
            fontSize = 40.sp,
            color = Color.White,
        )
    }
}

@Composable
fun ProfileStatusColumn(
    modifier: Modifier = Modifier,
    maxWidth: Float,
    @StringRes parameterOfStatus: Int,
    currentStatusParameter: String,
) {
    Column(
        modifier = modifier
            .fillMaxWidth(maxWidth)
            .padding(top = 10.dp, bottom = 10.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = localizedString(id = parameterOfStatus),
            fontSize = 30.sp,
            color = Color.White,
        )

        Spacer(modifier = Modifier.height(5.dp))

        Text(
            text = currentStatusParameter,
            fontSize = 40.sp,
            color = Color.White,
        )
    }
}

@Suppress("DEPRECATION")
@SuppressLint("ContextCastToActivity")
@Composable
fun SinglePicker(
    modifier: Modifier = Modifier,
    size: Dp = 200.dp,
    mainViewModel: MainViewModel,
) {
    val settingsData by mainViewModel.settingsData.collectAsState()
    val bitmap = settingsData.profile.chosenPhotoProfile
    val context = LocalContext.current as Activity

    val interactionSource = remember { MutableInteractionSource() }

    val photoPickerLauncher = rememberLauncherForActivityResult(
        contract = CropImageContract(),
        onResult = { result ->
            if (result.isSuccessful) {
                result.uriContent?.let {
                    val newBitmap = if (Build.VERSION.SDK_INT < 28) {
                        MediaStore.Images
                            .Media.getBitmap(context.contentResolver, it)
                    } else {
                        val source = ImageDecoder
                            .createSource(context.contentResolver, it)
                        ImageDecoder.decodeBitmap(source)
                    }
                    mainViewModel.changeChosenPhoto(bitmap = newBitmap)
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
                contentDescription = localizedString(R.string.choose_a_photo),
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
                    contentDescription = localizedString(R.string.selected_photo),
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.size(size)
                )
            }
        }
    }
}
package com.codebygus.navmenucomposecolumn

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.expandVertically
import androidx.compose.animation.graphics.ExperimentalAnimationGraphicsApi
import androidx.compose.animation.graphics.res.animatedVectorResource
import androidx.compose.animation.graphics.vector.AnimatedImageVector
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.codebygus.navmenucomposecolumn.textUtils.LeftDrawableText
import com.codebygus.navmenucomposecolumn.textUtils.LeftDrawableTextAnimated
import com.codebygus.navmenucomposecolumn.ui.theme.NavMenuComposeColumnTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NavMenuComposeColumnTheme {
                NavMenuComposeColumn()
            }
        }
    }
}

@OptIn(ExperimentalAnimationGraphicsApi::class)
@Composable
fun NavMenuComposeColumn() {
    val textColor = Color.Blue
    val imageExpand = AnimatedImageVector.animatedVectorResource(id = R.drawable.avd_expand)
    val imageChangeFolder = ImageVector.vectorResource(R.drawable.ic_change_folder)
    val imageSyncCollection = ImageVector.vectorResource(R.drawable.ic_sync_collection)
    val imageDataExport = ImageVector.vectorResource(R.drawable.ic_data_export)
    val imageDataImport = ImageVector.vectorResource(R.drawable.ic_data_import)
    val imageDataGenerate = ImageVector.vectorResource(R.drawable.ic_data_generate)
    val imageSettingsAppearance = ImageVector.vectorResource(R.drawable.ic_appearance_settings)
    val imageSettingsFunction = ImageVector.vectorResource(R.drawable.ic_function_settings)
    val imageSettingsPlaylists = ImageVector.vectorResource(R.drawable.ic_playlist_settings)
    val imageTypesArtist = ImageVector.vectorResource(R.drawable.ic_list_artist)
    val imageTypesGenre = ImageVector.vectorResource(R.drawable.ic_list_genre)
    val imageTypesLabel = ImageVector.vectorResource(R.drawable.ic_list_label)
    val imageTypesStyle = ImageVector.vectorResource(R.drawable.ic_list_style)
    var isExpandedCollection by remember { mutableStateOf(false) }
    var isExpandedData by remember { mutableStateOf(false) }
    var isExpandedSettings by remember { mutableStateOf(false) }
    var isExpandedTypes by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        LeftDrawableTextAnimated(
            layoutId = "txtCollection",
            inputAnimatedVector = imageExpand,
            inputIsExpanded = isExpandedCollection,
            drawableWidth = 30,
            drawableHeight = 30,
            textSize = 18,
            textHeight = 50,
            internalSpaces = "  ",
            inputString = "Collection",
            inputStartPadding = 12,
            inputTextColor = textColor,
            inputDrawableColor = textColor,
            onClick = {
                isExpandedCollection = !isExpandedCollection
                if (isExpandedCollection) {
                    isExpandedData = false
                    isExpandedSettings = false
                    isExpandedTypes = false
                }
            }
        )
        AnimatedVisibility(
            visible = isExpandedCollection,
            enter = expandVertically(animationSpec = tween(750)),
            exit = shrinkVertically(animationSpec = tween(750)),
        ) {
            LeftDrawableText(
                layoutId = "txtChangeFolder",
                inputDrawable = imageChangeFolder,
                drawableWidth = 30,
                drawableHeight = 30,
                textSize = 18,
                textHeight = 50,
                internalSpaces = "  ",
                inputString = "Change Folder",
                inputStartPadding = 12,
                inputTextColor = textColor,
                inputDrawableColor = textColor,
                onClick = { }
            )
        }
        AnimatedVisibility(
            visible = isExpandedCollection,
            enter = expandVertically(animationSpec = tween(750)),
            exit = shrinkVertically(animationSpec = tween(750)),
        ) {
            LeftDrawableText(
                layoutId = "txtSyncCollection",
                inputDrawable = imageSyncCollection,
                drawableWidth = 30,
                drawableHeight = 30,
                textSize = 18,
                textHeight = 50,
                internalSpaces = "  ",
                inputString = "Change Folder",
                inputStartPadding = 12,
                inputTextColor = textColor,
                inputDrawableColor = textColor,
                onClick = {}
            )
        }
        HorizontalDivider(
            modifier = Modifier
                .fillMaxWidth(),
            thickness = 1.dp,
            color = textColor
        )
        LeftDrawableTextAnimated(
            layoutId = "txtData",
            inputAnimatedVector = imageExpand,
            inputIsExpanded = isExpandedData,
            drawableWidth = 30,
            drawableHeight = 30,
            textSize = 18,
            textHeight = 50,
            internalSpaces = "  ",
            inputString = "Data",
            inputStartPadding = 12,
            inputTextColor = textColor,
            inputDrawableColor = textColor,
            onClick = {
                isExpandedData = !isExpandedData
                if (isExpandedData) {
                    isExpandedCollection = false
                    isExpandedSettings = false
                    isExpandedTypes = false
                }
            }
        )
        AnimatedVisibility(
            visible = isExpandedData,
            enter = expandVertically(animationSpec = tween(750)),
            exit = shrinkVertically(animationSpec = tween(750)),
        ) {
            LeftDrawableText(
                layoutId = "txtDataExport",
                inputDrawable = imageDataExport,
                drawableWidth = 30,
                drawableHeight = 30,
                textSize = 18,
                textHeight = 50,
                internalSpaces = "  ",
                inputString = "Export Data",
                inputStartPadding = 12,
                inputTextColor = textColor,
                inputDrawableColor = textColor,
                onClick = {}
            )
        }
        AnimatedVisibility(
            visible = isExpandedData,
            enter = expandVertically(animationSpec = tween(750)),
            exit = shrinkVertically(animationSpec = tween(750)),
        ) {
            LeftDrawableText(
                layoutId = "txtDataImport",
                inputDrawable = imageDataImport,
                drawableWidth = 30,
                drawableHeight = 30,
                textSize = 18,
                textHeight = 50,
                internalSpaces = "  ",
                inputString = "Import Data",
                inputStartPadding = 12,
                inputTextColor = textColor,
                inputDrawableColor = textColor,
                onClick = {}
            )
        }
        AnimatedVisibility(
            visible = isExpandedData,
            enter = expandVertically(animationSpec = tween(750)),
            exit = shrinkVertically(animationSpec = tween(750)),
        ) {
            LeftDrawableText(
                layoutId = "txtDataGenerate",
                inputDrawable = imageDataGenerate,
                drawableWidth = 30,
                drawableHeight = 30,
                textSize = 18,
                textHeight = 50,
                internalSpaces = "  ",
                inputString = "Generate Data",
                inputStartPadding = 12,
                inputTextColor = textColor,
                inputDrawableColor = textColor,
                onClick = {}
            )
        }
        HorizontalDivider(
            modifier = Modifier
                .fillMaxWidth(),
            thickness = 1.dp,
            color = textColor
        )
        LeftDrawableTextAnimated(
            layoutId = "txtSettings",
            inputAnimatedVector = imageExpand,
            inputIsExpanded = isExpandedSettings,
            drawableWidth = 30,
            drawableHeight = 30,
            textSize = 18,
            textHeight = 50,
            internalSpaces = "  ",
            inputString = "Settings",
            inputStartPadding = 12,
            inputTextColor = textColor,
            inputDrawableColor = textColor,
            onClick = {
                isExpandedSettings = !isExpandedSettings
                if (isExpandedSettings) {
                    isExpandedCollection = false
                    isExpandedData = false
                    isExpandedTypes = false
                }
            }
        )
        AnimatedVisibility(
            visible = isExpandedSettings,
            enter = expandVertically(animationSpec = tween(750)),
            exit = shrinkVertically(animationSpec = tween(750)),
        ) {
            LeftDrawableText(
                layoutId = "txtSettingsAppearance",
                inputDrawable = imageSettingsAppearance,
                drawableWidth = 30,
                drawableHeight = 30,
                textSize = 18,
                textHeight = 50,
                internalSpaces = "  ",
                inputString = "Appearance Settings",
                inputStartPadding = 12,
                inputTextColor = textColor,
                inputDrawableColor = textColor,
                onClick = {}
            )
        }
        AnimatedVisibility(
            visible = isExpandedSettings,
            enter = expandVertically(animationSpec = tween(750)),
            exit = shrinkVertically(animationSpec = tween(750)),
        ) {
            LeftDrawableText(
                layoutId = "txtSettingsFunction",
                inputDrawable = imageSettingsFunction,
                drawableWidth = 30,
                drawableHeight = 30,
                textSize = 18,
                textHeight = 50,
                internalSpaces = "  ",
                inputString = "Function Settings",
                inputStartPadding = 12,
                inputTextColor = textColor,
                inputDrawableColor = textColor,
                onClick = {}
            )
        }
        AnimatedVisibility(
            visible = isExpandedSettings,
            enter = expandVertically(animationSpec = tween(750)),
            exit = shrinkVertically(animationSpec = tween(750)),
        ) {
            LeftDrawableText(
                layoutId = "txtSettingsPlaylists",
                inputDrawable = imageSettingsPlaylists,
                drawableWidth = 30,
                drawableHeight = 30,
                textSize = 18,
                textHeight = 50,
                internalSpaces = "  ",
                inputString = "Playlist Settings",
                inputStartPadding = 12,
                inputTextColor = textColor,
                inputDrawableColor = textColor,
                onClick = {}
            )
        }
        HorizontalDivider(
            modifier = Modifier
                .fillMaxWidth(),
            thickness = 1.dp,
            color = textColor
        )
        LeftDrawableTextAnimated(
            layoutId = "txtTypes",
            inputAnimatedVector = imageExpand,
            inputIsExpanded = isExpandedTypes,
            drawableWidth = 30,
            drawableHeight = 30,
            textSize = 18,
            textHeight = 50,
            internalSpaces = "  ",
            inputString = "Types",
            inputStartPadding = 12,
            inputTextColor = textColor,
            inputDrawableColor = textColor,
            onClick = {
                isExpandedTypes = !isExpandedTypes
                if (isExpandedTypes) {
                    isExpandedCollection = false
                    isExpandedData = false
                    isExpandedSettings = false
                }
            }
        )
        AnimatedVisibility(
            visible = isExpandedTypes,
            enter = expandVertically(animationSpec = tween(750)),
            exit = shrinkVertically(animationSpec = tween(750)),
        ) {
            LeftDrawableText(
                layoutId = "txtTypesArtist",
                inputDrawable = imageTypesArtist,
                drawableWidth = 30,
                drawableHeight = 30,
                textSize = 18,
                textHeight = 50,
                internalSpaces = "  ",
                inputString = "Artist Types",
                inputStartPadding = 12,
                inputTextColor = textColor,
                inputDrawableColor = textColor,
                onClick = {}
            )
        }
        AnimatedVisibility(
            visible = isExpandedTypes,
            enter = expandVertically(animationSpec = tween(750)),
            exit = shrinkVertically(animationSpec = tween(750)),
        ) {
            LeftDrawableText(
                layoutId = "txtTypesGenre",
                inputDrawable = imageTypesGenre,
                drawableWidth = 30,
                drawableHeight = 30,
                textSize = 18,
                textHeight = 50,
                internalSpaces = "  ",
                inputString = "Genre Types",
                inputStartPadding = 12,
                inputTextColor = textColor,
                inputDrawableColor = textColor,
                onClick = {}
            )
        }
        AnimatedVisibility(
            visible = isExpandedTypes,
            enter = expandVertically(animationSpec = tween(750)),
            exit = shrinkVertically(animationSpec = tween(750)),
        ) {
            LeftDrawableText(
                layoutId = "txtTypesLabel",
                inputDrawable = imageTypesLabel,
                drawableWidth = 30,
                drawableHeight = 30,
                textSize = 18,
                textHeight = 50,
                internalSpaces = "  ",
                inputString = "Label Types",
                inputStartPadding = 12,
                inputTextColor = textColor,
                inputDrawableColor = textColor,
                onClick = {}
            )
        }
        AnimatedVisibility(
            visible = isExpandedTypes,
            enter = expandVertically(animationSpec = tween(750)),
            exit = shrinkVertically(animationSpec = tween(750)),
        ) {
            LeftDrawableText(
                layoutId = "txtTypesStyle",
                inputDrawable = imageTypesStyle,
                drawableWidth = 30,
                drawableHeight = 30,
                textSize = 18,
                textHeight = 50,
                internalSpaces = "  ",
                inputString = "Style Types",
                inputStartPadding = 12,
                inputTextColor = textColor,
                inputDrawableColor = textColor,
                onClick = {}
            )
        }
        HorizontalDivider(
            modifier = Modifier
                .fillMaxWidth(),
            thickness = 1.dp,
            color = textColor
        )
    }
}

@Preview(showBackground = true)
@Composable
fun NavMenuComposeColumnPreview() {
    NavMenuComposeColumnTheme {
        NavMenuComposeColumn()
    }
}
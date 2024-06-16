package com.codebygus.navmenucomposecolumn.textUtils

import android.util.Log
import androidx.compose.animation.graphics.ExperimentalAnimationGraphicsApi
import androidx.compose.animation.graphics.res.rememberAnimatedVectorPainter
import androidx.compose.animation.graphics.vector.AnimatedImageVector
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.InlineTextContent
import androidx.compose.foundation.text.appendInlineContent
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.text.Placeholder
import androidx.compose.ui.text.PlaceholderVerticalAlign
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.layoutId

@Composable
fun LeftDrawableText(
    layoutId: String,
    inputDrawable: ImageVector,
    drawableWidth: Int,
    drawableHeight: Int,
    textSize: Int,
    textHeight: Int,
    internalSpaces: String,
    inputString: String,
    inputStartPadding: Int,
    inputTextColor: Color,
    inputDrawableColor: Color,
    onClick: () -> Unit
) {
    val annotatedString = buildAnnotatedString {
        appendInlineContent(id = "inputDrawable")
        append(internalSpaces)
        append(inputString)
    }
    val inlineContentMap = mapOf(
        "inputDrawable" to InlineTextContent(
            Placeholder(drawableWidth.sp, drawableHeight.sp, PlaceholderVerticalAlign.Center)
        ) {
            Image(
                painter = rememberVectorPainter(image = inputDrawable),
                contentDescription = null,
                colorFilter = ColorFilter.tint(inputDrawableColor),
            )
        }
    )
    Text(
        text = annotatedString,
        lineHeight = textHeight.sp,
        fontSize = textSize.sp,
        color = inputTextColor,
        inlineContent = inlineContentMap,
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = inputStartPadding.dp)
            .clickable { onClick() }
            .layoutId(layoutId)
    )
}

@OptIn(ExperimentalAnimationGraphicsApi::class)
@Composable
fun LeftDrawableTextAnimated(
    layoutId: String,
    inputAnimatedVector: AnimatedImageVector,
    inputIsExpanded: Boolean,
    drawableWidth: Int,
    drawableHeight: Int,
    textSize: Int,
    textHeight: Int,
    internalSpaces: String,
    inputString: String,
    inputStartPadding: Int,
    inputTextColor: Color,
    inputDrawableColor: Color,
    onClick: () -> Unit
) {
    val annotatedString = buildAnnotatedString {
        appendInlineContent(id = "inputDrawable")
        append(internalSpaces)
        append(inputString)
    }
    val inlineContentMap = mapOf(
        "inputDrawable" to InlineTextContent(
            Placeholder(drawableWidth.sp, drawableHeight.sp, PlaceholderVerticalAlign.Center)
        ) {
            Image(
                painter = rememberAnimatedVectorPainter(
                    animatedImageVector = inputAnimatedVector,
                    atEnd = inputIsExpanded
                ),
                contentDescription = null,
                colorFilter = ColorFilter.tint(inputDrawableColor),
            )
        }
    )
    Text(
        text = annotatedString,
        lineHeight = textHeight.sp,
        fontSize = textSize.sp,
        color = inputTextColor,
        inlineContent = inlineContentMap,
        modifier = Modifier
            .fillMaxWidth()
            .height(textHeight.dp)
            .padding(start = inputStartPadding.dp)
            .clickable { onClick() }
            .layoutId(layoutId)
    )
    Log.d("navMenuTAG", "LeftDrawableTextAnimated(annotatedString): $annotatedString")
}
//@Composable
//fun RightDrawableText(
//    @DrawableRes inputDrawable: Int,
//    drawableWidth: Int,
//    drawableHeight: Int,
//    textHeight: Int,
//    internalSpaces: String,
//    inputString: String,
//    inputStartPadding: Int,
//    inputTextColor: Color,
//    inputDrawableColor: Color,
//    onClick: () -> Unit
//) {
//    val annotatedString = buildAnnotatedString {
//        append(inputString)
//        append(internalSpaces)
//        appendInlineContent(id = "inputDrawable")
//    }
//    val inlineContentMap = mapOf(
//        "inputDrawable" to InlineTextContent(
//            Placeholder(drawableWidth.sp, drawableHeight.sp, PlaceholderVerticalAlign.Center)
//        ) {
//            Image(
//                painter = painterResource(inputDrawable),
//                contentDescription = null,
//                colorFilter = ColorFilter.tint(inputDrawableColor)
//            )
//        }
//    )
//    Text(
//        text = annotatedString,
//        color = inputTextColor,
//        inlineContent = inlineContentMap,
//        modifier = Modifier
//            .height(textHeight.dp)
//            .padding(start = inputStartPadding.dp)
//            .fillMaxWidth()
//            .clickable { onClick() }
//    )
//}
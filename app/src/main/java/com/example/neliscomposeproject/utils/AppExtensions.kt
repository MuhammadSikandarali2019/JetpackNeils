package com.example.neliscomposeproject.utils

import com.example.neliscomposeproject.R

val dummyUserData = listOf(
    R.drawable.userimg_3 to R.string.name1,
    R.drawable.userimg_1 to R.string.name2,
    R.drawable.userimg_2 to R.string.name3,
    R.drawable.userimg_3 to R.string.name1,
    R.drawable.userimg_1 to R.string.name2,
    R.drawable.userimg_2 to R.string.name3,
    R.drawable.userimg_3 to R.string.name1,
    R.drawable.userimg_1 to R.string.name2,
    R.drawable.userimg_2 to R.string.name3
).map {
    DrawableStringPair(it.first, it.second)
}


val dummyImagesData = listOf(
    R.drawable.ic_rect4 to R.string.dummyImage,
    R.drawable.ic_rect6 to R.string.dummyImage,
    R.drawable.ic_rect2 to R.string.dummyImage,
    R.drawable.ic_rect5 to R.string.dummyImage,
    R.drawable.ic_rect3 to R.string.dummyImage,
    R.drawable.ic_rect4 to R.string.dummyImage,
    R.drawable.ic_rect6 to R.string.dummyImage,
    R.drawable.ic_rect2 to R.string.dummyImage,
    R.drawable.ic_rect5 to R.string.dummyImage,
    R.drawable.ic_rect4 to R.string.dummyImage,
    R.drawable.ic_rect6 to R.string.dummyImage,
    R.drawable.ic_rect2 to R.string.dummyImage,
    R.drawable.ic_rect5 to R.string.dummyImage,
    R.drawable.ic_rect3 to R.string.dummyImage,
    R.drawable.ic_rect4 to R.string.dummyImage,
    R.drawable.ic_rect6 to R.string.dummyImage,
    R.drawable.ic_rect2 to R.string.dummyImage,
    R.drawable.ic_rect5 to R.string.dummyImage
).map { DrawableStringPair(it.first, it.second) }
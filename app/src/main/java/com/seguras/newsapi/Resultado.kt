package com.seguras.newsapi

import com.google.gson.annotations.SerializedName

data class Resultado(var url: String,
                     var title: String,
                     var published_date: String,
                     var media: List<Media>
                     )

data class Media(
    @SerializedName("media-metadata") var metadata: List<MediaData>
)

data class MediaData(
    @SerializedName("url") var urlmetadata: String
)

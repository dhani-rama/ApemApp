package id.research.apemapp.home.OnlineCompiler

import id.research.apemapp.retrofit.APIClient

class PostData(private val script: String, private val stdin: String) {
    private val clientId: String
    private val clientSecret: String
    private val language: String
    private val versionIndex: String

    init {
        clientId = APIClient.API_ID
        clientSecret = APIClient.API_SECRET
        language = APIClient.LANGUAGE
        versionIndex = APIClient.VERSION_INDEX
    }
}
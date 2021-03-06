/*
 * Copyright (c) 2017 DuckDuckGo
 *
 * Licensed under the   Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.duckduckgo.app.global

import android.net.Uri
import android.net.Uri.parse
import com.duckduckgo.app.global.UrlScheme.Companion.http

fun Uri.withScheme(): Uri {
    if (scheme == null) {
        return parse("$http://${toString()}")
    }

    return this
}

/**
 * Tries to resolve a host (even if the scheme is missing), returning
 * a basic host without the "www" subdomain.
 */
fun Uri.baseHost(): String? {
    return withScheme().host?.removePrefix("www.")
}

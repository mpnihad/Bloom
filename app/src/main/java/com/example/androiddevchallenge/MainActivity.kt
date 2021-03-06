/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge

import android.content.Intent
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat.startActivity
import com.example.androiddevchallenge.ui.theme.MyTheme

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyTheme {
                MyApp() {
                    startActivity(Intent(this, Login::class.java))
                }
            }
        }
    }
}

// Start building your app here!
@Composable
fun MyApp(onLoginClick: () -> Unit) {
    Surface(color = MaterialTheme.colors.primary) {
        Box(modifier = Modifier.fillMaxSize()) {
            if (isSystemInDarkTheme()) {
                Image(
                    imageVector = ImageVector.vectorResource(id = R.drawable.ic_dark_welcome_bg),
                    contentDescription = "main_background",
                    modifier = Modifier.fillMaxSize(),
                )
            } else {
                Image(
                    imageVector = ImageVector.vectorResource(id = R.drawable.ic_light_welcome_bg),
                    contentDescription = "main_background",
                    modifier = Modifier.fillMaxSize(),
                )
            }
            Column {
                Spacer(modifier = Modifier.height(72.dp))
                Row() {
                    Spacer(modifier = Modifier.width(88.dp))
                    if (isSystemInDarkTheme()) {
                        Image(
                            imageVector = ImageVector.vectorResource(id = R.drawable.ic_dark_welcome_illos),
                            contentDescription = "main_background",
                        )
                    } else {
                        Image(
                            imageVector = ImageVector.vectorResource(id = R.drawable.ic_light_welcome_illos),
                            contentDescription = "main_background",
                        )
                    }
                }
                Spacer(modifier = Modifier.height(48.dp))
                if (isSystemInDarkTheme()) {
                    Image(
                        imageVector = ImageVector.vectorResource(id = R.drawable.ic_dark_logo),
                        contentDescription = "main_background",
                        Modifier
                            .fillMaxWidth()
                            .wrapContentWidth(align = Alignment.CenterHorizontally)
                    )
                } else {
                    Image(
                        imageVector = ImageVector.vectorResource(id = R.drawable.ic_light_logo),
                        contentDescription = "main_background",
                        Modifier
                            .fillMaxWidth()
                            .wrapContentWidth(align = Alignment.CenterHorizontally)
                    )
                }
                Text(
                    text = "Beautiful home garden solutions",
                    style = MaterialTheme.typography.subtitle1,

                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentWidth(align = Alignment.CenterHorizontally)
                        .paddingFromBaseline(top = 32.dp)
                )

                Spacer(modifier = Modifier.height(40.dp))

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 16.dp, end = 16.dp)
                        .height(48.dp)
                        .background(
                            color = MaterialTheme.colors.secondary,
                            shape = RoundedCornerShape(24.dp)
                        ),
                ) {
                    Text(
                        "Create account",
                        modifier = Modifier
                            .fillMaxSize()
                            .wrapContentSize(align = Alignment.Center),
                        style = MaterialTheme.typography.button.copy(
                            color = MaterialTheme.colors.background

                        )
                    )
                }

                Text(
                    "Log in",
                    modifier = Modifier
                        .height(48.dp)
                        .fillMaxSize()
                        .clickable {

                            onLoginClick()
                        }
                        .wrapContentSize(align = Alignment.Center),
                    style = MaterialTheme.typography.button.copy(
                        color = MaterialTheme.colors.secondary

                    )
                )
            }
        }
    }
}

@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun LightPreview() {
    MyTheme {
        MyApp() {
        }
    }
}

@Preview("Dark Theme", widthDp = 360, heightDp = 640)
@Composable
fun DarkPreview() {
    MyTheme(darkTheme = true) {
        MyApp() {
        }
    }
}

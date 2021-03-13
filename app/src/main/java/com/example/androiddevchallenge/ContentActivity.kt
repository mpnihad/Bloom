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

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.model.BrowseTheme
import com.example.androiddevchallenge.model.DesignModel
import com.example.androiddevchallenge.ui.theme.MyTheme
import dev.chrisbanes.accompanist.coil.CoilImage

class ContentActivity : AppCompatActivity() {
    val browseTheme: MutableList<BrowseTheme> = mutableListOf(
        BrowseTheme(
            "https://images.pexels.com/photos/2132227/pexels-photo-2132227.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940",
            "Desert chic"
        ),
        BrowseTheme(
            "https://images.pexels.com/photos/1400375/pexels-photo-1400375.jpeg?auto=compress&cs=tinysrgb&h=750&w=1260",
            "Tiny terrariums"
        ),
        BrowseTheme(
            "https://images.pexels.com/photos/5699665/pexels-photo-5699665.jpeg?auto=compress&cs=tinysrgb&h=750&w=1260",
            "Jungle vibes"
        ),
        BrowseTheme(
            "https://images.pexels.com/photos/6208086/pexels-photo-6208086.jpeg?auto=compress&cs=tinysrgb&h=750&w=1260",
            "Easy care"
        ),
        BrowseTheme(
            "https://images.pexels.com/photos/3511755/pexels-photo-3511755.jpeg?auto=compress&cs=tinysrgb&h=750&w=1260",
            "Statements"
        )
    )
    val designModel: MutableList<DesignModel> = mutableListOf(
        DesignModel(
            "https://images.pexels.com/photos/3097770/pexels-photo-3097770.jpeg?auto=compress&cs=tinysrgb&h=750&w=1260",
            "Monstera",
            "This is a description"
        ),
        DesignModel(
            "https://images.pexels.com/photos/4751978/pexels-photo-4751978.jpeg?auto=compress&cs=tinysrgb&h=750&w=1260",
            "Aglaonema",
            "This is a description"
        ),
        DesignModel(
            "https://images.pexels.com/photos/4425201/pexels-photo-4425201.jpeg?auto=compress&cs=tinysrgb&h=750&w=1260",
            "Peace lily",
            "This is a description"
        ),
        DesignModel(
            "https://images.pexels.com/photos/6208087/pexels-photo-6208087.jpeg?auto=compress&cs=tinysrgb&h=750&w=1260",
            "Fiddle leaf",
            "This is a description"
        ),
        DesignModel(
            "https://images.pexels.com/photos/2123482/pexels-photo-2123482.jpeg?auto=compress&cs=tinysrgb&h=750&w=1260",
            "Snake plant",
            "This is a description"
        ),
        DesignModel(
            "https://images.pexels.com/photos/1084199/pexels-photo-1084199.jpeg?auto=compress&cs=tinysrgb&h=750&w=1260",
            "Pothos",
            "This is a description"
        )
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    MyContentApp(browseTheme, designModel)
                }
            }
        }
    }
}

@Composable
fun MyContentApp(browseTheme: MutableList<BrowseTheme>, designModel: MutableList<DesignModel>) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 16.dp)
    ) {

        SearchText("Search")
        Text(
            "Browse themes",
            Modifier
                .paddingFromBaseline(top = 32.dp)
                .padding(start = 16.dp),
            style = MaterialTheme.typography.h1
        )
        LazyRow(

            Modifier.padding(top = 16.dp, start = 16.dp)
        ) {
            itemsIndexed(browseTheme) { index: Int, item: BrowseTheme ->
                Box(
                    modifier = Modifier
                        .padding(start = 8.dp, bottom = 2.dp)
                        .size(136.dp)
                        .shadow(elevation = 1.dp, shape = RoundedCornerShape(4.dp), clip = true)
                ) {

                    Box(
                        modifier = Modifier
                            .background(
                                color = MaterialTheme.colors.background,
                                shape = RoundedCornerShape(4.dp)
                            )
                            .fillMaxSize()

                    ) {

                        Column(
                            modifier = Modifier
                                .fillMaxSize()
                                .background(
                                    color = MaterialTheme.colors.surface,
                                    shape = RoundedCornerShape(4.dp)
                                )
                        ) {

                            CoilImage(
                                data = item.imageUrl,
                                contentDescription = item.imageName,
                                contentScale = ContentScale.Crop,
                                fadeIn = true,
                                modifier = Modifier
                                    .height(96.dp)
                                    .fillMaxWidth()

                            )
                            Text(
                                item.imageName,
                                Modifier
                                    .padding(start = 16.dp)
                                    .height(40.dp)
                                    .wrapContentHeight(align = Alignment.CenterVertically),
                                style = MaterialTheme.typography.h2
                            )
                        }
                    }
                }
            }
        }
        Row(
            modifier = Modifier
                .height(56.dp)
                .fillMaxWidth()
                .padding(start = 16.dp, end = 16.dp)
        ) {
            Text(
                "Design your home garden",
                Modifier
                    .paddingFromBaseline(top = 40.dp),
                style = MaterialTheme.typography.h1
            )
            Icon(
                imageVector = ImageVector.vectorResource(id = R.drawable.ic_baseline_filter_list_24),
                modifier = Modifier
                    .fillMaxSize()
                    .wrapContentSize(align = Alignment.CenterEnd)
                    .size(24.dp),
                contentDescription = "filter",
            )
        }
        Box() {
            LazyColumn(
                modifier = Modifier
                    .padding(bottom = 56.dp)
                    .fillMaxSize()

            ) {
                itemsIndexed(designModel) { index: Int, item: DesignModel ->
                    val checkStatus: MutableState<Boolean> = remember { mutableStateOf(true) }
                    Column(
                        modifier = Modifier
                            .height(64.dp)
                            .fillMaxWidth()
                            .padding(start = 16.dp, end = 16.dp, bottom = 8.dp)
                    ) {


                        Row(

                        ) {
                            CoilImage(
                                data = item.imageUrl,
                                contentDescription = item.imageName,
                                contentScale = ContentScale.Crop,
                                fadeIn = true,
                                modifier = Modifier
                                    .size(64.dp)
                                    .clip(shape = RoundedCornerShape(4.dp))

                            )

                            Box()
                            {
                                Row()
                                {
                                    Column(
                                        modifier = Modifier
                                            .padding(start = 16.dp)
                                    ) {

                                        Text(
                                            item.imageName,
                                            Modifier
                                                .paddingFromBaseline(top = 24.dp),
                                            style = MaterialTheme.typography.h2
                                        )
                                        Text(
                                            item.imageDescription,
                                            Modifier
                                                .paddingFromBaseline(bottom = 24.dp),
                                            style = MaterialTheme.typography.body1.copy(
                                                MaterialTheme.colors.onPrimary
                                            )
                                        )
                                    }
                                    Box() {
                                        Box(
                                            modifier = Modifier
                                                .fillMaxSize()
                                                .wrapContentSize(align = Alignment.CenterEnd)
                                                .size(24.dp)
                                                .clip(shape = RoundedCornerShape(4.dp))
                                                .border(
                                                    border = BorderStroke(
                                                        1.dp,
                                                        color = MaterialTheme.colors.secondary
                                                    ),
                                                    shape = RoundedCornerShape(4.dp)
                                                )
                                                .background(
                                                    color = if (index == 0) {
                                                        MaterialTheme.colors.secondary
                                                    } else {
                                                        Color.Transparent
                                                    },
                                                )

                                        )
                                        if (index == 0) {
                                            Icon(
                                                imageVector = ImageVector.vectorResource(id = R.drawable.ic_baseline_done_24),
                                                contentDescription = "checkbox",
                                                modifier = Modifier
                                                    .fillMaxSize()
                                                    .wrapContentSize(align = Alignment.CenterEnd)

                                                    .wrapContentSize(align = Alignment.Center)
                                                    .padding(4.dp)
                                                    .size(16.dp),
                                                tint = MaterialTheme.colors.onSecondary
                                            )
                                        }


                                    }

                                }
                                Divider(
                                    color =Color.Black,
                                    startIndent = 8.dp,
                                    modifier = Modifier.fillMaxHeight().wrapContentHeight(align = Alignment.Bottom)
                                    )
                            }
                        }


                    }
                }
            }

            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .wrapContentSize(align = Alignment.BottomCenter)
                    .height(56.dp)
                    .background(MaterialTheme.colors.primary)
                    .fillMaxWidth()

            ) {
                Row() {
                    Column(
                        modifier = Modifier
                            .weight(1f)
                            .fillMaxHeight()
                            .wrapContentHeight(align = Alignment.CenterVertically)
                    ) {
                        contentDown(R.drawable.ic_baseline_home_24, "Home")
                    }

                    Column(
                        modifier = Modifier
                            .weight(1f)
                            .fillMaxHeight()
                            .wrapContentHeight(align = Alignment.CenterVertically)
                    ) {
                        contentDown(R.drawable.ic_baseline_favorite_border_24, "Favorites")
                    }

                    Column(
                        modifier = Modifier
                            .weight(1f)
                            .fillMaxHeight()
                            .wrapContentHeight(align = Alignment.CenterVertically)
                    ) {
                        contentDown(R.drawable.ic_baseline_account_circle_24, "Profile")
                    }

                    Column(
                        modifier = Modifier
                            .weight(1f)
                            .fillMaxHeight()
                            .wrapContentHeight(align = Alignment.CenterVertically)
                    ) {
                        contentDown(R.drawable.ic_baseline_shopping_cart_24, "Cart")
                    }
                }
            }
        }
    }
}

@Composable
private fun contentDown(icon: Int, name: String) {
    Icon(
        imageVector = ImageVector.vectorResource(id = icon),
        contentDescription = name,
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentWidth(align = Alignment.CenterHorizontally)
            .size(24.dp),
        tint = if (name == "Home") {
            MaterialTheme.colors.onBackground
        } else {
            MaterialTheme.colors.primaryVariant
        }
    )
    Text(
        name,
        style = MaterialTheme.typography.caption.copy(
            color = if (name == "Home") {
                MaterialTheme.colors.onBackground
            } else {
                MaterialTheme.colors.primaryVariant
            }
        ),
        modifier = Modifier
            .fillMaxWidth()

            .wrapContentWidth(align = Alignment.CenterHorizontally)
    )
}

@Composable
fun SearchText(hint: String) {
    val inputValue = remember { mutableStateOf(TextFieldValue("")) }
    TextField(
        value = inputValue.value,
        onValueChange = { changedValue ->
            inputValue.value = changedValue
        },
        placeholder = {
            Text(

                hint,
                style = MaterialTheme.typography.body1.copy(color = MaterialTheme.colors.onPrimary),
                modifier = Modifier
                    .fillMaxHeight()
                    .wrapContentHeight(align = Alignment.CenterVertically)
            )
        },

        leadingIcon = {
            Icon(
                imageVector = ImageVector.vectorResource(id = R.drawable.ic_baseline_search_24),
                contentDescription = "Search",
                Modifier.size(18.dp)
            )
        },
        textStyle = MaterialTheme.typography.body1,
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = Color.Transparent,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent
        ),
        modifier = Modifier

            .height(56.dp)
            .fillMaxWidth()
            .fillMaxHeight()
            .wrapContentHeight(align = Alignment.CenterVertically)
            .padding(start = 16.dp, end = 16.dp)
            .border(
                BorderStroke(1.dp, color = MaterialTheme.colors.onPrimary),
                shape = RoundedCornerShape(4.dp)
            )
    )
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview2() {
    val browseTheme: MutableList<BrowseTheme> = mutableListOf(
        BrowseTheme(
            "https://images.pexels.com/photos/2132227/pexels-photo-2132227.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940",
            "Desert chic"
        ),
        BrowseTheme(
            "https://images.pexels.com/photos/1400375/pexels-photo-1400375.jpeg?auto=compress&cs=tinysrgb&h=750&w=1260",
            "Tiny terrariums"
        ),
        BrowseTheme(
            "https://images.pexels.com/photos/5699665/pexels-photo-5699665.jpeg?auto=compress&cs=tinysrgb&h=750&w=1260",
            "Jungle vibes"
        ),
        BrowseTheme(
            "https://images.pexels.com/photos/6208086/pexels-photo-6208086.jpeg?auto=compress&cs=tinysrgb&h=750&w=1260",
            "Easy care"
        )
    )
    val designModel: MutableList<DesignModel> = mutableListOf(
        DesignModel(
            "https://images.pexels.com/photos/2132227/pexels-photo-2132227.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940",
            "Desert chic",
            "This is a description"
        ),
        DesignModel(
            "https://images.pexels.com/photos/1400375/pexels-photo-1400375.jpeg?auto=compress&cs=tinysrgb&h=750&w=1260",
            "Tiny terrariums",
            "This is a description"
        ),
        DesignModel(
            "https://images.pexels.com/photos/5699665/pexels-photo-5699665.jpeg?auto=compress&cs=tinysrgb&h=750&w=1260",
            "Jungle vibes",
            "This is a description"
        ),
        DesignModel(
            "https://images.pexels.com/photos/6208086/pexels-photo-6208086.jpeg?auto=compress&cs=tinysrgb&h=750&w=1260",
            "Easy care",
            "This is a description"
        )
    )
    MyTheme {
        MyContentApp(browseTheme, designModel)
    }
}

package com.example.tb.pages

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreHoriz
import androidx.compose.material3.Card
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.tb.R
import com.example.tb.ui.theme.Tutor
import com.example.tb.ui.theme.abu3
import com.example.tb.ui.theme.biru1
import com.example.tb.ui.theme.ungu2
import com.example.tb.ui.theme.ungu3
import com.example.tb.viewModel.PostViewModel
import com.example.tb.viewModel.TutorViewModel
import androidx.compose.ui.layout.ContentScale
import androidx.compose.foundation.verticalScroll
import androidx.compose.foundation.rememberScrollState
import androidx.compose.ui.text.style.TextAlign
import com.example.tb.ui.theme.ungu1

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomePage (modifier: Modifier = Modifier){
//    val scrollState = rememberScrollState()

    Scaffold (
        topBar = {
            TopAppBar(
                title = {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.Start,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.toplogo),
                            contentDescription = null,
                            modifier = Modifier
                                .size(75.dp)
                                .padding(start = 16.dp, bottom = 4.dp)
                        )
                        Spacer(modifier = Modifier.weight(1f))

                        IconButton(
                            onClick = { /* TODO */ },
                            modifier = Modifier
                                .padding(end = 16.dp)
                                .size(55.dp)
                        ) {
                            Icon(
                                painter = painterResource(id = R.drawable.ic_schedule),
                                contentDescription = null,
                                tint = ungu2,
                                modifier = Modifier.size(55.dp)
                            )
                        }
                    }
                },
                colors = TopAppBarDefaults.smallTopAppBarColors(
                    containerColor = Color.White,
                    titleContentColor = Color.Black
                ),
                modifier = Modifier.shadow(4.dp)
            )
        }
    ){ innerPadding ->
        Column(
            modifier = modifier
                .fillMaxSize()
//                .verticalScroll(scrollState)
                .padding(innerPadding)
        ){
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(280.dp)
                    .padding(16.dp)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxSize(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Box(
                        modifier = Modifier
                            .weight(1f)
                            .fillMaxHeight()
                    ) {
                        tutor()
                    }
                    Spacer(modifier = Modifier.width(16.dp))

                    Box(
                        modifier = Modifier
                            .weight(1f)
                            .fillMaxHeight()
                    ) {
                       bankSoal()
                    }
                }
            }
            postingan()
        }
    }
}

@Composable
fun tutor(
    tutorViewModel: TutorViewModel = viewModel()
) {
    val tutorList = tutorViewModel.tutors.value
    val expandedStates = remember { mutableStateMapOf<Int, Boolean>() }

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
    ) {
        items(tutorList.take(3)) { tutor ->
            TutorCard(tutor = tutor)
        }

        item {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(0.dp, 3.dp)
                    .shadow(elevation = 0.dp, RoundedCornerShape(8.dp))
                    .clickable { /* TODO */ }
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(abu3)
                        .padding(16.dp, 8.dp)
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp)
                            .weight(1f),
                        horizontalAlignment = Alignment.CenterHorizontally, // Pusatkan secara horizontal di dalam Column
                        verticalArrangement = Arrangement.Center
                    ) {
                        Text(
                            text = "See more...",
                            color = Color.Black,
                            style = TextStyle(
                                fontWeight = FontWeight.Bold,
                                fontStyle = FontStyle.Italic
                            )
                        )
                    }
                }
            }
        }
    }
}

@Composable
private fun TutorCard(tutor: Tutor) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(0.dp, 3.dp)
            .shadow(elevation = 0.dp, RoundedCornerShape(8.dp))
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(biru1)
                .padding(16.dp, 8.dp)
        ) {
            Box(
                modifier = Modifier
                    .size(40.dp)
                    .clip(CircleShape)
                    .background(Color.Gray)
            ) {/*Tempat Foto*/}
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
                    .weight(1f)
            ) {
                Text(
                    text = tutor.name,
                    color = Color.White,
                    style = TextStyle(
                        fontWeight = FontWeight.Bold,
                    )
                )
                Text(
                    text = tutor.department,
                    color = Color.White,
                    style = TextStyle(
                        fontSize = 8.sp
                    )
                )
            }
        }
    }
}

@Composable
fun bankSoal() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        RowWithBoxes(
            items = listOf(
                "Information Sistem" to ungu1,
                "Computer Science" to ungu2
            )
        )
        Spacer(modifier = Modifier.height(6.dp))
        RowWithBoxes(
            items = listOf(
                "Informatics" to biru1,
                "See\nmore.." to abu3
            ),
            clickableIndices = listOf(1)
        )
    }
}

@Composable
fun RowWithBoxes(items: List<Pair<String, Color>>, clickableIndices: List<Int> = emptyList()) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items.forEachIndexed { index, (text, color) ->
            BoxWithText(
                text = text,
                backgroundColor = color,
                isClickable = index in clickableIndices,
                modifier = Modifier.weight(1f)
            )
        }
    }
}

@Composable
fun BoxWithText(
    text: String,
    backgroundColor: Color,
    isClickable: Boolean = false,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .height(115.dp)
            .clip(RoundedCornerShape(8.dp))
            .background(backgroundColor)
            .let { if (isClickable) it.clickable { /* TODO */ } else it }
    ) {
        Text(
            text = text,
            fontSize = if (text.contains("\n")) 14.sp else 12.sp,
            fontWeight = FontWeight.Bold,
            fontStyle = if (isClickable) FontStyle.Italic else FontStyle.Normal,
            color = if (isClickable) Color.Black else Color.White,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxSize()
                .wrapContentHeight(Alignment.CenterVertically)
        )
    }
}


@Composable
fun postingan(
    postViewModel: PostViewModel = viewModel()
) {
    val postList = postViewModel.posts.value
    val expandedStates = remember { mutableStateMapOf<Int, Boolean>() }

    LazyColumn(
        modifier = Modifier.fillMaxSize()
    ) {
        item {
            Text(
                "Recent Post",
                modifier = Modifier.padding(16.dp, 16.dp, 0.dp, 8.dp),
                style = TextStyle(
                    fontWeight = FontWeight.Bold,
                    fontSize = 24.sp
                )
            )
        }
        items(postList) { post ->
            val expanded = expandedStates[post.id] ?: false

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
                    .shadow(elevation = 4.dp, RoundedCornerShape(8.dp))
            ) {
                Column(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(65.dp)
                            .background(ungu3)
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxHeight()
                                .padding(16.dp, 0.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Box(
                                modifier = Modifier
                                    .size(40.dp)
                                    .clip(CircleShape)
                                    .background(Color.Gray)
                            )
                            Column(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(8.dp)
                                    .weight(1f)
                            ) {
                                Text(
                                    text = post.name,
                                    color = Color.White,
                                    style = TextStyle(
                                        fontWeight = FontWeight.Bold,
                                        fontSize = 14.sp
                                    )
                                )
                                Text(
                                    text = post.department,
                                    color = Color.White,
                                    style = TextStyle(fontSize = 8.sp)
                                )
                                Text(
                                    text = post.time,
                                    color = Color.White,
                                    style = TextStyle(fontSize = 10.sp)
                                )
                            }
                            IconButton(onClick = { expandedStates[post.id] = !expanded }) {
                                Icon(
                                    modifier = Modifier.shadow(elevation = 4.dp),
                                    imageVector = Icons.Default.MoreHoriz,
                                    contentDescription = null,
                                    tint = Color.White
                                )
                            }

                            DropdownMenu(
                                expanded = expanded,
                                onDismissRequest = { expandedStates[post.id] = false },
                                offset = DpOffset(x = 288.dp, y = 0.dp)
                            ) {
                                DropdownMenuItem(
                                    text = { Text("Edit") },
                                    onClick = { /* TODO: Edit action */ }
                                )
                                DropdownMenuItem(
                                    text = { Text("Hapus") },
                                    onClick = { /* TODO: Delete action */ }
                                )
                            }
                        }
                    }

                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(abu3)
                    ) {
                        if (post.image != null) {
                            Row(
                                modifier = Modifier.padding(16.dp),
                                horizontalArrangement = Arrangement.spacedBy(16.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Box(
                                    modifier = Modifier
                                        .size(120.dp)
                                        .background(Color.LightGray)
                                ) {
                                    Image(
                                        painter = painterResource(id = post.image),
                                        contentDescription = "Post Image",
                                        modifier = Modifier
                                            .fillMaxSize()
                                            .clip(RoundedCornerShape(8.dp)),
                                        contentScale = ContentScale.Crop
                                    )
                                }

                                Text(
                                    text = post.content,
                                    modifier = Modifier.weight(1f)
                                )
                            }
                        } else {
                            Row(
                                modifier = Modifier.padding(16.dp),
                                horizontalArrangement = Arrangement.Start,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Text(
                                    text = post.content,
                                    modifier = Modifier.fillMaxWidth()
                                )
                            }
                        }
                    }

                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(35.dp)
                            .background(ungu3)
                    )
                }
            }
        }
    }
}

@Composable
@Preview
fun tbPreview(){
    HomePage()
//    postingan(postViewModel = PostViewModel())
//    tutor(tutorViewModel = TutorViewModel())
}
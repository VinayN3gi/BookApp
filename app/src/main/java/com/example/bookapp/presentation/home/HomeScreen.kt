package com.example.bookapp.presentation.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bookapp.data.remote.book.Book
import com.example.bookapp.presentation.icons.Barcode_scanner
import com.example.bookapp.ui.theme.signikaFontFamily

@Composable
fun HomeScreen()
{
    val search=remember{ mutableStateOf<String>("")}
    val books: List<Book> = listOf(
        Book(
            id = 2,
            title = "Harry Potter and the Goblet of Fire",
            author = "J. K. Rowling",
            publishedYear = "1993",
            description = "The fourth book in the Harry Potter franchise sees Harry returning for his fourth year at " +
                    "Hogwarts School of Witchcraft and Wizardry, along with his friends, Ron and Hermione . " +
                    "There is an upcoming tournament between the three major schools of magic, " +
                    "with one participant selected from each school by the Goblet of Fire. " +
                    "When Harry's name is drawn, even though he is not eligible and is a fourth player, he must compete in the dangerous contest.",
            userId = "tIGVhaiJMqhP4JV7qL9bVNTrFlg1",
            cover = "https://covers.openlibrary.org/b/id/12059372-L.jpg"
        ),
        Book(
            id = 3,
            title = "Harry Potter and the Chamber of Secrets",
            author = "J. K. Rowling",
            publishedYear = "1998",
            description = "Throughout the summer holidays after his first year at " +
                    "Hogwarts School of Witchcraft and Wizardry, Harry Potter has been receiving sinister warnings from a house-elf called Dobby.",
            cover = "https://covers.openlibrary.org/b/id/8392798-L.jpg",
            userId = "tIGVhaiJMqhP4JV7qL9bVNTrFlg1"
        ),
        Book(
            id = 4,
            title = "Harry Potter and the Philosopher's Stone",
            author = "J. K. Rowling",
            publishedYear = "1997",
            description = "Harry Potter #1",
            cover = "https://covers.openlibrary.org/b/id/10521270-L.jpg",
            userId = "tIGVhaiJMqhP4JV7qL9bVNTrFlg1"
        )
    )
    Column(modifier = Modifier
        .fillMaxSize()
        .systemBarsPadding()
        .navigationBarsPadding())
    {
        Row(modifier = Modifier
            .fillMaxWidth()
            .height(60.dp), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Center)
        {
            OutlinedTextField(
                value = search.value,
                onValueChange = {
                    search.value=it
                },
                modifier = Modifier
                    .fillMaxWidth(.8f)
                    .height(50.dp),
                placeholder = {
                    Text(text = "Search", fontFamily = signikaFontFamily, fontWeight = FontWeight.Light)
                },
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = Color.Gray,
                    cursorColor = Color.Black,
                    unfocusedBorderColor = Color.Gray,
                    focusedTextColor = Color.Black,
                    unfocusedTextColor = Color.Black
                )

            )

            Spacer(modifier = Modifier.width(10.dp))

            Image(imageVector = Barcode_scanner, contentDescription = "Barcode Scanner", modifier = Modifier.size(30.dp))
        }


    }
}

@Composable
@Preview(showBackground = true, showSystemUi = true)
fun HomeScreenPreview()
{
    HomeScreen()
}
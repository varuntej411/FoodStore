package com.food.store.presentation.subcomponents

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.food.store.R

@Composable
fun CustomAlertDialog(
    title: String,
    body: String,
    negativeButton: String,
    positiveButton: String
) {
    var isDialog by remember {
        mutableStateOf(false)
    }

    Dialog(
        onDismissRequest = {},
    ) {
        DialogScreen(
            title = "",
            body = "",
            negativeButton = "",
            positiveButton = ""
        )
    }

}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun DialogScreen(
    title: String,
    body: String,
    negativeButton: String,
    positiveButton: String
) {
    Card(
        shape = RoundedCornerShape(15.dp),
        modifier = Modifier
            .padding(10.dp, 5.dp, 10.dp, 5.dp),
        elevation = CardDefaults.cardElevation(8.dp)
    ) {
        Column(
            modifier = Modifier
                .background(MaterialTheme.colorScheme.background),
        ) {
            Icon(
                imageVector = ImageVector.vectorResource(id = R.drawable.round_error),
                contentDescription = "alert icon",
                tint = MaterialTheme.colorScheme.onSurface,
                modifier = Modifier
                    .padding(top = 20.dp)
                    .height(50.dp)
                    .fillMaxWidth(),
            )

            Column(
                modifier = Modifier
                    .padding(top = 16.dp)
            ) {
                Text(
                    text = "Logout",
                    textAlign = TextAlign.Center,
                    fontStyle = FontStyle.Normal,
                    fontFamily = FontFamily.Serif,
                    style = MaterialTheme.typography.titleLarge,
                    color = MaterialTheme.colorScheme.onPrimaryContainer,
                    fontSize = 22.sp,
                    fontWeight = FontWeight.SemiBold,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(5.dp)
                )

                Text(
                    text = "Do you want to logout?",
                    textAlign = TextAlign.Center,
                    fontStyle = FontStyle.Normal,
                    style = MaterialTheme.typography.bodyMedium,
                    fontFamily = FontFamily.Serif,
                    maxLines = 2,
                    softWrap = true,
                    minLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    color = MaterialTheme.colorScheme.onPrimaryContainer,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.SemiBold,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(5.dp)
                )
            }

            HorizontalDivider(
                modifier = Modifier
                    .padding(top = 10.dp)
                    .fillMaxWidth(),
                thickness = 2.dp,
                color = MaterialTheme.colorScheme.secondary
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(height = 60.dp)
                    .background(color = MaterialTheme.colorScheme.background),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically
            ) {
                TextButton(
                    onClick = {

                    }) {
                    Text(
                        text = "Cancel",
                        textAlign = TextAlign.Center,
                        fontStyle = FontStyle.Normal,
                        fontFamily = FontFamily.Serif,
                        color = MaterialTheme.colorScheme.onPrimaryContainer,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.SemiBold,
                        style = MaterialTheme.typography.titleMedium
                    )
                }

                VerticalDivider(
                    color = MaterialTheme.colorScheme.secondary,
                    thickness = 2.dp
                )

                TextButton(
                    onClick = {

                    }) {
                    Text(
                        text = "Ok",
                        textAlign = TextAlign.Center,
                        fontStyle = FontStyle.Normal,
                        fontFamily = FontFamily.Serif,
                        color = MaterialTheme.colorScheme.onPrimaryContainer,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.SemiBold,
                        style = MaterialTheme.typography.titleMedium
                    )
                }
            }
        }
    }
}

@Composable
fun CustomAlert() {

}

@Preview
@Composable
fun PreviewCustomAlertDailog() {
    CustomAlertDialog(title = "hi", body = "", negativeButton = "", positiveButton = "")
}
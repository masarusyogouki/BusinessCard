package com.example.businesscard.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.material.OutlinedTextField
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.example.businesscard.viewmodel.SignupViewModel

@Composable
fun SignupScreen(
    viewModel: SignupViewModel,
) {
    Column {
        OutlinedTextField(
            value = viewModel.email,
            onValueChange = {viewModel.email = it},
            label = {Text(viewModel.email)},
            isError = !viewModel.email.contains("@") || !viewModel.email.contains("com")
        )
        OutlinedTextField(
            value = viewModel.phone,
            onValueChange = {viewModel.phone = it},
            label = {
                if (viewModel.phone.matches(Regex("^[0-9]{2,4}-[0-9]{2,4}-[0-9]{4}$"))) {
                    Text(viewModel.phone)
                } else {
                    Text("電話番号の形式が正しくありません")
                }
            },
        )
        OutlinedTextField(
            value = viewModel.password,
            onValueChange = {viewModel.password = it},
            label = {
                if (viewModel.password.matches(Regex("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#\$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?]).{12,}$"))) {
                    Text(viewModel.password)
                } else {
                    Text("パスワードの形式が正しくありません")
                }
            }
        )
        ElevatedButton(
            onClick = { viewModel.signup(email = viewModel.email, phone = viewModel.phone, password = viewModel.password) },
        ) {
            Text("登録")
        }
    }
}
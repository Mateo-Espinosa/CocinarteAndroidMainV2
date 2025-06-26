package com.camilo.cocinarte.api;

import com.camilo.cocinarte.models.RegisterRequest;
import com.camilo.cocinarte.models.RegisterResponse;
import com.camilo.cocinarte.models.LoginRequest;
import com.camilo.cocinarte.models.LoginResponse;
import com.camilo.cocinarte.models.ForgotPasswordRequest;
import com.camilo.cocinarte.models.UpdatePhotoResponse;
import com.camilo.cocinarte.models.VerifyCodeRequest;
import com.camilo.cocinarte.models.ResetPasswordRequest;
import com.camilo.cocinarte.models.ApiResponse;

import java.io.File;

import okhttp3.MultipartBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Part;
public interface AuthService {

    // Registro de usuario
    @Headers({
            "Content-Type: application/json",
            "Accept: application/json"
    })
    @POST("auth/register")
    Call<RegisterResponse> registerUser(@Body RegisterRequest request);

    // Inicio de sesión
    @Headers({
            "Content-Type: application/json",
            "Accept: application/json"
    })
    @POST("auth/login")
    Call<LoginResponse> loginUser(@Body LoginRequest request);

    // Solicitud de restablecimiento de contraseña
    @Headers({
            "Content-Type: application/json",
            "Accept: application/json"
    })
    @POST("auth/forgot-password")
    Call<ApiResponse> forgotPassword(@Body ForgotPasswordRequest request);

    // Verificación de código enviado por email
    @Headers({
            "Content-Type: application/json",
            "Accept: application/json"
    })
    @POST("auth/verify-reset-code")
    Call<ApiResponse> verifyCode(@Body VerifyCodeRequest request);

    // Restablecer contraseña con código verificado
    @Headers({
            "Content-Type: application/json",
            "Accept: application/json"
    })
    @POST("auth/set-new-password")
    Call<ApiResponse> resetPassword(@Body ResetPasswordRequest request);

    @Multipart
    @POST("auth/upload-profile-image")
    Call<UpdatePhotoResponse> subirImagen(@Part MultipartBody.Part imagen, @Header("Authorization") String token);

    class Name {
        String nombre;
        public Name(String name){
            nombre = name;
        }
    }

    @PUT("auth/update-profile")
    Call<UpdatePhotoResponse> updateNameProfile(@Body Name name, @Header("Authorization") String token);

}

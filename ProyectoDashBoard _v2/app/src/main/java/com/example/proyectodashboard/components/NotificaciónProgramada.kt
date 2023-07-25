package com.example.proyectodashboard.components

import android.app.NotificationManager
import android.app.PendingIntent
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import androidx.core.app.NotificationCompat
import com.example.proyectodashboard.MainActivity
import com.example.proyectodashboard.R
import com.example.proyectodashboard.utils.Constants.channelId

class NotificacionProgramada: BroadcastReceiver() {

    //Objetivo que no requiere ser instanciado de una clase
    companion object{
        const val NOTIFICATION_ID = 5
    }

    override fun onReceive(
        context: Context,
        intent: Intent?
    ){
        crearNotification(context)
        TODO("Not yet implemented")
    }

    private fun crearNotification(context: Context) {

        val  intent = Intent(
            context,
            MainActivity::class.java
        ).apply {
            flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        }
        val  pendingIntent: PendingIntent = PendingIntent.getActivity(
            context,
            0,
            intent,
            PendingIntent.FLAG_IMMUTABLE
        )

        val notification = NotificationCompat.Builder(
            context,
            channelId
        )
            .setSmallIcon(R.drawable.ic_shopping_cart_48)
            .setContentTitle("Notificacion Programada")
            .setContentText("Usted a reiniciado la aplicaion")
            .setStyle(
                NotificationCompat.BigTextStyle()
                    .bigText("Usted a reiniciado la aplicaion "
                    )
            )
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
            .setContentIntent(pendingIntent)
            .setAutoCancel(true)
            .build()

        val manager = context.getSystemService(Context.NOTIFICATION_SERVICE)
                as NotificationManager
        manager.notify(
            NOTIFICATION_ID,
            notification
        )
    }
}
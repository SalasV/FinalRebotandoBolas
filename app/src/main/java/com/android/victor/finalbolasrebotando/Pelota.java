package com.android.victor.finalbolasrebotando;

import android.widget.ImageView;
import android.widget.Toast;

public class Pelota {
    ImageView bola;
    float velocidadY, velocidadX;

    public Pelota(float velY, float velX) {
        this.velocidadY = velY;
        this.velocidadX = velX;
    }

    public ImageView getPelota() {
        return bola;
    }

    public void setPelota(ImageView pelota) {
        this.bola = pelota;
    }

    public float getVelY() {
        return velocidadY;
    }

    public float getVelX() {
        return velocidadX;
    }

    public void setVelY(float velY) {
        this.velocidadY = velY;
    }

    public void setVelX(float velX) {
        this.velocidadX = velX;
    }

    public void movimientoPelota(float x, float y) {
        //Metodo donde controlamos el movimiento de la pelota
        float PosicionY = bola.getY() + y * velocidadY;
        float PosicionX = bola.getX() + x * velocidadX;

        //derecha
        if ((bola.getX() > 0)) {
            if (PosicionX + bola.getWidth() < MainActivity.width) {
                bola.setX(PosicionX);
            } else {
                bola.setX(MainActivity.width - bola.getWidth());
                velocidadX = (-1) * velocidadX;
            }
            //izquierda
        }else{
            if(PosicionX>0){
                bola.setX(PosicionX);
            }else{
                bola.setX(0);
                velocidadX=(-1)*velocidadX;
            }
        }
        //abajo
        if ((bola.getY() > 0)) {
            if (PosicionY + bola.getHeight() < MainActivity.height) {
                bola.setY(PosicionY);
            } else {
                bola.setY(MainActivity.height - bola.getHeight());
                velocidadY = (-1) * velocidadY;
            }
            //arriba
        }else{
            if(PosicionY>0){
                bola.setY(PosicionY);
            }else{
                bola.setY(0);
                velocidadY=(-1)*velocidadY;
            }
        }
    }
}
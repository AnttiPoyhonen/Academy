package com.pankki.bl;

// pankkitilin aihio
public class Tili {

    private double saldo, luottoraja;

    public boolean otto(double euroa) {
        if (this.getMaksimiNosto() > euroa) {
            saldo -= euroa;
            return true;
        } else return false;
    }

    public void pano(double euroa) {
        saldo += euroa;
    }

    public Tili (double saldo, double luottoraja) {
        this.saldo = saldo;
        this.luottoraja = luottoraja;
    }

    public double getMaksimiNosto() {
        return this.saldo - this.luottoraja;
    }

    public double getSaldo() {
        return this.saldo;
    }

    public double getLuottoraja() {
        return this.luottoraja;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public void setLuottoraja(double luottoraja) {
        this.luottoraja = luottoraja;
    }

}

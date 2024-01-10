/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logismasapp;

import java.sql.Date;

/**
 *
 * @author user
 */
public class Empleado {

    private int numEmpleado;
    private String nombreCompleto;
    private String estado;
    private String genero;
    private String fechaNacimiento;
    private String fechaIngreso;
    private String numTelefono;
    private String curp;
    private String rfc;
    private String nss;
    private byte[] foto;
    private String puesto;
    private String departamento;
    private String domicilio;
    private byte[] comprobanteEstudios;

    public Empleado(int numEmpleado, String estado, String nombreCompleto, String puesto, String departamento, String fechaIngreso, String numTelefono, String curp, String rfc, String nss) {
        this.numEmpleado = numEmpleado;
        this.estado = estado;
        this.nombreCompleto = nombreCompleto;
        this.puesto = puesto;
        this.departamento = departamento;
        this.fechaIngreso = fechaIngreso;
        this.numTelefono = numTelefono;
        this.curp = curp;
        this.rfc = rfc;
        this.nss = nss;
    }

    public int getNumEmpleado() {
        return numEmpleado;
    }

    public void setNumEmpleado(int numEmpleado) {
        this.numEmpleado = numEmpleado;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(String fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public String getNumTelefono() {
        return numTelefono;
    }

    public void setNumTelefono(String numTelefono) {
        this.numTelefono = numTelefono;
    }

    public String getCurp() {
        return curp;
    }

    public void setCurp(String curp) {
        this.curp = curp;
    }

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    public String getNss() {
        return nss;
    }

    public void setNss(String nss) {
        this.nss = nss;
    }

    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public byte[] getComprobanteEstudios() {
        return comprobanteEstudios;
    }

    public void setComprobanteEstudios(byte[] comprobanteEstudios) {
        this.comprobanteEstudios = comprobanteEstudios;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

}

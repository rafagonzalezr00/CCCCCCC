/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daw.model;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author rafael
 */
@Entity
@Table(name="hermanos")
@NamedQueries({
 @NamedQuery(name="Hermano.findAll", query="SELECT h FROM Hermano h"),
 //@NamedQuery(name="Hermano.findByName", query="SELECT h FROM Hermano h WHERE h.nombre =:nombre && h.apellidos =:apellidos"),
 //@NamedQuery(name="Hermano.findByDNI", query="SELECT h FROM Hermano h WHERE h.dni =: dni"),
})
public class Hermano implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private int n_Hermano;
    private String nombre;
    private String apellidos;
    private String DNI;
    private Date fechaNac;
    private String direccion;
    private int numTelefono;
    private String correo;
    private Date fechaAlta;
    private Date fechaJura;
    private int cuota;
    private String opcionCobro;
    private String numCuenta;
    
    //CONSTRUCTORES
    
    public Hermano(){
        
    }

    
    public Hermano(int n_Hermano, String nombre, String apellidos, String DNI, Date fechaNac, String direccion, int numTelefono, String correo, Date fechaAlta, Date fechaJura, int cuota, String opcionCobro, String numCuenta) {
        this.n_Hermano = n_Hermano;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.DNI = DNI;
        this.fechaNac = fechaNac;
        this.direccion = direccion;
        this.numTelefono = numTelefono;
        this.correo = correo;
        this.fechaAlta = fechaAlta;
        this.fechaJura = fechaJura;
        this.cuota = cuota;
        this.opcionCobro = opcionCobro;
        this.numCuenta = numCuenta;
    }
        
    
    //GETTERS Y SETTERS

    public int getN_Hermano() {
        return n_Hermano;
    }

    public void setN_Hermano(int n_Hermano) {
        this.n_Hermano = n_Hermano;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public Date getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(Date fechaNac) {
        this.fechaNac = fechaNac;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getNumTelefono() {
        return numTelefono;
    }

    public void setNumTelefono(int numTelefono) {
        this.numTelefono = numTelefono;
    }


    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public Date getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(Date fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public Date getFechaJura() {
        return fechaJura;
    }

    public void setFechaJura(Date fechaJura) {
        this.fechaJura = fechaJura;
    }

    public int getCuota() {
        return cuota;
    }

    public void setCuota(int cuota) {
        this.cuota = cuota;
    }

    public String getOpcionCobro() {
        return opcionCobro;
    }

    public void setOpcionCobro(String opcionCobro) {
        this.opcionCobro = opcionCobro;
    }

    public String getNumCuenta() {
        return numCuenta;
    }

    public void setNumCuenta(String numCuenta) {
        this.numCuenta = numCuenta;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Hermano)) {
            return false;
        }
        Hermano other = (Hermano) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "daw.model.Hermano[ id=" + id + " ]";
    }
    
}

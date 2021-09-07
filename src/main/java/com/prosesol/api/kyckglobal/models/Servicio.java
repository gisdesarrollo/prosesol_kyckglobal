package com.prosesol.api.kyckglobal.models;

import org.springframework.format.annotation.NumberFormat;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "servicios")
public class Servicio implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_servicio", unique = true, nullable = false)
    private Long id;

    @NotEmpty(message = "Proporcione el nombre del servicio")
    @Column(name = "nombre")
    private String nombre;

    @Column(name = "notas")
    private String nota;

    @NumberFormat(style = NumberFormat.Style.NUMBER, pattern = "#,###.##")
    @NotNull(message = "{text.servicio.inscripcionTitular}")
    @Column(name = "inscripcion_titular")
    private Double inscripcionTitular;

    @NotNull(message = "{text.servicio.costoTitular}")
    @Column(name = "costo_titular")
    private Double costoTitular;

    //@NotNull(message = "{text.servicio.inscripcionBeneficiario}")
    @Column(name = "inscripcion_beneficiario")
    private Double inscripcionBeneficiario;

    //@NotNull(message = "{text.servicio.costoBeneficiario}")
    @Column(name = "costo_beneficiario")
    private Double costoBeneficiario;

    @Column(name = "estatus")
    private Boolean estatus;

    @NotNull(message = "{text.servicio.tipoPrivacidad}")
    @Column(name = "tipo_privacidad")
    private Boolean tipoPrivacidad;

    @Column(name = "is_plan")
    private Boolean isPlan;

    @OneToMany(mappedBy = "servicio", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Afiliado> afiliado;

    @Column(name = "nombre_proveedor")
    private String nombreProveedor;

    @Column(name = "telefono")
    private String telefono;

    @Column(name = "correo")
    private String correo;

    public Servicio() {

    }

    public Servicio(String nombre, String nota, Double inscripcionTitular, Double costoTitular,
                    Double inscripcionBeneficiario, Double costoBeneficiario, Boolean estatus, Boolean tipoPrivacidad
    ) {

        this.nombre = nombre;
        this.nota = nota;
        this.inscripcionTitular = inscripcionTitular;
        this.costoTitular = costoTitular;
        this.inscripcionBeneficiario = inscripcionBeneficiario;
        this.costoBeneficiario = costoBeneficiario;
        this.estatus = estatus;
        this.tipoPrivacidad = tipoPrivacidad;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNota() {
        return nota;
    }

    public void setNota(String nota) {
        this.nota = nota;
    }

    public List<Afiliado> getAfiliado() {
        return afiliado;
    }

    public void setAfiliado(List<Afiliado> afiliado) {
        this.afiliado = afiliado;
    }

    public Boolean getEstatus() {
        return estatus;
    }

    public void setEstatus(Boolean estatus) {
        this.estatus = estatus;
    }

    public Double getInscripcionTitular() {
        return inscripcionTitular;
    }

    public void setInscripcionTitular(Double inscripcionTitular) {
        this.inscripcionTitular = inscripcionTitular;
    }

    public Double getCostoTitular() {
        return costoTitular;
    }

    public void setCostoTitular(Double costoTitular) {
        this.costoTitular = costoTitular;
    }

    public Double getInscripcionBeneficiario() {
        return inscripcionBeneficiario;
    }

    public void setInscripcionBeneficiario(Double inscripcionBeneficiario) {
        this.inscripcionBeneficiario = inscripcionBeneficiario;
    }

    public Double getCostoBeneficiario() {
        return costoBeneficiario;
    }

    public void setCostoBeneficiario(Double costoBeneficiario) {
        this.costoBeneficiario = costoBeneficiario;
    }

    public Boolean getTipoPrivacidad() {
        return tipoPrivacidad;
    }

    public void setTipoPrivacidad(Boolean tipoPrivacidad) {
        this.tipoPrivacidad = tipoPrivacidad;
    }

    public Boolean getIsPlan() {
        return isPlan;
    }

    public void setIsPlan(Boolean isPlan) {
        this.isPlan = isPlan;
    }

    public String getNombreProveedor() {
        return nombreProveedor;
    }

    public void setNombreProveedor(String nombreProveedor) {
        this.nombreProveedor = nombreProveedor;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    @Override
    public String toString() {

        StringBuffer buffer = new StringBuffer();

        buffer.append("Nombre: [").append(nombre).append("]").append("Nota: [").append(nota).append("]")
                .append("Inscripción Titular: [").append(inscripcionTitular).append("]").append("Costo Titular: [")
                .append(costoTitular).append("]").append("Inscripción Beneficiario: [").append(inscripcionBeneficiario)
                .append("]").append("Costo Beneficiario: [").append(costoBeneficiario).append("]")
                .append("Tipo Privacidad: [").append(tipoPrivacidad).append("]");

        return buffer.toString();

    }
}

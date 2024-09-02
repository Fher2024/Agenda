package co.edu.uniquindio.tallerAgenda.model;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Reunion {
    private String tema;
    private String descripcion;
    private Date fecha;
    private Time hora;
    private List<Contacto> asistentes;

    // Constructor principal
    public Reunion(String tema, String descripcion, Date fecha, Time hora, List<Contacto> asistentes) {
        this.tema = tema;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.hora = hora;
        this.asistentes = new ArrayList<>(asistentes);
        /*
         * método para agregar asistente
         */
    }

    public void agregarAsistente(Contacto contacto) {
        if (!asistentes.contains(contacto)) {
            asistentes.add(contacto);
        }
    }
    /*
     * método para eliminar asistente
     */

    public void eliminarAsistente(Contacto contacto) {
        asistentes.remove(contacto);
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Time getHora() {
        return hora;
    }

    public void setHora(Time hora) {
        this.hora = hora;
    }

    public List<Contacto> getAsistentes() {
        return asistentes;
    }

    public void setAsistentes(List<Contacto> asistentes) {
        this.asistentes = asistentes;
    }

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }

    @Override
    public String toString() {
        return "Reunion: " +
                ", tema: '" + tema + '\'' +
                ", descripcion: " + descripcion +
                ", fecha: " + fecha +
                ", hora: " + hora +
                ", asistentes: " + asistentes;
    }
}
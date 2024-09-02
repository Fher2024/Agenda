package co.edu.uniquindio.tallerAgenda.model;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class Grupo {
    private String nombre;
    private Categoria categoria;
    private List<Contacto> contactos;

    // Constructor
    public Grupo(String nombre, Categoria categoria) {
        this.nombre = nombre;
        this.categoria = categoria;
        this.contactos = new ArrayList<>();
    }

    // Métodos para agregar y eliminar contactos
    public void agregarContacto(Contacto contacto) {
        if (contactos.size() < 5) {
            contactos.add(contacto);
        } else {
            JOptionPane.showMessageDialog(null, "El grupo ya tiene 5 contactos.");
        }
    }

    public void eliminarContacto(Contacto contacto) {
        contactos.remove(contacto);
    }

    // Métodos Get y Set
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public List<Contacto> getContactos() {
        return contactos;
    }

    public void setContactos(List<Contacto> contactos) {
        this.contactos = contactos;
    }

    // toString
    @Override
    public String toString() {
        return "Grupo: " +
                "nombre='" + nombre + '\'' +
                ", categoria=" + categoria +
                ", contactos=" + contactos;
    }

    // método Mostrar contactos
    public void mostrarContactos() {
        if (contactos.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay contactos en el grupo.");
        } else {
            String mensaje = "Contactos en el grupo " + nombre + ":\n";
            for (Contacto contacto : contactos) {
                mensaje += contacto + "\n"; // Usa el método toString() de Contacto
            }
            JOptionPane.showMessageDialog(null, mensaje);
        }
    }

}
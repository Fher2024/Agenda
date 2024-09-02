package co.edu.uniquindio.tallerAgenda.model;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
/*
         * método para crear listas
         */

public class Agenda {
    private List<Contacto> contactos;
    private List<Grupo> grupos;
    private List<Reunion> reuniones;

    public Agenda() {
        contactos = new ArrayList<>();
        grupos = new ArrayList<>();
        reuniones = new ArrayList<>();
    }

    /*
     * método para agregar contacto
     */
    public void agregarContacto(Contacto contacto) {
        contactos.add(contacto);
    }
    /*
     * método para mostrar contacto
     */

    public void mostrarContactos() {
        if (contactos.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay contactos en la agenda.");
        } else {
            StringBuilder mensaje = new StringBuilder("Contactos en la agenda:\n");
            for (Contacto contacto : contactos) {
                mensaje.append(contacto).append("\n");
            }
            JOptionPane.showMessageDialog(null, mensaje.toString());
        }
    }
    /*
     * método para eliminar contacto
     */

    public boolean eliminarContacto(String nombre) {
        return contactos.removeIf(contacto -> contacto.getNombre().equalsIgnoreCase(nombre));
    }
    /*
     * método para modificar contacto
     */

    public boolean modificarContacto(String nombre, Contacto contactoModificado) {
        for (int i = 0; i < contactos.size(); i++) {
            Contacto contacto = contactos.get(i);
            if (contacto.getNombre().equalsIgnoreCase(nombre)) {
                contactos.set(i, contactoModificado);
                return true;
            }
        }
        return false;
    }

    /*
     * método para agregar grupo
     */
    public void agregarGrupo(Grupo grupo) {
        grupos.add(grupo);
    } /*
       * método para eliminar grupo
       */

    public boolean eliminarGrupo(String nombre) {
        return grupos.removeIf(grupo -> grupo.getNombre().equalsIgnoreCase(nombre));
    }

    /*
     * método para mostrar grupo
     */
    public void mostrarGrupos() {
        if (grupos.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay grupos en la agenda.");
        } else {
            StringBuilder mensaje = new StringBuilder("Grupos en la agenda:\n");
            for (Grupo grupo : grupos) {
                mensaje.append("Grupo: ").append(grupo.getNombre()).append("\n");
            }
            JOptionPane.showMessageDialog(null, mensaje.toString());
        }
    }

    /*
     * método para agregar reunion
     */
    public void agregarReunion(Reunion reunion) {
        reuniones.add(reunion);
    }

    /*
     * método para eliminar asistente de reunion
     */
    public void eliminarAsistenteDeReunion(String temaReunion, String nombreContacto) {
        Reunion reunion = obtenerReunionPorTema(temaReunion);
        if (reunion != null) {
            Contacto contacto = obtenerContactoPorNombre(nombreContacto);
            if (contacto != null) {
                reunion.eliminarAsistente(contacto);
                JOptionPane.showMessageDialog(null, "Asistente eliminado de la reunión.");
            } else {
                JOptionPane.showMessageDialog(null, "Contacto no encontrado en la reunión.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Reunión no encontrada.");
        }
    }

    // Método ajustado para buscar la reunión por tema
    private Reunion obtenerReunionPorTema(String tema) {
        for (Reunion reunion : reuniones) {
            if (reunion.getTema().equalsIgnoreCase(tema)) { // Cambiado de descripcion a tema
                return reunion;
            }
        }
        return null;
    }

    /*
     * método para mostrar reunion
     */
    public void mostrarReuniones() {
        if (reuniones.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay reuniones en la agenda.");
        } else {
            StringBuilder mensaje = new StringBuilder("Reuniones en la agenda:\n");
            for (Reunion reunion : reuniones) {
                mensaje.append(reunion).append("\n");
            }
            JOptionPane.showMessageDialog(null, mensaje.toString());
        }
    }

    public Grupo obtenerGrupoPorNombre(String nombre) {
        for (Grupo grupo : grupos) {
            if (grupo.getNombre().equalsIgnoreCase(nombre)) {
                return grupo;
            }
        }
        return null;
    }

    public void mostrarContactosDeGrupo(String nombreGrupo) {
        Grupo grupo = obtenerGrupoPorNombre(nombreGrupo);
        if (grupo != null) {
            grupo.mostrarContactos();
        } else {
            JOptionPane.showMessageDialog(null, "Grupo no encontrado.");
        }
    }

    public void eliminarContactoDeGrupo(String nombreGrupo, String nombreContacto) {
        Grupo grupo = obtenerGrupoPorNombre(nombreGrupo);
        if (grupo != null) {
            Contacto contacto = null;
            for (Contacto c : grupo.getContactos()) {
                if (c.getNombre().equalsIgnoreCase(nombreContacto)) {
                    contacto = c;
                    break;
                }
            }
            if (contacto != null) {
                grupo.eliminarContacto(contacto);
                JOptionPane.showMessageDialog(null, "Contacto eliminado del grupo.");
            } else {
                JOptionPane.showMessageDialog(null, "Contacto no encontrado en el grupo.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Grupo no encontrado.");
        }
    }

    public List<Grupo> getGrupos() {
        return grupos;
    }

    public List<Reunion> getReuniones() {
        return reuniones;
    }

    public List<Contacto> getContactos() {
        return contactos;
    }

    public void agregarContactoAReunion(String temaReunion, String nombreContacto) {
        Reunion reunion = obtenerReunionPorTema(temaReunion);
        Contacto contacto = obtenerContactoPorNombre(nombreContacto);
        if (reunion != null && contacto != null) {
            reunion.agregarAsistente(contacto);
            JOptionPane.showMessageDialog(null, "Contacto agregado a la reunión.");
        } else if (reunion == null) {
            JOptionPane.showMessageDialog(null, "Reunión no encontrada.");
        } else {
            JOptionPane.showMessageDialog(null, "Contacto no encontrado.");
        }
    }

    private Contacto obtenerContactoPorNombre(String nombre) {
        for (Contacto contacto : contactos) {
            if (contacto.getNombre().equalsIgnoreCase(nombre)) {
                return contacto;
            }
        }
        return null;
    }
}
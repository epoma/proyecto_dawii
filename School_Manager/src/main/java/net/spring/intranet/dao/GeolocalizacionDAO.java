package net.spring.intranet.dao;

import java.util.List;

import net.spring.intranet.entity.Geolocalizacion;

public interface GeolocalizacionDAO {
//	un usuario puede insertar como maximo 2 geolocalizaciones
	public void insertar(Geolocalizacion bean);
	
	public void actualizar(Geolocalizacion bean);
	
	public void eliminar(int cod);
	
	public List<Geolocalizacion> listarGeolocalizaciones();
	
	public int validar(Geolocalizacion bean);
}

package com.redsocial.repositorio;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.redsocial.entidad.Revista;
import com.redsocial.entidad.Categoria;
@Repository
public class RevistaMySqlRepositorio implements RevistaRepositorio{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	RowMapper<Revista> mapperRevista = new RowMapper<Revista>() {
		@Override
		public Revista mapRow(ResultSet rs, int rowNum) throws SQLException {
			Revista obj = new Revista();
			obj.setIdRevista(rs.getInt(1));
			obj.setNombre(rs.getString(2));
			obj.setPrecio(rs.getDouble(3));
			obj.setSerie(rs.getString(4));
			obj.setCategoria(rs.getString(5));
			obj.setFechaLanzamiento(rs.getDate(6));
			obj.setFechaEdicion(rs.getDate(7));
			
			Categoria objCat = new Categoria();
			objCat.setIdCategoria(rs.getInt(8));
			objCat.setNombre(rs.getString(9));
			
			obj.setIdcategoria(objCat);
			
			return obj;
		}
	};


	
	@Override
	public void eliminaRevista(int idRevista) {
		jdbcTemplate.update("delete from revista where idrevista = ?", new Object[] {idRevista});
	}
	
	@Override
	public List<Revista> listaRevista() {
		List<Revista> lista= jdbcTemplate.query("select r.*,c.nombre from revista r inner join categoria c on r.idCategoria = c.idcategoria", new Object[] {} ,mapperRevista);
		return lista;
	}
	
	@Override
	public List<Revista> listaRevistaPorNombre(String nom){
		List<Revista> lista = jdbcTemplate.query("select r.*,c.nombre from revista r inner join categoria c on r.idCategoria = c.idcategoria where r.nombre like ?", new Object[] {nom} ,mapperRevista);
		return lista;
	}
	
	@Override
	public List<Revista> listaRevista(int idCategoria, String nombre){
		List<Revista> lista = jdbcTemplate.query("select r.*,c.nombre from revista r inner join categoria c on r.idCategoria = c.idcategoria where r.idCategoria =? and r.nombre like ? and r.precio>= ? ", new Object[] {idCategoria, nombre} ,mapperRevista);
		return lista;
		
	}

	@Override
	public Revista insertaActualizaRevista(Revista obj) {
		Revista salida = null;
		if (obj.getIdRevista() == 0) {
			  jdbcTemplate.update("insert into revista values(null,?,?,?,?,?,?)",
			new Object[] {obj.getNombre(), obj.getPrecio(), obj.getSerie(),obj.getCategoria(),obj.getFechaLanzamiento(),obj.getFechaEdicion(),obj.getIdcategoria().getIdCategoria()});	
			List<Revista> lista = jdbcTemplate.query("select r.*,c.nombre from revista r inner join deporte categoria c on r.idCategoria = c.idcategoria order by r.idrevista desc limit 0, 1",new Object[] {} ,mapperRevista);
			salida = lista.get(0);
		}else {
			jdbcTemplate.update("update revista set nombre=?,precio=?,serie=?,categoria=?,fechaLanzamiento =?,fechaEdicion =?, idCategoria = ? where idrevista=?", new Object[] {obj.getNombre(), obj.getPrecio(), obj.getSerie(), obj.getCategoria(),obj.getFechaLanzamiento(),obj.getFechaEdicion(), obj.getCategoria(), obj.getIdRevista()});
			List<Revista> lista = jdbcTemplate.query("select r.*,c.nombre from revista r inner join categoria c on r.idCategoria = c.idcategoria where r.idrevista =?",new Object[] {obj.getIdRevista()} ,mapperRevista);
			salida = lista.get(0);
		}
		return salida;
	}

}


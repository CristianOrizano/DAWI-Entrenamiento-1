package com.entrena.controller;


import java.lang.ProcessBuilder.Redirect;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.entrena.entity.Administrador;
import com.entrena.entity.Ciudad;
import com.entrena.entity.Estado;
import com.entrena.service.AdministradorService;
import com.entrena.service.CiudadService;

@Controller
@RequestMapping("/admin")
public class AdministradorController {
	
	@Autowired
	private AdministradorService seradm;
	
	@Autowired
	private CiudadService serCiu;
	
	
	@RequestMapping("/lista")
	public String ListarAdmi(Model model) {
		List<Administrador> lista= seradm.listadoActivos(1);
		model.addAttribute("listaAd",lista);
		 
		return "inicio";
	}
	
	@RequestMapping("/formAdm")
	public String formulario(Model model) {
		
		List<Ciudad> lista= serCiu.listCiuda();
		Administrador admi= new Administrador();

		model.addAttribute("ad",admi);
		model.addAttribute("lisCiu",lista);
		
		return "RegistrarAdmin";
	}
	
	@RequestMapping("/registrar")
	public String registrar(Model model,@RequestParam("codigo") int cod,
			@RequestParam("nombre") String nom,@RequestParam("Apellido") String ape,
			@RequestParam("Direccion") String direc,@RequestParam("telefono") int tel,
			@RequestParam("sueldo") double suel,@RequestParam("sexo") String sexo,
			@RequestParam("fecha") String fech,@RequestParam("ciudad") String codciu,RedirectAttributes redirect){
		
		try {
			Administrador ad= new Administrador();
			ad.setCodigoAd(cod);
			System.out.println("cod "+cod);
			ad.setNombre(nom);
			ad.setApellido(ape);
			ad.setDireccion(direc);
			ad.setTelefono(tel);
			ad.setSueldo(suel);
			ad.setSexo(sexo);
			ad.setFechanaci(new SimpleDateFormat("yyyy-MM-dd").parse(fech));
			
			Ciudad ci= new Ciudad();
			ci.setCodigoCiu(codciu);
			ad.setCiudad(ci);
			Estado es= new Estado();
			es.setEstado(1);
			ad.setEstado(es);

			seradm.guardar(ad);
			
			if(cod==0) {
				
				redirect.addFlashAttribute("MENSAJE","Registro exitoso");
			}else {
				
				redirect.addFlashAttribute("MENSAJE","Actualizado exitoso");
			}
			
		} catch (Exception e) {
			System.out.println("error al grabar"+e.getMessage());
		}

		return "redirect:/admin/lista";
	}
	
	@RequestMapping("/actualizar")
	public String formActu(Model model,@RequestParam("cody") int cod) {
		
		Administrador admi= seradm.BuscarAdmin(cod);
		System.out.println("codigo ciu =="+admi.getCiudad().getCodigoCiu());
		
		List<Ciudad> lista= serCiu.listCiuda();
		
		model.addAttribute("ad",admi);
		model.addAttribute("lisCiu",lista);
		
		return "RegistrarAdmin";
	}
	
	@RequestMapping("/eliminar")
	public String formelimi(Model model,@RequestParam("codig") int cod,RedirectAttributes redirect) {
		
		redirect.addFlashAttribute("MENSAJE","Eliminado exitoso");
		int estado=0;
		seradm.eliminar(estado,cod);
		
		
		
		return "redirect:/admin/lista";
	}


}

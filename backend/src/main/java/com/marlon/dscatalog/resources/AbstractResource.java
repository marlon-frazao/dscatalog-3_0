package com.marlon.dscatalog.resources;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.marlon.dscatalog.utils.Convertible;

@RestController
public abstract class AbstractResource<T extends Convertible<DTO, ID>, DTO extends Convertible<T, ID>, ID>
											implements IResource<T, DTO, ID>{

	@PostMapping
	public ResponseEntity<DTO> save(@RequestBody DTO dto) {
		dto = getService().save(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
		return ResponseEntity.created(uri).body(dto);
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<DTO> update(@RequestBody DTO dto, @PathVariable ID id) {
		return ResponseEntity.ok(getService().update(dto, id));
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<DTO> getById(@PathVariable ID id) {
		return ResponseEntity.ok(getService().getById(id));
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable ID id) {
		getService().deleteById(id);
		return ResponseEntity.noContent().build();
	}
	
	@PostMapping(value = "/delete")
	public ResponseEntity<Void> deleteById(@RequestBody List<ID> ids) {
		getService().deleteById(ids);
		return ResponseEntity.noContent().build();
	}
}

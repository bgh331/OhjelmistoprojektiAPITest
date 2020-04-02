package ohjelmistoprojektiAPI.ohjelmistoprojektiAPI.domain;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@RestController
class KyselyController {

  private final KyselyRepository repository;
  private final KyselyModeleAssembler assembler;
  KyselyController(KyselyRepository repository,
          KyselyModeleAssembler assembler) {

 this.repository = repository;
 this.assembler = assembler;
}
 

  // Aggregate root

  @GetMapping("/kyselyt")
  CollectionModel<EntityModel<Kysely>> all() {

	  List<EntityModel<Kysely>> kyselyt = repository.findAll().stream()
	    .map(assembler::toModel)
	    .collect(Collectors.toList());

	  return new CollectionModel<>(kyselyt,
	    linkTo(methodOn(KyselyController.class).all()).withSelfRel());
	}

  @PostMapping("/kyselyt")
  Kysely newKysely(@RequestBody Kysely newKysely) {
    return repository.save(newKysely);
  }

  // Single item

  @GetMapping("/kyselyt/{id}")
  EntityModel<Kysely> one(@PathVariable Long id) {

	  Kysely kysely = repository.findById(id).orElseThrow(() -> new KyselyNotFoundException(id));

	  return assembler.toModel(kysely);
	}

  @PutMapping("/kyselyt/{id}")
  Kysely replaceKysely(@RequestBody Kysely newKysely, @PathVariable Long id) {

    return repository.findById(id)
      .map(kysely -> {
        kysely.setQuestion(newKysely.getQuestion());
        kysely.setContent(newKysely.getContent());
        return repository.save(kysely);
      })
      .orElseGet(() -> {
        newKysely.setId(id);
        return repository.save(newKysely);
      });
  }

  @DeleteMapping("/kyselyt/{id}")
  void deleteKysely(@PathVariable Long id) {
    repository.deleteById(id);
  }
  
 
}
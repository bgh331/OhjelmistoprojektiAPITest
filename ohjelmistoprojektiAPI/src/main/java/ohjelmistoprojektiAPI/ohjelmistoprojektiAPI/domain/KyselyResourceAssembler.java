package ohjelmistoprojektiAPI.ohjelmistoprojektiAPI.domain;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

@Component
class KyselyModeleAssembler implements RepresentationModelAssembler<Kysely, EntityModel<Kysely>> {

  @Override
  public EntityModel<Kysely> toModel(Kysely kysely) {

    return new EntityModel<>(kysely,
      linkTo(methodOn(KyselyController.class).one(kysely.getId())).withSelfRel(),
      linkTo(methodOn(KyselyController.class).all()).withRel("kyselyt"));
  }
}
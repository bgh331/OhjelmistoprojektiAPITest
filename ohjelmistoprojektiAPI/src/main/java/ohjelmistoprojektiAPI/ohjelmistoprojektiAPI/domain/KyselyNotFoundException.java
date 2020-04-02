package ohjelmistoprojektiAPI.ohjelmistoprojektiAPI.domain;



class KyselyNotFoundException extends RuntimeException {

  KyselyNotFoundException(Long id) {
    super("Could not find employee " + id);
  }
}

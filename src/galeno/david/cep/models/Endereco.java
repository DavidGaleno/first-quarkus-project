package galeno.david.cep.models;

public record Endereco(
  String cep,
  String logradouro,
  String complemento,
  String bairro,
  String localidade,
  String uf,
  String ibge,
  String gia,
  String ddd,
  String siaf
) {}

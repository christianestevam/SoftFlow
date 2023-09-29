package softflow;

public class Desenvolvedor {
  private String nome;
  private String email;
  private int idade;
  private String linguagem;
  private String descricao;
  private String disponibilidade;

  public Desenvolvedor(String nome, String email, int idade, String linguagem, String descricao, String disponibilidade){
    this.nome = nome;
    this.email = email;
    this.idade = idade;
    this.linguagem = linguagem;
    this.descricao = descricao;
    this.disponibilidade = disponibilidade;
  }

  public String getNome(){
    return nome;
  }

  public String getEmail(){
    return email;
  }

  public int getIdade(){
    return idade;
  }

  public String getLinguagem(){
    return linguagem;
  }

  public String getDescricao(){
    return descricao;
  }

  public String getDisponibilidade(){
    return disponibilidade;
  }

  @Override
  public String toString() {
    return nome + "," + email + "," + idade + "," + linguagem + "," + descricao + "," + disponibilidade;
  }

}

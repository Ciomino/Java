
@Info(author="NomeAutore" ,version="1.0")
public class Person {
    private String nome;
    private int age;
    private String info;

    public Person(String nome, int age, String info){
        this.nome=nome;
        this.age=age;
        this.info=info;
    }

    public String getNome() {
        return nome;
    }
    @DeprecatedCustom
    public int getAge() {
        return age;
    }

    public String getInfo() {
        return info;
    }

    
}
